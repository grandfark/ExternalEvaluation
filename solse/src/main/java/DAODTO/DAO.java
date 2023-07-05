package DAODTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import getsetter.CIN;
import getsetter.Member;
import getsetter.RCP;

public class DAO {
	private String driver="oracle.jdbc.OracleDriver";
	private String url=
		"jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//레시피 변경 메서드
	public boolean updateRCP(RCP u) {
		String update="update food_recipe set content=?,"
				+ " title=? where seqno = ? ";
		boolean result = false;//작업의 결과를 위한 변수 선언
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, u.getContent());//글내용설정
			pstmt.setString(2, u.getTitle());//제목 설정
			pstmt.setInt(3, u.getSeqno());//글번호 설정
			pstmt.executeUpdate();//update실행
			con.commit();
			result = true;//update 실행 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//레시피 삭제 메서드
	public boolean deleteRCP(int seqno) {
		String delete="delete from food_recipe where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//글번호로 레시피를 검색하는 메서드 상세조회=====================================================
	public RCP getRCPDetail(int seqno) {
		String select="select seqno, title, writer,"
				+" to_char(reg_date,'YY/MM/DD'),"
				+" content from food_recipe"
				+" where seqno = ?";
		RCP rcp = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rcp = new RCP();
				rcp.setSeqno(rs.getInt(1));
				rcp.setTitle(rs.getString(2));
				rcp.setWriter(rs.getString(3));
				rcp.setReg_date(rs.getString(4));
				rcp.setContent(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return rcp;
	}
	
	//전체 레시피의 갯수를 찾는 메서드=====================================================
	public Integer getTotalRCP() {
		String select = "select count (*) from food_recipe";
		Integer totalRCP = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalRCP = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close(); pstmt.close(); con.close();	
			}catch(Exception e) {}
		}
		return totalRCP;
	}

	//레시피 조회 메서드 (전체조회)=====================================================
	public ArrayList<RCP> getPageRCP(int start , int end){
		String select = "select seqno, title, writer, r_date "
				+" from (select rownum rn, seqno, title, writer, r_date from"
				+" (select seqno, title, writer, to_char(reg_date,'YY/MM/DD') r_date"
				+" from food_recipe order by seqno desc)) where rn > ? and rn < ?";
			ArrayList<RCP> list = new ArrayList<RCP>();
		try {
		Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RCP rcp = new RCP();
				rcp.setSeqno(rs.getInt(1));
				rcp.setTitle(rs.getString(2));
				rcp.setWriter(rs.getString(3));
				rcp.setReg_date(rs.getString(4));
				list.add(rcp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
		}	
	
	
	//레시피 번호를 검색하는 메서드=====================================================
	public Integer getMaxRecipe() {
		String select = "select max(seqno) from food_recipe";
		Integer max = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return max;
	}

	//레시피 삽입 메서드
	public boolean RecipeIn(RCP rcp) {
		String insert = "insert into food_recipe values(?,?,?,sysdate,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, rcp.getSeqno());
			pstmt.setString(2, rcp.getTitle());
			pstmt.setString(3, rcp.getWriter());
			pstmt.setString(4, rcp.getContent());
			pstmt.execute();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close(); con.close();}
			catch(Exception e) {}
			}	
		return result;
	}
	
	//한줄평 변경 메서드
	public boolean updateComment(CIN u) {
		String update="update food_comment set content=?,"
				+ " title=? where seqno = ? ";
		boolean result = false;//작업의 결과를 위한 변수 선언
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, u.getContent());//글내용설정
			pstmt.setString(2, u.getTitle());//제목 설정
			pstmt.setInt(3, u.getSeqno());//글번호 설정
			pstmt.executeUpdate();//update실행
			con.commit();
			result = true;//update 실행 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//한줄평 삭제 메서드
	public boolean deleteComment(int seqno) {
		String delete="delete from food_comment where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//글번호로 게시글을 검색하는 메서드=====================================================
	public CIN getCINDetail(int seqno) {
		String select="select seqno, title, writer,"
				+" to_char(reg_date,'YY/MM/DD'),"
				+" content from food_comment"
				+" where seqno = ?";
		CIN cin = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cin = new CIN();
				cin.setSeqno(rs.getInt(1));
				cin.setTitle(rs.getString(2));
				cin.setWriter(rs.getString(3));
				cin.setReg_date(rs.getString(4));
				cin.setContent(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return cin;
	}
	
	//전체 게시글의 갯수를 찾는 메서드=====================================================
	public Integer getTotalCount() {
		String select = "select count (*) from food_comment";
		Integer totalCount = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close(); pstmt.close(); con.close();	
			}catch(Exception e) {}
		}
		return totalCount;
	}
	
	//게시글 조회 메서드 (전체조회)=====================================================
	public ArrayList<CIN> getPageCIN(int start , int end){
		String select = "select seqno, title, writer, r_date "
				+" from (select rownum rn, seqno, title, writer, r_date from"
				+" (select seqno, title, writer, to_char(reg_date,'YY/MM/DD') r_date"
				+" from food_comment order by seqno desc)) where rn > ? and rn < ?";
		ArrayList<CIN> list = new ArrayList<CIN>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CIN cin = new CIN();
				cin.setSeqno(rs.getInt(1));
				cin.setTitle(rs.getString(2));
				cin.setWriter(rs.getString(3));
				cin.setReg_date(rs.getString(4));
				list.add(cin);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	//한줄평 삽입 메서드
	public boolean CommentIN(CIN cin) {
		String insert = "insert into food_comment values(?,?,?,sysdate,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, cin.getSeqno());
			pstmt.setString(2, cin.getTitle());
			pstmt.setString(3, cin.getWriter());
			pstmt.setString(4, cin.getContent());
			pstmt.execute();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{pstmt.close(); con.close();}
			catch(Exception e) {}
			}	
		return result;
	}
	
	//가장큰 글번호를 찾는 메서드=====================================================
	public Integer getMaxSeqno() {
		String select = "select max(seqno) from food_comment";
		Integer max = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				max = rs.getInt(1);
			}else {
				max = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		return max;
	}
	
	//고객정보를 삽입하는 가입메서드 
	public boolean putMember(Member mem){
		String insert = "insert into food_user values(?,?,?,?,?,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getAddr());
			pstmt.setString(6, mem.getTel());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//입력된 계정으로 기존 계정을 검색하는 메서드
	public String getId(String id) {
		String select="select id from food_user where id = ?";
		String selectedId = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return selectedId;
	}
	
	
	
	//로그인 메서드 암호로 계정정보를 검색하는 메서드
	public String getPwd(String id) {
		String select = "select pwd from food_user where id = ?";
		String pwd = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pwd = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return pwd;
	}
}

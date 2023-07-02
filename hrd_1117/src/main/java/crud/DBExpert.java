package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BookInfo;

public class DBExpert {
	private String driver="oracle.jdbc.OracleDriver";
	private String url=
		"jdbc:oracle:thin:@//localhost:1521/orcl";
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	public boolean updateBookTbl(BookInfo info) {
		String update="update books_tbl set name=?, "
			+ "publisher=?, price=?,"
			+ "	p_date=to_date(?,'YYYY-MM-DD') "
			+ "where id=?";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(update);
			pstmt.setString(1, info.getName());//도서명 설정
			pstmt.setString(2, info.getPublisher());//출판사
			pstmt.setInt(3, info.getPrice());//가격설정
			pstmt.setString(4, info.getP_date());//출판일설정
			pstmt.setString(5, info.getId());//도서번호 설정
			pstmt.executeUpdate();//update실행
			flag = true;
			conn.commit();//commit실행
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	public boolean updateBWTbl(String id, String no) {
		//id:도서번호, no:저자번호
		String update="update bw_tbl set w_no = ? "
				+ " where b_id = ?";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(update);
			pstmt.setString(1, no);//저자번호 설정
			pstmt.setString(2, id);//도서번호 설정
			pstmt.executeUpdate();//update실행
			flag = true;
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	public ArrayList<String> getOtherWriters(String name){
		String select="select name from writers_tbl "
				+ "where name != ?";
		ArrayList<String> nameList=
				new ArrayList<String>();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nameList.add(rs.getString(1));
			}
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return nameList;
	}
	
	public BookInfo getUpdateInfo(String id,String no) {
		String select = "select b.id, b.name, w.name, "
			+ "b.publisher, b.price, "
			+ "to_char(b.p_date,'YYYY-MM-DD') "
			+ "from books_tbl b, writers_tbl w, "
			+ "bw_tbl bw "
			+ "where b.id = bw.b_id and bw.w_no = w.no "
			+ "	and b_id = ? and w.no = ?";
		BookInfo info = null;//조회결과를 저장할 변수 선언
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			pstmt.setString(1, id);
			pstmt.setString(2, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회결과가 존재하는 경우
				info = new BookInfo();//DTO생성
				info.setId(rs.getString(1));//도서번호
				info.setName(rs.getString(2));//도서명
				info.setW_name(rs.getString(3));//저자명
				info.setPublisher(rs.getString(4));//출판사명
				info.setPrice(rs.getInt(5));//가격
				info.setP_date(rs.getString(6));//출판일
			}
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return info;
	}
	
	public void deleteBook(String no) {
		String delete="delete from books_tbl where id = ?";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(delete);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
			conn.commit();
		}catch(Exception e) {
			
		}finally {
			try {
				pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
	}//도서정보 테이블에서 삭제(도서번호로 삭제)
	
	public void deleteBW(String no) {
		String delete="delete from bw_tbl where b_id = ?";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(delete);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
			conn.commit();
		}catch(Exception e) {
			
		}finally {
			try {
				pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
	}//도서-저자 정보 테이블에서 삭제(도서번호로 삭제)
	
	public void putBook(BookInfo info) {
		String insert="insert into books_tbl "
			+ "values(?,?,?,?,to_date(?,'YYYY-MM-DD'))";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, info.getId());
			pstmt.setString(2, info.getName());
			pstmt.setString(3, info.getPublisher());
			pstmt.setInt(4, info.getPrice());
			pstmt.setString(5, info.getP_date());
			pstmt.executeUpdate();//insert실행
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
	}//도서정보 테이블에 삽입
	
	public void putBW(BookInfo info) {
		String insert="insert into bw_tbl values(?,?)";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, info.getId());//도서번호
			pstmt.setString(2, info.getW_name());//저자번호
			pstmt.executeUpdate();//insert실행
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
	}//도서-저자 정보 테이블에 삽입
	
	public String getNo(String name) {
		String select="select no from writers_tbl "
				+ "where name = ?";
		String no = null;//조회결과(저자번호)를 저장할 변수 선언
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();//select실행
			if(rs.next())
				no = rs.getString(1);
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return no;
	}
	
	public ArrayList<String> getWriters(){
		String select = "select name from writers_tbl";
		ArrayList<String> nameList=new ArrayList<String>();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nameList.add(rs.getString(1));
			}
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return nameList;
	}
	
	public ArrayList<BookInfo> getBookInfo(){
		String select="select b.id,b.name,w.name,"
			+ "b.publisher,b.price,"
			+ "to_char(b.p_date,'YYYY-MM-DD') "
			+ "from books_tbl b, writers_tbl w, "
			+ "bw_tbl bw where b.id = bw.b_id and "
			+ "bw.w_no = w.no order by b.id";
		ArrayList<BookInfo> bookList = 
				new ArrayList<BookInfo>();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			rs=pstmt.executeQuery();//select 실행
			while(rs.next()) {
				BookInfo info=new BookInfo();
				info.setId(rs.getString(1));//도서번호
				info.setName(rs.getString(2));//도서명
				info.setW_name(rs.getString(3));//저자명
				info.setPublisher(rs.getString(4));//출판사명
				info.setPrice(rs.getInt(5));//도서가격
				info.setP_date(rs.getString(6));//출판일
				bookList.add(info);//DTO를 ArrayList에 저장
			}
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close(); pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
		return bookList;
	}
}









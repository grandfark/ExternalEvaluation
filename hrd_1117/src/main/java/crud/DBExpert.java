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
			pstmt.setString(1, info.getName());//������ ����
			pstmt.setString(2, info.getPublisher());//���ǻ�
			pstmt.setInt(3, info.getPrice());//���ݼ���
			pstmt.setString(4, info.getP_date());//�����ϼ���
			pstmt.setString(5, info.getId());//������ȣ ����
			pstmt.executeUpdate();//update����
			flag = true;
			conn.commit();//commit����
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
		//id:������ȣ, no:���ڹ�ȣ
		String update="update bw_tbl set w_no = ? "
				+ " where b_id = ?";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(update);
			pstmt.setString(1, no);//���ڹ�ȣ ����
			pstmt.setString(2, id);//������ȣ ����
			pstmt.executeUpdate();//update����
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
		BookInfo info = null;//��ȸ����� ������ ���� ����
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			pstmt.setString(1, id);
			pstmt.setString(2, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ����� �����ϴ� ���
				info = new BookInfo();//DTO����
				info.setId(rs.getString(1));//������ȣ
				info.setName(rs.getString(2));//������
				info.setW_name(rs.getString(3));//���ڸ�
				info.setPublisher(rs.getString(4));//���ǻ��
				info.setPrice(rs.getInt(5));//����
				info.setP_date(rs.getString(6));//������
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
	}//�������� ���̺��� ����(������ȣ�� ����)
	
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
	}//����-���� ���� ���̺��� ����(������ȣ�� ����)
	
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
			pstmt.executeUpdate();//insert����
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			}catch(Exception e) {}
		}
	}//�������� ���̺� ����
	
	public void putBW(BookInfo info) {
		String insert="insert into bw_tbl values(?,?)";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, info.getId());//������ȣ
			pstmt.setString(2, info.getW_name());//���ڹ�ȣ
			pstmt.executeUpdate();//insert����
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
	}//����-���� ���� ���̺� ����
	
	public String getNo(String name) {
		String select="select no from writers_tbl "
				+ "where name = ?";
		String no = null;//��ȸ���(���ڹ�ȣ)�� ������ ���� ����
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"hr","hr");
			pstmt=conn.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();//select����
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
			rs=pstmt.executeQuery();//select ����
			while(rs.next()) {
				BookInfo info=new BookInfo();
				info.setId(rs.getString(1));//������ȣ
				info.setName(rs.getString(2));//������
				info.setW_name(rs.getString(3));//���ڸ�
				info.setPublisher(rs.getString(4));//���ǻ��
				info.setPrice(rs.getInt(5));//��������
				info.setP_date(rs.getString(6));//������
				bookList.add(info);//DTO�� ArrayList�� ����
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









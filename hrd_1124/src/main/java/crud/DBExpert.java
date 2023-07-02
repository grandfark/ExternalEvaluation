package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Booking;
import model.Movie;
import model.Watcher;

public class DBExpert {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@//localhost:1521/orcl";
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public void entryBooking(Booking b) {
		String insert="insert into booking_info "
				+ "values(?,?,?,to_date(?,'YYYY-MM-DD'))";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(2, b.getNo());
			pstmt.setString(1, b.getId());
			pstmt.setInt(3, b.getTickets());
			pstmt.setString(4, b.getR_date());
			pstmt.executeUpdate();
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public ArrayList<Movie> getAllMovies(){
		String select="select id from movies_info";
		ArrayList<Movie> list = new ArrayList<Movie>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getString(1));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public void updateWatcher(Watcher w) {
		String update="update watcher_info set name=?,"
				+ "address=?,phone=? where no=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, w.getName());
			pstmt.setString(2, w.getAddress());
			pstmt.setString(3, w.getPhone());
			pstmt.setString(4, w.getNo());
			pstmt.executeUpdate();//update실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public Watcher getMemberById(String id) {
		String select="select no,name,address,phone "
				+ "from watcher_info where no = ?";
		Watcher watcher = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//select실행
			if(rs.next()) {
				watcher = new Watcher();//DTO생성
				watcher.setNo(rs.getString(1));
				watcher.setName(rs.getString(2));
				watcher.setAddress(rs.getString(3));
				watcher.setPhone(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return watcher;
	}
	
	public ArrayList<Watcher> getMembers(){
		String select="select no,name,address,phone "
				+ "from watcher_info";
		ArrayList<Watcher> list = new ArrayList<Watcher>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();//select실행
			while(rs.next()) {
				Watcher w = new Watcher();
				w.setNo(rs.getString(1));//고객번호
				w.setName(rs.getString(2));//이름
				w.setAddress(rs.getString(3));//주소
				w.setPhone(rs.getString(4));//전화번호
				list.add(w);
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
	
	public void putMember(Watcher w) {
		String insert="insert into watcher_info "
				+ "values(?,?,?,?)";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, w.getNo());
			pstmt.setString(2, w.getName());
			pstmt.setString(3, w.getAddress());
			pstmt.setString(4, w.getPhone());
			pstmt.executeUpdate();//insert실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public void putMovie(Movie movie) {
		String insert="insert into movies_info "
			+ "values(?,?,to_date(?,'YYYY-MM-DD'),?,?)";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, movie.getId());
			pstmt.setString(2, movie.getTitle());
			pstmt.setString(3, movie.getOpen_date());
			pstmt.setInt(4, movie.getStart_hour());
			pstmt.setInt(5, movie.getEnd_hour());
			pstmt.executeUpdate();//insert실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public void deleteBooking(String id,String no) {
		String delete="delete from booking_info "
				+ "where id=? and no=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.setString(2, no);
			pstmt.executeUpdate();//delete실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public ArrayList<Booking> getBookings(){
		String select="select w.name, w.phone, m.title,"
			+ "	to_char(m.start_hour,'0999'), "
			+ "to_char(m.end_hour,'9999'),"
			+ "	b.tickets, to_char(b.r_date,'YYYYMMDD'), "
			+ " b.id, b.no "
			+ "from watcher_info w, movies_info m, "
			+ "booking_info b "
			+ "where w.no = b.no and b.id = m.id";
		ArrayList<Booking> list = new ArrayList<Booking>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();//select실행
			while(rs.next()) {
				Booking b = new Booking();
				b.setName(rs.getString(1));//예매자 명
				b.setPhone(rs.getString(2));//연락처
				b.setTitle(rs.getString(3));//영화제목
				b.setStart_hour(rs.getString(4));//시작시간
				b.setEnd_hour(rs.getString(5));//종료시간
				b.setTickets(rs.getInt(6));//예매 수
				b.setR_date(rs.getString(7));//예매 일
				b.setId(rs.getString(8));//영화번호
				b.setNo(rs.getString(9));//고객번호
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}











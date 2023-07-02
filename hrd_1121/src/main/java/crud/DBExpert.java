package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Course;
import model.Lecturer;

public class DBExpert {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@//localhost:1521/orcl";
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public void updateCourse(Course c) {
		String update="update course_tbl set name=?, "
			+ "credit=?, lecturer=?,"
			+ "week=?, start_hour=?, end_end=? "
			+ "where id=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, c.getName());
			pstmt.setInt(2, c.getCredit());
			pstmt.setString(3, c.getLecturer());
			pstmt.setInt(4, Integer.parseInt(c.getWeek()));
			pstmt.setInt(5, Integer.parseInt(c.getStart_hour()));
			pstmt.setInt(6, Integer.parseInt(c.getEnd_end()));
			pstmt.setString(7, c.getId());
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
	
	public void deleteCourse(String id) {
		String delete="delete from course_tbl where id=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.executeUpdate();//delete 실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close();con.close();}catch(Exception e) {}
		}
	}
	public void putCourse(Course c) {
		String insert="insert into course_tbl "
				+ "values(?,?,?,?,?,?,?)";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, c.getId());//과목번호설정
			pstmt.setString(2, c.getName());//과목명 설정
			pstmt.setInt(3, c.getCredit());//학점 설정
			pstmt.setString(4, c.getLecturer());//강사번호
			pstmt.setInt(5, Integer.parseInt(c.getWeek()));
			pstmt.setInt(6, Integer.parseInt(c.getStart_hour()));
			pstmt.setInt(7, Integer.parseInt(c.getEnd_end()));
			pstmt.executeUpdate();//insert실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close();con.close();}catch(Exception e) {}
		}
	}
	
	public ArrayList<Lecturer> getLecturers(){
		String select="select idx,name from lecturer_tbl";
		ArrayList<Lecturer> lecList = 
				new ArrayList<Lecturer>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();//select실행
			while(rs.next()) {
				Lecturer l = new Lecturer();
				l.setIdx(rs.getInt(1));
				l.setName(rs.getString(2));
				lecList.add(l);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return lecList;
	}
	public Course getCourse(String id) {
		String select = "select c.id, c.name, c.credit, "
			+ "l.name, c.week, to_char(c.start_hour,'0999'),"
			+ "to_char(c.end_end,'9999') "
			+ "from course_tbl c, lecturer_tbl l "
			+ "where c.lecturer = l.idx and c.id = ?";
		Course course = null;//조회결과를 저장할 변수 선언(DTO)
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//select 실행
			if(rs.next()) {//조회결과가 존재하는 경우
				course = new Course();//DTO생성
				course.setId(rs.getString(1));//교과목번호
				course.setName(rs.getString(2));//과목명
				course.setCredit(rs.getInt(3));//학점
				course.setLecturer(rs.getString(4));//강사코드
				course.setWeek(rs.getString(5));//요일
				course.setStart_hour(rs.getString(6));//시작
				course.setEnd_end(rs.getString(7));//종료
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return course;
	}
	public ArrayList<Course> getCourseList(){
		String select="select c.id, c.name, c.credit, "
			+ "l.name, c.week, "
			+ "	to_char(c.start_hour,'0999'),"
			+ "to_char(c.end_end,'9999') "
			+ "from course_tbl c, lecturer_tbl l "
			+ "where c.lecturer = l.idx "
			+ "order by c.id";
		ArrayList<Course> courseList = 
			new ArrayList<Course>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();//select 실행
			while(rs.next()) {
				Course c = new Course();//DTO생성
				c.setId(rs.getString(1));//과목번호
				c.setName(rs.getString(2));//과목명
				c.setCredit(rs.getInt(3));//학점
				c.setLecturer(rs.getString(4));//강사명
				int week = rs.getInt(5);
				switch(week) {
				case 1: c.setWeek("월"); break;
				case 2: c.setWeek("화"); break;
				case 3: c.setWeek("수"); break;
				case 4: c.setWeek("목"); break;
				case 5: c.setWeek("금"); break;
				case 6: c.setWeek("토"); break;
				}
				c.setStart_hour(rs.getString(6));//시작시간
				c.setEnd_end(rs.getString(7));//종료시간
				courseList.add(c);//ArrayList에 DTO 저장
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return courseList;
	}
	
	public Integer getCourseCount() {
		String select="select count(*) from course_tbl";
		Integer count = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return count;
	}
}








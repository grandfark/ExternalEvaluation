package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Course;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String code=request.getParameter("CODE");
		String name=request.getParameter("NAME");
		String idx=request.getParameter("LEC");//강사코드
		String credit=request.getParameter("CREDIT");
		String week=request.getParameter("WEEK");
		String start=request.getParameter("START");
		String end=request.getParameter("END");
		Course course = new Course();
		course.setId(code); course.setName(name);
		course.setLecturer(idx); 
		course.setCredit(Integer.parseInt(credit));
		course.setWeek(week); 
		course.setStart_hour(start);
		course.setEnd_end(end);
		DBExpert crud = new DBExpert();
		crud.putCourse(course);
		response.sendRedirect("courseList.do");
	}

}










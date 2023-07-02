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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String id=request.getParameter("ID");//�����ȣ
		String name=request.getParameter("NAME");//�����
		String idx=request.getParameter("CODE");//�����ȣ
		String credit=request.getParameter("CREDIT");//����
		String week=request.getParameter("WEEK");//����
		String start=request.getParameter("START");//����
		String end=request.getParameter("END");//����
		Course c = new Course();//DTO����
		c.setId(id); c.setName(name); c.setLecturer(idx);
		c.setCredit(Integer.parseInt(credit));
		c.setWeek(week); c.setStart_hour(start);
		c.setEnd_end(end);
		DBExpert crud = new DBExpert();
		crud.updateCourse(c);
		response.sendRedirect("courseList.do");
	}

}








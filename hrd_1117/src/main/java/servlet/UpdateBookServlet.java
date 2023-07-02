package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.BookInfo;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updateBook.do")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");//도서번호
		String name= request.getParameter("NAME");//저자명
		DBExpert crud = new DBExpert();
		String no = crud.getNo(name);//저자번호를 찾음
		BookInfo info = crud.getUpdateInfo(id, no);
		ArrayList<String> names=crud.getOtherWriters(name);
		request.setAttribute("INFO", info);
		request.setAttribute("NAMES", names);
		RequestDispatcher rd = 
			request.getRequestDispatcher("updateBook.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

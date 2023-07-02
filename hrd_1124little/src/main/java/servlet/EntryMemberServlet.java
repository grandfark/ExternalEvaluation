package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Watcher;

/**
 * Servlet implementation class EntryMemberServlet
 */
@WebServlet("/entryMember.do")
public class EntryMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryMemberServlet() {
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
		String id=request.getParameter("ID");
		String name=request.getParameter("NAME");
		String addr=request.getParameter("ADDR");
		String tel=request.getParameter("TEL");
		Watcher w = new Watcher();//DTO»ý¼º
		w.setNo(id); w.setName(name); w.setAddress(addr);
		w.setPhone(tel);
		DBExpert crud = new DBExpert();
		crud.putMember(w);
		response.sendRedirect("memberList.do");
	}

}









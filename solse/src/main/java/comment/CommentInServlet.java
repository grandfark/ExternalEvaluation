package comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAODTO.DAO;
import getsetter.CIN;

/**
 * Servlet implementation class CommentInServlet
 */
@WebServlet("/commentIn.do")
public class CommentInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInServlet() {
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
		request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USERID");
		DAO dao = new DAO();
		int seqno = dao.getMaxSeqno() + 1;
		CIN cin = new CIN ();
		cin.setSeqno(seqno); cin.setTitle(title);
		cin.setWriter(id); cin.setContent(content);
		boolean result = dao.CommentIN(cin);
		String url = "main.jsp?BODY=commentResult.jsp?R=";
		if(result) {
			response.sendRedirect(url+"Y");
		}else {
			response.sendRedirect(url+"N");
		}
	}
}

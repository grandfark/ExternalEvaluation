package comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAODTO.DAO;
import getsetter.CIN;

/**
 * Servlet implementation class commentUpdateServlet
 */
@WebServlet("/updateComment.do")
public class commentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentUpdateServlet() {
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
		String seqno = request.getParameter("SEQ");
		String btn = request.getParameter("BTN");
		DAO dao = new DAO();
		boolean result = false;
		if(btn.equals("삭 제")) {
			result=dao.deleteComment(Integer.parseInt(seqno));
			response.sendRedirect(
			"main.jsp?BODY=commentDeleteResult.jsp?R="+result);
		}else if(btn.equals("수 정")) {
			String title = request.getParameter("TITLE");
			String content = request.getParameter("CONTENT");
			CIN cin = new CIN();
			cin.setSeqno(Integer.parseInt(seqno));
			cin.setTitle(title);
			cin.setContent(content);
			result = dao.updateComment(cin);
			response.sendRedirect(
			"main.jsp?BODY=commentUpdateResult.jsp?R="+result);
		}
	}
}

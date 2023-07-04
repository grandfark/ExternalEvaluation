package recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAODTO.DAO;
import getsetter.RCP;


/**
 * Servlet implementation class recipeUpdateServlet
 */
@WebServlet("/updateRecipe.do")
public class recipeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recipeUpdateServlet() {
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
		if(btn.equals("삭제")) {
			result=dao.deleteRCP(Integer.parseInt(seqno));
			response.sendRedirect(
			"main.jsp?BODY=recipeDeleteResult.jsp?R="+result);
		}else if(btn.equals("수정")) {
			String title = request.getParameter("TITLE");
			String content = request.getParameter("CONTENT");
			RCP rcp = new RCP();
			rcp.setSeqno(Integer.parseInt(seqno));
			rcp.setTitle(title);
			rcp.setContent(content);
			result = dao.updateRCP(rcp);
			response.sendRedirect(
			"main.jsp?BODY=recipeUpdateResult.jsp?R="+result);
		}
	}
}

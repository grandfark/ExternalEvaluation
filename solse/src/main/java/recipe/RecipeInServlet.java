package recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAODTO.DAO;
import getsetter.RCP;

/**
 * Servlet implementation class CommentInServlet
 */
@WebServlet("/insertRecipe.do")
public class RecipeInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeInServlet() {
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
		String id = (String)session.getAttribute("MANAGER");
		DAO dao = new DAO();
		int seqno = dao.getMaxSeqno() + 1;
		RCP rcp = new RCP ();
		rcp.setSeqno(seqno); rcp.setTitle(title);
		rcp.setWriter(id); rcp.setContent(content);
		boolean result = dao.RecipeIn(rcp);
		String url = "main.jsp?BODY=RecipeResult.jsp?R=";
		if(result) {
			response.sendRedirect(url+"Y");
		}else {
			response.sendRedirect(url+"N");
		}
	}
}

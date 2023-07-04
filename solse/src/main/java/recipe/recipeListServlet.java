package recipe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAODTO.DAO;
import getsetter.RCP;

/**
 * Servlet implementation class recipeListServlet
 */
@WebServlet("/recipeList.do")
public class recipeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recipeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1; 
		String page = request.getParameter("PAGE");
		if(page != null) {
			pageNo = Integer.parseInt(page);
		}
		int start = (pageNo - 1 ) *5;
		int end = ((pageNo -1 ) *5 ) +6;
		
		DAO dao = new DAO();
		ArrayList<RCP> list = dao.getPageRCP(start, end);
		int totalRCP = dao.getTotalRCP();
		int pageCount =  totalRCP / 5;
		if( totalRCP % 5 != 0) pageCount++;
		
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher(
				"main.jsp?BODY=recipeList.jsp");
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

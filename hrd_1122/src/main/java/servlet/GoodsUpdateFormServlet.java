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
import model.Goods;

/**
 * Servlet implementation class GoodsUpdateFormServlet
 */
@WebServlet("/goodsUpdateForm.do")
public class GoodsUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		DBExpert crud = new DBExpert();
		//상품번호로 상품정보를 조회한다.
		Goods goods = crud.getGoodsById(id);
		//원산지 명을 조회한다.
		ArrayList<String> nations=crud.getNations();
		request.setAttribute("GOODS", goods);
		request.setAttribute("NATIONS", nations);
		RequestDispatcher rd = 
			request.getRequestDispatcher("goodsUpdateForm.jsp");
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

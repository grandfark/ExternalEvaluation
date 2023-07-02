package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Goods;

/**
 * Servlet implementation class GoodsUpdateServlet
 */
@WebServlet("/goodsUpdate.do")
public class GoodsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdateServlet() {
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
		String id = request.getParameter("ID");
		String name = request.getParameter("NAME");
		String made = request.getParameter("MADE");
		String price = request.getParameter("PRICE");
		Goods goods = new Goods();
		goods.setId(id); goods.setName(name); 
		goods.setMade(made); 
		goods.setPrice(Integer.parseInt(price));
		DBExpert crud = new DBExpert();
		crud.updateGoods(goods);
		response.sendRedirect("orderList.do");
	}

}







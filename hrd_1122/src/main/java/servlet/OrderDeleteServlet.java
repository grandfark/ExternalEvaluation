package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;

/**
 * Servlet implementation class OrderDeleteServlet
 */
@WebServlet("/orderDelete.do")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDeleteServlet() {
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
		String id=request.getParameter("ID");//상품번호
		String name=request.getParameter("NAME");//주문자명
		String date=request.getParameter("DATE");//주문일
		//주문자이름으로 주문자번호를 찾는다.
		DBExpert crud = new DBExpert();
		Integer no = crud.getGuestNo(name);
		//상푸번호,주문자번호,주문일을 사용해서 주문정보를 삭제한다.
		crud.deleteOrder(id, no, date);
		//첫화면으로 돌아간다.
		response.sendRedirect("orderList.do");
	}

}










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
		String id=request.getParameter("ID");//��ǰ��ȣ
		String name=request.getParameter("NAME");//�ֹ��ڸ�
		String date=request.getParameter("DATE");//�ֹ���
		//�ֹ����̸����� �ֹ��ڹ�ȣ�� ã�´�.
		DBExpert crud = new DBExpert();
		Integer no = crud.getGuestNo(name);
		//��Ǫ��ȣ,�ֹ��ڹ�ȣ,�ֹ����� ����ؼ� �ֹ������� �����Ѵ�.
		crud.deleteOrder(id, no, date);
		//ùȭ������ ���ư���.
		response.sendRedirect("orderList.do");
	}

}










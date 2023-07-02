package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;

/**
 * Servlet implementation class BookEntryServlet
 */
@WebServlet("/bookEntry.do")
public class BookEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEntryServlet() {
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
		String writer = request.getParameter("WRITER");
		String publisher = request.getParameter("PUB");
		String price = request.getParameter("PRICE");
		String date = request.getParameter("DATE");
		DBExpert crud = new DBExpert();
		//�����̸����� ���ڹ�ȣ�� �˻�(select)�Ѵ�.
		BookInfo info = new BookInfo();//DTO����
		info.setId(id);//������ȣ
		info.setName(name);//������
		info.setW_name(crud.getNo(writer));//���ڹ�ȣ
		info.setPublisher(publisher);//���ǻ� ��
		info.setPrice(Integer.parseInt(price));//����
		info.setP_date(date);//������
		//�������� ���̺�(books_tbl)�� ����-���� ���̺�(bw_tbl)�� ����
		crud.putBook(info); crud.putBW(info);
		response.sendRedirect("booksList.do");//���� ��� ȣ��
	}

}









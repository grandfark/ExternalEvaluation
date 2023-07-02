package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Booking;

/**
 * Servlet implementation class BookingEntryServlet
 */
@WebServlet("/bookingEntry.do")
public class BookingEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingEntryServlet() {
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
		String no=request.getParameter("NO");//����ȣ
		String id=request.getParameter("ID");//��ȭ��ȣ
		String num=request.getParameter("NUM");//���� ��
		String date=request.getParameter("DATE");//���� ��
		Booking b = new Booking();
		b.setNo(no); b.setId(id); b.setR_date(date);
		b.setTickets(Integer.parseInt(num));
		DBExpert crud = new DBExpert();
		crud.entryBooking(b);
		response.sendRedirect("bookingList.do");
	}

}








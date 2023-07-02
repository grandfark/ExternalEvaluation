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
		String no=request.getParameter("NO");//고객번호
		String id=request.getParameter("ID");//영화번호
		String num=request.getParameter("NUM");//예매 수
		String date=request.getParameter("DATE");//예매 일
		Booking b = new Booking();
		b.setNo(no); b.setId(id); b.setR_date(date);
		b.setTickets(Integer.parseInt(num));
		DBExpert crud = new DBExpert();
		crud.entryBooking(b);
		response.sendRedirect("bookingList.do");
	}

}








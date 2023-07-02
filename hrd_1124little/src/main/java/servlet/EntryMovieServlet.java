package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.Movie;

/**
 * Servlet implementation class EntryMovieServlet
 */
@WebServlet("/entryMovie.do")
public class EntryMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryMovieServlet() {
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
		String id=request.getParameter("ID");
		String title=request.getParameter("NAME");
		String date=request.getParameter("DATE");
		String start=request.getParameter("START");
		String end=request.getParameter("END");
		Movie movie = new Movie();//DTO»ý¼º
		movie.setId(id); movie.setTitle(title);
		movie.setOpen_date(date); 
		movie.setStart_hour(Integer.parseInt(start));
		movie.setEnd_hour(Integer.parseInt(end));
		DBExpert crud = new DBExpert();
		boolean f = crud.putMovie(movie);
		if(f) {
			response.sendRedirect("entryMovies.jsp?R=Y");
		}else {
			response.sendRedirect("entryMovies.jsp?R=N");
		}
		
	}

}










package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.DBExpert;
import model.BookInfo;

/**
 * Servlet implementation class ChangeBookServlet
 */
@WebServlet("/changeBook.do")
public class ChangeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBookServlet() {
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
		String id=request.getParameter("ID");//도서번호
		String name=request.getParameter("NAME");//도서명
		String writer=request.getParameter("WNAME");//저자명
		String publisher=request.getParameter("PUB");//출판사명
		String price=request.getParameter("PRICE");//가격
		String date=request.getParameter("DATE");//출판일
		DBExpert crud = new DBExpert();
		BookInfo bookInfo = new BookInfo();//DTO생성
		bookInfo.setId(id); bookInfo.setName(name);
		bookInfo.setPublisher(publisher);
		bookInfo.setPrice(Integer.parseInt(price));
		bookInfo.setP_date(date);
		bookInfo.setW_name(crud.getNo(writer));//저자번호설정
		//도서번호를 조건으로 도서 정보 변경
		crud.updateBookTbl(bookInfo);
		//도서번호를 조건으로 저자명 변경
		crud.updateBWTbl(bookInfo.getId(), 
				bookInfo.getW_name());
		response.sendRedirect("booksList.do");
	}

}










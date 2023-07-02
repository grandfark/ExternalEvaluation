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
		//저자이름으로 저자번호를 검색(select)한다.
		BookInfo info = new BookInfo();//DTO생성
		info.setId(id);//도서번호
		info.setName(name);//도서명
		info.setW_name(crud.getNo(writer));//저자번호
		info.setPublisher(publisher);//출판사 명
		info.setPrice(Integer.parseInt(price));//가격
		info.setP_date(date);//출판일
		//도서정보 테이블(books_tbl)과 도서-저자 테이블(bw_tbl)에 삽입
		crud.putBook(info); crud.putBW(info);
		response.sendRedirect("booksList.do");//도서 목록 호출
	}

}









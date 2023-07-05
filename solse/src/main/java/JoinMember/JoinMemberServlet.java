package JoinMember;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAODTO.DAO;
import getsetter.Member;

/**
 * Servlet implementation class JoinMemberServlet
 */
@WebServlet("/joinMemer.do")
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberServlet() {
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
		String pwd = request.getParameter("PWD");
		String name=request.getParameter("NAME");
		String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");
		String  email = request.getParameter("EMAIL");
		Member member = new Member();
		member.setId(id); member.setPwd(pwd);
		member.setName(name); member.setAddr(addr);
		member.setTel(tel); member.setEmail(email); 
		DAO dao = new DAO();
		boolean result = dao.putMember(member);
		String url="main.jsp?BODY=joinFoodResult.jsp?R=";
		if(result) response.sendRedirect(url+"Y");
		else response.sendRedirect(url+"N");
	}

}

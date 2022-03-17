package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.Member;
import model.MemberSet;

/**
 * Servlet implementation class AddMember
 */
@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/addMember.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String[] names = request.getParameterValues("name[]");
		String[] passwords = request.getParameterValues("pass[]");
		MemberSet members = new MemberSet();
		for(int i = 0;i < names.length;i++) {
			if(names[i] == null || passwords[i] == null)continue;
			members.add(new Member(0, names[i], passwords[i], 0, 0));
		}
		if(!members.isEmpty()) {
			MemberDAO dao = new MemberDAO();
			HttpSession session = request.getSession();
			dao.addMembers(members, (int)session.getAttribute("memberNum"));
		}
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/addOK.jsp");
		d.forward(request, response);
	}

}

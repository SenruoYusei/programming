package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		ServletContext application = this.getServletContext();
		MemberSet members = (MemberSet) application.getAttribute("members");
		int startID = members.get(members.size() - 2).getId();
		MemberSet newMembers = new MemberSet();
		for(int i = 0;i < names.length;i++) {
			if(names[i] == null || passwords[i] == null)continue;
			newMembers.add(new Member(startID + i, names[i], passwords[i], 0, 0));
		}
		if(!newMembers.isEmpty()) {
			MemberDAO dao = new MemberDAO();
			dao.addMembers(newMembers);
			HttpSession session = request.getSession();
			session.setAttribute("startID", startID);
		}
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/addOK.jsp");
		d.forward(request, response);
	}

}

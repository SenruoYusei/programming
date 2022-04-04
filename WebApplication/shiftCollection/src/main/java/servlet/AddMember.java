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
		/*
		String[] names = request.getParameterValues("name[]");
		String[] passwords = request.getParameterValues("pass[]");
		*/
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		ServletContext application = this.getServletContext();
		MemberSet members = (MemberSet) application.getAttribute("members");
		int startID = members.get(members.size() - 2).getId() + 1;
		/*
		MemberSet newMembers = new MemberSet();
		for(int i = 0;i < names.length;i++) {
			if(names[i] == null || passwords[i] == null)continue;
			newMembers.add(new Member(startID + i, names[i], passwords[i], 0, 0));
		}
		*/
		Member m = null;
		if(name != null && password != null)m = new Member(startID, name, password, 0, 0);
		HttpSession session = request.getSession();
		if(m != null) {
			MemberDAO dao = new MemberDAO();
			dao.addMembers(m);
			session.setAttribute("startID", startID);
			session.setAttribute("executeMsg", name + "さんを追加しました");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/addOK.jsp");
			d.forward(request, response);
		}else {
			session.setAttribute("errorMsg", "登録内容が不足しています．");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/addMember.jsp");
			d.forward(request, response);
		}
	}

}

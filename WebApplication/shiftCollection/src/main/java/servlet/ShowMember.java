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
import model.MemberSet;

/**
 * Servlet implementation class ShowMember
 */
@WebServlet("/ShowMember")
public class ShowMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		MemberSet members = dao.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("members", members);
		session.setAttribute("memberNum", members.size());
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/showMember.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		int deletePos = Integer.parseInt(request.getParameter("deleteIndex"));
		if(action.equals("deleteMember")){
			session.setAttribute("deletePos", deletePos);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/deleteMemberConfirm.jsp");
			d.forward(request, response);
		} else {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/showMember.jsp");
			d.forward(request, response);
		}
	}

}

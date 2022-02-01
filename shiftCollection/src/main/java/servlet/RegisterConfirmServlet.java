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

/**
 * Servlet implementation class RegisterConfirmServlet
 */
@WebServlet("/RegisterConfirmServlet")
public class RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		if(m == null)response.sendRedirect("/shiftCollection/loginError.jsp");
		else {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/confirm.jsp");
			d.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String action = request.getParameter("action");
		int deletePos = Integer.parseInt(request.getParameter("pos"));
		if(action.equals("modify")) {
			session.setAttribute("modifyPos", deletePos);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/modify.jsp");
			d.forward(request, response);
		}else if(action.equals("delete")) {
			m.resetSchedule(deletePos);
			session.setAttribute("member", m);
			MemberDAO dao = new MemberDAO();
			dao.resetDaySchedule(m, deletePos);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/confirm.jsp");
			d.forward(request, response);
		}
	}

}

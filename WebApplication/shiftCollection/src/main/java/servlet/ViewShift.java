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
 * Servlet implementation class ViewShift
 */
@WebServlet("/ViewShift")
public class ViewShift extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/viewShift.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int month = Integer.parseInt(request.getParameter("month"));
		int term = Integer.parseInt(request.getParameter("term"));
		//LoginLogic llogic = new LoginLogic();
		//MemberSet members = llogic.getMemberList();
		MemberDAO dao = new MemberDAO();
		MemberSet members = dao.findAll();
		String[] output = members.getSubmittedSchedule(month, term);
		HttpSession session = request.getSession();
		session.setAttribute("output", output);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/viewShift.jsp");
		d.forward(request, response);
	}

}

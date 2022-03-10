package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		if(m == null) {
			request.setAttribute("loginError", "正式なログインができておりません\nログインしなおしてください");
			response.sendRedirect("/shiftCollection/welcome.jsp");
		}else {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/delete.jsp");
			d.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		int dayPos = Integer.parseInt(request.getParameter("pos"));
		String flag = request.getParameter("flag");
		if(flag.equals("1")) {
			m.deleteSchedule(dayPos);
			session.setAttribute("member", m);
			session.removeAttribute("deletePos");
			RequestDispatcher d = request.getRequestDispatcher("WEB-INF/confirm.jsp");
			d.forward(request, response);
		}else {
			RequestDispatcher d = request.getRequestDispatcher("WEB-INF/confirm.jsp");
			d.forward(request, response);
		}
	}

}

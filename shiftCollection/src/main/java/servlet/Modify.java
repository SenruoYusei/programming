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
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class Modify extends HttpServlet {
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
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/modify.jsp");
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
		int dayPos = Integer.parseInt(request.getParameter("ModifyPos"));
		String bH = request.getParameter("beginHour");
		String bM = request.getParameter("beginMinute");
		String eH = request.getParameter("endHour");
		String eM = request.getParameter("endMinute");
		String s = bH + ":" + bM + "," + eH + ":" + eM + "," + request.getParameter("memo");
		if(bH != null) {
			m.setSchedule(dayPos, s);
			MemberDAO dao = new MemberDAO();
			dao.insertSchedule(m, dayPos, s);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/modify.jsp");
			d.forward(request, response);
		}else {
			request.setAttribute("registerError", "日程が正確に入力されていません");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/nodify.jsp");
			d.forward(request, response);
		}
	}

}

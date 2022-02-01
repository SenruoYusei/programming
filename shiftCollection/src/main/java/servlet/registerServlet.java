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
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		session.setAttribute("beginHour", "8");
		session.setAttribute("beginMinute", "30");
		session.setAttribute("endHour", "22");
		session.setAttribute("endMinute", "15");
		if(m == null)response.sendRedirect("/shiftCollection/loginError.jsp");
		else {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/register.jsp");
			d.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int dayPos = Integer.parseInt(request.getParameter("dayPos"));
		String bH = request.getParameter("beginHour");
		String bM = request.getParameter("beginMinute");
		String eH = request.getParameter("endHour");
		String eM = request.getParameter("endMinute");
		String s = bH + ":" + bM + "," + eH + ":" + eM + "," + request.getParameter("memo");
		if(s != null && dayPos != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("dayPos", dayPos);
			session.setAttribute("beginHour", bH);
			session.setAttribute("beginMinute", bM);
			session.setAttribute("endHour", eH);
			session.setAttribute("endMinute", eM);
			Member m = (Member) session.getAttribute("member");
			m.setSchedule(dayPos, s);
			MemberDAO dao = new MemberDAO();
			dao.insertSchedule(m, dayPos, s);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/register.jsp");
			d.forward(request, response);
		}else if(dayPos == -1) {
			request.setAttribute("registerError", "日程が正確に入力されていません");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/register.jsp");
			d.forward(request, response);
		}
	}

}

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

import model.LoginLogic;
import model.Member;
import model.MemberSet;
import model.User;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		LoginLogic llogic = new LoginLogic();
		MemberSet members = llogic.getMemberList();
		application.setAttribute("members", members);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
		d.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		if(userName != null && pass != null) {
			ServletContext application = this.getServletContext();
			MemberSet members = (MemberSet) application.getAttribute("members");
			LoginLogic llogic = new LoginLogic();
			if(members == null) {
				members = llogic.getMemberList();
				application.setAttribute("members", members);
			}
			User u = new User(userName, pass);
			Member m = llogic.getLoginAccount(u);
			
			if(m == null) {
				request.setAttribute("loginError", "ユーザー名とパスワードが正しくありません");
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
				d.forward(request, response);
			}else if(m.getId() == 99) {
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/loginManagerOK.jsp");
				d.forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("member", m);
				
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/loginOK.jsp");
				d.forward(request, response);
			}
		}
	}
}

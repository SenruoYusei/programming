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
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private MemberDAO dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//ServletContext application = this.getServletContext();
//		LoginLogic llogic = new LoginLogic();
		//dao = new MemberDAO();
		
//		MemberSet members = (MemberSet) application.getAttribute("members");
//		if(members == null) {
////			members = llogic.getMemberList();
//			members = dao.findAll();
//			application.setAttribute("members", members);//アプリケーションで持つスコープ
//		}
		
		
//		HttpSession session = request.getSession();
//		Member m = (Member) session.getAttribute("member");
//		if(m != null && !m.isUpdated()) {//途中で終了してしまった場合，再ログイン時に変更内容を更新したい
////			llogic.updateAll(m);
//			dao.updateAll(m);
//			m.updateCompleted();
//		}
		
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
		d.forward(request, response);//welcome.jsp に移動
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("pass");
		
		if(userName != null && userPass != null) {//ユーザー名，パスワードが入力されたとき
			
			ServletContext application = this.getServletContext();
			MemberSet members = (MemberSet) application.getAttribute("members");
//			LoginLogic llogic = new LoginLogic();
			if(members == null) {//アプリケーションスコープがnull のとき新しく作成
//				members = llogic.getMemberList();
				MemberDAO dao = new MemberDAO();
				members = dao.findAll();
				application.setAttribute("members", members);
			}
			application.setAttribute("members", members);
			//Member m = llogic.getLoginAccount(userName, userPass);//ユーザーまたは管理者かどうかを判定
			Member m = null;
			for(Member mem : members) {
				if(!mem.getName().equals(userName) || !mem.getPass().equals(userPass))continue;
				m = mem;
				break;
			}
			
			if(m == null) {//ユーザーまたは管理者でない場合
				request.setAttribute("loginError", "ユーザー名とパスワードが正しくありません");
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
				d.forward(request, response);
			}else if(m.getId() == 99) {//管理者の場合
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/loginManagerOK.jsp");
				d.forward(request, response);
			}else {//ユーザーの場合
				HttpSession session = request.getSession();
				session.setAttribute("member", m);//ログインしたアカウントの情報をセッションスコープに保持
				
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/loginOK.jsp");
				d.forward(request, response);
			}
		}
	}
}

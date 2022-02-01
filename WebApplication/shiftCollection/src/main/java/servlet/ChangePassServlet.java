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
 * Servlet implementation class ChangePassServlet
 */
//アカウントのパスワードを変更する
@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/inputNewPass.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String currentPass = request.getParameter("currentPass");
		String newPass = request.getParameter("newPass");
		
		//現在のパスワードが正しければ，変更の処理を行い，
		//正しくない場合，再度入力させる
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		if(m != null) {
			MemberDAO dao = new MemberDAO();
			dao.updatePass(m, newPass);
			m.setNewPass(newPass);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/changePassOK.jsp");
			d.forward(request, response);
		}else if(currentPass.equals(newPass)){
			request.setAttribute("matchError", "現在のパスワードと変更がありません");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/inputNewPass.jsp");
			d.forward(request, response);//redirect?
		}else {
			request.setAttribute("matchError", "現在のパスワードが正しくありません");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/inputNewPass.jsp");
			d.forward(request, response);//redirect?
		}
	}

}
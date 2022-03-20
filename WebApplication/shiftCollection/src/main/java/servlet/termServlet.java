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
 * Servlet implementation class termServlet
 */
@WebServlet("/termServlet")
public class termServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		//ログイン情報 となる m を取り出すことで，ログインできているかを確認
		
		if(m == null) {
			request.setAttribute("loginError", "正式なログインができておりません\nログインしなおしてください");
			response.sendRedirect("/shiftCollection/welcome.jsp");
		}else if(m != null && m.isUpdated()) {//途中で終了してしまった場合，再ログイン時に変更内容を更新したい
			MemberDAO dao = new MemberDAO();
			dao.updateAll(m);
			m.updateCompleted();
		}
		
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/registerTerm.jsp");
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//月と期間(前半 or 後半)の情報を取得し，記憶する
		request.setCharacterEncoding("UTF-8");
		int month = Integer.parseInt(request.getParameter("month"));
		int term = Integer.parseInt(request.getParameter("term"));
		if(isFeasible(month, term)) {
			HttpSession session = request.getSession();
			Member m = (Member) session.getAttribute("member");
			session.setAttribute("month", month);
//			session.setAttribute("term", term);
			if(m.termChanged(month, term))m.initializeSchedule(month, term);
			session.setAttribute("member", m);
			//setTerm を m.getDayNum の中に
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/registerTerm.jsp");
			d.forward(request, response);
		}else {
			request.setAttribute("inputError", "月が正確に入力されていません");
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/registerTerm.jsp");
			d.forward(request, response);
		}
	}
	public boolean isFeasible(int m, int t) {
		return ((1 <= m) || (m <= 12)) && (t == 0 || t == 1);
	}
}

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

/**
 * Servlet implementation class DeleteMemberExecute
 */
@WebServlet("/DeleteMemberExecute")
public class DeleteMemberExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int deleteID = (int)session.getAttribute("deleteID");
		String deleteName = (String)session.getAttribute("deleteName");
		MemberDAO dao = new MemberDAO();
		dao.deleteMember(deleteID);
		session.setAttribute("executeMsg", deleteName + " さんを削除しました");
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/deleteMember.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/
}

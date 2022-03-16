package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GenerateCsv
 */
@WebServlet("/GenerateCsv")
public class GenerateCsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String[] output = (String[])session.getAttribute("output");
		String filename = "output.csv";
		//GenerateCSV gc = new GenerateCSV(output, filename);
		

		response.setHeader("Context-Type", "text/csv; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		PrintWriter out = response.getWriter();
		for(int i = 0;i < output.length;i++) {
			out.append(",シフト\n");
			out.append("氏名,出勤，退勤\n\n");
			out.append(output[i]);
		}
		out.close();
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller.doctorServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;

/**
 * Servlet implementation class GetViewOrRemoveOrUpdateMedicalReport
 */
public class GetViewOrRemoveOrUpdateMedicalReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(GetViewOrRemoveOrUpdateMedicalReport.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button=request.getParameter("selectedValue");
		request.setAttribute("button", button);
		
		//PrintWriter writerA = response.getWriter();
		//writerA.println(button);

		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewOrRemoveOrUpdateMedicalReport.jsp");
		  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

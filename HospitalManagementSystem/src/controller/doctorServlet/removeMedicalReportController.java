package controller.doctorServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bl.DoctorBusinessLogic;

public class removeMedicalReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(removeMedicalReportController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int patientId=Integer.parseInt(request.getParameter("patientId"));
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		boolean result=false;
		try {
			try {
				result=dbl.removeMedicalReport(patientId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(request.getParameter("patientId")==null){
			String message="Patient not found";
			session.setAttribute("message", message);
			response.sendRedirect("output.jsp");
		}
		request.setAttribute("patientId", patientId);
		
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/removeMedicalReport.jsp");
	    rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

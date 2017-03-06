package controller.doctorServlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bean.Appointment;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class updateMedicalReport
 */
public class updateMedicalReport extends HttpServlet {
	
	private static Logger logger=Logger.getLogger(updateMedicalReport.class);
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		String visitDateString = (request.getParameter("visitDate"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date visitDate = java.sql.Date.valueOf(visitDateString);
		String diagnosis = request.getParameter("diagnosis");
		String investigations = request.getParameter("investigations");
		String tests = request.getParameter("tests");
		String recommendations = request.getParameter("recommendations");
		String doctorId=request.getParameter("doctorId");
		String technicianId=request.getParameter("technicianId");
		
//		String doctorId=request.getParameter("doctorId");
//		Integer fee=Integer.parseInt(request.getParameter("fee"));
//		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
//		String puspose=request.getParameter("purpose");
//		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		
		AdminBusinessLogic abl = new AdminBusinessLogic();
		MedicalReport newMedicalReport = new MedicalReport();
		newMedicalReport.setPatientId(regNo);
		newMedicalReport.setVisitDate(visitDate);
		newMedicalReport.setDiagnosis(diagnosis);
		newMedicalReport.setInvestigations(investigations);
		newMedicalReport.setTests(tests);
		newMedicalReport.setRecommendations(recommendations);
		newMedicalReport.setDoctorId(doctorId);
		newMedicalReport.setTechnicianId(technicianId);
		try {
			try {
				boolean status=abl.modifyMedicalReport(regNo, newMedicalReport);
				
				BasicConfigurator.configure();
		 	    logger.info("Updated Medical Report by Doctor!!");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("medicalReport",newMedicalReport);
			String servlet="./doctor.jsp";
			String button="CONTINUE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);

		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewOrRemoveOrUpdateFormMedicalReport.jsp");
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

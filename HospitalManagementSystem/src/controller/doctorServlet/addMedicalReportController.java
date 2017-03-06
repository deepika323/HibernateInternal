package controller.doctorServlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bean.MedicalReport;
import model.bean.Medicine;
import model.bl.DoctorBusinessLogic;

public class addMedicalReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(addMedicalReportController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int patientId=Integer.parseInt(request.getParameter("appointmentId"));
		String visitDateString=(request.getParameter("visitDate"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date visitDate=java.sql.Date.valueOf(visitDateString);			//check
//		try {
//			visitDate = (Date)sdf.parse(visitDateString);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		String diagnosis=request.getParameter("diagnosis");
		String investigations=request.getParameter("investigations");
		String tests=request.getParameter("tests");
		String recommendations=request.getParameter("recommendations");
		String doctorId=request.getParameter("doctorId");
		String technicianId=request.getParameter("technicianId");
		int sNo=Integer.parseInt(request.getParameter("sNo"));
		String medicineName=request.getParameter("medicineName");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String dosage=request.getParameter("dosage");
		int price=Integer.parseInt(request.getParameter("price"));
		
		MedicalReport newMedicalReport = new MedicalReport();
		newMedicalReport.setPatientId(patientId);
		newMedicalReport.setVisitDate(visitDate);
		newMedicalReport.setDiagnosis(diagnosis);
		newMedicalReport.setInvestigations(investigations);
		newMedicalReport.setTests(tests);
		newMedicalReport.setRecommendations(recommendations);
		newMedicalReport.setDoctorId(doctorId);
		newMedicalReport.setTechnicianId(technicianId);
		Medicine newMedicine = new Medicine();
		newMedicine.setsNo(sNo);
		
		newMedicine.setMedicineName(medicineName);
		newMedicine.setQuantity(quantity);
		newMedicine.setDosage(dosage);
		newMedicine.setPrice(price);
		newMedicine.setPatientId(patientId);
		
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		boolean result=false;
		boolean result1=false;
		try {
			try {
				result=dbl.addMedicalReport(newMedicalReport);
				result1=dbl.addMedicine(newMedicine);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("newMedicalReport", newMedicalReport);
		 request.setAttribute("newMedicine", newMedicine);
		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/addMedicalReport.jsp");
		    rd.forward(request, response);
		    //Change
//		    if(request.getParameter("doctorId")==null){
//		    	String message="Doctor not found";
//		    	session.setAttribute("message", message);
//		    	response.sendRedirect("output.jsp");
//		    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

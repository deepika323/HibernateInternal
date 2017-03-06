package controller.patientServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bl.PersonBusinessLogic;


public class MedicalReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(MedicalReportServlet.class);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Code for Getting relevant Medical Report.
		
		HttpSession session=request.getSession();
		String personId =(String)session.getAttribute("personId");
		
		PersonBusinessLogic pb = new PersonBusinessLogic();
		
		try { 
			if(pb.listMyMedicalReport(personId)!=null){
				//PrintWriter pw=response.getWriter();
				request.setAttribute("reportList", pb.listMyMedicalReport(personId)) ;
				
				BasicConfigurator.configure();
		 	    logger.info("Medical Report viewed by Patient!!");
		 	    
				//pw.println(pb.listMyMedicalReport("twahal"));
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/medicalReport.jsp");
			    rd.forward(request, response);
	
			}//Add MedicalReport.jsp and recheck logic.
			else 
			{
				String message="Medical Report not found.";
				session.setAttribute("message", message);
				response.sendRedirect("ErrorPage.jsp");
			}
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

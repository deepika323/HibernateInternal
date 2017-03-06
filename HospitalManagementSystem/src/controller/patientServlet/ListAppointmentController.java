package controller.patientServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bean.Appointment;
import model.bl.PersonBusinessLogic;



public class ListAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(ListAppointmentController.class);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Code for Getting relevant Appointment List.
		
		HttpSession session=request.getSession();
		String personId =(String)session.getAttribute("personId");
		
		PersonBusinessLogic pb = new PersonBusinessLogic();
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		
			try {
				appointmentList=pb.myAppointments(personId);
				
				BasicConfigurator.configure();
		 	    logger.info("Appointment listed by Patient!!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			if(request.getParameter("personId")==null){
//				String message="Patient not found";
//				session.setAttribute("message", message);
//				response.sendRedirect("ErrorPage.jsp");
//			}
		
		 request.setAttribute("appList", appointmentList);
		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAppointment.jsp");
		    rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

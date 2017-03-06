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

public class DischargeSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(DischargeSummaryServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Code for getting discharge summary using serial number
		HttpSession session=request.getSession();
		String personId =(String)session.getAttribute("personId");
		
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			
			if(pb.listMyDischargeSummary(personId)!=null){
				
				request.setAttribute("dischargeSummaryList", pb.listMyDischargeSummary(personId));
				
				BasicConfigurator.configure();
		 	    logger.info("Discharge Summary Viewed by Patient!!");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/dischargeSummary.jsp");
			    rd.forward(request, response);
			}//Add Discharge Summary jsp and recheck logic.
			else 
				{
				
					String message="Discharge Summary not found";
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

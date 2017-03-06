package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bl.PersonBusinessLogic;


public class AddBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(AddBill.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String personId = request.getParameter("personId");
		
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
		
			
			if(pb.listMyDischargeSummary(personId)!=null){
				
				//request.setAttribute("personId", personId);
				request.setAttribute("dischargeSummaryList", pb.listMyDischargeSummary(personId));
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddBill.jsp");
			    rd.forward(request, response);
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

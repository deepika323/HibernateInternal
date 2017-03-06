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
import model.bean.Medicine;
import model.bl.PersonBusinessLogic;


public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(MedicineServlet.class);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//Code for Getting Medicine result.
		
				HttpSession session=request.getSession();
				String personId =(String)session.getAttribute("personId");
				
				PersonBusinessLogic pb = new PersonBusinessLogic();
				
				try { 
					
					ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
					medicineList=pb.listMyMedicine(personId);
					
					BasicConfigurator.configure();
			 	    logger.info("Listing of Medicine by Person!!");
//					if(medicineList.size()==0)
//					{ 
//						String message="Medicine not found";
//						session.setAttribute("message", message);
//						response.sendRedirect("ErrorPage.jsp");
//					} 
//					else  
//					{ 
						request.setAttribute("medicineList", medicineList);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/medicine.jsp");
					    rd.forward(request, response);
//					for(Medicine m:medicineList)
//					{ 
//					System.out.println(m);
//					} 
//					} 
					
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

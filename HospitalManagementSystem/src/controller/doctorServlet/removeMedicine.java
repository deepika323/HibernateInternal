package controller.doctorServlet;

import java.io.IOException;
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
import model.bl.DoctorBusinessLogic;

/**
 * Servlet implementation class removeMedicine
 */
public class removeMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(removeMedicine.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int patientId=Integer.parseInt(request.getParameter("regNo"));
		int radioValue=Integer.parseInt(request.getParameter("radioValue"));
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		boolean result=false;
		try {
			try {
				result=dbl.removeMedicine(radioValue, patientId);
				
				BasicConfigurator.configure();
		 	    logger.info("Medicine Removed by Doctor!!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("doctor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

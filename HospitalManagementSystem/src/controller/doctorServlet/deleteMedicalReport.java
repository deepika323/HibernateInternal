package controller.doctorServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

/**
 * Servlet implementation class deleteMedicalReport
 */
public class deleteMedicalReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(deleteMedicalReport.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
		AdminBusinessLogic abl=new AdminBusinessLogic();
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		
			try {
				boolean status=abl.removeMedicalReport(regNo);
				boolean status1=dbl.removeMedicalReport(regNo);
				BasicConfigurator.configure();
		 	    logger.info("Medical Report removed by Doctor!!");
			}
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			PrintWriter out=response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Medical Report Deleted');");
			   out.println("location='doctor.jsp'");
			   out.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

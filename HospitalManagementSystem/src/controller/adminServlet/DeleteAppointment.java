package controller.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bean.Appointment;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class DeleteAppointment
 */
public class DeleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(DeleteAppointment.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			Integer regNo=Integer.parseInt(request.getParameter("regNo"));
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
			try {
				boolean status=abl.removeAppointment(regNo);
				
				BasicConfigurator.configure();
		 	    logger.info("Appointment Deleted");
			}
		 catch (SQLException e) {
				PrintWriter out=response.getWriter();
				 out.println("<script type=\"text/javascript\">");
				   out.println("alert('Deletion Failed Due To Dependencies');");
				   out.println("location='admin.jsp';");
				   out.println("</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			PrintWriter out=response.getWriter();
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Deletion Failed Due To Dependencies');");
			   out.println("location='admin.jsp';");
			   out.println("</script>");
		}
			PrintWriter out=response.getWriter();
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Appointment Deleted');");
			   out.println("location='admin.jsp';");
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

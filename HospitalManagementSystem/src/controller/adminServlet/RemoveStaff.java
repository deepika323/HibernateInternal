package controller.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class RemoveStaff
 */
public class RemoveStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(RemoveStaff.class);
       
  //Delete Staff Member
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffId= request.getParameter("staffId");
		AdminBusinessLogic abl=new AdminBusinessLogic();
		boolean status=false;
			try {
				status=abl.removeStaff(staffId);
				
				BasicConfigurator.configure();
		 	    logger.info("Staff Removed!!");
				
				status=true;
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
			if(status==true){
			PrintWriter out=response.getWriter();
			 out.println("<script type=\"text/javascript\">");  
			 out.println("alert('Staff Deleted');");
			 out.println("location='admin.jsp';");
			 out.println("</script>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

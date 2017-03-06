package controller.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;

/**
 * Servlet implementation class DisplayDepartment
 */
public class DisplayDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(DisplayDepartment.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BasicConfigurator.configure();
 	    logger.info("Department Displayed!!");
		
		PrintWriter pw=response.getWriter();
		pw.println(request.getParameter("deptId"));
		
		pw.println("Site Under Construction");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

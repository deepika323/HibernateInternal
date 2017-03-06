package controller.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bean.Appointment;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

/**
 * Servlet implementation class ViewMR
 */
public class ViewMR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(ViewMR.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appList=new ArrayList<Appointment>();
		
		BasicConfigurator.configure();
 	    logger.info("MR View Page visites!!");
		
		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
		AdminBusinessLogic abl=new AdminBusinessLogic();
		MedicalReport mr=new MedicalReport();
		try {
			try {
				mr=abl.viewMedicalReports(regNo);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("mr", mr);
		 
		 String servlet="./admin.jsp";
			String button="CONTINUE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);
		//PrintWriter pw=response.getWriter();
		
		//pw.println("MR "+mr);
		 
		 
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewMR.jsp");
		    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

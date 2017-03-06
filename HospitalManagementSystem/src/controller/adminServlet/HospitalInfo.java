package controller.adminServlet;

import java.io.IOException;
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
import model.bean.Department;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class HospitalInfo
 */
public class HospitalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(HospitalInfo.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
		ArrayList<Department> departmentList=new ArrayList<Department>();
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
		try {
			doctorList=abl.listDoctor();
			departmentList=abl.listDepartment();
			
			BasicConfigurator.configure();
	 	    logger.info("Hospital Info page visited!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 request.setAttribute("doctorList", doctorList);
		 request.setAttribute("departmentList", departmentList);
			
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/HospitalInfo.jsp");
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

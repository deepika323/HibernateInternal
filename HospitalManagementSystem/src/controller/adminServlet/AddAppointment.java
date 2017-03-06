package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bean.Department;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;



/**
 * Servlet implementation class AddAppointment
 */
public class AddAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(AddAppointment.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAppointment() {
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
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 request.setAttribute("doctorList", doctorList);
		 request.setAttribute("departmentList", departmentList);
			
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/addAppointment.jsp");
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

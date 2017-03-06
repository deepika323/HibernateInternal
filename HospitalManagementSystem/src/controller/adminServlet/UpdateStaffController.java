package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bean.Staff;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class UpdateStaffController
 */
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(UpdateStaffController.class);
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staffId=request.getParameter("id");
		String staffName=request.getParameter("name");
		String specialization=request.getParameter("specialization");
		String timing=request.getParameter("timing");
		String staffAddress=request.getParameter("Address");
		long staffPhoneNo=Long.parseLong(request.getParameter("phone"));
		String staffPassword=request.getParameter("Password");
		int departmentId=Integer.parseInt(request.getParameter("department"));
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		Staff staff=new Staff();
		
		staff.setDepartmentId(departmentId);
		staff.setSpecialization(specialization);
		staff.setStaffAddress(staffAddress);
		staff.setStaffId(staffId);
		staff.setStaffName(staffName);
		staff.setStaffPassword(staffPassword);
		staff.setStaffPhoneNo(staffPhoneNo);
		staff.setTiming(timing);
		
		
		
		try {
			try {
				boolean status=abl.modifyStaff(staffId, staff);
				
				BasicConfigurator.configure();
		 	    logger.info("Staff Updated");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("staff",staff);
			String servlet="./admin.jsp";
			String button="CONTINUE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);

		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newStaff.jsp");
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

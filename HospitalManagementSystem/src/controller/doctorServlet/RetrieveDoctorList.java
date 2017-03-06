package controller.doctorServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bean.Appointment;
import model.bean.Department;
import model.bean.Doctor;
import model.bean.Medicine;
import model.bean.Technician;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

/**
 * Servlet implementation class RetrieveDoctorList
 */
public class RetrieveDoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(RetrieveDoctorList.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveDoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
		ArrayList<Technician> technicianList=new ArrayList<Technician>();
		ArrayList<Department> departmentList=new ArrayList<Department>();
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		HttpSession session=request.getSession();
		
		String doctorId=(String) session.getAttribute("doctorId");
		AdminBusinessLogic abl=new AdminBusinessLogic();
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		
		try {
//			doctorList=abl.listDoctor();
			technicianList=abl.listTechnician();
			departmentList=abl.listDepartment();
			Doctor doctor=abl.viewDoctor(doctorId);
			doctorList.add(doctor);
			//appointmentList=abl.listAppointment();
			appointmentList=dbl.myAppointments(doctorId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 request.setAttribute("doctorList", doctorList);
		 request.setAttribute("technicianList", technicianList);
		 request.setAttribute("departmentList", departmentList);
		 request.setAttribute("appointmentList", appointmentList);
		 
//		PrintWriter pw=response.getWriter();
//		pw.println(doctorId); 
//		pw.println();
//		pw.println(doctorList);
//		 pw.println(appointmentList);
//		 
			
   RequestDispatcher rd = getServletContext().getRequestDispatcher("/addMedicalReportForm.jsp");
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

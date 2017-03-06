package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.bean.Appointment;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class DischargeAjax
 */
public class DischargeAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DischargeAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appList=new ArrayList<Appointment>();
		Integer regNo=Integer.parseInt(request.getParameter("name"));
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
		 
		 if(mr.getAppointmentId()==0)
		 {
			 List<String> list = new ArrayList<>();
			    list.add("Medical Report Not Found");
			    
			    String json = new Gson().toJson(list);

			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);

		 }
		 else{
		 //String text = "<br>Message from servlet<br>"; //message you will recieve 
		 //   String name = request.getParameter("name");
		 List<String> list = new ArrayList<>();
		    list.add("Medical Report ID : "+Integer.toString(mr.getAppointmentId()));
		    list.add("Diagnosis : " +mr.getDiagnosis());
		    list.add("Doctor ID: "+mr.getDoctorId());
		    list.add("Investigations : "+mr.getInvestigations());
		    list.add("Tests : "+mr.getTests());
		    
		    String json = new Gson().toJson(list);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		 
		    //PrintWriter out = response.getWriter();
		    //out.println(mr.toString());
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

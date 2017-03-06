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
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import model.bean.DischargeSummary;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class AddDischargeSummary
 */
public class AddDischargeSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(AddDischargeSummary.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDischargeSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
		Integer bedNo=null;
		HttpSession session=request.getSession();
		if(request.getParameter("bedNo")!=null){
		bedNo=Integer.parseInt(request.getParameter("bedNo"));
		}
		String history=request.getParameter("history");
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
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		int serialNo= Math.abs((int) currentDate.getTime());
		DischargeSummary newDischarge=new DischargeSummary();
		
		newDischarge.setAdmissionDate(currentDate);
		if(bedNo!=null||bedNo==0)
		{
		newDischarge.setBedNo(bedNo);
		}
		newDischarge.setDischargeDate(currentDate);
		newDischarge.setSerialNo(serialNo);
		newDischarge.setPatientId(regNo);
		newDischarge.setOnExamination(mr.getTests());
		newDischarge.setOperationDone(mr.getDiagnosis());
		newDischarge.setOperativeFindings(mr.getTests());
		newDischarge.setRecommendations(mr.getRecommendations());
		newDischarge.setDoctorId(mr.getDoctorId());
		newDischarge.setTreatmentGiven(mr.getDiagnosis());
		
		try {
			try {
				boolean status=abl.addDischargeSummary(newDischarge);
				
				BasicConfigurator.configure();
		 	    logger.info("Discharge Summary Added!!");
				 request.setAttribute("appointment",newDischarge);
					String servlet="./admin.jsp";
					String button="CONTINUE";
					
				request.setAttribute("servlet", servlet);
				request.setAttribute("button", button);

				 RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDischargeSummary.jsp");
				    rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			PrintWriter out=response.getWriter();
			 out.println("<script type=\"text/javascript\">");  
			 out.println("alert('Discharge Summary Addition Failed!!!');");
			 out.println("alert('Make Sure The Bed Exist!!!');");
		 
			 out.println("location='./addDischargeSummary.jsp';");
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

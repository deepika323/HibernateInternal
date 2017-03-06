package controller.adminServlet;

import java.io.IOException;
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
import model.bean.Bill;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class UpdateBill
 */
public class UpdateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(UpdateBill.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer serialNo=Integer.parseInt(request.getParameter("discharge"));
		Integer billNo=Integer.parseInt(request.getParameter("billNo"));
		int appointmentId=Integer.parseInt(request.getParameter("patientId"));
		float doctorVisit=Float.parseFloat(request.getParameter("docfee"));
		float bedCharges=Float.parseFloat(request.getParameter("bedfee"));
		float tests=Float.parseFloat(request.getParameter("tests"));
		float medicines=Float.parseFloat(request.getParameter("medicines"));
		
		Bill bill = new Bill();
		bill.setBedCharges(bedCharges);
		bill.setBillNo(billNo);
		bill.setDoctorVisit(doctorVisit);
		bill.setMedicines(medicines);
		bill.setPatientId(appointmentId);
		bill.setSerialNo(serialNo);
		bill.setTests(tests);
		AdminBusinessLogic abl=new AdminBusinessLogic();
		try {
			try {
				boolean status=abl.modifyBill(billNo, bill);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("bill",bill);
			String servlet="./admin.jsp";
			String button="CONTINUE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);

		BasicConfigurator.configure();
 	    logger.info("Bill Updated!!");
		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newBill.jsp");
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

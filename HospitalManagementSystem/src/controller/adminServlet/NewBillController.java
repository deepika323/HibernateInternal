package controller.adminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Bill;
import model.bl.AdminBusinessLogic;

import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;

public class NewBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Integer serialNo=Integer.parseInt(request.getParameter("discharge"));
		int appointmentId=Integer.parseInt(request.getParameter(serialNo.toString()));
		float doctorVisit=Float.parseFloat(request.getParameter("docfee"));
		float bedCharges=Float.parseFloat(request.getParameter("bedfee"));
		float tests=Float.parseFloat(request.getParameter("tests"));
		float medicines=Float.parseFloat(request.getParameter("medicines"));
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		int billNo= Math.abs((int) currentDate.getTime());
		AdminBusinessLogic abl=new AdminBusinessLogic();
		Bill bill = new Bill();
		bill.setBedCharges(bedCharges);
		bill.setBillNo(billNo);
		bill.setDoctorVisit(doctorVisit);
		bill.setMedicines(medicines);
		bill.setPatientId(appointmentId);
		bill.setSerialNo(serialNo);
		bill.setTests(tests);
		
		try {
			try {
				boolean status=abl.addBill(bill);
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

		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newBill.jsp");
		    rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

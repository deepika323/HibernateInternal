package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Department;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class FindDischargeSummary
 */
public class FindDischargeSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDischargeSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
		AdminBusinessLogic abl=new AdminBusinessLogic();
		try {
			try {
				request.setAttribute("appointment",abl.viewDischargeSummary(regNo));
				//appList=dbl.myAppointments(doctorId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String operation=request.getParameter("selectedValue");
		
		
		//To DELETE
		
		if(operation.equalsIgnoreCase("Remove"))
		{
			String servlet="./RemoveDischargeSummary";
			String button="DELETE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);
		request.setAttribute("regNo", regNo);
		}
		
		//TO FIND AND DISPLAY
		else if(operation.equalsIgnoreCase("Find"))
		{
			String servlet="./admin.jsp";
			String button="CONTINUE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);

		}
		
		

		//PrintWriter writerA = response.getWriter();
		//writerA.println(operation);
		
    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDischargeSummary.jsp");
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

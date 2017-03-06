package controller.adminServlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Appointment;
import model.bean.DischargeSummary;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class FindOrRemove
 */
public class FindOrRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOrRemoveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String button=request.getParameter("selectedValue");
		request.setAttribute("button", button);
		
		//PrintWriter writerA = response.getWriter();
		//writerA.println(button);
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ArrayList<Appointment> appList=new ArrayList<Appointment>();
		
		
		try {
			appList=abl.listAppointment();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("appList", appList);

		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/findAppointment.jsp");
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

package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class UpdateStaff
 */
public class UpdateStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staffId=request.getParameter("staffId");
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
		try {
				request.setAttribute("staff",abl.viewStaff(staffId));
				
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateStaff.jsp");
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

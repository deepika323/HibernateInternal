package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bean.Department;

import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class AddDoctor
 */
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(AddDoctor.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Department> departmentList=new ArrayList<Department>();
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
		try {
			
			departmentList=abl.listDepartment();
			
			BasicConfigurator.configure();
	 	    logger.info("Adding Doctor!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 request.setAttribute("departmentList", departmentList);
			
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/addDoctor.jsp");
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

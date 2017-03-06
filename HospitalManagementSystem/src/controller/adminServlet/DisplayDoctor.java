package controller.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.doctorServlet.removeMedicine;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class DisplayDoctor
 */
public class DisplayDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(DisplayDoctor.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BasicConfigurator.configure();
 	    logger.info("Doctor Displayed!!");
 	    
		PrintWriter pw=response.getWriter();
		String doctorId=request.getParameter("docId");
		
		Doctor newDoctor=new Doctor();
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
		try {
			newDoctor=abl.viewDoctor(doctorId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("doctor",newDoctor);
		String servlet="./admin.jsp";
		String button="CONTINUE";
		
	request.setAttribute("servlet", servlet);
	request.setAttribute("button", button);

	
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDoctor.jsp");
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

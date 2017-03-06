package controller.staffServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;
import model.bean.Ward;
import model.bl.StaffBusinessLogic;

/**
 * Servlet implementation class ViewMyWardsController
 */
public class ViewMyWardsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(ViewMyWardsController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyWardsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String staffId=(String) session.getAttribute("staffId");
		//String staffId = request.getParameter("staffId");
		StaffBusinessLogic sbl = new StaffBusinessLogic();
		ArrayList<Ward> wardList=new ArrayList<Ward>();
		System.out.println(staffId);
		try {
			wardList = sbl.myWards(staffId);
			
			BasicConfigurator.configure();
	 	    logger.info("Ward List viewed by Staff!!");
		} catch (ClassNotFoundException | SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{	
			PrintWriter out=response.getWriter();
			 out.println("<script type=\"text/javascript\">");  
			 out.println("alert('No Wards!!!');");
			 out.println("location='./viewWards.jsp';");
			 out.println("</script>");
			
		}
//		PrintWriter out=response.getWriter();
//		 out.println(wardList);  
		
		
		request.setAttribute("staffId", staffId);
		request.setAttribute("wardList", wardList);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewWards.jsp");
	    rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

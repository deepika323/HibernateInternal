package controller.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.loginSignUp.LogInController;

/**
 * Servlet implementation class AdminLogInController
 */
public class AdminLogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Logger log = Logger.getLogger(LogInController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("ID");
 		String password= request.getParameter("password");
 		if(id.equals("admin")&&password.equals("admin")){
 			log.info("Admin Login Successful");
 			HttpSession session = request.getSession();
 			session.setAttribute("admin", id);
 			response.sendRedirect("./admin.jsp");
 		}
 		else{
 			response.sendRedirect("./ErrorPage.jsp");
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

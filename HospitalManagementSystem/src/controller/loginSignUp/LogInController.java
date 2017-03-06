package controller.loginSignUp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import model.bl.DoctorBusinessLogic;
import model.bl.PersonBusinessLogic;
import model.bl.StaffBusinessLogic;


/**
 * Servlet implementation class LogInController
 */
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(LogInController.class);
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1= request.getParameter("ID");
 		String password1= request.getParameter("password");
 		
 		BasicConfigurator.configure();
 	   
 		
 		PrintWriter pw=response.getWriter();
 		//pw.print(request.getParameter("radios")); 
		
		
		if(request.getParameter("radios").equals("radio1")){
		 		String id = request.getParameter("ID");
		 		String password = request.getParameter("password");
		 		
		 		PrintWriter out=response.getWriter();
		 				 		
		 		StaffBusinessLogic sbl = new StaffBusinessLogic();
		 		try {
					if(sbl.staffLogin(id, password)!=null){
						logger.info("Staff Login Successful");
						HttpSession session=request.getSession();
						session.setAttribute("staffId",id);
						response.sendRedirect("./staff.jsp");
					}
					else {
//						PrintWriter out=response.getWriter();
						 out.println("<script type=\"text/javascript\">");  
						 out.println("alert('Login Failed!!!');");
						 out.println("location='./login.jsp';");
						 out.println("</script>");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					logger.info("Staff Login Failed");
					e.printStackTrace();
				} catch (SQLException e) {
					logger.info("Staff Login Failed");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		catch (Exception e){
		 			//PrintWriter out=response.getWriter();
					 out.println("<script type=\"text/javascript\">");  
					 out.println("alert('Login Failed!!!');");
					 out.println("location='./login.jsp';");
					 out.println("</script>");
		 			
		 		}
		 	}
		 	else if(request.getParameter("radios").equals("radio2")){
		 		String id = request.getParameter("ID");
		 		String password = request.getParameter("password");
		 		
		 		
		 		
		 		PersonBusinessLogic pbl = new PersonBusinessLogic();
		 		
		 		

		 		try {
					if(pbl.personLogin(id, pbl.getHashString(password)).getPersonAge()!=0){
						logger.info("Patient Login Successful");
						HttpSession session=request.getSession();
						session.setAttribute("personId",id);
						response.sendRedirect("./Patient.jsp");
					}
					else
					{
						response.sendRedirect("./personlogin.jsp");	
					}
				} catch (ClassNotFoundException e) {
					logger.info("Paient Login Failed");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					logger.info("Patient Login Failed");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		catch (Exception e){
		 			PrintWriter out=response.getWriter();
					 out.println("<script type=\"text/javascript\">");  
					 out.println("alert('Login Failed!!!');");
					 out.println("location='./personlogin.jsp';");
					 out.println("</script>");
		 			
		 		}
		 	}
		 	else if(request.getParameter("radios").equals("radio3")){
		 		String id = request.getParameter("ID");
		 		String password = request.getParameter("password");
		 		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		 		try {
					if(dbl.doctorLogin(id, password)!=null){
						logger.info("Doctor Login Successful");
						HttpSession session=request.getSession();
						session.setAttribute("doctorId",id);
						response.sendRedirect("./doctor.jsp");
					}
					else {
						PrintWriter out=response.getWriter();
						 out.println("<script type=\"text/javascript\">");  
						 out.println("alert('Login Failed!!!');");
						 out.println("location='./login.jsp';");
						 out.println("</script>");
					}
				} catch (ClassNotFoundException e) {
					logger.info("Doctor Login Failed");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					logger.info("Doctor Login Failed");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		catch (Exception e){
		 			PrintWriter out=response.getWriter();
					 out.println("<script type=\"text/javascript\">");  
					 out.println("alert('Login Failed!!!');");
					 out.println("location='./login.jsp';");
					 out.println("</script>");
		 			
		 		}
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

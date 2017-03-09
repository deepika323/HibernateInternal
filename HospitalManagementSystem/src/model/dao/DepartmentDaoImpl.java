package model.dao;

import static model.helper.ConnectToDb.closeConnection;
import static model.helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import model.helper.ConnectToDb.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import model.bean.Bill;
import model.bean.Department;
import model.bean.Doctor;

public class DepartmentDaoImpl implements DepartmentDao {

	SessionFactory factory=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	Transaction t;  
	Session session=factory.openSession();
	
//	private PreparedStatement pstmt=null;
//	private Connection con;
//	private ResultSet rs;
	
	@Override
	public boolean insertDepartment(Department newDepartment) throws ClassNotFoundException, SQLException, IOException {
		
		try{
			t=session.beginTransaction();
			
			session.save(newDepartment);
			
			t.commit();
			System.out.println("Record Inserted");
			return true;
			}
			catch(Exception ex){
				t.rollback();
			}
			finally{
				session.close();
			}
			
			return false;
		
		
//		con= openConnection();
//		
//		int departmentId =newDepartment.getDepartmentId();
//		String departmentName = newDepartment.getDepartmentName();
//		String departmentLocation=newDepartment.getDepartmentLocation();
//		String description=newDepartment.getDescription();
//		
//		pstmt=con.prepareStatement("insert into department (departmentId,"
//				+ "departmentName,departmentLocation,description)"
//				+ " values" + "(?,?,?,?)");
//		
//		pstmt.setInt(1, departmentId);
//		pstmt.setString(2, departmentName);
//		pstmt.setString(3, departmentLocation);
//		pstmt.setString(4, description);
//		
//	
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//		}
//		else 
//		{
//			closeConnection(con);
//			return false;
//		}

	}

	@Override
	public boolean deleteDepartment(int departmentId) throws SQLException, ClassNotFoundException, IOException {
		
		try{
			Bill bill=(Bill) session.get(Bill.class,departmentId);
			session.delete(bill);
			System.out.println("Record Deleted");
			return true;
			}
			catch(Exception ex){
				System.out.println("Record Not Deleted");
			}
			finally{
				session.close();
			}
			
			return false;
			
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("delete from department where departmentId = ?");
//		
//		pstmt.setInt(1,departmentId);
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//			}
//		else 
//		{
//			closeConnection(con);
//			return false;
//			}

	}

	@Override
	public boolean updateDepartment(int departmentId, Department renewDepartment) throws ClassNotFoundException, SQLException, IOException {

		try{
			t=session.beginTransaction();
			
			//session.save(renewBill);
			session.update(renewDepartment);
			
			t.commit();
			System.out.println("Record Updated");
			return true;
			}
			catch(Exception ex){
				t.rollback();
			}
			finally{
				session.close();
			}
			
			return false;
		
		
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("update department set departmentName = ? , departmentLocation =? "
//				+ ", description=?"
//				+ "where departmentId= ?");
//		
//
//		pstmt.setString(1,renewDepartment.getDepartmentName());
//		pstmt.setString(2,renewDepartment.getDepartmentLocation());
//		pstmt.setString(3, renewDepartment.getDescription());
//		pstmt.setInt(4, departmentId);
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true ;
//		}
//		else 
//		{
//			closeConnection(con);
//			return false;
//			
//		}
		

		


	}

	@Override
	public Department displayDepartment(int departmentId) throws ClassNotFoundException, SQLException, IOException {
		
		try{
			Department department=(Department) session.get(Department.class,departmentId);
			System.out.println("Record Displayed");
			return department;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		
		
		return null;
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select * from department where departmentId = ?");
//		pstmt.setInt(1,departmentId);
//		
//		rs=pstmt.executeQuery();
//		
//		Department department=new Department();
//		while(rs.next())
//		{
//			department.setDepartmentId(rs.getInt("departmentId"));
//			department.setDepartmentLocation(rs.getString("departmentLocation"));
//			department.setDepartmentName(rs.getString("departmentName"));
//			department.setDescription(rs.getString("description"));
//		}
//		
//		closeConnection(con);
//		return department;


	}

	@Override
	public ArrayList<Department> displayAllDepartments() throws ClassNotFoundException, SQLException, IOException {
		
		try{
			Query query=session.createQuery("from Department");
			List<Department> departmentList=query.list();
			System.out.println("Record Displayed");
			return (ArrayList<Department>)departmentList;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		return null;
		
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select * from department ");
//		
//		ArrayList<Department> departmentList=new ArrayList<Department>();
//		rs=pstmt.executeQuery();
//		
//		
//		while(rs.next())
//		{
//			Department department=new Department();
//			department.setDepartmentId(rs.getInt("departmentId"));
//			department.setDepartmentLocation(rs.getString("departmentLocation"));
//			department.setDepartmentName(rs.getString("departmentName"));
//			department.setDescription(rs.getString("description"));
//			departmentList.add(department);
//		}
//		
//		closeConnection(con);
//		return departmentList;

	}

}

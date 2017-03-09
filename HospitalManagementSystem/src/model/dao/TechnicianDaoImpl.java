package model.dao;

import static model.helper.ConnectToDb.closeConnection;
import static model.helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
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

import model.bean.Medicine;
import model.bean.Technician;

public class TechnicianDaoImpl implements TechnicianDao {
	
	SessionFactory factory=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	Transaction t;  
	Session session=factory.openSession();
	
//	private PreparedStatement pstmt=null;
//	private Connection con;
//	private ResultSet rs;
	
	@Override
	public boolean insertTechnician(Technician newTechnician) throws ClassNotFoundException, SQLException, IOException {
		
		try{
			t=session.beginTransaction();
			
			session.save(newTechnician);
			
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
		
		// TODO Auto-generated method stub
//		con= openConnection();
//		
//		String technicianId=newTechnician.getTechnicianId();
//		String technicianName=newTechnician.getTechnicianName();
//		String technicianAddress=newTechnician.getTechnicianAddress();
//		String specialization=newTechnician.getSpecialization();
//		String timing=newTechnician.getTiming();
//		long technicianPhoneNo=newTechnician.getTechnicianPhoneNo();
//		int departmentId=newTechnician.getDepartmentId();
//		String technicianPassword=newTechnician.getTechnicianPassword();
//		
//		
//		
//		
//		pstmt=con.prepareStatement("insert into Technician (technicianId,technicianName," +
//				"timing,specialization,technicianAddress,technicianPhoneNo,departmentId,Password) values" + 
//				"(?,?,?,?,?,?,?,?)");
//		
//		pstmt.setString(1,technicianId);
//		pstmt.setString(2,technicianName );
//		pstmt.setString(3, timing);
//		pstmt.setString(4, specialization);
//		pstmt.setString(5, technicianAddress);
//		pstmt.setLong(6, technicianPhoneNo);
//		pstmt.setInt(7, departmentId);
//		pstmt.setString(8, technicianPassword);
//		
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//		}
//		else closeConnection(con);
//		return false;
	}

	@Override
	public boolean deleteTechnician(String technicianId) throws ClassNotFoundException, SQLException, IOException {

		try{
			Technician technician=(Technician) session.get(Technician.class,technicianId);
			session.delete(technician);
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
		
		//		// TODO Auto-generated method stub
//        con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("delete from technician where technicianId = ?");
//		
//		pstmt.setString(1,technicianId);
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
	public boolean updateTechnician(String technicianId, Technician renewTechnician) throws ClassNotFoundException, SQLException , IOException{

		try{
			t=session.beginTransaction();
			
			//session.save(renewBill);
			session.update(renewTechnician);
			
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
		
		//		// TODO Auto-generated method stub
//        con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("update technician set technicianName = ? , specialization =? "
//				+ ", timing=? ,technicianAddress=? "
//				+ ", technicianPhoneNo=?, departmentId=?, Password=? "
//				+ "where technicianId= ?");
//		
//
//		pstmt.setString(1,renewTechnician.getTechnicianName());
//		pstmt.setString(2,renewTechnician.getSpecialization());
//		pstmt.setString(3, renewTechnician.getTiming());
//		pstmt.setString(4, renewTechnician.getTechnicianAddress());
//		pstmt.setLong(5, renewTechnician.getTechnicianPhoneNo());
//		pstmt.setInt(6, renewTechnician.getDepartmentId());
//		pstmt.setString(7, renewTechnician.getTechnicianPassword());
//		pstmt.setString(8, technicianId);
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//		}
//		else 
//			{
//			closeConnection(con);
//			return false;
//			}
//		//return false;
	}

	@Override
	public Technician displayTechnician(String technicianId) throws ClassNotFoundException, SQLException , IOException{
		
		try{
			Technician technician=(Technician) session.get(Technician.class,technicianId);
			System.out.println("Record Displayed");
			return technician;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		return null;
		
		// TODO Auto-generated method stub
//        con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select * from technician where technicianId = ?");
//		pstmt.setString(1,technicianId);
//		
//		rs=pstmt.executeQuery();
//		
//		Technician technician=new Technician();
//		while(rs.next())
//		{
//			technician.setTechnicianId(technicianId);
//			technician.setDepartmentId(rs.getInt("departmentId"));
//			technician.setTechnicianAddress(rs.getString("technicianAddress"));
//			technician.setTechnicianName(rs.getString("technicianName"));
//			technician.setTechnicianPhoneNo(rs.getLong("technicianPhoneNo"));
//			technician.setSpecialization(rs.getString("specialization"));
//			technician.setTiming(rs.getString("timing"));
//			technician.setTechnicianPassword(rs.getString("Password"));
//		}
//		
//		closeConnection(con);
//		return technician;
	}

	@Override
	public ArrayList<Technician> displayAllTechnicians() throws ClassNotFoundException, SQLException , IOException{
	
		try{
			Query query=session.createQuery("from Technician");
			List<Technician> technicianList=query.list();
			System.out.println("Record Displayed");
			return (ArrayList<Technician>)technicianList;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		return null;
		
		// TODO Auto-generated method stub
//        con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select * from technician ");
//		
//		
//		rs=pstmt.executeQuery();
//		
//		ArrayList<Technician> technicianList=new ArrayList<Technician>();
//		
//		
//		while(rs.next())
//		{
//			Technician technician=new Technician();
//			technician.setTechnicianId(rs.getString("technicianId"));
//			technician.setDepartmentId(rs.getInt("departmentId"));
//			technician.setTechnicianAddress(rs.getString("technicianAddress"));
//			technician.setTechnicianName(rs.getString("technicianName"));
//			technician.setTechnicianPhoneNo(rs.getLong("technicianPhoneNo"));
//			technician.setSpecialization(rs.getString("specialization"));
//			technician.setTiming(rs.getString("timing"));
//			technician.setTechnicianPassword(rs.getString("Password"));
//			technicianList.add(technician);
//		}
//		
//		closeConnection(con);
//
//		return technicianList;
	}

}

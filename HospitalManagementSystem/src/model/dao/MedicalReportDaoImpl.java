package model.dao;

import java.sql.Date;
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

import java.io.IOException;
import java.sql.Connection;
import static model.helper.ConnectToDb.*;

import model.bean.DischargeSummary;
import model.bean.MedicalReport;

public class MedicalReportDaoImpl implements MedicalReportDao {

	SessionFactory factory=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	Transaction t;  
	Session session=factory.openSession();
	
//	private PreparedStatement pstmt=null;
//	private Connection con;
//	private ResultSet rs;
	
	@Override
	public boolean insertMedicalReport(MedicalReport newMedicalReport) throws SQLException, ClassNotFoundException, IOException {


		try{
			t=session.beginTransaction();
			
			session.save(newMedicalReport);
			
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
//		int patientId = newMedicalReport.getPatientId(); 
//		Date visitDate = newMedicalReport.getVisitDate();
//		String diagnosis=newMedicalReport.getDiagnosis();
//		String investigations=newMedicalReport.getInvestigations();
//		String tests=newMedicalReport.getTests();
//		String recommendations=newMedicalReport.getRecommendations();
//		
//		pstmt=con.prepareStatement("insert into medicalreport (patientId,visitDate,diagnosis,investigations,tests,recommendations,"
//				+ "doctorId,technicianId)"
//				+ "values" + "(?,?,?,?,?,?,?,?)");
//		
//		pstmt.setInt(1,patientId);
//		pstmt.setDate(2, visitDate);
//		pstmt.setString(3, diagnosis);
//		pstmt.setString(4, investigations);
//		pstmt.setString(5, tests);
//		pstmt.setString(6, recommendations);
//		pstmt.setString(7, newMedicalReport.getDoctorId());
//		pstmt.setString(8, newMedicalReport.getTechnicianId());
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
		
	}

	@Override
	public boolean deleteMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException {

		try{
			MedicalReport medicalReport=(MedicalReport) session.get(MedicalReport.class,patientId);
			session.delete(medicalReport);
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
//		pstmt=con.prepareStatement("delete from medicalreport where patientId = ?");
//		
//		pstmt.setInt(1,patientId);
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
	public boolean updateMedicalReport(int medicalReportId, MedicalReport renewMedicalReport) throws ClassNotFoundException, SQLException, IOException {

		try{
			t=session.beginTransaction();
			
			//session.save(renewBill);
			session.update(renewMedicalReport);
			
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
//		pstmt=con.prepareStatement("update medicalreport set visitDate = ? , diagnosis = ? "
//				+ ", investigations = ? ,tests = ? "
//				+ ", recommendations= ? "
//				+ "where patientId = ?");
//		
//
//		pstmt.setDate(1,renewMedicalReport.getVisitDate());
//		pstmt.setString(2,renewMedicalReport.getDiagnosis());
//		pstmt.setString(3, renewMedicalReport.getInvestigations());
//		pstmt.setString(4, renewMedicalReport.getTests());
//		pstmt.setString(5, renewMedicalReport.getRecommendations());
//		pstmt.setInt(6, medicalReportId);
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
	}

	@Override
	public MedicalReport displayMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException {

		try{
			MedicalReport medicalReport=(MedicalReport) session.get(MedicalReport.class,patientId);
			System.out.println("Record Displayed");
			return medicalReport;
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
//		pstmt=con.prepareStatement("select * from medicalreport where patientId = ?");
//		pstmt.setInt(1,patientId);
//		
//		rs=pstmt.executeQuery();
//		
//		MedicalReport medicalreport=new MedicalReport();
//		while(rs.next())
//		{
//			medicalreport.setPatientId(rs.getInt("patientId"));
//			medicalreport.setVisitDate(rs.getDate("visitDate"));
//			medicalreport.setDiagnosis(rs.getString("diagnosis"));
//			medicalreport.setRecommendations(rs.getString("recommendations"));
//			medicalreport.setInvestigations(rs.getString("investigations"));
//			medicalreport.setTests(rs.getString("tests"));
//			medicalreport.setTechnicianId(rs.getString("TECHNICIANID"));
//			medicalreport.setDoctorId(rs.getString("DoctorID"));
//			
//		}
//		
//		closeConnection(con);
//		return medicalreport;
	}

	@Override
	public ArrayList<MedicalReport> displayAllMedicalReports() throws ClassNotFoundException, SQLException, IOException {

		try{
			Query query=session.createQuery("from MedicalReport");
			List<MedicalReport> medicalReportList=query.list();
			System.out.println("Record Displayed");
			return (ArrayList<MedicalReport>)medicalReportList;
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
//		pstmt=con.prepareStatement("select * from medicalreport ");
//		
//		
//		rs=pstmt.executeQuery();
//		
//		ArrayList<MedicalReport> medicalReportList=new ArrayList<MedicalReport>();
//		
//			while(rs.next())
//		{
//				MedicalReport medicalreport=new MedicalReport();
//				
//			medicalreport.setPatientId(rs.getInt("patientId"));
//			medicalreport.setVisitDate(rs.getDate("visitDate"));
//			medicalreport.setDiagnosis(rs.getString("diagnosis"));
//			medicalreport.setInvestigations(rs.getString("investigations"));
//			medicalreport.setTests(rs.getString("tests"));
//			medicalreport.setRecommendations(rs.getString("recommendations"));
//
//			medicalreport.setTechnicianId(rs.getString("TECHNICIANID"));
//			medicalreport.setDoctorId(rs.getString("DoctorID"));
//			medicalReportList.add(medicalreport);
//		}
//		
//		closeConnection(con);
//
//		return medicalReportList;
	}

	@Override
	public ArrayList<MedicalReport> displayMyMedicalReports(String personId) throws ClassNotFoundException, SQLException, IOException {
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select *  from medicalreport,appointment where medicalreport.patientId=appointment.regno and appointment.personId like ?");
//		
//		pstmt.setString(1,personId);
//		
//		
//		rs=pstmt.executeQuery();
//		
//		ArrayList<MedicalReport> medicalReportList=new ArrayList<MedicalReport>();
//		
//			while(rs.next())
//		{
//				MedicalReport medicalreport=new MedicalReport();
//				
//			medicalreport.setPatientId(rs.getInt("patientId"));
//			medicalreport.setVisitDate(rs.getDate("visitDate"));
//			medicalreport.setDiagnosis(rs.getString("diagnosis"));
//			medicalreport.setInvestigations(rs.getString("investigations"));
//			medicalreport.setTests(rs.getString("tests"));
//			medicalreport.setRecommendations(rs.getString("recommendations"));
//
//			medicalreport.setTechnicianId(rs.getString("TECHNICIANID"));
//			medicalreport.setDoctorId(rs.getString("DoctorID"));
//			medicalReportList.add(medicalreport);
//		}
//		
//		closeConnection(con);
//
//		return medicalReportList;
	}
}

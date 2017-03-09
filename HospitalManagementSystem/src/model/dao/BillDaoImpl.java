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
import org.hibernate.cfg.Configuration;

import model.bean.Appointment;
import model.bean.Bill;
import model.bean.DischargeSummary;

public class BillDaoImpl implements BillDao {
	
	 SessionFactory factory=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	 Transaction t;  
	 Session session=factory.openSession();
	
//	private PreparedStatement pstmt=null;
//	private Connection con;
//	private ResultSet rs;

	@Override
	public boolean insertBill(Bill newBill) throws ClassNotFoundException, SQLException, IOException {

		try{
			t=session.beginTransaction();
			
			session.save(newBill);
			
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
//		int billNo = newBill.getBillNo();
//		int patientId = newBill.getPatientId();
//		int serialNo = newBill.getSerialNo();
//		float doctorVisit = newBill.getDoctorVisit();
//		float bedCharges = newBill.getBedCharges();
//		float tests = newBill.getTests();
//		float medicines = newBill.getMedicines();
//		
//		pstmt=con.prepareStatement("insert into Bill (billNo,patientId,serialNo,doctorVisit,bedCharges,tests,medicines" +
//				") values (?,?,?,?,?,?,?)");
//		
//		pstmt.setInt(1,billNo);
//		pstmt.setInt(2,patientId);
//		pstmt.setInt(3,serialNo);
//		pstmt.setFloat(4, doctorVisit);
//		pstmt.setFloat(5, bedCharges);
//		pstmt.setFloat(6, tests);
//		pstmt.setFloat(7, medicines);
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
	public boolean deleteBill(int billId) throws ClassNotFoundException, SQLException, IOException {

		try{
			Bill bill=(Bill) session.get(Bill.class,billId);
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
//		pstmt=con.prepareStatement("delete from Bill where billNo = ?");
//		
//		pstmt.setInt(1,billId);
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
	public boolean updateBill(int billId, Bill renewBill) throws ClassNotFoundException, SQLException, IOException {

		try{
			t=session.beginTransaction();
			
			//session.save(renewBill);
			session.update(renewBill);
			
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
//		pstmt=con.prepareStatement("update Bill set patientId=?,serialNo=?,doctorVisit=?,bedCharges=?," +
//				"tests=?,medicines=? where billNo=?");
//		
//
//		pstmt.setInt(1, renewBill.getPatientId());
//		pstmt.setInt(2, renewBill.getSerialNo());
//		pstmt.setFloat(3,renewBill.getDoctorVisit());
//		pstmt.setFloat(4, renewBill.getBedCharges());
//		pstmt.setFloat(5, renewBill.getTests());
//		pstmt.setFloat(6, renewBill.getMedicines());
//		pstmt.setInt(7,billId);
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
	public Bill displayBill(int billId) throws ClassNotFoundException, SQLException, IOException {

		try{
			Bill bill=(Bill) session.get(Bill.class,billId);
			System.out.println("Record Displayed");
			return bill;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select * from Bill where billNo = ?");
//		pstmt.setInt(1,billId);
//		
//		rs=pstmt.executeQuery();
//		
//		Bill bill = new Bill();
//		
//		
//		while(rs.next()){
//			bill.setBillNo(rs.getInt("billNo"));
//			bill.setPatientId(rs.getInt("patientId"));
//			bill.setSerialNo(rs.getInt("serialNo"));
//			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
//			bill.setBedCharges(rs.getFloat("bedCharges"));
//			bill.setTests(rs.getFloat("tests"));
//			bill.setMedicines(rs.getFloat("medicines"));
//		}
//			
//		
//		closeConnection(con);
//		return bill;
	
		return null;
	}

	@Override
	public ArrayList<Bill> displayAllBills() throws ClassNotFoundException, SQLException, IOException {


		try{
			Query query=session.createQuery("from Bill");
			List<Bill> billList=query.list();
			System.out.println("Record Displayed");
			return (ArrayList<Bill>)billList;
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
//		pstmt=con.prepareStatement("select * from Bill");
//		
//		
//		rs=pstmt.executeQuery();
//		
//		ArrayList<Bill> billList=new ArrayList<Bill>();
//		
//		
//		
//		while(rs.next())
//		{
//			Bill bill = new Bill();
//			bill.setBillNo(rs.getInt("billNo"));
//			bill.setPatientId(rs.getInt("patientId"));
//			bill.setSerialNo(rs.getInt("serialNo"));
//			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
//			bill.setBedCharges(rs.getFloat("bedCharges"));
//			bill.setTests(rs.getFloat("tests"));
//			bill.setMedicines(rs.getFloat("medicines"));
//			billList.add(bill);
//		}
//		
//		closeConnection(con);
//		return billList;
	}

	@Override
	public ArrayList<Bill> displayMyBills(String personId) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	//public ArrayList<Bill> displayMyBills(String personId) throws ClassNotFoundException, SQLException, IOException {
//con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select *  from Bill,appointment where bill.patientId=appointment.regno and appointment.personId like ?");
//		pstmt.setString(1,personId);
//		
//		rs=pstmt.executeQuery();
//		
//		ArrayList<Bill> billList=new ArrayList<Bill>();
//		
//		
//		while(rs.next())
//		{
//			Bill bill = new Bill();
//			bill.setBillNo(rs.getInt("billNo"));
//			bill.setPatientId(rs.getInt("patientId"));
//			bill.setSerialNo(rs.getInt("serialNo"));
//			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
//			bill.setBedCharges(rs.getFloat("bedCharges"));
//			bill.setTests(rs.getFloat("tests"));
//			bill.setMedicines(rs.getFloat("medicines"));
//			billList.add(bill);
//		}
//		
//		closeConnection(con);
//		return billList;
	//}

	

}

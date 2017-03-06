package model.dao;

import static model.helper.ConnectToDb.closeConnection;
import static model.helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bill;
import model.bean.DischargeSummary;

public class BillDaoImpl implements BillDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertBill(Bill newBill) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		int billNo = newBill.getBillNo();
		int patientId = newBill.getPatientId();
		int serialNo = newBill.getSerialNo();
		float doctorVisit = newBill.getDoctorVisit();
		float bedCharges = newBill.getBedCharges();
		float tests = newBill.getTests();
		float medicines = newBill.getMedicines();
		
		pstmt=con.prepareStatement("insert into Bill (billNo,patientId,serialNo,doctorVisit,bedCharges,tests,medicines" +
				") values (?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,billNo);
		pstmt.setInt(2,patientId);
		pstmt.setInt(3,serialNo);
		pstmt.setFloat(4, doctorVisit);
		pstmt.setFloat(5, bedCharges);
		pstmt.setFloat(6, tests);
		pstmt.setFloat(7, medicines);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else closeConnection(con);
		return false;
		
	}

	@Override
	public boolean deleteBill(int billId) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from Bill where billNo = ?");
		
		pstmt.setInt(1,billId);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else closeConnection(con);
		return false;
	}

	@Override
	public boolean updateBill(int billId, Bill renewBill) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update Bill set patientId=?,serialNo=?,doctorVisit=?,bedCharges=?," +
				"tests=?,medicines=? where billNo=?");
		

		pstmt.setInt(1, renewBill.getPatientId());
		pstmt.setInt(2, renewBill.getSerialNo());
		pstmt.setFloat(3,renewBill.getDoctorVisit());
		pstmt.setFloat(4, renewBill.getBedCharges());
		pstmt.setFloat(5, renewBill.getTests());
		pstmt.setFloat(6, renewBill.getMedicines());
		pstmt.setInt(7,billId);
		
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else closeConnection(con);
		return false;
		
	}

	@Override
	public Bill displayBill(int billId) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from Bill where billNo = ?");
		pstmt.setInt(1,billId);
		
		rs=pstmt.executeQuery();
		
		Bill bill = new Bill();
		
		
		while(rs.next()){
			bill.setBillNo(rs.getInt("billNo"));
			bill.setPatientId(rs.getInt("patientId"));
			bill.setSerialNo(rs.getInt("serialNo"));
			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
			bill.setBedCharges(rs.getFloat("bedCharges"));
			bill.setTests(rs.getFloat("tests"));
			bill.setMedicines(rs.getFloat("medicines"));
		}
			
		
		closeConnection(con);
		return bill;
	}

	@Override
	public ArrayList<Bill> displayAllBills() throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from Bill");
		
		
		rs=pstmt.executeQuery();
		
		ArrayList<Bill> billList=new ArrayList<Bill>();
		
		
		
		while(rs.next())
		{
			Bill bill = new Bill();
			bill.setBillNo(rs.getInt("billNo"));
			bill.setPatientId(rs.getInt("patientId"));
			bill.setSerialNo(rs.getInt("serialNo"));
			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
			bill.setBedCharges(rs.getFloat("bedCharges"));
			bill.setTests(rs.getFloat("tests"));
			bill.setMedicines(rs.getFloat("medicines"));
			billList.add(bill);
		}
		
		closeConnection(con);
		return billList;
	}

	public ArrayList<Bill> displayMyBills(String personId) throws ClassNotFoundException, SQLException, IOException {
con= openConnection();
		
		
		pstmt=con.prepareStatement("select *  from Bill,appointment where bill.patientId=appointment.regno and appointment.personId like ?");
		pstmt.setString(1,personId);
		
		rs=pstmt.executeQuery();
		
		ArrayList<Bill> billList=new ArrayList<Bill>();
		
		
		while(rs.next())
		{
			Bill bill = new Bill();
			bill.setBillNo(rs.getInt("billNo"));
			bill.setPatientId(rs.getInt("patientId"));
			bill.setSerialNo(rs.getInt("serialNo"));
			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
			bill.setBedCharges(rs.getFloat("bedCharges"));
			bill.setTests(rs.getFloat("tests"));
			bill.setMedicines(rs.getFloat("medicines"));
			billList.add(bill);
		}
		
		closeConnection(con);
		return billList;
	}

	

}

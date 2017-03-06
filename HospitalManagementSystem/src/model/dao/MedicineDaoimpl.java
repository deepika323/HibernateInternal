package model.dao;

import static model.helper.ConnectToDb.closeConnection;
import static model.helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bill;
import model.bean.MedicalReport;
import model.bean.Medicine;

public class MedicineDaoimpl implements MedicineDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection(); 
		
		int sNo = newMedicine.getsNo();
		String medicineName = newMedicine.getMedicineName();
		int quantity=newMedicine.getQuantity();
		String dosage=newMedicine.getDosage();
		float price=newMedicine.getPrice();
		int patientId=newMedicine.getPatientId();
		
		pstmt=con.prepareStatement("insert into medicine (sNo,medicineName,quantity,dosage,price,patientId)"
				+ "values" + "(?,?,?,?,?,?)");
		
		pstmt.setInt(1,sNo);
		pstmt.setString(2, medicineName);
		pstmt.setInt(3, quantity);
		pstmt.setString(4, dosage);
		pstmt.setFloat(5, price);
		pstmt.setInt(6, patientId);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else 
			{
			closeConnection(con);
			return false;
			}
	}

	@Override
	public boolean deleteMedicine(int sNo,int patientId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from medicine where  patientId=?");
		
		//pstmt.setInt(1,sNo);
		pstmt.setInt(1,patientId);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else 
		{
			closeConnection(con);
			return false;
		}
	}

	@Override
	public boolean updateMedicine(int sNo, Medicine renewMedicine) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update medicine set medicineName = ? , quantity = ? "
				+ ", dosage = ? ,price = ? ,patientId = ? "
				+ "where sNo = ?");
		

		pstmt.setString(1,renewMedicine.getMedicineName());
		pstmt.setInt(2,renewMedicine.getQuantity());
		pstmt.setString(3, renewMedicine.getDosage());
		pstmt.setFloat(4, renewMedicine.getPrice());
		pstmt.setInt(5, renewMedicine.getPatientId());
		pstmt.setInt(6,sNo);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else 
			{
			closeConnection(con);
			return false;
			}
	}

	@Override
	public Medicine displayMedicine(int sNo,int patientId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from medicine where sNo = ? and patientId=?");
		pstmt.setInt(1,sNo);
		pstmt.setInt(2,patientId);
		
		rs=pstmt.executeQuery();
		
		Medicine medicine=new Medicine();
		while(rs.next())
		{
			medicine.setsNo(rs.getInt("sNo"));
			medicine.setMedicineName(rs.getString("medicineName"));
			medicine.setQuantity(rs.getInt("quantity"));
			medicine.setDosage(rs.getString("dosage"));
			medicine.setPrice(rs.getFloat("price"));
			medicine.setPatientId(rs.getInt("patientId"));
		}
		
		closeConnection(con);
		return medicine;
	}

	@Override
	public ArrayList<Medicine> displayAllMedicines(int patientId) throws ClassNotFoundException, SQLException , IOException{
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from medicine where patientId = ?");
		pstmt.setInt(1,patientId);
		
		
		rs=pstmt.executeQuery();
		
		ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
		
			while(rs.next())
		{
				Medicine medicine = new Medicine();
				
			medicine.setsNo(rs.getInt("sNo"));
			medicine.setMedicineName(rs.getString("medicineName"));
			medicine.setQuantity(rs.getInt("quantity"));
			medicine.setDosage(rs.getString("dosage"));
			medicine.setPrice(rs.getFloat("price"));
			medicine.setPatientId(rs.getInt("patientId"));
			medicineList.add(medicine);
		}
		
		closeConnection(con);

		return medicineList;
	}
	
	public ArrayList<Medicine> displayMyMedicines(String personId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
				
				
				pstmt=con.prepareStatement("select *  from Medicine,appointment where medicine.patientId=appointment.regno and appointment.personId like ?");
				pstmt.setString(1,personId);
				
				rs=pstmt.executeQuery();
				
				ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
				
				
				while(rs.next())
				{	
					Medicine medicine = new Medicine();
				
					medicine.setsNo(rs.getInt("sNo"));
					medicine.setMedicineName(rs.getString("medicineName"));
					medicine.setQuantity(rs.getInt("quantity"));
					medicine.setDosage(rs.getString("dosage"));
					medicine.setPrice(rs.getFloat("price"));
					medicine.setPatientId(rs.getInt("patientId"));
					medicineList.add(medicine);
				}
				
				closeConnection(con);
				return medicineList;
			}



}

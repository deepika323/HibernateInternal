package model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static model.helper.ConnectToDb.*;

import model.bean.Doctor;

public class DoctorDaoImpl implements DoctorDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException, IOException {
		
		con= openConnection();
		
		String doctorId =newDoctor.getDoctorId();
		String doctorName = newDoctor.getDoctorName();
		String doctorAddress=newDoctor.getDoctorAddress();
		String doctorSpecializtion=newDoctor.getSpecialization();
		String doctorTiming=newDoctor.getTiming();
		long doctorPhoneNo=newDoctor.getDoctorPhoneNo();
		int departmentId=newDoctor.getDepartmentId();
		String doctorPassword=newDoctor.getDoctorPassword();
		
		pstmt=con.prepareStatement("insert into doctor (doctorId,doctorName,specialization,timing,doctorAddress,"
				+ "doctorPhoneNo,departmentId,Password) values" + "(?,?,?,?,?,?,?,?)");
		
		pstmt.setString(1,doctorId);
		pstmt.setString(2,doctorName);
		pstmt.setString(3, doctorSpecializtion);
		pstmt.setString(4, doctorTiming);
		pstmt.setString(5, doctorAddress);
		pstmt.setLong(6, doctorPhoneNo);
		pstmt.setInt(7, departmentId);
		pstmt.setString(8, doctorPassword);
		
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
	public boolean deleteDoctor(String doctorId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from doctor where doctorId like ?");
		
		pstmt.setString(1,doctorId);
		
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
	public boolean updateDoctor(String doctorId, Doctor renewDoctor) throws ClassNotFoundException, SQLException, IOException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update doctor set doctorName = ? , specialization =? "
				+ ", timing=? ,doctorAddress=? "
				+ ", doctorPhoneNo=?, departmentId=?, Password=? "
				+ "where doctorId like ?");
		

		pstmt.setString(1,renewDoctor.getDoctorName());
		pstmt.setString(2,renewDoctor.getSpecialization());
		pstmt.setString(3, renewDoctor.getTiming());
		pstmt.setString(4, renewDoctor.getDoctorAddress());
		pstmt.setLong(5, renewDoctor.getDoctorPhoneNo());
		pstmt.setInt(6, renewDoctor.getDepartmentId());
		pstmt.setString(7, renewDoctor.getDoctorPassword());
		pstmt.setString(8, doctorId);
		
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
	public Doctor displayDoctor(String doctorId) throws ClassNotFoundException, SQLException, IOException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from doctor where doctorId = ?");
		pstmt.setString(1,doctorId);
		
		rs=pstmt.executeQuery();
		
		Doctor doctor=new Doctor();
		while(rs.next())
		{
			doctor.setDoctorId(rs.getString("doctorId"));
			doctor.setDepartmentId(rs.getInt("departmentId"));
			doctor.setDoctorAddress(rs.getString("doctorAddress"));
			doctor.setDoctorName(rs.getString("doctorName"));
			doctor.setDoctorPhoneNo(rs.getLong("doctorPhoneNo"));
			doctor.setSpecialization(rs.getString("specialization"));
			doctor.setTiming(rs.getString("timing"));
			doctor.setDoctorPassword(rs.getString("Password"));
		}
		
		closeConnection(con);
		return doctor;
	}

	@Override
	public ArrayList<Doctor> displayAllDoctors() throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from doctor ");
		
		
		rs=pstmt.executeQuery();
		
		ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
		
		
		while(rs.next())
		{
			Doctor doctor=new Doctor();
			doctor.setDoctorId(rs.getString("doctorId"));
			doctor.setDepartmentId(rs.getInt("departmentId"));
			doctor.setDoctorAddress(rs.getString("doctorAddress"));
			doctor.setDoctorName(rs.getString("doctorName"));
			doctor.setDoctorPhoneNo(rs.getLong("doctorPhoneNo"));
			doctor.setSpecialization(rs.getString("specialization"));
			doctor.setTiming(rs.getString("timing"));
			doctor.setDoctorPassword(rs.getString("Password"));
			doctorList.add(doctor);
		}
		
		closeConnection(con);

		return doctorList;
	}

}

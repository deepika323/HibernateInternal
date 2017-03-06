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

import model.bean.Staff;

public class StaffDaoImpl implements StaffDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertStaff(Staff newStaff) throws ClassNotFoundException, SQLException, IOException {		
		con= openConnection();
	 
	String staffId=newStaff.getStaffId();
	String staffName=newStaff.getStaffName();
	String staffAddress=newStaff.getStaffAddress();
	String specialization=newStaff.getSpecialization();
	String timing=newStaff.getTiming();
	long staffPhoneNo=newStaff.getStaffPhoneNo();
	int departmentId=newStaff.getDepartmentId();
	String staffPassword=newStaff.getStaffPassword();
	
	
	
	
	pstmt=con.prepareStatement("insert into Staff (staffId,staffName," +
			"timing,specialization,staffAddress,staffPhoneNo,departmentId,Password) values" + 
			"(?,?,?,?,?,?,?,?)");
	
	pstmt.setString(1,staffId);
	pstmt.setString(2,staffName );
	pstmt.setString(3, timing);
	pstmt.setString(4, specialization);
	pstmt.setString(5, staffAddress);
	pstmt.setLong(6, staffPhoneNo);
	pstmt.setInt(7, departmentId);
	pstmt.setString(8, staffPassword);
	
	
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
	public boolean deleteStaff(String staffId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from staff where staffId = ?");
		
		pstmt.setString(1,staffId);
		
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
	public boolean updateStaff(String staffId, Staff renewStaff) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update staff set staffName = ? , specialization =? "
				+ ", timing=? ,staffAddress=? "
				+ ", staffPhoneNo=?, departmentId=?, Password=? "
				+ "where staffId= ?");
		

		pstmt.setString(1,renewStaff.getStaffName());
		pstmt.setString(2,renewStaff.getSpecialization());
		pstmt.setString(3, renewStaff.getTiming());
		pstmt.setString(4, renewStaff.getStaffAddress());
		pstmt.setLong(5, renewStaff.getStaffPhoneNo());
		pstmt.setInt(6, renewStaff.getDepartmentId());
		pstmt.setString(7, renewStaff.getStaffPassword());
		pstmt.setString(8, staffId);
		
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
	public Staff displayStaff(String staffId) throws ClassNotFoundException, SQLException , IOException{


		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from staff where staffId like ?");
		pstmt.setString(1,staffId);
		
		rs=pstmt.executeQuery();
		
		Staff staff=new Staff();
		while(rs.next())
		{
			staff.setStaffId(rs.getString("staffId"));
			staff.setDepartmentId(rs.getInt("departmentId"));
			staff.setStaffAddress(rs.getString("staffAddress"));
			staff.setStaffName(rs.getString("staffName"));
			staff.setStaffPhoneNo(rs.getLong("staffPhoneNo"));
			staff.setSpecialization(rs.getString("specialization"));
			staff.setTiming(rs.getString("timing"));
			staff.setStaffPassword(rs.getString("Password"));
			
		}
		closeConnection(con);
		return staff;

	}

	@Override
	public ArrayList<Staff> displayAllStaffs() throws ClassNotFoundException, SQLException, IOException {
	
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from staff ");
		
		
		rs=pstmt.executeQuery();
		
		ArrayList<Staff> staffList=new ArrayList<Staff>();
		
		
		while(rs.next())
		{
			Staff staff=new Staff();
			staff.setStaffId(rs.getString("staffId"));
			staff.setDepartmentId(rs.getInt("departmentId"));
			staff.setStaffAddress(rs.getString("staffAddress"));
			staff.setStaffName(rs.getString("staffName"));
			staff.setStaffPhoneNo(rs.getLong("staffPhoneNo"));
			staff.setSpecialization(rs.getString("specialization"));
			staff.setTiming(rs.getString("timing"));
			staff.setStaffPassword(rs.getString("Password"));
			staffList.add(staff);
		}
		
		closeConnection(con);

		return staffList;

	}

}

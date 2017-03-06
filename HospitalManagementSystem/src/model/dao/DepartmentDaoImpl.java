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

import model.bean.Department;
import model.bean.Doctor;

public class DepartmentDaoImpl implements DepartmentDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertDepartment(Department newDepartment) throws ClassNotFoundException, SQLException, IOException {
		
		con= openConnection();
		
		int departmentId =newDepartment.getDepartmentId();
		String departmentName = newDepartment.getDepartmentName();
		String departmentLocation=newDepartment.getDepartmentLocation();
		String description=newDepartment.getDescription();
		
		pstmt=con.prepareStatement("insert into department (departmentId,"
				+ "departmentName,departmentLocation,description)"
				+ " values" + "(?,?,?,?)");
		
		pstmt.setInt(1, departmentId);
		pstmt.setString(2, departmentName);
		pstmt.setString(3, departmentLocation);
		pstmt.setString(4, description);
		
	
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
	public boolean deleteDepartment(int departmentId) throws SQLException, ClassNotFoundException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from department where departmentId = ?");
		
		pstmt.setInt(1,departmentId);
		
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
	public boolean updateDepartment(int departmentId, Department renewDepartment) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update department set departmentName = ? , departmentLocation =? "
				+ ", description=?"
				+ "where departmentId= ?");
		

		pstmt.setString(1,renewDepartment.getDepartmentName());
		pstmt.setString(2,renewDepartment.getDepartmentLocation());
		pstmt.setString(3, renewDepartment.getDescription());
		pstmt.setInt(4, departmentId);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true ;
		}
		else 
		{
			closeConnection(con);
			return false;
			
		}
		

		


	}

	@Override
	public Department displayDepartment(int departmentId) throws ClassNotFoundException, SQLException, IOException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from department where departmentId = ?");
		pstmt.setInt(1,departmentId);
		
		rs=pstmt.executeQuery();
		
		Department department=new Department();
		while(rs.next())
		{
			department.setDepartmentId(rs.getInt("departmentId"));
			department.setDepartmentLocation(rs.getString("departmentLocation"));
			department.setDepartmentName(rs.getString("departmentName"));
			department.setDescription(rs.getString("description"));
		}
		
		closeConnection(con);
		return department;


	}

	@Override
	public ArrayList<Department> displayAllDepartments() throws ClassNotFoundException, SQLException, IOException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from department ");
		
		ArrayList<Department> departmentList=new ArrayList<Department>();
		rs=pstmt.executeQuery();
		
		
		while(rs.next())
		{
			Department department=new Department();
			department.setDepartmentId(rs.getInt("departmentId"));
			department.setDepartmentLocation(rs.getString("departmentLocation"));
			department.setDepartmentName(rs.getString("departmentName"));
			department.setDescription(rs.getString("description"));
			departmentList.add(department);
		}
		
		closeConnection(con);
		return departmentList;
	}

}

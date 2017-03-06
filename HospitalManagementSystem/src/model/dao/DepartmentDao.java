package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Department;

public interface DepartmentDao {
	public boolean insertDepartment(Department newDepartment) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteDepartment(int departmentId) throws SQLException, ClassNotFoundException, IOException;
	public boolean updateDepartment(int departmentId, Department renewDepartment) throws ClassNotFoundException, SQLException, IOException;
	public Department displayDepartment(int departmentId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Department> displayAllDepartments() throws ClassNotFoundException, SQLException, IOException;
}

package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Staff;

public interface StaffDao {
	public boolean insertStaff(Staff newStaff) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteStaff(String staffId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateStaff(String staffId, Staff renewStaff) throws ClassNotFoundException, SQLException, IOException;
	public Staff displayStaff(String staffId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Staff> displayAllStaffs() throws ClassNotFoundException, SQLException, IOException;
}

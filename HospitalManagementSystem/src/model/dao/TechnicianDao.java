package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Technician;

public interface TechnicianDao {
	public boolean insertTechnician (Technician newTechnician) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteTechnician(String technicianId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateTechnician(String technicianId, Technician renewTechnician) throws ClassNotFoundException, SQLException, IOException;
	public Technician displayTechnician(String technicianId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Technician> displayAllTechnicians() throws ClassNotFoundException, SQLException, IOException;
}

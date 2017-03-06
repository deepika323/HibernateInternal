package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Doctor;

public interface DoctorDao {
	public boolean insertDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteDoctor(String doctorId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateDoctor(String doctorId, Doctor renewDoctor) throws ClassNotFoundException, SQLException, IOException;
	public Doctor displayDoctor(String doctorId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Doctor> displayAllDoctors() throws SQLException, ClassNotFoundException, IOException;
}

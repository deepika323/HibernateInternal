package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.MedicalReport;

public interface MedicalReportDao {
	public boolean insertMedicalReport(MedicalReport newMedicalReport) throws SQLException, ClassNotFoundException, IOException;
	public boolean deleteMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateMedicalReport(int patientId, MedicalReport renewMedicalReport) throws ClassNotFoundException, SQLException, IOException;
	public MedicalReport displayMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<MedicalReport> displayAllMedicalReports() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<MedicalReport> displayMyMedicalReports(String personId) throws ClassNotFoundException, SQLException, IOException;
}

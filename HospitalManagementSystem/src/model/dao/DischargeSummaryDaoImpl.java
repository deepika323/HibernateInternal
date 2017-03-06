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
import model.bean.DischargeSummary;

public class DischargeSummaryDaoImpl implements DischargeSummaryDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException, IOException {


		con= openConnection();
		
		 int serialNo = newDischargeSummary.getSerialNo();
		 int patientId = newDischargeSummary.getPatientId();
		 int otId = newDischargeSummary.getOtId();
		 int bedNo = newDischargeSummary.getBedNo();
		 Date admissionDate = newDischargeSummary.getAdmissionDate();
		 Date dischargeDate = newDischargeSummary.getDischargeDate();
		 String doctorId = newDischargeSummary.getDoctorId();
		 String history = newDischargeSummary.getHistory();
		 String onExamination = newDischargeSummary.getOnExamination();
		 String operationDone = newDischargeSummary.getOperationDone();
		 String operationFindings = newDischargeSummary.getOperativeFindings();
		 String treatmentGiven = newDischargeSummary.getTreatmentGiven();
		 String recommendations = newDischargeSummary.getRecommendations();
		
		pstmt=con.prepareStatement("insert into DischargeSummary (serialNo,patientId,otId,bedNo,admissionDate,dischargeDate,doctorId,history" +
				",onExamination,operationDone,operativeFindings,treatmentGiven,recommendations) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,serialNo);
		pstmt.setInt(2, patientId);
		pstmt.setInt(3, otId);
		pstmt.setInt(4, bedNo);
		pstmt.setDate(5, admissionDate);
		pstmt.setDate(6, dischargeDate);
		pstmt.setString(7, doctorId);
		pstmt.setString(8, history);
		pstmt.setString(9, onExamination);
		pstmt.setString(10, operationDone);
		pstmt.setString(11, operationFindings);
		pstmt.setString(12, treatmentGiven);
		pstmt.setString(13, recommendations);
		 
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
	public boolean deleteDischargeSummary(int dischargeSummaryId) throws  IOException, SQLException, ClassNotFoundException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from DischargeSummary where serialNo = ?");
		
		pstmt.setInt(1,dischargeSummaryId);
		
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
	public boolean updateDischargeSummary(int dischargeSummaryId, DischargeSummary renewDischargeSummary) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update DischargeSummary set patientId=?,otId=?,bedNo=?,admissionDate=?,"
				+ "dischargeDate=?,doctorId=?,history=?" +
				",onExamination=?,operationDone=?,operativeFindings=?,treatmentGiven=?,recommendations=? where serialNo=?");
		

		pstmt.setInt(1, renewDischargeSummary.getPatientId());
		pstmt.setInt(2, renewDischargeSummary.getOtId());
		pstmt.setInt(3, renewDischargeSummary.getBedNo());
		pstmt.setDate(4, renewDischargeSummary.getAdmissionDate());
		pstmt.setDate(5, renewDischargeSummary.getDischargeDate());
		pstmt.setString(6, renewDischargeSummary.getDoctorId());
		pstmt.setString(7, renewDischargeSummary.getHistory());
		pstmt.setString(8, renewDischargeSummary.getOnExamination());
		pstmt.setString(9, renewDischargeSummary.getOperationDone());
		pstmt.setString(10, renewDischargeSummary.getOperativeFindings());
		pstmt.setString(11, renewDischargeSummary.getTreatmentGiven());
		pstmt.setString(12, renewDischargeSummary.getRecommendations());
		pstmt.setInt(13,dischargeSummaryId);
		
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
	public DischargeSummary displayDischargeSummary(int dischargeSummaryId) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from DischargeSummary where serialNo = ?");
		pstmt.setInt(1,dischargeSummaryId);
		
		rs=pstmt.executeQuery();
		
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		while(rs.next()){
			dischargeSummary.setSerialNo(rs.getInt("serialNo"));
			 dischargeSummary.setPatientId(rs.getInt("patientId"));
			 dischargeSummary.setOtId(rs.getInt("otId"));
			 dischargeSummary.setBedNo(rs.getInt("bedNo"));
			 dischargeSummary.setAdmissionDate(rs.getDate("admissionDate"));
			 dischargeSummary.setDischargeDate(rs.getDate("dischargeDate"));
			 dischargeSummary.setDoctorId(rs.getString("doctorId"));
			 dischargeSummary.setHistory(rs.getString("history"));
			 dischargeSummary.setOnExamination(rs.getString("onExamination"));
			 dischargeSummary.setOperationDone(rs.getString("operationDone"));
			 dischargeSummary.setOperativeFindings(rs.getString("operativeFindings"));
			 dischargeSummary.setTreatmentGiven(rs.getString("treatmentGiven"));
			 dischargeSummary.setRecommendations(rs.getString("recommendations"));
		}
		 
		
		closeConnection(con);
		return dischargeSummary;
	}

	@Override
	public ArrayList<DischargeSummary> displayAllDischargeSummarys() throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from DischargeSummary");
		
		
		rs=pstmt.executeQuery();
		
		ArrayList<DischargeSummary> dischargeSummaryList=new ArrayList<DischargeSummary>();
		
		
		while(rs.next())
		{
			DischargeSummary dischargeSummary = new DischargeSummary();
			
			dischargeSummary.setSerialNo(rs.getInt("serialNo"));
			 dischargeSummary.setPatientId(rs.getInt("patientId"));
			 dischargeSummary.setOtId(rs.getInt("otId"));
			 dischargeSummary.setBedNo(rs.getInt("bedNo"));
			 dischargeSummary.setAdmissionDate(rs.getDate("admissionDate"));
			 dischargeSummary.setDischargeDate(rs.getDate("dischargeDate"));
			 dischargeSummary.setDoctorId(rs.getString("doctorId"));
			 dischargeSummary.setHistory(rs.getString("history"));
			 dischargeSummary.setOnExamination(rs.getString("onExamination"));
			 dischargeSummary.setOperationDone(rs.getString("operationDone"));
			 dischargeSummary.setOperativeFindings(rs.getString("operativeFindings"));
			 dischargeSummary.setTreatmentGiven(rs.getString("treatmentGiven"));
			 dischargeSummary.setRecommendations(rs.getString("recommendations"));
			dischargeSummaryList.add(dischargeSummary);
		}
		
		closeConnection(con);
		return dischargeSummaryList;
	}
	
	
	@Override
	public ArrayList<DischargeSummary> displayMyDischargeSummarys(String personId) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select *  from dischargesummary,appointment where dischargesummary.patientId=appointment.regno and appointment.personId like ?");
		pstmt.setString(1,personId);
		
		rs=pstmt.executeQuery();
		
		ArrayList<DischargeSummary> dischargeSummaryList=new ArrayList<DischargeSummary>();
		
		
		while(rs.next())
		{
			DischargeSummary dischargeSummary = new DischargeSummary();
			
			dischargeSummary.setSerialNo(rs.getInt("serialNo"));
			 dischargeSummary.setPatientId(rs.getInt("patientId"));
			 dischargeSummary.setOtId(rs.getInt("otId"));
			 dischargeSummary.setBedNo(rs.getInt("bedNo"));
			 dischargeSummary.setAdmissionDate(rs.getDate("admissionDate"));
			 dischargeSummary.setDischargeDate(rs.getDate("dischargeDate"));
			 dischargeSummary.setDoctorId(rs.getString("doctorId"));
			 dischargeSummary.setHistory(rs.getString("history"));
			 dischargeSummary.setOnExamination(rs.getString("onExamination"));
			 dischargeSummary.setOperationDone(rs.getString("operationDone"));
			 dischargeSummary.setOperativeFindings(rs.getString("operativeFindings"));
			 dischargeSummary.setTreatmentGiven(rs.getString("treatmentGiven"));
			 dischargeSummary.setRecommendations(rs.getString("recommendations"));
			dischargeSummaryList.add(dischargeSummary);
		}
		
		closeConnection(con);
		return dischargeSummaryList;
	}


}

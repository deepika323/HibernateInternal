package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.DischargeSummary;
import model.bean.Person;
import model.dao.DischargeSummaryDaoImpl;

public class DischargeSummaryDaoImplTest {

	private DischargeSummaryDaoImpl dsd;
	
	@Before
	public void setUp() throws Exception {
		dsd = new DischargeSummaryDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dsd = null;
	}

	@Test
	public void testInsertDischargeSummary() throws ClassNotFoundException, SQLException, IOException {
		 dsd.deleteDischargeSummary(0);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(0);
		 dischargeSummary.setPatientId(0);
		 dischargeSummary.setOtId(0);
		 dischargeSummary.setBedNo(0);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId("4");
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 
		 assertTrue(dsd.insertDischargeSummary(dischargeSummary));
	}
	
	@Test(expected=SQLException.class)
	public void testInsertDischargeSummaryNegative() throws ClassNotFoundException, SQLException, IOException {
		

		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		dischargeSummary.setSerialNo(1);
		 dischargeSummary.setPatientId(0);
		 dischargeSummary.setOtId(0);
		 dischargeSummary.setBedNo(0);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId("0");
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		
		dsd.insertDischargeSummary(dischargeSummary);
	}

	@Test
	public void testDeleteDischargeSummaryNegative() throws ClassNotFoundException, SQLException, IOException {
		
		assertFalse(dsd.deleteDischargeSummary(16501));
	}
	
	@Test
	public void testDeleteDischargeSummary() throws ClassNotFoundException, SQLException, IOException {
		
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		dischargeSummary.setSerialNo(5);
		 dischargeSummary.setPatientId(0);
		 dischargeSummary.setOtId(0);
		 dischargeSummary.setBedNo(0);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId("0");
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dsd.insertDischargeSummary(dischargeSummary);
		 
		 assertTrue(dsd.deleteDischargeSummary(dischargeSummary.getSerialNo()));
	}
	
	
	@Test
	public void testUpdateDischargeSummary() throws ClassNotFoundException, SQLException, IOException {
		
		dsd.deleteDischargeSummary(8);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(8);
		 dischargeSummary.setPatientId(0);
		 dischargeSummary.setOtId(0);
		 dischargeSummary.setBedNo(0);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId("0");
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dsd.insertDischargeSummary(dischargeSummary);
			
		 DischargeSummary newDischargeSummary = new DischargeSummary();
		 
		 newDischargeSummary.setSerialNo(8);
		 newDischargeSummary.setPatientId(0);
		 newDischargeSummary.setOtId(0);
		 newDischargeSummary.setBedNo(0);
		 newDischargeSummary.setAdmissionDate(date);
		 newDischargeSummary.setDischargeDate(date);
		 newDischargeSummary.setDoctorId("0");
		 newDischargeSummary.setHistory("Leg Patient");
		 newDischargeSummary.setOnExamination("Check Up Successful");
		 newDischargeSummary.setOperationDone("Leg CheckUp");
		 newDischargeSummary.setOperativeFindings("No Issue");
		 newDischargeSummary.setTreatmentGiven("Massage");
		 newDischargeSummary.setRecommendations("Regular CheckUp");
		 
		 
		 assertTrue(dsd.updateDischargeSummary(8, newDischargeSummary));
	}
	@Test
	public void testUpdateDischargeSummaryNegative() throws ClassNotFoundException, SQLException, IOException
	{
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(9);
		 dischargeSummary.setPatientId(0);
		 dischargeSummary.setOtId(0);
		 dischargeSummary.setBedNo(0);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId("0");
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		
		assertFalse(dsd.updateDischargeSummary(2343, dischargeSummary));
	}
	

	@Test
	public void testDisplayDischargeSummary() throws ClassNotFoundException, SQLException, IOException {
		 
		 dsd.deleteDischargeSummary(56);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(56);
		 dischargeSummary.setPatientId(0);
		 dischargeSummary.setOtId(0);
		 dischargeSummary.setBedNo(0);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId("0");
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dsd.insertDischargeSummary(dischargeSummary);
		 
		 assertEquals(dischargeSummary.getOperationDone(), dsd.displayDischargeSummary(56).getOperationDone());
	}
	
	@Test
	public void testDisplayDischargeSummaryNegative() throws ClassNotFoundException, SQLException, IOException {
		
		
		assertEquals(0,dsd.displayDischargeSummary(234234).getSerialNo());
		
	}

	@Test
	public void testDisplayAllDischargeSummarys() throws ClassNotFoundException, SQLException, IOException {
//		TreeSet<DischargeSummary> dischargeSummaryList=new TreeSet<DischargeSummary>();
//		
//		 dsd.deleteDischargeSummary(1);
//		
//
//		 DischargeSummary dischargeSummary = new DischargeSummary();
//		 
//		 dischargeSummary.setSerialNo(1);
//		 dischargeSummary.setPatientId(1);
//		 dischargeSummary.setOtId(1);
//		 dischargeSummary.setBedNo(1);
//		 dischargeSummary.setAdmissionDate(null);
//		 dischargeSummary.setDischargeDate(null);
//		 dischargeSummary.setDoctorId(1);
//		 dischargeSummary.setHistory("Eye Patient");
//		 dischargeSummary.setOnExamination("Check Up Successful");
//		 dischargeSummary.setOperationDone("Eye CheckUp");
//		 dischargeSummary.setOperativeFindings("No Issue");
//		 dischargeSummary.setTreatmentGiven("Eye Drop");
//		 dischargeSummary.setRecommendations("Regular CheckUp");
//
//		 
//		 dsd.insertDischargeSummary(dischargeSummary);
//		 
//		 assertEquals(dischargeSummary, dsd.displayAllDischargeSummarys());
		
		assertNotEquals(null, dsd.displayAllDischargeSummarys());
	}

}

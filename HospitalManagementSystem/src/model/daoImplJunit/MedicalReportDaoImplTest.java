package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Doctor;
import model.bean.MedicalReport;
import model.dao.MedicalReportDaoImpl;

public class MedicalReportDaoImplTest {
	
	private MedicalReportDaoImpl mrd;
	
	@Before
	public void setUp() throws Exception {
		mrd=new MedicalReportDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		mrd=null;
	}

	@Test
	public void testInsertMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		mrd.deleteMedicalReport(0);
		MedicalReport medicalreport = new MedicalReport();
		medicalreport.setPatientId(0);
		String str="2015-03-31";  
	    Date visitDate=Date.valueOf(str);
		medicalreport.setVisitDate(visitDate);
		medicalreport.setDiagnosis("abc");
		medicalreport.setInvestigations("def");
		medicalreport.setTests("ghi");
		medicalreport.setRecommendations("jkl");
		//medicalreport.setRegNo(0);
		medicalreport.setDoctorId("0");
		medicalreport.setTechnicianId("0");
		assertTrue(mrd.insertMedicalReport(medicalreport));
	}

	@Test(expected=SQLException.class)
	public void testInsertMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException {
		
		MedicalReport medicalreport = new MedicalReport();
		medicalreport.setPatientId(1);
		String str="2015-03-31";  
	    Date visitDate=Date.valueOf(str);
		medicalreport.setVisitDate(visitDate);
		medicalreport.setDiagnosis("abc");
		medicalreport.setInvestigations("def");
		medicalreport.setTests("ghi");
		medicalreport.setRecommendations("jkl");
		//medicalreport.setRegNo(1);
		medicalreport.setDoctorId("0");
		medicalreport.setTechnicianId("0");
		
		mrd.insertMedicalReport(medicalreport);
	}
	
	@Test
	public void testDeleteMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		mrd.deleteMedicalReport(0);
		MedicalReport medicalreport = new MedicalReport();
		medicalreport.setPatientId(0);
		String str="2015-03-31";  
	    Date visitDate=Date.valueOf(str);
		medicalreport.setVisitDate(visitDate);
		medicalreport.setDiagnosis("abc");
		medicalreport.setInvestigations("def");
		medicalreport.setTests("ghi");
		medicalreport.setRecommendations("jkl");
		//medicalreport.setRegNo(12345);
		medicalreport.setDoctorId("0");
		medicalreport.setTechnicianId("0");
		mrd.insertMedicalReport(medicalreport);
		assertTrue(mrd.deleteMedicalReport(0));
	}
	
	@Test
	public void testDeleteMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException {
		assertFalse(mrd.deleteMedicalReport(12131));
	}

	@Test
	public void testUpdateMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		mrd.deleteMedicalReport(0);
		MedicalReport medicalreport = new MedicalReport();
		medicalreport.setPatientId(0);
		String str="2015-03-31";  
	    Date visitDate=Date.valueOf(str);
		medicalreport.setVisitDate(visitDate);
		medicalreport.setDiagnosis("abc");
		medicalreport.setInvestigations("def");
		medicalreport.setTests("ghi");
		medicalreport.setRecommendations("jkl");
		//medicalreport.setRegNo(0);
		medicalreport.setDoctorId("0");
		medicalreport.setTechnicianId("0");
		mrd.insertMedicalReport(medicalreport);
		medicalreport.setPatientId(1);
		str="2015-03-31";  
	    visitDate=Date.valueOf(str);
	    MedicalReport newmedicalreport = new MedicalReport();
		newmedicalreport.setVisitDate(visitDate);
		newmedicalreport.setDiagnosis("abc");
		newmedicalreport.setInvestigations("def");
		newmedicalreport.setTests("ghi");
		newmedicalreport.setRecommendations("jkl");
		//newmedicalreport.setRegNo(0);
		newmedicalreport.setDoctorId("0");
		newmedicalreport.setTechnicianId("0");
		assertTrue(mrd.updateMedicalReport(0,newmedicalreport));
	}
	
	@Test
	public void testUpdateMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException
	{
		String str="2015-03-31";  
	    Date visitDate=Date.valueOf(str);
		MedicalReport newmedicalreport = new MedicalReport();
		newmedicalreport.setVisitDate(visitDate);
		newmedicalreport.setDiagnosis("abc");
		newmedicalreport.setInvestigations("def");
		newmedicalreport.setTests("ghi");
		newmedicalreport.setRecommendations("jkl");
	//	newmedicalreport.setRegNo(0);
		newmedicalreport.setDoctorId("0");
		newmedicalreport.setTechnicianId("0");
		
		assertFalse(mrd.updateMedicalReport(2343, newmedicalreport));
	}

	@Test
	public void testDisplayMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		mrd.deleteMedicalReport(0);
		MedicalReport medicalreport = new MedicalReport();
		medicalreport.setPatientId(0);
		String str="2015-03-31";  
	    Date visitDate=Date.valueOf(str);
		medicalreport.setVisitDate(visitDate);
		medicalreport.setDiagnosis("abc");
		medicalreport.setInvestigations("def");
		medicalreport.setTests("ghi");
		medicalreport.setRecommendations("jkl");
		
		medicalreport.setDoctorId("0");
		medicalreport.setTechnicianId("0");
		mrd.insertMedicalReport(medicalreport);
		
		assertEquals(medicalreport, mrd.displayMedicalReport(0));
	}
	
	@Test
	public void testDisplayMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException {
		assertEquals(0,mrd.displayMedicalReport(234234).getPatientId());	
	}

	@Test
	public void testDisplayAllMedicalReports() throws ClassNotFoundException, SQLException, IOException {
		assertNotEquals(null, mrd.displayAllMedicalReports());
	}

}

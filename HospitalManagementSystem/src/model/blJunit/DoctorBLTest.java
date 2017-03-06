package model.blJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Doctor;
import model.bean.MedicalReport;
import model.bean.Medicine;
import model.bl.DoctorBusinessLogic;

public class DoctorBLTest {

	DoctorBusinessLogic dbl;
	MedicalReport newMedicalReport = new MedicalReport();
	Medicine newMedicine =  new Medicine();
	
	@Before
	public void setUp() throws Exception {
		dbl=new DoctorBusinessLogic();
	}

	@After
	public void tearDown() throws Exception {
		dbl=null;
	}

	@Test
	public void testDoctorLogin() throws ClassNotFoundException, SQLException, IOException {
		Doctor doctor=new Doctor();
		doctor.setDoctorId("DO1");
		doctor.setDoctorPassword("pass");
		
		assertEquals(doctor.getDoctorId(), dbl.doctorLogin("DO1", "pass").getDoctorId());
	}

	@Test
	public void testMyAppointments() throws ClassNotFoundException, SQLException, IOException {
		Doctor doctor=new Doctor();
		doctor.setDoctorId("DO1");
		doctor.setDoctorPassword("pass");
		assertNotEquals(null,dbl.myAppointments(doctor.getDoctorId()));
	}

	@Test
	public void testAddMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		
		newMedicalReport.setDiagnosis("Good");
		newMedicalReport.setDoctorId("1");
		newMedicalReport.setInvestigations("Good");
		newMedicalReport.setPatientId(1);
		newMedicalReport.setRecommendations("Good");
		newMedicalReport.setTechnicianId("1");
		newMedicalReport.setTests("Good");
		newMedicalReport.setVisitDate(Date.valueOf("2017-11-11"));
		assertTrue(dbl.addMedicalReport(newMedicalReport));
	}

	@Test
	public void testRemoveMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		int patientId = 1;
		
		assertTrue(dbl.removeMedicalReport(patientId));
	}

	@Test
	public void testModifyMedicalReport() throws ClassNotFoundException, SQLException, IOException {

		int patientId = 1;
		newMedicalReport.setDiagnosis("Good");
		newMedicalReport.setDoctorId("1");
		newMedicalReport.setInvestigations("Good");
		newMedicalReport.setPatientId(1);
		newMedicalReport.setRecommendations("Good");
		newMedicalReport.setTechnicianId("1");
		newMedicalReport.setTests("Good");
		newMedicalReport.setVisitDate(Date.valueOf("2017-11-11"));
		
		assertTrue(dbl.modifyMedicalReport(patientId,newMedicalReport));
	}

	@Test
	public void testListMedicalReport() throws ClassNotFoundException, SQLException, IOException {
		assertNotEquals(null,dbl.listMedicalReport());
	}

	@Test
	public void testViewMedicalReports() throws ClassNotFoundException, SQLException, IOException {
		int patientId = 1;
		
		assertEquals(patientId, dbl.viewMedicalReports(patientId));
	}

	@Test
	public void testAddMedicine() throws ClassNotFoundException, SQLException, IOException {
		newMedicine.setBillNo(1);
		newMedicine.setDosage("Normal");
		newMedicine.setMedicineName("Normal");
		newMedicine.setPatientId(1);
		newMedicine.setPrice(100);
		newMedicine.setQuantity(1);
		newMedicine.setsNo(1);
		
		assertTrue(dbl.addMedicine(newMedicine));
	}

	@Test
	public void testRemoveMedicine() throws ClassNotFoundException, SQLException, IOException {
		newMedicine.setBillNo(1);
		newMedicine.setDosage("Normal");
		newMedicine.setMedicineName("Normal");
		newMedicine.setPatientId(1);
		newMedicine.setPrice(100);
		newMedicine.setQuantity(1);
		newMedicine.setsNo(1);
		
		dbl.addMedicine(newMedicine);
		
		assertTrue(dbl.removeMedicine(newMedicine.getsNo(),newMedicine.getPatientId()));
	}

	@Test
	public void testModifyMedicine() throws ClassNotFoundException, SQLException, IOException {
		newMedicine.setBillNo(1);
		newMedicine.setDosage("Normal");
		newMedicine.setMedicineName("Normal");
		newMedicine.setPatientId(1);
		newMedicine.setPrice(100);
		newMedicine.setQuantity(1);
		newMedicine.setsNo(1);
		
		dbl.addMedicine(newMedicine);
		
		assertTrue(dbl.modifyMedicine(newMedicine.getsNo(),newMedicine));
	}

	@Test
	public void testListMedicine() throws ClassNotFoundException, SQLException, IOException {
		int patientId=1;
		assertNotEquals(null,dbl.listMedicine(patientId));
	}

	@Test
	public void testViewMedicine() throws ClassNotFoundException, SQLException, IOException {

		int patientId = 1,sNo=1;
		
		assertEquals(patientId, dbl.viewMedicine(patientId,sNo));
	}

}

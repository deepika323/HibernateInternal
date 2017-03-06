package model.blJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Bill;
import model.bean.DischargeSummary;
import model.bean.MedicalReport;
import model.bean.Person;
import model.bl.PersonBusinessLogic;


public class PersonBLTest {

	private PersonBusinessLogic pbl;
	
	@Before
	public void setUp() throws Exception {
		pbl = new PersonBusinessLogic();
	}

	@After
	public void tearDown() throws Exception {
		pbl = null;
	}

	@Test
	public void testListReception() throws ClassNotFoundException, SQLException, IOException {
		assertNotEquals(null, pbl.listAppointment());
	}

	@Test
	public void testViewMedicalReport() {
		int patientId = 1;
		MedicalReport newMedicalReport = new MedicalReport();
		
		newMedicalReport.setDiagnosis("Good");
		newMedicalReport.setDoctorId("1");
		newMedicalReport.setInvestigations("Good");
		newMedicalReport.setPatientId(1);
		newMedicalReport.setRecommendations("Good");
		newMedicalReport.setTechnicianId("1");
		newMedicalReport.setTests("Good");
		newMedicalReport.setVisitDate(Date.valueOf("2017-11-11"));
		
		assertEquals(patientId,newMedicalReport.getPatientId());
	}

	@Test
	public void testViewBill() throws ClassNotFoundException, SQLException, IOException {
		Bill bill = new Bill();
		
		bill.setBedCharges(1000);
		bill.setBillNo(1);
		bill.setDoctorVisit(1);
		bill.setMedicines(1);
		bill.setPatientId(1);
		bill.setSerialNo(1);
		bill.setTests(1);
		
		assertEquals(bill.getBillNo(), pbl.viewBill(bill.getBillNo()));
	}

	@Test
	public void testViewDischargeSummary() throws ClassNotFoundException, SQLException, IOException {
		DischargeSummary ds = new DischargeSummary();
		
		ds.setAdmissionDate(Date.valueOf("2017-11-11"));
		ds.setBedNo(1);
		ds.setDischargeDate(Date.valueOf("2017-11-11"));
		ds.setDoctorId("1");
		ds.setHistory("Good");
		ds.setOnExamination("Good");
		ds.setOperationDone("Good");
		ds.setOperativeFindings("Good");
		ds.setOtId(1);
		ds.setPatientId(1);
		ds.setRecommendations("Good");
		ds.setSerialNo(1);
		ds.setTreatmentGiven("Good");
		
		assertEquals(ds, pbl.viewDischargeSummary(ds.getPatientId()));
	}

	@Test
	public void testMyMedicines() throws ClassNotFoundException, SQLException, IOException {
		int patientId = 1;
		
		assertNotEquals(null, pbl.myMedicines(patientId));
	}

	@Test
	public void testPersonSignUp() throws ClassNotFoundException, SQLException, IOException {
		Person person = new Person();
		person.setPersonAddress("delhi");
		person.setPersonAge(10);
		person.setPersonDateOfBirth(Date.valueOf("2017-11-11"));
		person.setPersonGender("Female");
		person.setPersonId("00");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonPassword("pass");
		person.setPersonPhoneNo(3256);
	
		
		
		assertTrue(pbl.personSignUp(person));
	}

	@Test
	public void testPersonLogin() throws ClassNotFoundException, SQLException, IOException {
		Person person = new Person();
		person.setPersonAddress("delhi");
		person.setPersonAge(10);
		person.setPersonDateOfBirth(Date.valueOf("2017-11-11"));
		person.setPersonGender("Female");
		person.setPersonId("00");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonPassword("pass");
		person.setPersonPhoneNo(3256);
		
		pbl.personSignUp(person);
		
		assertEquals(person, pbl.personLogin(person.getPersonId(), person.getPersonPassword()));
	}

}

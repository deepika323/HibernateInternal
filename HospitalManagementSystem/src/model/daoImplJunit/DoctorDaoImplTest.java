package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Doctor;
import model.dao.DoctorDaoImpl;

public class DoctorDaoImplTest {
	
	private DoctorDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new DoctorDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertDoctor() throws ClassNotFoundException, SQLException, IOException {
		
		
		//Create necessary tables and insert one tuple for negative insert testing 
		dd.deleteDoctor("DO4");
		Doctor doctor=new Doctor();
		doctor.setDoctorId("DO4");
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Modi");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		doctor.setDoctorPassword("pass");
		
		assertTrue(dd.insertDoctor(doctor));
		
	}
	@Test(expected=SQLException.class)
	public void testInsertDoctorNegative() throws ClassNotFoundException, SQLException, IOException {
		
		
		Doctor doctor=new Doctor();
		doctor.setDoctorId("DO0");
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Modi");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		doctor.setDoctorPassword("pass");
		dd.insertDoctor(doctor);
	}
	

	@Test
	public void testDeleteDoctorNegative() throws ClassNotFoundException, SQLException, IOException {
		
		assertFalse(dd.deleteDoctor("doc1234"));
	}
	
	@Test
	public void testDeleteDoctor() throws ClassNotFoundException, SQLException, IOException {
		
		Doctor doctor=new Doctor();
		doctor.setDoctorId("5");
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Gandhi");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		doctor.setDoctorPassword("pass");
		dd.insertDoctor(doctor);
		assertTrue(dd.deleteDoctor("5"));
	}

	@Test
	public void testUpdateDoctor() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteDoctor("6");
		Doctor doctor=new Doctor();
		doctor.setDoctorId("6");
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("fgdg");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		doctor.setDoctorPassword("pass");
		dd.insertDoctor(doctor);
		Doctor newdoctor=new Doctor();
		newdoctor.setDoctorId("6");
		newdoctor.setDoctorAddress("Mumbai");
		newdoctor.setDoctorName("dadasd");
		newdoctor.setDoctorPhoneNo(1876543210);
		newdoctor.setSpecialization("Hair Specialist");
		newdoctor.setTiming("5-6");
		newdoctor.setDepartmentId(0);
		newdoctor.setDoctorPassword("pass");
		
		assertTrue(dd.updateDoctor("6",newdoctor));
		
		//assertEquals(newdoctor.getDoctorAddress(), dd.displayDoctor(1).getDoctorAddress());
		
		
	}
	

	@Test
	public void testUpdateDoctorNegative() throws ClassNotFoundException, SQLException, IOException
	{
		Doctor newdoctor=new Doctor();
		
		newdoctor.setDoctorAddress("Mumbai");
		newdoctor.setDoctorName("dadasd");
		newdoctor.setDoctorPhoneNo(1876543210);
		newdoctor.setSpecialization("Hair Specialist");
		newdoctor.setTiming("5-6");
		newdoctor.setDepartmentId(0);
		newdoctor.setDoctorPassword("pass");
		
		assertFalse(dd.updateDoctor("2343", newdoctor));
	}

	@Test
	public void testDisplayDoctor() throws ClassNotFoundException, SQLException, IOException {
		
		
		dd.deleteDoctor("7");
		Doctor doctor=new Doctor();
		doctor.setDoctorId("7");
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		doctor.setDoctorPassword("pass");
		dd.insertDoctor(doctor);
		
		
		
		assertEquals(doctor, dd.displayDoctor("7"));
		
		
	}
	@Test
	public void testDisplayDoctorNegative() throws ClassNotFoundException, SQLException, IOException {
		
		
		assertEquals(0,dd.displayDoctor("234234").getDoctorId());
		
	}

	@Test
	public void testDisplayAllDoctors() throws ClassNotFoundException, SQLException, IOException {
		
		
		
		assertNotEquals(null, dd.displayAllDoctors());
		
	}

}

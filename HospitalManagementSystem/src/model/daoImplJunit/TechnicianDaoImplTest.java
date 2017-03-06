package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Technician;
import model.dao.TechnicianDaoImpl;

public class TechnicianDaoImplTest {

	private TechnicianDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new TechnicianDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertTechnician() throws ClassNotFoundException, SQLException, IOException {
		dd.deleteTechnician("1");
		Technician technician=new Technician();
		technician.setTechnicianId("1");
		technician.setTechnicianAddress("Gurgaon");
		technician.setTechnicianName("Dr Batra");
		technician.setTechnicianPhoneNo(1234567890);
		technician.setSpecialization("Hair Specialist");
		technician.setTiming("5-6");
		technician.setDepartmentId(0);
		technician.setTechnicianPassword("pass");
		assertTrue(dd.insertTechnician(technician));
		
		
	}
	

	@Test
	public void testDeleteTechnician() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteTechnician("1");
		Technician technician=new Technician();
		technician.setTechnicianId("1");
		technician.setTechnicianAddress("Gurgaon");
		technician.setTechnicianName("Dr Batra");
		technician.setTechnicianPhoneNo(1234567890);
		technician.setSpecialization("Hair Specialist");
		technician.setTiming("5-6");
		technician.setDepartmentId(0);
		technician.setTechnicianPassword("pass");
		dd.insertTechnician(technician);
		assertTrue(dd.deleteTechnician("1"));
	}

	@Test
	public void testUpdateTechnician() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteTechnician("1");
		Technician technician=new Technician();
		technician.setTechnicianId("1");
		technician.setTechnicianAddress("Gurgaon");
		technician.setTechnicianName("Dr Batra");
		technician.setTechnicianPhoneNo(1234567890);
		technician.setSpecialization("Hair Specialist");
		technician.setTiming("5-6");
		technician.setDepartmentId(0);
		technician.setTechnicianPassword("pass");
		dd.insertTechnician(technician);
		Technician newtechnician=new Technician();
		newtechnician.setTechnicianId("1");
		newtechnician.setTechnicianAddress("Mumbai");
		newtechnician.setTechnicianName("Dr Batra");
		newtechnician.setTechnicianPhoneNo(1876543210);
		newtechnician.setSpecialization("Hair Specialist");
		newtechnician.setTiming("5-6");
		newtechnician.setDepartmentId(0);
		technician.setTechnicianPassword("pass");
		assertTrue(dd.updateTechnician("1",newtechnician));
		
		//assertEquals(newtechnician.getTechnicianAddress(), dd.displayTechnician(1).getTechnicianAddress());
		
		
	}

	@Test
	public void testDisplayTechnician() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteTechnician("1");
		Technician technician=new Technician();
		technician.setTechnicianId("1");
		technician.setTechnicianAddress("Gurgaon");
		technician.setTechnicianName("Dr Batra");
		technician.setTechnicianPhoneNo(1234567890);
		technician.setSpecialization("Hair Specialist");
		technician.setTiming("5-6");
		technician.setDepartmentId(0);
		technician.setTechnicianPassword("pass");
		dd.insertTechnician(technician);
		
		assertEquals(technician, dd.displayTechnician("1"));
		
		
	}

	@Test
	public void testDisplayAllTechnicians() throws ClassNotFoundException, SQLException, IOException {
		
		assertNotEquals(null, dd.displayAllTechnicians());
		
	}

}

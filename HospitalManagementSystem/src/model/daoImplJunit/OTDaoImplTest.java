package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.MedicalReport;
import model.bean.OT;
import model.dao.MedicalReportDaoImpl;
import model.dao.OTDaoImpl;

public class OTDaoImplTest {

	private OTDaoImpl otd;
	@Before
	public void setUp() throws Exception {
		otd=new OTDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		otd=null;
	}

	@Test
	public void testInsertOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(0);
		ot.setStaffId(0);
		ot.setDoctorId("0");
		assertTrue(otd.insertOT(ot));
	}

	@Test(expected=SQLException.class)
	public void testInsertMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException {
	
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(0);
		ot.setStaffId(0);
		ot.setDoctorId("0");
		
		assertFalse(otd.insertOT(ot));
	}	
	
	@Test
	public void testDeleteOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(0);
		ot.setStaffId(0);
		ot.setDoctorId("0");
		otd.insertOT(ot);
		assertTrue(otd.deleteOT(0));
	}
	
	@Test
	public void testDeleteOTNegative() throws ClassNotFoundException, SQLException, IOException {
		assertFalse(otd.deleteOT(12131));
	}

	@Test
	public void testUpdateOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(0);
		ot.setStaffId(0);
		ot.setDoctorId("0");
		otd.insertOT(ot);
	    OT newot = new OT();
	    newot.setDescription("abc");
		newot.setEquipments("def");
		newot.setPatientId(0);
		newot.setStaffId(0);
		newot.setDoctorId("0");
		assertTrue(otd.updateOT(0,newot));
	}
	
	@Test
	public void testUpdateMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException
	{
	
		OT newot = new OT();
	    newot.setDescription("abc");
		newot.setEquipments("def");
		newot.setPatientId(0);
		newot.setStaffId(0);
		newot.setDoctorId("0");
		
		assertFalse(otd.updateOT(2343, newot));
	}


	@Test
	public void testDisplayOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(0);
		ot.setStaffId(0);
		ot.setDoctorId("0");
		otd.insertOT(ot);
		
		assertEquals(ot.getPatientId(), otd.displayOT(0).getPatientId());
	}

	@Test
	public void testDisplayOTNegative() throws ClassNotFoundException, SQLException, IOException {
		assertEquals(0,otd.displayOT(234234).getOtId());	
	}
	
	@Test
	public void testDisplayAllOTs() throws ClassNotFoundException, SQLException, IOException {
		assertNotEquals(null, otd.displayAllOTs());
	}

}

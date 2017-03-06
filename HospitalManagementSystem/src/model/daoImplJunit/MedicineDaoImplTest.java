package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Doctor;
import model.bean.Medicine;
import model.dao.MedicineDaoimpl;

public class MedicineDaoImplTest {
	
	private MedicineDaoimpl md;

	@Before
	public void setUp() throws Exception {
		md=new MedicineDaoimpl();
	}

	@After
	public void tearDown() throws Exception {
		md=null;
	}

	@Test
	public void testInsertMedicine() throws ClassNotFoundException, SQLException, IOException {
		md.deleteMedicine(1,0);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(0);
		medicine.setPatientId(0);
	//	medicine.setBillNo(0);
		assertTrue(md.insertMedicine(medicine));
	}

	@Test(expected=SQLException.class)
	public void testInsertMedicineNegative() throws ClassNotFoundException, SQLException, IOException {	
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(0);
		medicine.setPatientId(0);
		medicine.setBillNo(0);
		
		assertFalse(md.insertMedicine(medicine));
	}
	
	@Test
	public void testDeleteMedicine() throws ClassNotFoundException, SQLException, IOException {
		md.deleteMedicine(1,0);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(0);
		medicine.setPatientId(0);
		medicine.setBillNo(0);
		md.insertMedicine(medicine);
		assertTrue(md.deleteMedicine(1,0));
	}
	
	@Test
	public void testDeleteMedicineNegative() throws ClassNotFoundException, SQLException, IOException {
		assertFalse(md.deleteMedicine(12131,0));
	}

	@Test
	public void testUpdateMedicine() throws ClassNotFoundException, SQLException, IOException {
		md.deleteMedicine(1,0);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(0);
		medicine.setPatientId(0);
		medicine.setBillNo(0);
		md.insertMedicine(medicine);
		Medicine newmedicine = new Medicine();
		newmedicine.setsNo(1);
		newmedicine.setMedicineName("abc");
		newmedicine.setQuantity(2);
		newmedicine.setDosage("def");
		newmedicine.setPrice(0);
		newmedicine.setPatientId(0);
		newmedicine.setBillNo(0);
		assertTrue(md.updateMedicine(1,newmedicine));

	}
	
	@Test
	public void testUpdateMedicineNegative() throws ClassNotFoundException, SQLException, IOException
	{
		Medicine newmedicine = new Medicine();
		newmedicine.setsNo(1);
		newmedicine.setMedicineName("abc");
		newmedicine.setQuantity(2);
		newmedicine.setDosage("def");
		newmedicine.setPrice(0);
		newmedicine.setPatientId(0);
		newmedicine.setBillNo(0);
		
		assertFalse(md.updateMedicine(2343, newmedicine));
	}

	@Test
	public void testDisplayMedicine() throws ClassNotFoundException, SQLException, IOException {
		md.deleteMedicine(1,0);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(0);
		medicine.setPatientId(0);
		medicine.setBillNo(0);
		md.insertMedicine(medicine);
		
		assertEquals(medicine, md.displayMedicine(1,0));
	}

	@Test
	public void testDisplayMedicineNegative() throws ClassNotFoundException, SQLException, IOException {
		assertEquals(0,md.displayMedicine(234234,0).getsNo());
	}
	@Test
	public void testDisplayAllMedicines() throws ClassNotFoundException, SQLException, IOException {
		int patientId = 1;
		assertNotEquals(null, md.displayAllMedicines(patientId));
	}

}

package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Bill;
import model.bean.Person;
import model.dao.BillDaoImpl;

public class BillDaoImplTest {

	private BillDaoImpl bd;
	@Before
	public void setUp() throws Exception {
		bd=new BillDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		bd=null;
	}

	@Test
	public void testInsertBill() throws ClassNotFoundException, SQLException, IOException {
		bd.deleteBill(1);
		
		 Bill bill=new Bill();
		 bill.setBillNo(1);
		 bill.setPatientId(0);
		 bill.setSerialNo(0);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 
		 assertTrue(bd.insertBill(bill));
	}
	
	@Test(expected=SQLException.class)
	public void testInsertBillNegative() throws ClassNotFoundException, SQLException, IOException {
		
		Bill bill=new Bill();
		 bill.setBillNo(34);
		 bill.setPatientId(0);
		 bill.setSerialNo(0);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		
		bd.insertBill(bill);
	}
	
	@Test
	public void testDeleteBillNegative() throws ClassNotFoundException, SQLException, IOException {
		
		assertFalse(bd.deleteBill(346421));
	}

	@Test
	public void testDeleteBill() throws ClassNotFoundException, SQLException, IOException {
		 
		 Bill bill=new Bill();
		 bill.setBillNo(89);
		 bill.setPatientId(0);
		 bill.setSerialNo(0);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 bd.insertBill(bill);
		 
		 assertTrue(bd.deleteBill(89));
	}

	@Test
	public void testUpdateBill() throws ClassNotFoundException, SQLException, IOException {
		bd.deleteBill(21);
		
		Bill bill=new Bill();
		bill.setBillNo(21);
		 bill.setPatientId(0);
		 bill.setSerialNo(0);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 bd.insertBill(bill);
		 
		 Bill newBill=new Bill();
		 newBill.setBillNo(21);
		 newBill.setPatientId(0);
		 newBill.setSerialNo(0);
		 newBill.setDoctorVisit(3);
		 newBill.setBedCharges(1);
		 newBill.setTests(1);
		 newBill.setMedicines(1);
		  
		 
		 assertTrue(bd.updateBill(21, newBill));
		 
		 
		 
		
	}
	
	@Test
	public void testUpdateBillNegative() throws ClassNotFoundException, SQLException, IOException
	{
		 Bill newBill=new Bill();
		 newBill.setBillNo(2343);
		 newBill.setPatientId(1);
		 newBill.setSerialNo(4);
		 newBill.setDoctorVisit(3);
		 newBill.setBedCharges(1);
		 newBill.setTests(1);
		 newBill.setMedicines(1);
		
		assertFalse(bd.updateBill(2343, newBill));
	}
	
	@Test
	public void testDisplayPersonNegative() throws ClassNotFoundException, SQLException, IOException {
		
		
		assertEquals(0,bd.displayBill(234234).getBillNo());
		
	}

	@Test
	public void testDisplayBill() throws ClassNotFoundException, SQLException, IOException {

		bd.deleteBill(77);
		
		 Bill bill=new Bill();
		 bill.setBillNo(77);
		 bill.setPatientId(0);
		 bill.setSerialNo(0);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 bd.insertBill(bill);
		 
		 assertEquals(bill.getBillNo(), bd.displayBill(77).getBillNo());
	}

	@Test
	public void testDisplayAllBills() throws ClassNotFoundException, SQLException, IOException {
		
//		TreeSet<Bill> billList=new TreeSet<Bill>();
//		
//		 bd.deleteBill(1);
//		
//		 Bill bill=new Bill();
//		 bill.setBillNo(1);
//		 bill.setPatientId(1);
//		 bill.setSerialNo(1);
//		 bill.setDoctorVisit(1);
//		 bill.setBedCharges(1);
//		 bill.setTests(1);
//		 bill.setMedicines(1);
//		 bd.insertBill(bill);
//		 
//		 assertEquals(bill, bd.displayAllBills());
		
		assertNotEquals(null, bd.displayAllBills());
		
	}

}

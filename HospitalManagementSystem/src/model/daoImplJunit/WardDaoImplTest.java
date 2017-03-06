package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Doctor;
import model.bean.Ward;
import model.dao.WardDaoImpl;

public class WardDaoImplTest {

	private WardDaoImpl wd;
	@Before
	public void setUp() throws Exception {
		wd=new WardDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		wd=null;
	}

	@Test
	public void testInsertWard() throws ClassNotFoundException, SQLException, IOException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateDischarged(dateDischarged);
	    ward.setStaffId("0");
	    ward.setPatientId(0);
		assertTrue(wd.insertWard(ward));
	}

	@Test(expected=SQLException.class)
	public void testInsertWardNegative() throws ClassNotFoundException, SQLException, IOException {
		
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateDischarged(dateDischarged);
	    ward.setStaffId("0");
	    ward.setPatientId(0);
		
		assertFalse(wd.insertWard(ward));
	}
	
	@Test
	public void testDeleteWard() throws ClassNotFoundException, SQLException, IOException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateDischarged(dateDischarged);
	    ward.setStaffId("0");
	    ward.setPatientId(0);
		wd.insertWard(ward);
	}
	
	@Test
	public void testDeleteWardNegative() throws ClassNotFoundException, SQLException, IOException {
		assertFalse(wd.deleteWard(12131));
	}

	@Test
	public void testUpdateWard() throws ClassNotFoundException, SQLException, IOException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateDischarged(dateDischarged);
	    ward.setStaffId("0");
	    ward.setPatientId(0);
		wd.insertWard(ward);
		Ward newward = new Ward();
		newward.setBedNo(1);
		newward.setType("abc");
		newward.setLocation("def");
		str="2015-03-31";  
	    dateAdmitted=Date.valueOf(str);
		newward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    dateDischarged=Date.valueOf(str);
	    newward.setDateDischarged(dateDischarged);
	    newward.setStaffId("0");
	    newward.setPatientId(0);
	    assertTrue(wd.updateWard(1,newward));
		
	}

	@Test
	public void testUpdateWardNegative() throws ClassNotFoundException, SQLException, IOException
	{
		Ward newward = new Ward();
		newward.setBedNo(1);
		newward.setType("abc");
		newward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		newward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    newward.setDateDischarged(dateDischarged);
	    newward.setStaffId("0");
	    newward.setPatientId(0);
		
		assertFalse(wd.updateWard(2343, newward));
	}
	
	@Test
	public void testDisplayWard() throws ClassNotFoundException, SQLException, IOException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateDischarged(dateDischarged);
	    ward.setStaffId("0");
	    ward.setPatientId(0);
		wd.insertWard(ward);
		
		assertEquals(ward, wd.displayWard(1));
	}
	
	@Test
	public void testDisplayDoctorNegative() throws ClassNotFoundException, SQLException, IOException {	
		assertEquals(0,wd.displayWard(234234).getBedNo());
	}

	@Test
	public void testDisplayAllWards() throws ClassNotFoundException, SQLException, IOException {
		assertNotEquals(null, wd.displayAllWards());
	}

}

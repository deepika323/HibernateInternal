package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Appointment;
import model.dao.AppointmentDaoImpl;

public class AppointmentDaoImplTest {

	private AppointmentDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new AppointmentDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertAppointment() throws ClassNotFoundException, SQLException, IOException {
		dd.deleteAppointment(1);
		Appointment reception=new Appointment();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("asjkdhasd");
		reception.setPayment(12345);
		reception.setDoctorId("0");
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		assertTrue(dd.insertAppointment(reception));
		
		
	}
	

	@Test
	public void testDeleteAppointment() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteAppointment(1);
		Appointment reception=new Appointment();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("Dr Batra");
		reception.setPayment(0);
		reception.setDoctorId("0");
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		dd.insertAppointment(reception);
		assertTrue(dd.deleteAppointment(1));
	}

	@Test
	public void testUpdateAppointment() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteAppointment(1);
		Appointment reception=new Appointment();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("Dr Batra");
		reception.setPayment(0);
		reception.setDoctorId("0");
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		dd.insertAppointment(reception);
		
		Appointment newreception=new Appointment();
		
		newreception.setRegNo(1);
		newreception.setPersonId("ABCD");
		newreception.setPurpose("Dr Batra");
		newreception.setPayment(18);
		
		assertTrue(dd.updateAppointment(1,newreception));
		
		//assertEquals(newreception.getAppointmentAddress(), dd.displayAppointment(1).getAppointmentAddress());
		
		
	}

	@Test
	public void testDisplayAppointment() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteAppointment(1);
		Appointment reception=new Appointment();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("Dr Batra");
		reception.setPayment(0);
		reception.setDoctorId("0");
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		dd.insertAppointment(reception);
		
		assertEquals(reception.getRegNo(), dd.displayAppointment(1).getRegNo());
		
		
	}

	@Test
	public void testDisplayAllAppointments() throws ClassNotFoundException, SQLException, IOException {
		
		assertNotEquals(null, dd.displayAllAppointments());
		
	}

}

package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Department;
import model.bean.Doctor;
import model.dao.DepartmentDaoImpl;

public class DepartmentDaoImplTest {
	
	private DepartmentDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new DepartmentDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertDepartment() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteDepartment(1);
		Department department=new Department();
		department.setDepartmentId(1);
		department.setDepartmentLocation("Gurgaon");
		department.setDepartmentName("General");
		department.setDescription("dummyDescription");
		
		assertTrue(dd.insertDepartment(department));
	}
	
	@Test(expected=SQLException.class)
	public void testInsertDoctorNegative() throws ClassNotFoundException, SQLException, IOException {
		
		Department department=new Department();
		department.setDepartmentId(0);
		department.setDepartmentLocation("Gurgaon");
		department.setDepartmentName("General");
		department.setDescription("dummyDescription");
		assertFalse(dd.insertDepartment(department));
	}


	
	@Test
	public void testDeleteDepartment() throws ClassNotFoundException, SQLException, IOException {
		//dummy values inserted manually
		Department department=new Department();
		department.setDepartmentId(2);
		department.setDepartmentLocation("Gurgaon");
		department.setDepartmentName("General");
		department.setDescription("dummyDescription");
		
		dd.insertDepartment(department);
		assertTrue(dd.deleteDepartment(2));
		
	}

	@Test
	public void testDeleteDepartmentNegative() throws ClassNotFoundException, SQLException, IOException
	{
		assertFalse(dd.deleteDepartment(231424));
		
	}
	@Test
	public void testUpdateDepartment() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteDepartment(3);
		Department department=new Department();
		department.setDepartmentId(3);
		department.setDepartmentLocation("Gurgaon");
		department.setDepartmentName("General");
		department.setDescription("dummyDescription");
		dd.insertDepartment(department);
		
		
		Department newDepartment=new Department();
		
		newDepartment.setDepartmentLocation("Gurgaon");
		newDepartment.setDepartmentName("General");
		newDepartment.setDescription("dummyChange");

		assertTrue(dd.updateDepartment(3, newDepartment));
		
	}
	
	@Test
	public void testUpdateDepartmentNegative() throws ClassNotFoundException, SQLException, IOException
	{
		Department newDepartment=new Department();
		
		newDepartment.setDepartmentLocation("Gurgaon");
		newDepartment.setDepartmentName("General");
		newDepartment.setDescription("dummyChange");

		assertFalse(dd.updateDepartment(3234234, newDepartment));

	}

	@Test
	public void testDisplayDepartment() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteDepartment(3);
		Department department=new Department();
		department.setDepartmentId(3);
		department.setDepartmentLocation("dis location");
		department.setDepartmentName("xyz");
		department.setDescription("qwerty");
		dd.insertDepartment(department);
		
		assertEquals(department, dd.displayDepartment(3));
		
	}
	@Test
	public void testDisplayDepartmentNegative() throws ClassNotFoundException, SQLException, IOException {
		
		
		
		assertEquals(0, dd.displayDepartment(3242332).getDepartmentId());
		
	}

	@Test
	public void testDisplayAllDepartments() throws ClassNotFoundException, SQLException, IOException {
		
		assertNotEquals(null, dd.displayAllDepartments());
		
	}

}

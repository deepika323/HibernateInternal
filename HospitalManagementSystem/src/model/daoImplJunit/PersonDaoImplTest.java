package model.daoImplJunit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.bean.Doctor;
import model.bean.Person;


import model.dao.PersonDaoImpl;

public class PersonDaoImplTest {

	private PersonDaoImpl pd;
	
	@Before
	public void setUp() throws Exception {
		pd=new PersonDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		pd=null;
	}

	@Test
	public void testInsertPerson() throws ClassNotFoundException, SQLException, IOException {
		
		//Create necessary tables and insert one tuple for negative insert testing 
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		
		assertTrue(pd.insertPerson(person));
	}

	
	@Test(expected=SQLException.class)
	public void testInsertPersonNegative() throws ClassNotFoundException, SQLException, IOException {
		
		pd.deletePerson("2");
		Person person=new Person();
		person.setPersonId("2");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		
		person.setPersonId("2");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		
		assertFalse(pd.insertPerson(person));
	}
	
	@Test
	public void testDeletePersonNegative() throws ClassNotFoundException, SQLException, IOException {
		
		assertFalse(pd.deletePerson("346421"));
	}
	
	@Test
	public void testDeletePerson() throws ClassNotFoundException, SQLException, IOException {
		
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		assertTrue(pd.deletePerson("1"));
	}

	@Test
	public void testUpdatePerson() throws ClassNotFoundException, SQLException, IOException {
		
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		
		
		Person newPerson=new Person();
		newPerson.setPersonId("1");
		newPerson.setPersonIdType("Patient");
		newPerson.setPersonName("XYZ");
		newPerson.setPersonDateOfBirth(null);
		newPerson.setPersonAge(16);
		newPerson.setPersonGender("Male");
		newPerson.setPersonAddress("Delhi");
		newPerson.setPersonPhoneNo(28299266);
		newPerson.setPersonPassword("pass");
		//pd.updatePerson("1",newPerson);
		
		assertTrue(pd.updatePerson("1", newPerson));
		//assertEquals(newPerson.getPersonAddress(), pd.displayPerson("1").getPersonAddress());
	}

	@Test
	public void testUpdatePersonNegative() throws ClassNotFoundException, SQLException, IOException
	{
		Person newPerson=new Person();
		
		newPerson.setPersonId("1");
		newPerson.setPersonIdType("Patient");
		newPerson.setPersonName("XYZ");
		newPerson.setPersonDateOfBirth(null);
		newPerson.setPersonAge(16);
		newPerson.setPersonGender("Male");
		newPerson.setPersonAddress("Delhi");
		newPerson.setPersonPhoneNo(28299266);
		newPerson.setPersonPassword("pass");
		
		assertFalse(pd.updatePerson("2343", newPerson));
	}
	
	@Test
	public void testDisplayPerson() throws ClassNotFoundException, SQLException, IOException {
		
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		
		assertEquals(person.getPersonAddress(), pd.displayPerson("1").getPersonAddress());
	}

	@Test
	public void testDisplayPersonNegative() throws ClassNotFoundException, SQLException, IOException {
		
		
		assertEquals(null,pd.displayPerson("234234").getPersonId());
		
	}
	
	@Test
	public void testDisplayAllPersons() throws ClassNotFoundException, SQLException, IOException {
		
//		TreeSet<Person> personList=new TreeSet<Person>();
//		pd.deletePerson("1");
//		Person person=new Person();
//		person.setPersonId("1");
//		person.setPersonIdType("Patient");
//		person.setPersonName("XYZ");
//		person.setPersonDateOfBirth(null);
//		person.setPersonAge(16);
//		person.setPersonGender("Male");
//		person.setPersonAddress("Delhi");
//		person.setPersonPhoneNo(25299266);
//		person.setPersonPassword("pass");
//		personList.add(person);
//		
//		assertEquals(personList, pd.displayAllPersons());
		
		assertNotEquals(null, pd.displayAllPersons().size());
	}

}

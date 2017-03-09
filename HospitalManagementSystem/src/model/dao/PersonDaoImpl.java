package model.dao;

import static model.helper.ConnectToDb.closeConnection;
import static model.helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import model.bean.Doctor;
import model.bean.Medicine;
import model.bean.Person;

public class PersonDaoImpl implements PersonDao {

	SessionFactory factory=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	Transaction t;  
	Session session=factory.openSession();
	
//	private PreparedStatement pstmt=null;
//	private Connection con;
//	private ResultSet rs;
	
	@Override
	public boolean insertPerson(Person newPerson) throws SQLException, ClassNotFoundException, IOException {

		try{
			t=session.beginTransaction();
			
			session.save(newPerson);
			
			t.commit();
			System.out.println("Record Inserted");
			return true;
			}
			catch(Exception ex){
				t.rollback();
			}
			finally{
				session.close();
			}
			
			return false;
		
//		con= openConnection();
//		
//		String personId=newPerson.getPersonId();
//		String personType=newPerson.getPersonIdType();
//		String personName=newPerson.getPersonName();
//		Date personDateOfBirh=newPerson.getPersonDateOfBirth();
//		int personAge=newPerson.getPersonAge();
//		String personGender=newPerson.getPersonGender();
//		String personAddress=newPerson.getPersonAddress();
//		long personPhoneNo=newPerson.getPersonPhoneNo();
//		String personPassword=newPerson.getPersonPassword();
//		
//		pstmt=con.prepareStatement("insert into Person (personId,personIdType,personName,personDateOfBirth," +
//				"personAge,personGender,personAddress,personPhoneNo,personPassword) values" + 
//				"(?,?,?,?,?,?,?,?,?)");
//		
//		pstmt.setString(1,personId);
//		pstmt.setString(2,personType);
//		pstmt.setString(3, personName);
//		pstmt.setDate(4, personDateOfBirh);
//		pstmt.setInt(5, personAge);
//		pstmt.setString(6, personGender);
//		pstmt.setString(7, personAddress);
//		pstmt.setLong(8, personPhoneNo);
//		pstmt.setString(9, personPassword);
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//		}
//		else closeConnection(con);
//		return false;
		
	}

	@Override
	public boolean deletePerson(String personId) throws ClassNotFoundException, SQLException, IOException {

		try{
			Person person=(Person) session.get(Person.class,personId);
			session.delete(person);
			System.out.println("Record Deleted");
			return true;
			}
			catch(Exception ex){
				System.out.println("Record Not Deleted");
			}
			finally{
				session.close();
			}
			
			return false;
		
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("delete from Person where personId = ?");
//		
//		pstmt.setString(1,personId);
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//		}
//		else closeConnection(con);
//		return false;
	}

	@Override
	public boolean updatePerson(String personId, Person renewPerson) throws ClassNotFoundException, SQLException, IOException {

		try{
			t=session.beginTransaction();
			
			//session.save(renewBill);
			session.update(renewPerson);
			
			t.commit();
			System.out.println("Record Updated");
			return true;
			}
			catch(Exception ex){
				t.rollback();
			}
			finally{
				session.close();
			}
			
			return false;
		
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("update Person set personIdType=?,personName=?,personDateOfBirth=?," +
//				"personAge=?,personGender=?,personAddress=?,personPhoneNo=?,personPassword=? where personId=?");
//		
//
//		pstmt.setString(1,renewPerson.getPersonIdType());
//		pstmt.setString(2, renewPerson.getPersonName());
//		pstmt.setDate(3, renewPerson.getPersonDateOfBirth());
//		pstmt.setInt(4, renewPerson.getPersonAge());
//		pstmt.setString(5, renewPerson.getPersonGender());
//		pstmt.setString(6, renewPerson.getPersonAddress());
//		pstmt.setLong(7, renewPerson.getPersonPhoneNo());
//		pstmt.setString(8, renewPerson.getPersonPassword());
//		pstmt.setString(9, personId);
//		
//		int rows=pstmt.executeUpdate();
//		
//		if(rows>0)
//		{
//			closeConnection(con);
//			return true;
//		}
//		else closeConnection(con);
//		return false;
//		
		
	}

	@Override
	public Person displayPerson(String personId) throws ClassNotFoundException, SQLException, IOException {

		try{
			Person person=(Person) session.get(Person.class,personId);
			System.out.println("Record Displayed");
			return person;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		return null;
		
		
//		con= openConnection();
//		
//		pstmt=con.prepareStatement("select * from Person where personId like ?");
//		pstmt.setString(1,personId);
//		
//		rs=pstmt.executeQuery();
//		
//		Person person = new Person();
//		
//		while(rs.next()){
//		
//			person.setPersonId(rs.getString("personId"));
//			person.setPersonIdType(rs.getString("personIdType"));
//			person.setPersonName(rs.getString("personName"));
//			person.setPersonDateOfBirth(rs.getDate("personDateOfBirth"));
//			person.setPersonAge(rs.getInt("personAge"));
//			person.setPersonGender(rs.getString("personGender"));
//			person.setPersonAddress(rs.getString("personAddress"));
//			person.setPersonPhoneNo(rs.getLong("personPhoneNo"));
//			person.setPersonPassword(rs.getString("personPassword"));
//		}
//			
//		
//		closeConnection(con);
//		return person;
	}

	@Override
	public ArrayList<Person> displayAllPersons() throws ClassNotFoundException, SQLException , IOException{

		try{
			Query query=session.createQuery("from Person");
			List<Person> personList=query.list();
			System.out.println("Record Displayed");
			return (ArrayList<Person>)personList;
			}
			catch(Exception ex){
				System.out.println("Record Not Displayed");
			}
			finally{
				session.close();
			}
		return null;
		
//		con= openConnection();
//		
//		
//		pstmt=con.prepareStatement("select * from Person");
//		
//		
//		rs=pstmt.executeQuery();
//		
//		ArrayList<Person> personList=new ArrayList<Person>();
//		
//		while(rs.next())
//		{
//			Person person = new Person();
//			
//			person.setPersonId(rs.getString("personId"));
//			person.setPersonIdType(rs.getString("personIdType"));
//			person.setPersonName(rs.getString("personName"));
//			person.setPersonDateOfBirth(rs.getDate("personDateOfBirth"));
//			person.setPersonAge(rs.getInt("personAge"));
//			person.setPersonGender(rs.getString("personGender"));
//			person.setPersonAddress(rs.getString("personAddress"));
//			person.setPersonPhoneNo(rs.getLong("personPhoneNo"));
//			person.setPersonPassword(rs.getString("personPassword"));
//			personList.add(person);
//			
//		}
//		//System.out.println(personList);
//		//System.out.println();
//		//System.out.println();
//		closeConnection(con);
//		return personList;
	}

}

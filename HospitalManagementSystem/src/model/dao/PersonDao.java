package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Person;

public interface PersonDao {
	public boolean insertPerson(Person newPerson) throws SQLException, ClassNotFoundException, IOException;
	public boolean deletePerson(String personId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updatePerson(String personId, Person renewPerson) throws ClassNotFoundException, SQLException, IOException;
	public Person displayPerson(String personId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Person> displayAllPersons() throws ClassNotFoundException, SQLException, IOException;
}

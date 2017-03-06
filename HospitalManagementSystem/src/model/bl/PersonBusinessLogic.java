package model.bl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bill;
import model.bean.DischargeSummary;
import model.bean.Doctor;
import model.bean.MedicalReport;
import model.bean.Medicine;
import model.bean.Person;
import model.bean.Appointment;
import model.dao.BillDaoImpl;
import model.dao.DischargeSummaryDaoImpl;
import model.dao.MedicalReportDaoImpl;
import model.dao.MedicineDaoimpl;
import model.dao.PersonDaoImpl;
import model.dao.AppointmentDaoImpl;

public class PersonBusinessLogic {
	
	PersonDaoImpl pd= new PersonDaoImpl();
	BillDaoImpl bd= new BillDaoImpl();
	DischargeSummaryDaoImpl dsd = new DischargeSummaryDaoImpl();
	MedicalReportDaoImpl mrd = new MedicalReportDaoImpl();
	AppointmentDaoImpl rd = new AppointmentDaoImpl();
	MedicineDaoimpl md = new MedicineDaoimpl();
		
	public ArrayList<Appointment> listAppointment() throws ClassNotFoundException, SQLException, IOException
	{
		return rd.displayAllAppointments();
	}
	
	public ArrayList<MedicalReport> listMyMedicalReport(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayMyMedicalReports(personId);
	}
	
	public ArrayList<Bill> listMyBill(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.displayMyBills(personId);
	}
	
	public ArrayList<Medicine> listMyMedicine(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		return md.displayMyMedicines(personId);
	}
	
	public MedicalReport viewMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayMedicalReport(patientId);
	}
	
	public Bill viewBill(int billNo) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.displayBill(billNo);
	}
	
	public DischargeSummary viewDischargeSummary(int serialNo) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.displayDischargeSummary(serialNo);
	}
	public ArrayList<DischargeSummary> listMyDischargeSummary(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.displayMyDischargeSummarys(personId);
	}

	
//	public boolean addPerson(Person newPerson) throws ClassNotFoundException, SQLException
//	{
//		return pd.insertPerson(newPerson);	
//	}
//	public boolean modifyPerson(String personId, Person newPerson) throws ClassNotFoundException, SQLException
//	{
//		return pd.updatePerson(personId,newPerson);
//	}
	
	public ArrayList<Medicine> myMedicines(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
		medicineList=md.displayAllMedicines(patientId);
		ArrayList<Medicine> patientMedicines=new ArrayList<Medicine>();
		for(Medicine ml: medicineList){
			if(ml.getPatientId()==patientId){
				patientMedicines.add(ml);
			}
		}
		return patientMedicines;
	}
	public boolean personSignUp(Person person) throws ClassNotFoundException, SQLException, IOException
	{
		return pd.insertPerson(person);
	}
	
	
	public Person personLogin(String personId, String personPassword) throws ClassNotFoundException, SQLException, IOException
	{
		Person person=new Person();
		person = pd.displayPerson(personId);
		//System.out.println(person);
		if(person.getPersonId()==null)
		{
			return null;
		}
		else
		{
			
			if(person.getPersonPassword().equals(personPassword))
			{
				return person;
			}
			else return null;
		}
	}
	public ArrayList<Appointment> myAppointments(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		appointmentList=rd.displayAllAppointments();
		//System.out.println(appointmentList);
		ArrayList<Appointment> doctorAppintments=new ArrayList<Appointment>();
		for(Appointment rl: appointmentList){
			if(rl.getPersonId().equals(personId)){
				doctorAppintments.add(rl);
			}
		}
		return doctorAppintments;
	}
	 public String getHashString(String input)
	            throws NoSuchAlgorithmException, UnsupportedEncodingException
	        {
	            MessageDigest md = MessageDigest.getInstance("SHA1");
	            md.reset();
	            byte[] buffer = input.getBytes("UTF-8");
	            md.update(buffer);
	            byte[] digest = md.digest();

	            String hexStr = "";
	            for (int i = 0; i < digest.length; i++) {
	                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
	            }
	            return hexStr;
	        }

}

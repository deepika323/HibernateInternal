package model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bill;
import model.bean.Department;
import model.bean.DischargeSummary;
import model.bean.Doctor;
import model.bean.MedicalReport;
import model.bean.Person;
import model.bean.Appointment;
import model.bean.Staff;
import model.bean.Technician;
import model.dao.BillDaoImpl;
import model.dao.DepartmentDaoImpl;
import model.dao.DischargeSummaryDaoImpl;
import model.dao.MedicalReportDaoImpl;
import model.dao.PersonDaoImpl;
import model.dao.AppointmentDaoImpl;
import model.dao.DoctorDaoImpl;
import model.dao.StaffDaoImpl;
import model.dao.TechnicianDaoImpl;

public class AdminBusinessLogic {
	
	AppointmentDaoImpl rd=new AppointmentDaoImpl();
	MedicalReportDaoImpl mrd=new MedicalReportDaoImpl();
	DischargeSummaryDaoImpl dsd=new DischargeSummaryDaoImpl();
	BillDaoImpl bd=new BillDaoImpl();
	DepartmentDaoImpl dd=new DepartmentDaoImpl();
	DoctorDaoImpl dod=new DoctorDaoImpl();
	StaffDaoImpl sd=new StaffDaoImpl();
	TechnicianDaoImpl td=new TechnicianDaoImpl();
	PersonDaoImpl pd=new PersonDaoImpl();

	public boolean adminLogin(String username, String password) throws ClassNotFoundException, SQLException
	{
		if(username==null)
		{
			return false;
		}
		else if(username=="admin")
		{
			if(password.equals("pass")){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	/**********************************************Appointment
	 * @throws IOException **********************************************/
	public boolean addAppointment(Appointment newAppointment) throws ClassNotFoundException, SQLException, IOException
	{
		return rd.insertAppointment(newAppointment);	
	}
	public boolean removeAppointment(int regNo) throws ClassNotFoundException, SQLException, IOException
	{
		return rd.deleteAppointment(regNo);
	}
	public boolean modifyAppointment(int regNo, Appointment newAppointment) throws ClassNotFoundException, SQLException, IOException
	{
		return rd.updateAppointment(regNo,newAppointment);
	}
	public ArrayList<Appointment> listAppointment() throws ClassNotFoundException, SQLException, IOException
	{
		return rd.displayAllAppointments();
	}
	public Appointment viewAppointments(int regNo) throws ClassNotFoundException, SQLException, IOException
	{
		return rd.displayAppointment(regNo);
	}
	
	
	/**********************************************Medical Report**********************************************/
	public boolean addMedicalReport(MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.insertMedicalReport(newMedicalReport);
		
	}
	public boolean removeMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.deleteMedicalReport(patientId);
	}
	public boolean modifyMedicalReport(int patientId,MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.updateMedicalReport(patientId,newMedicalReport);
	}
	public ArrayList<MedicalReport> listMedicalReport() throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayAllMedicalReports();
	}
	public MedicalReport viewMedicalReports(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayMedicalReport(patientId);
	}
	

	/**********************************************Discharge Summary**********************************************/
	public boolean addDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.insertDischargeSummary(newDischargeSummary);
	}
	public boolean removeDischargeSummary(int serialNo) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.deleteDischargeSummary(serialNo);
	}
	public boolean modifyDischargeSummary(int serialNo,DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.updateDischargeSummary(serialNo,newDischargeSummary);
	}
	public ArrayList<DischargeSummary> listDischargeSummary() throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.displayAllDischargeSummarys();
	}
	public DischargeSummary viewDischargeSummary(int serialNo) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.displayDischargeSummary(serialNo);
	}
	
	
	/**********************************************Bills**********************************************/
	public boolean addBill(Bill newBill) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.insertBill(newBill);	
	}
	public boolean removeBill(int number) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.deleteBill(number);
	}
	public boolean modifyBill(int number, Bill newBill) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.updateBill(number,newBill);
	}
	public ArrayList<Bill> listBill() throws ClassNotFoundException, SQLException, IOException
	{
		return bd.displayAllBills();
	}
	public Bill viewBill(int number) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.displayBill(number);
	}
	public float calculateBill(int number) throws ClassNotFoundException, SQLException, IOException{
		Bill cBill=new Bill();
		cBill = bd.displayBill(number);
		float totalBill = cBill.getDoctorVisit() + cBill.getBedCharges() + cBill.getTests() + cBill.getMedicines();
		return totalBill;
	}
	
	/**********************************************Department**********************************************/
	public boolean addDepartment(Department newDepartment) throws ClassNotFoundException, SQLException, IOException
	{
		return dd.insertDepartment(newDepartment);	
	}
	public boolean removeDepartment(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		return dd.deleteDepartment(departmentId);
	}
	public boolean modifyDepartment(int departmentId, Department newDepartment) throws ClassNotFoundException, SQLException, IOException
	{
		return dd.updateDepartment(departmentId,newDepartment);
	}
	public ArrayList<Department> listDepartment() throws ClassNotFoundException, SQLException, IOException
	{
	return dd.displayAllDepartments();
		
	}
	public Department viewDepartment(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		return dd.displayDepartment(departmentId);
	}
	
	
	/**********************************************Doctor**********************************************/
	public boolean addDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException, IOException
	{
		return dod.insertDoctor(newDoctor);	
	}
	public boolean removeDoctor(String doctorId) throws ClassNotFoundException, SQLException, IOException
	{
		return dod.deleteDoctor(doctorId);
	}
	public boolean modifyDoctor(String doctorId, Doctor newDoctor) throws ClassNotFoundException, SQLException, IOException
	{
		return dod.updateDoctor(doctorId,newDoctor);
	}
	public ArrayList<Doctor> listDoctor() throws ClassNotFoundException, SQLException, IOException
	{
		return dod.displayAllDoctors();
		
	}
	public Doctor viewDoctor(String doctorId) throws ClassNotFoundException, SQLException, IOException
	{
		return dod.displayDoctor(doctorId);
	}
	
	/**********************************************Staff**********************************************/
	public boolean addStaff(Staff newStaff) throws ClassNotFoundException, SQLException, IOException
	{
		return sd.insertStaff(newStaff);	
	}
	public boolean removeStaff(String staffId) throws ClassNotFoundException, SQLException, IOException
	{
		return sd.deleteStaff(staffId);
	}
	public boolean modifyStaff(String staffId, Staff newStaff) throws ClassNotFoundException, SQLException, IOException
	{
		return sd.updateStaff(staffId,newStaff);
	}
	public ArrayList<Staff> listStaff() throws ClassNotFoundException, SQLException, IOException
	{
		return sd.displayAllStaffs();
	}
	public Staff viewStaff(String staffId) throws ClassNotFoundException, SQLException, IOException
	{
		return sd.displayStaff(staffId);
	}
	
	/**********************************************Technician**********************************************/
	public boolean addTechnician(Technician newTechnician) throws ClassNotFoundException, SQLException, IOException
	{
		return td.insertTechnician(newTechnician);	
	}
	public boolean removeTechnician(String technicianId) throws ClassNotFoundException, SQLException, IOException
	{
		return td.deleteTechnician(technicianId);
	}
	public boolean modifyTechnician(String technicianId, Technician newTechnician) throws ClassNotFoundException, SQLException, IOException
	{
		return td.updateTechnician(technicianId,newTechnician);
	}
	public ArrayList<Technician> listTechnician() throws ClassNotFoundException, SQLException, IOException
	{
		return td.displayAllTechnicians();
	}
	public Technician viewTechnician(String technicianId) throws ClassNotFoundException, SQLException, IOException
	{
		return td.displayTechnician(technicianId);
	}
	
	/*******************************************Person**********************************************/
	public boolean removePerson(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		return pd.deletePerson(personId);
	}
	public ArrayList<Person> listPerson() throws ClassNotFoundException, SQLException, IOException
	{
		return pd.displayAllPersons();
	}
	public Person viewPerson(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		return pd.displayPerson(personId);
	}
}

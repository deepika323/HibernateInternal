package model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Doctor;
import model.bean.MedicalReport;
import model.bean.Medicine;
import model.bean.OT;
import model.bean.Appointment;
import model.dao.DoctorDaoImpl;
import model.dao.MedicalReportDaoImpl;
import model.dao.MedicineDaoimpl;
import model.dao.AppointmentDao;
import model.dao.AppointmentDaoImpl;

public class DoctorBusinessLogic {
	
	DoctorDaoImpl dd=new DoctorDaoImpl();
	AppointmentDaoImpl rd=new AppointmentDaoImpl();
	MedicalReportDaoImpl mrd=new MedicalReportDaoImpl(); 
	MedicineDaoimpl md=new MedicineDaoimpl();
	
	public Doctor doctorLogin(String doctorId, String doctorPassword) throws ClassNotFoundException, SQLException, IOException
	{
		
		Doctor doctor=new Doctor();
		if(dd.displayDoctor(doctorId).getDoctorId()==null)
		{
			return null;
		}
		else
		{
			doctor=dd.displayDoctor(doctorId);
			if(doctor.getDoctorPassword().equals(doctorPassword))
			{
				return doctor;
			}
			else 
				return null;
		}
	}
	public ArrayList<Appointment> myAppointments(String doctorId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		appointmentList=rd.displayAllAppointments();
		ArrayList<Appointment> doctorAppintments=new ArrayList<Appointment>();
		for(Appointment rl: appointmentList){
			if(rl.getDoctorId().equals(doctorId)){
				doctorAppintments.add(rl);
			}
		}
		return doctorAppintments;
	}
	
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
	
	public boolean addMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException, IOException
	{
		return md.insertMedicine(newMedicine);
		
	}
	public boolean removeMedicine(int sNo,int patientId) throws ClassNotFoundException, SQLException, IOException
	{
	
		return md.deleteMedicine(sNo,patientId);
	}
	public boolean modifyMedicine(int sNo,Medicine newMedicine) throws ClassNotFoundException, SQLException, IOException
	{
	
		return md.updateMedicine(sNo,newMedicine);
	}

	public ArrayList<Medicine> listMedicine(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return md.displayAllMedicines(patientId);
	}
	public Medicine viewMedicine(int sNo,int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return md.displayMedicine(sNo,patientId);
	}
}

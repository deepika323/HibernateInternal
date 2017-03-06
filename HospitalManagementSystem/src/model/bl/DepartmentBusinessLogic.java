package model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Department;
import model.bean.Doctor;
import model.bean.Staff;
import model.bean.Technician;
import model.dao.DepartmentDaoImpl;
import model.dao.DoctorDaoImpl;
import model.dao.StaffDaoImpl;
import model.dao.TechnicianDaoImpl;



public class DepartmentBusinessLogic {

	DepartmentDaoImpl dd = new DepartmentDaoImpl();
	DoctorDaoImpl dod=new DoctorDaoImpl();
	StaffDaoImpl sd=new StaffDaoImpl();
	TechnicianDaoImpl td=new TechnicianDaoImpl();
	
	public ArrayList<Department> listDepartment() throws ClassNotFoundException, SQLException, IOException
	{
		return dd.displayAllDepartments();
	}
	
	public ArrayList<Doctor> departmentDoctors(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
		doctorList=dod.displayAllDoctors();
		ArrayList<Doctor> departmentDoctorList=new ArrayList<Doctor>();
		for(Doctor dl: doctorList){
			if(dl.getDepartmentId()==departmentId){
				departmentDoctorList.add(dl);
			}
		}
		return departmentDoctorList;
	}
	
	public ArrayList<Staff> departmentStaffs(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Staff> staffList=new ArrayList<Staff>();
		staffList=sd.displayAllStaffs();
		ArrayList<Staff> departmentStaffList=new ArrayList<Staff>();
		for(Staff sl: staffList){
			if(sl.getDepartmentId()==departmentId){
				departmentStaffList.add(sl);
			}
		}
		return departmentStaffList;
	}
	
	public ArrayList<Technician> departmentTechnicians(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Technician> technicianList=new ArrayList<Technician>();
		technicianList=td.displayAllTechnicians();
		ArrayList<Technician> departmentTechnicianList=new ArrayList<Technician>();
		for(Technician tl: technicianList){
			if(tl.getDepartmentId()==departmentId){
				departmentTechnicianList.add(tl);
			}
		}
		return departmentTechnicianList;
	}
//	public Department viewDepartment(int departmentId) throws ClassNotFoundException, SQLException
//	{
//		return dd.displayDepartment(departmentId);
//	}
//	
//	
//	public ArrayList<Doctor> listDoctor() throws ClassNotFoundException, SQLException
//	{
//		return dod.displayAllDoctors();
//	}
//	public Doctor viewDoctor(int doctorId) throws ClassNotFoundException, SQLException
//	{
//		return dod.displayDoctor(doctorId);
//	}
//
//	
//	public ArrayList<Staff> listStaff() throws ClassNotFoundException, SQLException
//	{
//		return sd.displayAllStaffs();
//	}
//	public Staff viewStaff(int staffId) throws ClassNotFoundException, SQLException
//	{
//		return sd.displayStaff(staffId);
//	}
//	
//	
//	public ArrayList<Technician> listTechnician() throws ClassNotFoundException, SQLException
//	{
//		return td.displayAllTechnicians();
//	}
//	public Technician viewTechnician(int technicianId) throws ClassNotFoundException, SQLException
//	{
//		return td.displayTechnician(technicianId);
//	}
}

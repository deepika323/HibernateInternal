package model.helper;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.bean.DischargeSummary;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;

public class DischargeSummaryData {
	
	private DischargeSummary ds=new DischargeSummary();

	public DischargeSummary getDs() {
		return ds;
	}

	public void input()
	{
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		Scanner sc=new Scanner(System.in);
		MedicalReport mr=new MedicalReport();
		//System.out.println("Enter Serial No for the Discharge Summary");
		//String sn=sc.nextLine();
		
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		int serialNo= Math.abs((int) currentDate.getTime());
		
		//int serialNo=Integer.parseInt(sn);
		String strPatientId;
		int patientId;
//		System.out.println("Enter the Patient Appointment ID ");
//		String pId=sc.nextLine();
//		int patientId=Integer.parseInt(pId);
		while(true){
			System.out.println("Enter the Patient Appointment ID : "); 
			strPatientId=sc.nextLine();
			if(Pattern.matches("[0-9]+",strPatientId)){
				patientId=Integer.parseInt(strPatientId);
				break;
			}
			else{
				System.out.println("Invalid patient Id!!!");
				}
		}
		try {
			mr=abl.viewMedicalReports(patientId);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Patient Id is Wrong !! Please Try Again");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Patient Id is Wrong !! Please Try Again");
			e.printStackTrace();
		}
		
		//System.out.println(mr);
		
		String doctorId=mr.getDoctorId();
		Date admissionDate=mr.getVisitDate();
	
		Date dischargeDate=new Date(Calendar.getInstance().getTime().getTime());
		
		String treatmentGiven=mr.getTests();
		String onExamination=mr.getInvestigations();
		
		String operativeDone=mr.getTests();
		String operativeFindings=mr.getInvestigations();
		
		System.out.println("Enter History");
		String history=sc.nextLine();
		
		//automate bed number and ot id
		System.out.println("Enter Bed No");
		String bn=sc.nextLine();
		int bedNo=Integer.parseInt(bn);
		
		System.out.println("Enter OT ID");
		String ot=sc.nextLine();
		int otId=Integer.parseInt(ot);
		
		String recommedation=mr.getRecommendations();
		
		
		
		ds.setAdmissionDate(admissionDate);
		ds.setBedNo(bedNo);
		ds.setDischargeDate(dischargeDate);
		ds.setDoctorId(doctorId);
		ds.setHistory(history);
		ds.setOnExamination(onExamination);
		ds.setOperationDone(operativeDone);
		ds.setOperativeFindings(operativeFindings);
		ds.setOtId(otId);
		ds.setPatientId(patientId);
		ds.setRecommendations(recommedation);
		ds.setSerialNo(serialNo);
		ds.setTreatmentGiven(treatmentGiven);
		//System.out.println(ds);
	}
}

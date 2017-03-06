package model.helper;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import model.bean.MedicalReport;

public class MedicalReportData {

	MedicalReport medicalReport;
	
	Scanner sc=new Scanner(System.in) ;
	public MedicalReport insert()
	{
		medicalReport=new MedicalReport();
		System.out.println("Enter Patient ID:\n");
		medicalReport.setPatientId(Integer.parseInt(sc.nextLine())); 
		
		
		Date visitDate = new Date(Calendar.getInstance().getTime().getTime());
		medicalReport.setVisitDate(visitDate);//Date as Input.//Manage format
		
		System.out.println("Enter Diagnosis:\n");
		medicalReport.setDiagnosis(sc.nextLine());
		
		System.out.println("Enter Investigations:\n");
		medicalReport.setInvestigations(sc.nextLine());
		
		System.out.println("Enter Tests:\n");
		medicalReport.setTests(sc.nextLine());
		
		System.out.println("Enter Recommendations:\n");
		medicalReport.setRecommendations(sc.nextLine());
		
		System.out.println("Enter Technician ID:\n");
		medicalReport.setTechnicianId(sc.nextLine());
		
		return medicalReport;
	}
}

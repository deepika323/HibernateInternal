package model.helper;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import model.bean.Bill;

public class BillData {

	private Bill bill;
	
	
	public Bill getBill() {
		return bill;
	}


	public void input()
	{
		Scanner sc=new Scanner(System.in);
		bill=new Bill();
		
//		System.out.println("Enter Bill Number");
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		int billNo= Math.abs((int) currentDate.getTime());
		System.out.println("Enter Patient ID");
		int patientId=Integer.parseInt((sc.nextLine()));
		System.out.println("Enter Doctor ID ");
		int doctorId=(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Serial No of Discarge Summay");
		int serialNo=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Bed Charges");
		int bedCharges=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Doctor Visit Charges");
		int doctorVisit=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Test Charges");
		int tests=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Medicine Charges");
		int medicines=Integer.parseInt(sc.nextLine());
		
//		Date currentDate=new Date(Calendar.getInstance().getTime().getTime());
		
	
//		int regNo= Math.abs((int) currentDate.getTime());
		
		//check values for validation
		
		bill.setBedCharges(bedCharges);
		bill.setBillNo(billNo);
		bill.setDoctorVisit(doctorVisit);
		bill.setMedicines(medicines);
		bill.setPatientId(patientId);
		bill.setSerialNo(serialNo);
		bill.setTests(tests);
		
		
		return ;

	}
	
}

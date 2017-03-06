package model.helper;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.bean.Appointment;

public class AppointmentInput {

	private Appointment recep;
	public Appointment getRecep() {
		return recep;
	}
	public boolean input()
	{	
		Scanner sc=new Scanner(System.in);
		recep=new Appointment();
		String personId;
		System.out.print("Enter Person ID : ");
		personId=sc.nextLine();
		System.out.print("Enter Doctor ID : ");
		int doctorId=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Purpose For Appointment : ");
		String purpose=sc.nextLine();
		int fee;
		while(true){
			System.out.println("Enter Appointment Registration Fee : ");
			String strFee;
			strFee=sc.nextLine();
			if(Pattern.matches("[0-9]{2}",strFee)){
				fee=Integer.parseInt(strFee);
				if(fee>=0 && fee<=50)
					break;
				else
					System.out.println("The appointment fee should be less than 50");
			}
			else{
				System.out.println("The appointment fee contains characters!!!");
			}
		}
		//System.out.println(fee);
		//String str="2017-02-09";
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		//System.out.println(currentDate);
		
		
		int regNo= Math.abs((int) currentDate.getTime());
		//System.out.println(regNo);
		//check values for validation
		recep.setPersonId(personId);
		recep.setDoctorId("doctorId");
		recep.setPayment(fee);
		recep.setRegNo(regNo);
		recep.setAppointmentDate(currentDate);
		recep.setPurpose(purpose);
		
		
		return true;
		
	}
}


package model.helper;
import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.bean.Person;

public class PersonInput {

	private Person person;
	public Person getPerson() {
		return person;
	}
		
	public boolean input(){
		Scanner sc=new Scanner(System.in);
		person = new Person();
		String id; 
		System.out.print("Eneter Id : ");
		id=sc.nextLine();
		String idType;
		System.out.print("Enter Id type : ");
		idType=sc.nextLine();
		String name;
		System.out.print("Enter Name : ");
		name=sc.nextLine();
		String dateOfBirth;
		System.out.print("Enter  Date of Birth (yyyy-mm-dd) : ");
		dateOfBirth=sc.nextLine(); 
	    Date doB=Date.valueOf(dateOfBirth);
	    String strAge;
		int age; 
		while(true){
			System.out.print("Enter Age : ");
			strAge=sc.nextLine();
			if(Pattern.matches("[0-9]{2}",strAge)){
				
				age=Integer.parseInt(strAge);
				if(age<0)
				{System.out.println("Age should be positive");
				}
				else
				{
					break;
				}
			}
			else{
				System.out.println("The age contains characters!!!");
				}
		}
		String gender;
		while(true){
			System.out.print("Enter Gender : ");
			gender=sc.nextLine();
			if((gender.toLowerCase()).equals("male")||(gender.toLowerCase()).equals("female")){
				break;
			}
			else{
				System.out.println("The gender field can be male or female");
			}
		}
		
		String address;
		System.out.print("Enter Address : ");
		address=sc.nextLine();
		String strPhoneNo;
		long phoneNo;
		while(true){
			System.out.print("Enter Phone No. : ");
			strPhoneNo=sc.nextLine();
			if(Pattern.matches("[0-9]{10}",strPhoneNo)){
				phoneNo=Long.parseLong(strPhoneNo);
				break;
			}
			else{
					System.out.println("The phone no contains characters!!!");
				}
		}
		String password;
		System.out.print("Enter Password : ");
		password=sc.nextLine();
		
		person.setPersonId(id);
		person.setPersonIdType(idType);
		person.setPersonName(name);
		person.setPersonDateOfBirth(doB);
		person.setPersonAge(age);
		person.setPersonGender(gender);
		person.setPersonAddress(address);
		person.setPersonPhoneNo(phoneNo);
		person.setPersonPassword(password);
		return true;
		}
}

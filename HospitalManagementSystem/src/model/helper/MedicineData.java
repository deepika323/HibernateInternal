package model.helper;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.bean.Medicine;

public class MedicineData {

	public Medicine insert(){
		
		Scanner sc = new Scanner(System.in);
		Medicine medicine = new Medicine();
		
		System.out.println("Enter Serial Number:\n");
		medicine.setsNo(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter Medicine Name:\n");
		medicine.setMedicineName(sc.nextLine());
		
		String strQuantity;
		int quantity;
		while(true){
			System.out.println("Enter Quantity:\n"); 
			strQuantity=sc.nextLine();
			if(Pattern.matches("[0-9]+",strQuantity)){
				quantity=Integer.parseInt(strQuantity);
				break;
			}
			else{
					System.out.println("The quantity contains characters!!!");
				}
		}
		medicine.setQuantity(quantity);
		
		System.out.println("Enter Dosage:\n"); 
		medicine.setDosage(sc.nextLine());
		
		String strPrice;
		float price;
		while(true){
			System.out.println("Enter Price : \n");
			strPrice=sc.nextLine();
			if(Pattern.matches("[0-9]",strQuantity)){
				price=Float.parseFloat(strPrice);
				break;
			}
			else{
				System.out.println("The price should be in decimal form!!!");
			}
		}
		medicine.setPrice(price);
		
		
		return medicine;
		
	}
}

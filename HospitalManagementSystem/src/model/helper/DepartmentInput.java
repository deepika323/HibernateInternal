package model.helper;

import java.util.Scanner;

import model.bean.Department;

public class DepartmentInput {

		private Department department;
		public Department getDepartment(){
			return department;
		}
		
		public boolean input(){
			Scanner sc=new Scanner(System.in);
			department = new Department();
			int departmentId;
			System.out.print("Eneter Department Id : ");
			departmentId=Integer.parseInt(sc.nextLine());
			String departmentName;
			System.out.print("Enter Department Name : ");
			departmentName=sc.nextLine();
			String departmentLocation;
			System.out.print("Enter Department Location : ");
			departmentLocation=sc.nextLine();
			String description;
			System.out.print("Enter Description : ");
			description=sc.nextLine(); 
			
			department.setDepartmentId(departmentId);
			department.setDepartmentName(departmentName);
			department.setDepartmentLocation(departmentLocation);
			department.setDescription(description);
			return true;
		}
}

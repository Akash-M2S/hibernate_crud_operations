package dco;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

import dao.EmpDao;
import dto.Empdetails;

public class EmpController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmpDao dao=new EmpDao();
		boolean flag = true;
		while (flag) {
			System.out.println("1)add the employee" + "\n" + "2)Update employee salary" + "\n"
					+ "3)delete the employee record" + "\n" + "4)delete all the employees record" + "\n"
					+ "5)fetch employees details" + "\n" + "6)fetch all the employees details" + "\n" + "7)exit");
			System.out.println("select your option");
			switch (scanner.nextInt()) {
			case 1:
			{
				
				System.out.println("enter employee name");
				scanner.nextLine();
				String ename=scanner.nextLine();
				System.out.println("enter the mobile number");
				long mobile=scanner.nextLong();
				System.out.println("enter the job role");
				scanner.nextLine();
				String jobRole=scanner.nextLine();
				System.out.println("enter the salary");
				double sal=scanner.nextDouble();
				dao.addEmp(ename, mobile, jobRole, sal);
			}break;
			case 2:
			{
				System.out.println("enter the employee id");
				int id= scanner.nextInt();
				System.out.println("enter new salary");
				double sal=scanner.nextDouble();
				dao.updateSal(id,sal);
			}break;
			case 3:
			{
				System.out.println("enter the employee id");
				int id= scanner.nextInt();
				dao.delete(id);
			}break;
			case 4:
			{
				dao.deleteAll();
			}break;
			case 5:
			{
				System.out.println("enter the employee id");
				int id= scanner.nextInt();
				dao.fetch(id);
			}break;
			
			case 6:
			{
				dao.fetchAll();
			}break;
			case 7:
			{
				flag=false;
				System.out.println("thank you");
				
			}break;
			default:
				System.out.println("invalid option");
		}
	}
	}
}

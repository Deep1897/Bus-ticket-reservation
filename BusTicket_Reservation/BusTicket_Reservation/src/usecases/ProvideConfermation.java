package usecases;

import java.util.Scanner;

import Implementaion.BusIntrImpl;
import Interfaces.BusInterface;
import exceptions.BusDetailsException;

public class ProvideConfermation {
	
	public static void prConfirm() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter the perticular bus Id to conferm your seat");
		
		int bid=sc.nextInt();
		
		System.out.println("please Enter your name");
		String name=sc.next();
		System.out.println("please Enter your mobile no.");
		long mobile=sc.nextLong();
		
		
		BusInterface bus=new BusIntrImpl();
		
		try {
			String s= bus.provideConfermation(bid);
			System.out.println(s);
			
			System.out.println("Candidate Name :-"+name+"    mobile no.. :-"+ mobile);
			
			String s1=bus.providePersonDetails(bid);
			System.out.println(s1);
		} catch (BusDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}

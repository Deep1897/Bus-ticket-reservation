package usecases;

import java.util.Scanner;

import Implementaion.BusIntrImpl;
import Interfaces.BusInterface;
import exceptions.BusDetailsException;

public class GetDetailswithsourceAndDEstination {
	
	public static void getDetailsrcDes() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please Enter the source");
		String source =sc.next();
		System.out.println("please Enter the desingnation ");
		String desing=sc.next();
		
		BusInterface bus=new BusIntrImpl();
		try {
			String s= bus.getDetailswithsourceAndDEstination(source, desing);
			System.out.println(s);
			
			System.out.println("please select busId to confirm your seat");
			
			
			
		} catch (BusDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

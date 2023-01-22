package usecases;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import BeanClasses.BusDetails;
import BeanClasses.Droute;
import Implementaion.BusIntrImpl;
import Interfaces.BusInterface;
import exceptions.BusDetailsException;

public class InsertDetailsOfBus {
	
	public static void insDetails() throws ParseException {
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("please Enter the busId");
		int bid=sc.nextInt();
		System.out.println("please Enter the Bus name");
		String bname=sc.next();
		System.out.println("Please Enter the bus route");
		String broute=sc.next();
		System.out.println("please Enter the bus type AC or non_Ac");
		String btype=sc.next();
		System.out.println("Please Enter the bus Total seats");
		int seats=sc.nextInt();
		System.out.println("please Enter the arival time");
		String atime=sc.next();
		System.out.println("please Enter the departure time");
		String dtime=sc.next();
		
		

		
		
		int rid=bid;
		System.out.println("please Enter the source");
		String source=sc.next();
		System.out.println("please Enter the desingnation");
		
		String desing=sc.next();
		
		BusDetails bus=new BusDetails(bid, bname, broute, btype, seats, atime, dtime);
		
		Droute dr1=new Droute(rid, source, desing);
		
		BusInterface bs=new BusIntrImpl();
		try {
			String s= bs.insertDetailsOfBus(bus, dr1);
			System.out.println("\n"+"\n");
			System.out.println(s);
			System.out.println("All details of buses.......");
			System.out.println("\n"+"\n");
			
		} catch (BusDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

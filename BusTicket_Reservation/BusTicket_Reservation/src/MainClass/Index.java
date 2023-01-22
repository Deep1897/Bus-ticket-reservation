package MainClass;

import java.text.ParseException;
import java.util.Scanner;

import Implementaion.BusIntrImpl;
import Interfaces.BusInterface;
import usecases.GetDetailswithsourceAndDEstination;
import usecases.InsertDetailsOfBus;
import usecases.ProvideConfermation;
import usecases.ProvideDetailsOfBus;

public class Index {
		
		public static void main(String[] args) {
			
			System.out.println("press:1 for Admin login");
			System.out.println("press: 2 for Admin SignIn");
			System.out.println("press: 3 for customer service");
			boolean flag=false;
			BusInterface bus=new BusIntrImpl();
			
			Scanner sc=new Scanner(System.in);
			int logInput=sc.nextInt();
			
			if(logInput==2)
			{
				System.out.println("please Enter your email");
				String username=sc.next();
				System.out.println("please Enter the password");
				String password=sc.next();
				String s=bus.adminsignIn(username, password);
				System.out.println(s);
				
			}
			else if(logInput==1)
			{
				for(int i=0;i<3;i++)
				{
					System.out.println("please Enter the username");
					String username=sc.next();
					System.out.println("please Enter the password");
					String password=sc.next();
					boolean x=bus.adminlogIn(username, password);
					if(x==true)
					{
						flag=true;
						break;
					}else
					{
						System.out.println("invalid credential..");
						if(i<2)
						{
							System.out.println("You have left"+(2-i)+" chance only..");
						}
						else
						{
							System.out.println("please try after some time later..");
						}
						
						continue;
					}
					
				}
				
				boolean x=true;
				while(x) {
					ProvideDetailsOfBus.detaisBus();
					System.out.println(" \n\n               press: 1 for Add new BusDetails");
					
					int key=sc.nextInt();
					if(key==0) {
						
						GetDetailswithsourceAndDEstination.getDetailsrcDes();
						ProvideConfermation.prConfirm();
						
				
					}else
					{
						System.out.println("\n");
//						System.out.println("                press: 1 for Add new BusDetails");
						
					}
				
				
				
				switch (key) {
				case 1: {
					try {
						
						InsertDetailsOfBus.insDetails();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				
				case 0:
					x=false;
					break;
				}
				
				
				
				}
				
				
				
				
				
				
			}
			else
			{
				
				
				GetDetailswithsourceAndDEstination.getDetailsrcDes();
				ProvideConfermation.prConfirm();
				
				
				
				
				
			}
			
			
			
			
			
		}
	
}

package usecases;

import BeanClasses.BusDetails;
import Implementaion.BusIntrImpl;
import Interfaces.BusInterface;
import exceptions.BusDetailsException;

public class ProvideDetailsOfBus {
	
	public static void main(String[] args) {
		
		BusInterface bus=new BusIntrImpl();
		try {
			bus.provideDetailsOfBus();
			//System.out.println(b);
			
		} catch (BusDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

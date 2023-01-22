package Interfaces;

import BeanClasses.BusDetails;
import BeanClasses.Droute;
import exceptions.BusDetailsException;

public interface BusInterface {
	
	public BusDetails provideDetailsOfBus() throws BusDetailsException;
	
	public String provideConfermation(int bid) throws BusDetailsException;
	
	public String providePersonDetails(int bid) throws BusDetailsException;
	
	public String insertDetailsOfBus(BusDetails bus,Droute dr)throws BusDetailsException;
	
	public String getDetailswithsourceAndDEstination(String source,String desing)throws BusDetailsException;
	
	public String adminsignIn(String username,String password);
	
	public boolean adminlogIn(String username,String password);

}

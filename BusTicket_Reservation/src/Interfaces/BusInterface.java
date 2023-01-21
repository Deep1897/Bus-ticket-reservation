package Interfaces;

import BeanClasses.BusDetails;
import exceptions.BusDetailsException;

public interface BusInterface {
	
	public BusDetails provideDetailsOfBus() throws BusDetailsException;

}

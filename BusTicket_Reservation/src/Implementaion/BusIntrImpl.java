package Implementaion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import com.mysql.cj.protocol.Resultset;

import BeanClasses.BusDetails;
import Interfaces.BusInterface;
import exceptions.BusDetailsException;
import getConnection.Database;

public class BusIntrImpl implements BusInterface {

	@Override
	public BusDetails provideDetailsOfBus() throws BusDetailsException {
		BusDetails bb=null;
		
		try (Connection conn= Database.provideConnection()){
			
			PreparedStatement pr= conn.prepareStatement("select * from dbus");
			ResultSet rs= pr.executeQuery();
			
			while (rs.next()) {
				
				bb=new BusDetails();
				
			  bb.setBid(rs.getInt("bid"));
			  bb.setBname(rs.getString("bname"));
			  bb.setBroute(rs.getString("broute"));
			  bb.setBtype(rs.getString("btype"));
			  bb.setSeats(rs.getInt("seats"));
			  bb.setAtime(rs.getTime("atime"));
			  bb.setDtime(rs.getTime("dtime"));
			  System.out.println(bb);
				
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return bb;
	}

}

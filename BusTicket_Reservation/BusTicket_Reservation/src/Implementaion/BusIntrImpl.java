package Implementaion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import com.mysql.cj.protocol.Resultset;

import BeanClasses.BusDetails;
import BeanClasses.Droute;
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
			  bb.setAtime(rs.getString("atime"));
			  bb.setDtime(rs.getString("dtime"));
			  System.out.println(bb);
				
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return bb;
	}

	@Override
	public String provideConfermation(int bid) throws BusDetailsException {
		String s="not confirmed";
		
		try (Connection conn= Database.provideConnection()){
			
   			PreparedStatement pr= conn.prepareStatement("select * from dbus where seats>0 and bid=?");
			pr.setInt(1, bid);
			ResultSet rs= pr.executeQuery();
			
			while(rs.next()) {
				
				s="your Seat is Confirmed";
				
			}
			
			PreparedStatement pr1= conn.prepareStatement("update dbus set seats=seats-1 where bid=?");
			pr1.setInt(1, bid);
			pr1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return s;
	}

	@Override
	public String providePersonDetails(int bid) throws BusDetailsException {
		
		String s=null;
		
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("select d.bid,d.bname,d.broute,d.btype,d.atime,d.dtime,r.source,r.desing from dbus d inner join droute r on d.bid=r.rid where bid=?");
			pr.setInt(1, bid);
			ResultSet rs= pr.executeQuery();
			
			while(rs.next()) {
				s="BusId :- "+rs.getInt("bid")+"   BusName :- "+rs.getString("bname")+"   Bus Route :- "+rs.getString("broute")+"   Bus Type :- "+rs.getString("btype")+"   Arrival time :- "+rs.getString("atime")+"   Departure Time :- "+rs.getString("dtime")+"   source :- "+rs.getString("source")+"   Desingnation :-"+rs.getString("desing");
				//s="Deep"+rs.getString("desing");
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return s;
	}

	@Override
	public String insertDetailsOfBus(BusDetails bus, Droute dr) throws BusDetailsException {
		String s="not added";
		
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("insert into dbus values(?,?,?,?,?,?,?)");
			pr.setInt(1, bus.getBid());
			pr.setString(2, bus.getBname());
			pr.setString(3, bus.getBroute());
			pr.setString(4, bus.getBtype());
			pr.setInt(5, bus.getSeats());
			pr.setString(6, bus.getAtime());
			pr.setString(7, bus.getDtime());
			
			int x=pr.executeUpdate();
			if(x>0) {
				s="hkfJFSDBS";
			}
			PreparedStatement pr1= conn.prepareStatement("insert into droute values(?,?,?)");
			pr1.setString(1, dr.getSource());
			pr1.setString(2, dr.getDestination());
			pr1.setInt(3, bus.getBid());
			int y=pr1.executeUpdate();
			
			if(x>0 && y>0)
			{
				s="added successfully";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return s;
	}

	@Override
	public String getDetailswithsourceAndDEstination(String source, String desing) throws BusDetailsException {
		String s="invalid input";
		
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("select d.bid,d.bname,d.broute,d.btype,d.atime,d.dtime,r.source,r.desing from dbus d inner join droute r on d.bid=r.rid where r.source=? and r.desing=?");
			pr.setString(1, source);
			pr.setString(2, desing);
			ResultSet rs= pr.executeQuery();
			while(rs.next()) {
				
				s="BusId :- "+rs.getInt("bid")+"   BusName :- "+rs.getString("bname")+"   Bus Route :- "+rs.getString("broute")+"   Bus Type :- "+rs.getString("btype")+"   Arrival time :- "+rs.getString("atime")+"   Departure Time :- "+rs.getString("dtime")+"   source :- "+rs.getString("source")+"   Desingnation :-"+rs.getString("desing");

				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return s;
		
		
	}

	@Override
	public String adminsignIn(String username, String password) {
		String s="invalid input";
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("insert into admin values(?,?)");
			pr.setString(1, username);
			pr.setString(2, password);
			int x= pr.executeUpdate();
			if(x>0) {
				s="resisterd successfully....";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s;
	}

	@Override
	public boolean adminlogIn(String username, String password) {
		boolean s=false;
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("select * from admin where username=? AND password=?");
			pr.setString(1, username);
			pr.setString(2, password);
			
			ResultSet rs= pr.executeQuery();
			while(rs.next()) {
				
				s=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s;
	}

}

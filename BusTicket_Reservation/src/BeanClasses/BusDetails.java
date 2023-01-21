package BeanClasses;

import java.sql.Time;

public class BusDetails {
	

	
	private int bid;
	private String bname;
	private String broute;
	private String btype;
	private int seats;
    private Time atime;
    private Time dtime;
    
    public BusDetails() {
		// TODO Auto-generated constructor stub
	}

	public BusDetails(int bid, String bname, String broute, String btype, int seats, Time atime, Time dtime) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.broute = broute;
		this.btype = btype;
		this.seats = seats;
		this.atime = atime;
		this.dtime = dtime;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBroute() {
		return broute;
	}

	public void setBroute(String broute) {
		this.broute = broute;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Time getAtime() {
		return atime;
	}

	public void setAtime(Time atime) {
		this.atime = atime;
	}

	public Time getDtime() {
		return dtime;
	}

	public void setDtime(Time dtime) {
		this.dtime = dtime;
	}

	@Override
	public String toString() {
		return "BusDetails [bid=" + bid + ", bname=" + bname + ", broute=" + broute + ", btype=" + btype + ", seats="
				+ seats + ", atime=" + atime + ", dtime=" + dtime + "]";
	}
    
    
	
	
	

}

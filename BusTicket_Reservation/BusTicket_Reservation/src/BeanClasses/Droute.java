package BeanClasses;

public class Droute {
	
	private int rid;
	private String source;
	private String destination;
	
	public Droute() {
		// TODO Auto-generated constructor stub
	}

	public Droute(int rid, String source, String destination) {
		super();
		this.rid = rid;
		this.source = source;
		this.destination = destination;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Droute [rid=" + rid + ", source=" + source + ", destination=" + destination + "]";
	}
	
	

}

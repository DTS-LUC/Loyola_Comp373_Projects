package use;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UseDetailImpl implements UseDetail {

	private String start;
	private String end;
	private String name;
	private String info;

	private SimpleDateFormat sdf;

	public UseDetailImpl() { }

	public void setSimpleDateFormat(SimpleDateFormat sdf) {this.sdf = sdf;}

	public SimpleDateFormat getSimpleDateFormat() { return sdf; }

	public String toString(){
		return ("Reservation: [Name: " + this.name
						+ ", Start: " + this.start + ", End: "
						+ this.end + " Info: " + this.info+ " ]");
	}

	public void setStart(String start){ this.start 	= start; }

	public String getStart(){
		return this.start;
	}

	public void setEnd(String end){ this.end = end; }

	public String getEnd(){
		return this.end;
	}

	public double getDuration() throws ParseException{
		if (start == null) return 0;
		Date dateStart = sdf.parse(this.getStart());
		Date dateEnd = sdf.parse(this.getEnd());
		long milliseconds = dateEnd.getTime() - dateStart.getTime();
		double hours   = ((milliseconds / (1000.0*60*60)) % 24);
		return hours;
	}

	public void setName(String name){ this.name = name; }

	public String getName(){
		return this.name;
	}

	public void setInfo(String info){ this.info = info; }

	public String getInfo(){
		return this.info;
	}
}

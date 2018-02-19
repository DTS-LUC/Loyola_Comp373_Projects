package use;

public class Inspection {

	private String start;
	private String end;
	private String inspector;
	private String info;

	public Inspection(String start, String end, String inspector, String info){
		this.start			= start;
		this.end				=	end;
		this.inspector	=	inspector;
		this.info				=	info;
	}

	public String toString(){
		return ("Inspection: [Performed by: " + this.inspector
						+ ", Start: " + this.start + ", End: "
						+ this.end + " Info: " + this.info+ " ]");
	}

	public void setStart(String start){
		this.start 	= start;
		return;
	}

	public String getStart(){
		return this.start;
	}

	public void setEnd(String end){
		this.end = end;
		return;
	}

	public String getEnd(){
		return this.end;
	}

	public void setInspector(String inspector){
		this.inspector = inspector;
		return;
	}

	public String getInspector(){
		return this.inspector;
	}

	public void setInfo(String info){
		this.info = info;
		return;
	}

	public String getInfo(){
		return this.info;
	}
}

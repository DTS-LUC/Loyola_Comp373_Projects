package use;

public class Inspection extends UseDetail{

	private String inspector;

	public Inspection(String start, String end, String inspector, String info){
		super(start, end, "Inspection", info);
		this.inspector	=	inspector;
	}

	public String toString(){
		return ("Inspection: [Performed by: " + this.inspector
						+ ", Start: " + this.getStart() + ", End: "
						+ this.getEnd() + " Info: " + this.getInfo()+ " ]");
	}

	public void setInspector(String inspector){
		this.inspector = inspector;
		return;
	}

	public String getInspector(){
		return this.inspector;
	}
}

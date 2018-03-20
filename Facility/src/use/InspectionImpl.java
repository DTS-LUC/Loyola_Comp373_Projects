package use;

public class InspectionImpl extends UseDetailImpl implements Inspection{

	private String inspector;

	public InspectionImpl(){ }

	public String toString(){
		return ("Inspection: [Performed by: " + this.inspector
						+ ", Start: " + this.getStart() + ", End: "
						+ this.getEnd() + " Info: " + this.getInfo()+ " ]");
	}

	public void setInspector(String inspector){ this.inspector = inspector; }

	public String getInspector(){
		return this.inspector;
	}
}

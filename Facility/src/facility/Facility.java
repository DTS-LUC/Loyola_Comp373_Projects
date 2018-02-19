package facility;

// import maintenance.Maintenance;
import use.Use;

public class Facility extends Use{
	private ArrayList<Facility> subfacilities;

	public Facility(String name, String info, int capacity){
		super(name, info, capacity);
		subfacilities = new ArrayList<Facility>;
	}

	public String toString(){
		return ("Facility :[ Name : " + this.name + ", info : " + this.info + ", capacity :" + this.capacity+" ]");
	}

	public ArrayList<Facility> listFacilities(){
		return this.subfacilities;
	}

	public void addNewFacility(Facility subFacility){
		subfacilities.add(subFacility);
	}

	public void removeFacility(Facility subFacility){
		subfacilities.remove(subFacility);
	}
}

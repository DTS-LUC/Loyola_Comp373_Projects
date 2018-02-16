import maintenance.Maintenance;

public class Facility extends Maintenance{
	private ArrayList<Facility> subfacilities;

	public Facility(String name, String info, int capacity){
		super(name, info, capacity);
		subfacilities = new ArrayList<Facility>;
	}

	public String listFacilities(){
		// TODO Create list formatter
	}

	public void addNewFacility(Facility subFacility){
		subfacilities.add(subFacility);
	}

	public void removeFacility(){

	}
}

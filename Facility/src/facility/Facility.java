import maintenance.Maintenance;

public class Facility extends Maintenance{
	private ArrayList<Facility> subfacilities;

	public Facility(String name, String info, int capacity){
		super(name, info, capacity);
		subfacilities = new ArrayList<Facility>;
	}

	public boolean hasSubfacilities(){
		if (subfacilities.length() > 0) {
			return true;
		}
		return false;
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

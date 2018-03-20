package facility;

import java.text.ParseException;
import java.util.List;
import maintenance.MaintenanceImpl;
import use.UseDetail;

public class FacilityImpl extends MaintenanceImpl implements Facility {

	private List<Facility> subfacilities;

	public FacilityImpl(){ }

	public String toString(){
		return ("Facility :[ Name : " + this.getName() + ", info : " + this.getInfo() + ", capacity :" + this.getCapacity()+" ]");
	}

	public void setFacility(List<Facility> subfacilities) {
		this.subfacilities = subfacilities;
	}

	public List<Facility> getFacility(){
		return this.subfacilities;
	}

	public int numFacilities() {
		int total = 1;
		for (Facility subFacility : this.getFacility()) {
			total += subFacility.numFacilities();
		}
		return total;
	}

	public void addNewFacility(Facility subFacility){
		subfacilities.add(subFacility);
	}

	public void removeFacility(Facility subFacility){
		subfacilities.remove(subFacility);
	}

	public void vacateFacility(UseDetail vacate) throws ParseException{
		removeObjectsDuringInterval(vacate.getStart(), vacate.getEnd());
		for (Facility subfacility : subfacilities) {
			subfacility.vacateFacility(vacate);
		}
		vacate.setInfo("Facility has been asked to be vacated");
		vacate.setName("RESERVED");

		assignFacilityToUse(vacate);
	}

	public long totalMaintenanceCost(){
		long subCosts = 0;
		for (Facility subFacility : subfacilities) {
			subCosts += subFacility.totalMaintenanceCost();
		}
		long costs = this.calcMaintenanceCost() + subCosts;
		return costs;
	}

	public double avgTotalProblemRate(){
		long sumRate = 0;
		for (Facility subFacility : subfacilities) {
			sumRate += subFacility.calcProblemRate();
		}
		double avg = sumRate / this.numFacilities();
		return avg;
	}
}

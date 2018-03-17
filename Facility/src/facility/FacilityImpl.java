package facility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import maintenance.MaintenanceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

public class FacilityImpl extends MaintenanceImpl implements Facility {
	private List<Facility> subfacilities;

	public FacilityImpl(){
		super();
	}

	/*public FacilityImpl(String name, String info, int capacity){
		super();
	}*/

	public void setFacility(List<Facility> subfacilities) {
		this.subfacilities = subfacilities;
	}

	public String toString(){
		return ("Facility :[ Name : " + this.getName() + ", info : " + this.getInfo() + ", capacity :" + this.getCapacity()+" ]");
	}

	public List<Facility> getFacility(){
		return this.subfacilities;
	}

	public int numFacilities(){
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

	public void vacateFacility(String start, String end) throws ParseException{
		removeObjectsDuringInterval(start, end);
		if (subfacilities != null) {
			for (Facility subfacility : subfacilities) {
				subfacility.vacateFacility(start, end);
			}
		}
		String name = "RESERVED";
		String info = "Facility has been asked to be vacated";
		assignFacilityToUse(start, end, name, info);
	}

	public long totalMaintenanceCost(){
		long subCosts = 0;
		if (subfacilities != null) {
			for (Facility subFacility : subfacilities) {
				subCosts += subFacility.totalMaintenanceCost();
			}
		}
		long costs = this.calcMaintenanceCost() + subCosts;
		return costs;
	}

	public double avgTotalProblemRate(){
		long sumRate = 0;
		if (subfacilities != null) {
			for (Facility subFacility : subfacilities) {
				sumRate += subFacility.calcProblemRate();
			}
		}
		double avg = sumRate / this.numFacilities();
		return avg;
	}
}

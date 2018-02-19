package facility;

import java.text.ParseException;
import java.util.ArrayList;

import maintenance.Maintenance;

public class Facility extends Maintenance{
	private ArrayList<Facility> subfacilities;

	public Facility(String name, String info, int capacity){
		super(name, info, capacity);
		subfacilities = new ArrayList<Facility>();
	}

	public String toString(){
		return ("Facility :[ Name : " + this.getName() + ", info : " + this.getInfo() + ", capacity :" + this.getCapacity()+" ]");
	}

	public ArrayList<Facility> listFacilities(){
		return this.subfacilities;
	}

	public int numFacilities(){
		int total = 1;
		for (Facility subFacility : this.listFacilities()) {
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
		for (Facility subfacility : listFacilities()) {
			subfacility.vacateFacility(start, end);
	     }
		String name = "RESERVED";
		String info = "Facility has been asked to be vacated";
		assignFacilityToUse(start, end, name, info);
	}

	public long totalMaintenanceCost(){
		long subCosts = 0;
		for (Facility subFacility : this.listFacilities()) {
			subCosts += subFacility.calcMaintenanceCost();
		}
		long costs = this.calcMaintenanceCost() + subCosts;
		return costs;
	}

	public long avgTotalProblemRate(){
		long sumRate = 0;
		for (Facility subFacility : this.listFacilities()) {
			sumRate += subFacility.calcProblemRate();
		}
		long avg = sumRate / this.numFacilities();
		return avg;
	}
}

package use;

import java.util.List;

import facility.FacilityDetail;
import use.UseDetail;
import use.Inspection;

public class Use extends FacilityDetail{

	private ArrayList<UseDetail> 	usageHistory;
	private ArrayList<Inspection>	inspections;


	public Use(String name, String info, int capacity) {
		super(name, info, capacity);

		usageHistory = new ArrayList<UseDetail>;
		inspections = new ArrayList<Inspection>;
	}

	public boolean objectIsInUseDuringInterval(String start, String end){

	}

	public void assignFacilityToUse(String start, String end, String name, String info){
		// Perform check to see if it is in use;
		if (objectIsInUseDuringInterval(start, end)){return;}

		// TODO

		UseDetail reservation = new UseDetail(start, end, name, info);
		usageHistory.add(reservation);
	}

	public void vacateFacility(String start, String end){
		String name = "RESERVED";
		String info = "Facility has been asked to be vacated";
		if (objectIsInUseDuringInterval(start, end)) {

		}
		assignFacilityToUse(start, end, name, info);
	}

	public ArrayList<Inspection> listInspections(){
		return this.inspections;
	}

	public ArrayList<UseDetail> listActualUsage(){
		return this.usageHistory;
	}

	public double calcUsageRate(){
		// TODO calculate usage(hrs) per day
	}
}

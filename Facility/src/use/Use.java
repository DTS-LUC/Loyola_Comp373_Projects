package use;

import java.util.List;

import facility.FacilityDetail;
import use.UseDetail;
import use.Inspection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Use extends FacilityDetail{
	// TODO: Probably not calling these properly
	public List<UseDetail> 	usageHistory;
	public List<Inspection>	inspections;

	public Use(String name, String info, int capacity) {
		super(name, info, capacity);
	}

	public bool objectIsInUseDuringInterval(String time){
		// TODO
	}

	public void assignFacilityToUse(String time, String name, String info){
		// TODO Perform check to see if it is in use;
		// true - give error to system
		// false - create UseDetail object
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		time = LocalDateTime.parse(time, formatter);
		time = time.format(formatter);
	}

	public void vacateFacility(String time){
		// TODO Create a special vacate event & call assignFacilityToUse()
	}

	public List listInspections(){
		// TODO unpack inspections object
		// Return list or concated String
	}

	public List listActualUsage(){
		// TODO unpack usageHistory object
		// Return list or concated String
	}

	public double calcUsageRate(){
		// TODO calculate usage(hrs) per day
	}
}

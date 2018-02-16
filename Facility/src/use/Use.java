package use;

import java.util.List;

import facility.FacilityDetail;
import use.UseDetail;
import use.Inspection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Use extends FacilityDetail{

	private ArrayList<UseDetail> 	usageHistory = new ArrayList<UseDetail>;
	private ArrayList<Inspection>	inspections = new ArrayList<Inspection>;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public Use(String name, String info, int capacity) {
		super(name, info, capacity);
	}

	public bool objectIsInUseDuringInterval(String time){
		LocalDateTime reservation = LocalDateTime.parse(time, formatter);
		reservation = reservation.format(formatter);
		for (int i = 0; i < usageHistory.size(); i++) {
			if (reservation = usageHistory.get(i).getTime()) {
				return true;
			}
		}
		return false;
	}

	public void assignFacilityToUse(String time, String name, String info){
		// Perform check to see if it is in use;
		if (objectIsInUseDuringInterval(time)) {return;}

		time = LocalDateTime.parse(time, formatter);
		time = time.format(formatter);

		UseDetail reservation = new UseDetail(time, name, info);
		usageHistory.add(reservation);
	}

	public void vacateFacility(String time){
		String name = "RESERVED";
		String info = "Facility has been asked to be vacated";
		if (objectIsInUseDuringInterval(time)) {
			// TODO Remove any existing reservation
		}
		assignFacilityToUse(time, name, info);
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

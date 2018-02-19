package use;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import facility.FacilityDetail;
import use.UseDetail;
import use.Inspection;

public class Use extends FacilityDetail{

	private ArrayList<UseDetail> 		usageHistory;
	private ArrayList<Inspection>		inspections;
	private final SimpleDateFormat 	sdf;


	public Use(String name, String info, int capacity) {
		super(name, info, capacity);

		this.usageHistory = new ArrayList<UseDetail>();
		this.inspections 	= new ArrayList<Inspection>();
		this.sdf				 	= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	}

	public boolean objectIsInUseDuringInterval(String start, String end) throws ParseException{
		Date checkStart = sdf.parse(start);
		Date checkEnd		= sdf.parse(end);
		for (int i = 0;i < usageHistory.size(); i++) {
			UseDetail reservation = usageHistory.get(i);

      Date reservationEnd = sdf.parse(reservation.getEnd());
      Date reservationStart = sdf.parse(reservation.getStart());

      if((checkStart.compareTo(reservationStart) >= 0 && checkStart.compareTo(reservationEnd) <= 0) ||
    		  (checkEnd.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0) ||
    		  (checkStart.compareTo(reservationStart) <= 0 && checkEnd.compareTo(reservationEnd) >= 0) ||
					(checkStart.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0)){
						return true;
					}
			}
			return false;
		}

	public void assignFacilityToUse(String start, String end, String name, String info) throws ParseException{
		if (objectIsInUseDuringInterval(start, end)){
			System.out.println("Space is in use");
			return;
		}
		UseDetail reservation = new UseDetail(start, end, name, info);
		this.usageHistory.add(reservation);
	}

	public void removeObjectsDuringInterval(String start, String end) throws ParseException{
		Date checkStart = sdf.parse(start);
		Date checkEnd		= sdf.parse(end);
		for (int i = 0;i < usageHistory.size(); i++) {
			UseDetail reservation = usageHistory.get(i);

      Date reservationEnd = sdf.parse(reservation.getEnd());
      Date reservationStart = sdf.parse(reservation.getStart());

			if((checkStart.compareTo(reservationStart) >= 0 && checkStart.compareTo(reservationEnd) <= 0) ||
    		  (checkEnd.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0) ||
    		  (checkStart.compareTo(reservationStart) <= 0 && checkEnd.compareTo(reservationEnd) >= 0) ||
					(checkStart.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0)){
					this.usageHistory.remove(i);
				}
			}
	}

	public void performInspection(String start, String end, String inspector, String info){
		Inspection inspect = new Inspection(start, end, inspector, info);
		this.inspections.add(inspect);
	}

	public ArrayList<Inspection> listInspections(){
		return this.inspections;
	}

	public ArrayList<UseDetail> listActualUsage(){
		return this.usageHistory;
	}

//	public double calcUsageRate(){
//		// TODO calculate usage(hrs) per day
//	}
}

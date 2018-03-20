package use;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class UseImpl implements Use {

	private List<UseDetail> usageHistory;
	private List<Inspection> inspections;
	private SimpleDateFormat sdf;


	public UseImpl() {}

	public void setSimpleDateFormat(SimpleDateFormat sdf) {this.sdf = sdf;}

	public SimpleDateFormat getSimpleDateFormat() { return sdf; }

	public void setUseDetails(List<UseDetail> useDetails) { usageHistory = useDetails; }
	public List<UseDetail> getUseDetails() { return usageHistory; }


	public List<Inspection> getInspections() { return inspections; }
	public void setInspections(List<Inspection> inspections) {this.inspections=inspections;}

	public boolean objectIsInUseDuringInterval(String start, String end) throws ParseException{
		Date checkStart = sdf.parse(start);
		Date checkEnd   = sdf.parse(end);

		for (UseDetail reservation: usageHistory) {
			if (reservation.getEnd() != null) {
				Date reservationEnd = sdf.parse(reservation.getEnd());
				Date reservationStart = sdf.parse(reservation.getStart());

				if ((checkStart.compareTo(reservationStart) >= 0 && checkStart.compareTo(reservationEnd) <= 0) ||
						(checkEnd.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0) ||
						(checkStart.compareTo(reservationStart) <= 0 && checkEnd.compareTo(reservationEnd) >= 0) ||
						(checkStart.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public void assignFacilityToUse(UseDetail reservation) throws ParseException{
		if (objectIsInUseDuringInterval(reservation.getStart(), reservation.getEnd())){
			System.out.println("Space is in use");
			return;
		}
		this.usageHistory.add(reservation);
	}

	public void removeObjectsDuringInterval(String start, String end) throws ParseException{
		Date checkStart = sdf.parse(start);
		Date checkEnd		= sdf.parse(end);
		for (int i = 0; i < usageHistory.size(); i++) {
			UseDetail reservation = usageHistory.get(i);

			if (reservation.getEnd() != null) {
				Date reservationEnd = sdf.parse(reservation.getEnd());
				Date reservationStart = sdf.parse(reservation.getStart());

				if ((checkStart.compareTo(reservationStart) >= 0 && checkStart.compareTo(reservationEnd) <= 0) ||
						(checkEnd.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0) ||
						(checkStart.compareTo(reservationStart) <= 0 && checkEnd.compareTo(reservationEnd) >= 0) ||
						(checkStart.compareTo(reservationStart) >= 0 && checkEnd.compareTo(reservationEnd) <= 0)) {
					this.usageHistory.remove(i);
				}
			}
		}
	}

	public void performInspection(Inspection inspect){ this.inspections.add(inspect); }

	public double calcUsageRate() throws ParseException{
		long useTime = 0;
		for (UseDetail use : this.getUseDetails()) {
			useTime += use.getDuration();
		}

		double usePerRes = useTime / (double) (this.getUseDetails().size());
		return usePerRes;
	}
}

import java.text.ParseException;
import java.util.ArrayList;

import facility.Facility;

import use.UseDetail;
import use.Inspection;

public class FacilityDemo {
	public static FacilityDemo demo = new FacilityDemo();

	public void addRooms(Facility floor, int level){
		for (int i = 0; i < 5; i++) {
			Facility newRoom = new Facility("Room "+level+i, "Room "+i+" on level "+level, 10);
			floor.addNewFacility(newRoom);
		}
	}

	public void printReservations(Facility complex){
	System.out.println("Reservations for "+ complex.getName());
    for (UseDetail complexUse : complex.listActualUsage()) {
			System.out.println(complexUse);
		}
	 ArrayList<Facility> floors = complex.listFacilities();
	 for(int f = 0; f < floors.size(); f++) {
		System.out.println("Reservations for "+ floors.get(f).getName());
		 for (UseDetail floorUse : floors.get(f).listActualUsage()) {
			 System.out.println(floorUse);
		 }
		ArrayList<Facility> rooms = floors.get(f).listFacilities();
		for(int r = 0; r < rooms.size(); r++) {
			System.out.println("Reservations for "+ rooms.get(r).getName());
			for (UseDetail roomUse : rooms.get(r).listActualUsage()) {
				System.out.println(roomUse);
			}
		}
	 }
	}

	public void printComplex(Facility complex){
		System.out.println(complex);
    for (Facility floors : complex.listFacilities()) {
       System.out.println(floors);

       for (Facility rooms : floors.listFacilities()) {
          System.out.println(rooms);
       }
    }
	}
	// NOTE: Date & Time Pattern: "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
	// 														2001-07-04T12:08:56.235-0700
	public String reservationFormatter(int year, int month, int day, int hr, int min){
		String time = year+"-";
		if (month < 10) {
			time += "0"+month+"-";
		}
		else {
			time += month+"-";
		}
		if (day < 10) {
			time += "0"+day+"T";
		}
		else {
			time += day+"T";
		}
		if (hr < 10) {
			time += "0"+hr+":";
		}
		else {
			time += hr+":";
		}
		if (min < 10) {
			time += "0"+min+":";
		}
		else {
			time += min+":";
		}
		return (time+"00.000-0600");
	}

  public static void main (String args[]) throws ParseException {
		// Build a large Facility
		Facility ApartmentComplex = new Facility("Big Complex", "An apartment complex", 200);
		// Build 3 smaller floor Facilities with rooms
		Facility floor0 = new Facility("Basement", "Basement of the complex", 50);
		demo.addRooms(floor0, 0);
		Facility floor1 = new Facility("Floor 1", "First floor of the complex", 50);
		demo.addRooms(floor1, 1);
		Facility floor2 = new Facility("Floor 2", "Second floor of the complex", 50);
		demo.addRooms(floor2, 2);
		Facility floor3 = new Facility("Floor 3", "Third floor of the complex", 50);
		demo.addRooms(floor3, 3);
		// Add floors to large Facility
		ApartmentComplex.addNewFacility(floor0);
		ApartmentComplex.addNewFacility(floor1);
		ApartmentComplex.addNewFacility(floor2);
		ApartmentComplex.addNewFacility(floor3);
		// Print all Facilities
		demo.printComplex(ApartmentComplex);
		// Demo removeFacility
		ApartmentComplex.removeFacility(floor3);
		demo.printComplex(ApartmentComplex);
		ApartmentComplex.addNewFacility(floor3);

		// 6. Make room maintenance requests
		// 7. listMaintRequest();
		// 8. Schedule maintenance
		// 9. listMaintenance();
		// 8. calculate cost
		// 9. Get down Time
		// 10. Add issue?
		// 11. listFacilityProblems();
		// 12. calcProblemRate()

		// 13. Reserve rooms
		ArrayList<Facility> rooms = new ArrayList<Facility>();
		rooms.addAll(floor0.listFacilities());
		rooms.addAll(floor1.listFacilities());
		rooms.addAll(floor2.listFacilities());
		rooms.addAll(floor3.listFacilities());
		for (int q = 0; q < rooms.size(); q++) {
			Facility tempRoom = rooms.get(q);
			String start0 	= demo.reservationFormatter(2018, 1, 5, 8, 15);
			String end0 		= demo.reservationFormatter(2018, 1, 5, 10, 15);
			tempRoom.assignFacilityToUse(start0, end0, "Reservation 1", "Example reservation");

			String start1 	= demo.reservationFormatter(2018, 1, 5, 11, 15);
			String end1	= demo.reservationFormatter(2018, 1, 5, 12, 15);
			tempRoom.assignFacilityToUse(start1, end1, "Reservation 2", "Example reservation");

			String start2 	= demo.reservationFormatter(2018, 1, 4, 8, 15);
			String end2 		= demo.reservationFormatter(2018, 1, 4, 10, 15);
			tempRoom.assignFacilityToUse(start2, end2, "Reservation 3", "Example reservation");

			String start3 	= demo.reservationFormatter(2018, 1, 4, 11, 15);
			String end3	= demo.reservationFormatter(2018, 1, 4, 12, 15);
			tempRoom.assignFacilityToUse(start3, end3, "Reservation 4", "Example reservation");
		}
		demo.printReservations(ApartmentComplex);
		String testStart = demo.reservationFormatter(2018, 1, 5, 11, 15);
		String testEnd	= demo.reservationFormatter(2018, 1, 5, 12, 15);
		// 14. Show objectIsInUseDuringInterval()
		System.out.println(rooms.get(4).objectIsInUseDuringInterval(testStart, testEnd));
		// 15. Vacate building
		ApartmentComplex.vacateFacility(testStart, testEnd);
		demo.printReservations(ApartmentComplex);
		// 16. calcUsageRate()
		// 17. Add inspections
		// 18. listInspections()

  }
}

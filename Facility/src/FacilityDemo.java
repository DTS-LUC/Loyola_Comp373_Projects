import java.text.ParseException;
import java.util.ArrayList;

import DemoTools;
import facility.Facility;
import use.UseDetail;
import use.Inspection;

public class FacilityDemo {

  public static void main (String args[]) throws ParseException {
	  DemoTools demo = new DemoTools();
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

		//Reserve rooms
		ArrayList<Facility> rooms = new ArrayList<Facility>();
		rooms.addAll(floor0.listFacilities());
		rooms.addAll(floor1.listFacilities());
		rooms.addAll(floor2.listFacilities());
		rooms.addAll(floor3.listFacilities());
		demo.makeReservations(rooms);
		demo.printReservations(ApartmentComplex);
		String testStart = demo.reservationFormatter(2018, 1, 5, 11, 00);
		String testEnd	= demo.reservationFormatter(2018, 1, 5, 12, 30);
		// Show objectIsInUseDuringInterval()
		System.out.println(rooms.get(4).objectIsInUseDuringInterval(testStart, testEnd));
		// Vacate building
		ApartmentComplex.vacateFacility(testStart, testEnd);
		demo.printReservations(ApartmentComplex);
		// TODO calcUsageRate()

		// Add inspections
		demo.makeInspections(rooms);
		demo.printInspections(ApartmentComplex);

		// Make room maintenance requests
		demo.addIssues(rooms);
		demo.printIssues(ApartmentComplex); TOD
		// listMaintRequest();
		demo.addRequests(rooms);
		demo.printRequests(ApartmentComplex);
		// Schedule maintenance
		demo.performMaint(ApartmentComplex);
		// listMaintenance();
		demo.printMaint(ApartmentComplex);
		// TODO
		// calculate cost
		
		// Get down Time
		// calcProblemRate()

  }
}

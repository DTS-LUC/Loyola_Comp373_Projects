import java.text.ParseException;
import java.util.ArrayList;
import facility.Facility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import use.UseDetail;

public class FacilityDemo {

  public static void main (String args[]) throws ParseException {

	  ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");

	  DemoTools demo = (DemoTools) context.getBean("demoTools");

	  // Build a large Facility

	  Facility apartmentComplex = (Facility) context.getBean("facility");

	  apartmentComplex.setName("Big Complex");
	  apartmentComplex.setInfo("An apartment complex");
	  apartmentComplex.setCapacity(200);


	  // Build 3 smaller floor Facilities with rooms
	  Facility floor0 = (Facility) context.getBean("facility");
	  floor0.setName("Basement");
	  floor0.setInfo("Basement of the complex");
	  floor0.setCapacity(50);
	  demo.addRooms(floor0, 0, context);

	  Facility floor1 = (Facility) context.getBean("facility");
	  floor1.setName("Floor 1");
	  floor1.setInfo("First floor of the complex");
	  floor1.setCapacity(50);
	  demo.addRooms(floor1, 1, context);

	  Facility floor2 = (Facility) context.getBean("facility");
	  floor2.setName("Floor 2");
	  floor2.setInfo("Second floor of the complex");
	  floor2.setCapacity(50);
	  demo.addRooms(floor2, 2, context);

	  Facility floor3 = (Facility) context.getBean("facility");
	  floor3.setName("Floor 3");
	  floor3.setInfo("Third floor of the complex");
	  floor3.setCapacity(50);
	  demo.addRooms(floor3, 3, context);

		// Add floors to large Facility
	  apartmentComplex.addNewFacility(floor0);
	  apartmentComplex.addNewFacility(floor1);
	  apartmentComplex.addNewFacility(floor2);
	  apartmentComplex.addNewFacility(floor3);
		// Print all Facilities
	  demo.printComplex(apartmentComplex);
		// Demo removeFacility
	  apartmentComplex.removeFacility(floor3);
	  demo.printComplex(apartmentComplex);
	  apartmentComplex.addNewFacility(floor3);

		//Reserve rooms
	  ArrayList<Facility> rooms = new ArrayList<Facility>();
	  rooms.addAll(floor0.getFacility());
	  rooms.addAll(floor1.getFacility());
	  rooms.addAll(floor2.getFacility());
	  rooms.addAll(floor3.getFacility());
	  demo.makeReservations(rooms, context);
	  demo.printReservations(apartmentComplex);
	  String testStart = demo.reservationFormatter(2018, 1, 5, 11, 00);
	  String testEnd	= demo.reservationFormatter(2018, 1, 5, 12, 30);
		// Show objectIsInUseDuringInterval()
	  System.out.println(rooms.get(4).objectIsInUseDuringInterval(testStart, testEnd));
		// Vacate building

	  UseDetail vacateComplex = (UseDetail) context.getBean("useDetail");
	  vacateComplex.setStart(testStart);
	  vacateComplex.setEnd(testEnd);
	  apartmentComplex.vacateFacility(vacateComplex);
	  demo.printReservations(apartmentComplex);
		// Show UsageRate
	  demo.printUsageRates(apartmentComplex);
		// Add inspections
	  demo.makeInspections(rooms);
	  demo.printInspections(apartmentComplex);
		// Make room maintenance requests
	  demo.addIssues(rooms, context);
	  demo.printIssues(apartmentComplex);
		// listMaintRequest();
	  demo.addRequests(rooms);
	  demo.printRequests(apartmentComplex);

		// calculate cost
	  System.out.println("$" + apartmentComplex.totalMaintenanceCost());
		// Get down Time
	  demo.printDownTimes(apartmentComplex);
		// calcProblemRate()
	  demo.printProblemRate(apartmentComplex);

		// Schedule maintenance
	  demo.performMaint(rooms);
	  demo.printIssues(apartmentComplex);

		// listMaintenance();
	  demo.printRecords(apartmentComplex);
  }
}

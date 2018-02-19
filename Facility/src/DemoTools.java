import java.util.ArrayList;

import facility.Facility;
import maintenance.Issue;
import maintenance.Request;
import use.Inspection;
import use.UseDetail;
class DemoTools{

  public void addRooms(Facility floor, int level){
    for (int i = 0; i < 5; i++) {
      Facility newRoom = new Facility("Room "+level+i, "Room "+i+" on level "+level, 10);
      floor.addNewFacility(newRoom);
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

  public void printInspections(Facility complex){
    System.out.println("Inspections for "+ complex.getName());
      for (Inspection complexUse : complex.listInspections()) {
        System.out.println(complexUse);
      }
     ArrayList<Facility> floors = complex.listFacilities();
     for(int f = 0; f < floors.size(); f++) {
      System.out.println("Inspections for "+ floors.get(f).getName());
       for (Inspection floorUse : floors.get(f).listInspections()) {
         System.out.println(floorUse);
       }
      ArrayList<Facility> rooms = floors.get(f).listFacilities();
      for(int r = 0; r < rooms.size(); r++) {
        System.out.println("Inspections for "+ rooms.get(r).getName());
        for (Inspection roomUse : rooms.get(r).listInspections()) {
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

  public void makeReservations(ArrayList<Facility> rooms){
    for (int q = 0; q < rooms.size(); q++) {
			Facility tempRoom = rooms.get(q);
			String start0 	= reservationFormatter(2018, 1, 5, 8, 15);
			String end0 		= reservationFormatter(2018, 1, 5, 10, 15);
			tempRoom.assignFacilityToUse(start0, end0, "Reservation 1", "Example reservation");

			String start1 	= reservationFormatter(2018, 1, 5, 11, 15);
			String end1	= reservationFormatter(2018, 1, 5, 12, 15);
			tempRoom.assignFacilityToUse(start1, end1, "Reservation 2", "Example reservation");

			String start2 	= reservationFormatter(2018, 1, 4, 8, 15);
			String end2 		= reservationFormatter(2018, 1, 4, 10, 15);
			tempRoom.assignFacilityToUse(start2, end2, "Reservation 3", "Example reservation");

			String start3 	= reservationFormatter(2018, 1, 4, 11, 15);
			String end3	= reservationFormatter(2018, 1, 4, 12, 15);
			tempRoom.assignFacilityToUse(start3, end3, "Reservation 4", "Example reservation");
		}
  }

  public void makeInspections(ArrayList<Facility> rooms){
    String inspection1Start = reservationFormatter(2018, 1, 6, 11, 00);
		String inspection1End	= reservationFormatter(2018, 1, 6, 12, 00);
		String inspection2Start = reservationFormatter(2018, 1, 7, 11, 00);
		String inspection2End	= reservationFormatter(2018, 1, 7, 12, 00);
		String inspection3Start = reservationFormatter(2018, 8, 6, 11, 00);
		String inspection3End	= reservationFormatter(2018, 8, 6, 12, 00);

		rooms.get(2).performInspection(inspection1Start, inspection1End, "Mr. Jones", "Example inspection");
		rooms.get(2).performInspection(inspection2Start, inspection2End, "Mr. Smith", "Example inspection");
		rooms.get(2).performInspection(inspection3Start, inspection3End, "Mr. James", "Example inspection");

  }

  public void addIssues(ArrayList<Facility> rooms){
    for (int q = 0; q < rooms.size(); q++) {
      Facility tempRoom = rooms.get(q);
      String details = "Issue number " + q;
      long time = (q%3)+1;
      long cost = 100;
      tempRoom.addIssue(details, time, cost);
    }
  }

  public void addRequests(ArrayList<Facility> rooms){
    for (int q = 0; q < rooms.size(); q++) {
      Facility tempRoom = rooms.get(q);
      for (Issue issue : tempRoom.listIssues()) {
        tempRoom.makeFacilityMaintRequest(issue);
      }
    }
  }

  public void performMaint(ArrayList<Facility> rooms){
    for (int q = 0; q < rooms.size(); q++) {
      Facility tempRoom = rooms.get(q);
      for (Request request : tempRoom.listRequests()) {
//    	  TODO add date and worker for tests
        tempRoom.addMaintRecord(request, date, worker);
      }
    }
  }
}

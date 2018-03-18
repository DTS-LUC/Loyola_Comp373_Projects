import java.text.ParseException;
import java.util.List;

import facility.Facility;
import maintenance.Issue;
import maintenance.Request;
import org.springframework.context.ApplicationContext;
import use.Inspection;
import use.UseDetail;
class DemoTools{

  public void addRooms(Facility floor, int level, ApplicationContext context){
    for (int i = 0; i < 5; i++) {
      Facility newRoom = (Facility) context.getBean("facility");
      newRoom.setName("Room "+level+i);
      newRoom.setInfo("Room "+i+" on level "+level);
      newRoom.setCapacity(10);
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
      List<Facility> floors = complex.getFacility();
      for(int f = 0; f < floors.size(); f++) {
          System.out.println("Reservations for "+ floors.get(f).getName());

          for (UseDetail floorUse : floors.get(f).listActualUsage()) {
              System.out.println(floorUse);
          }
          List<Facility> rooms = floors.get(f).getFacility();
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
      List<Facility> floors = complex.getFacility();
      for(int f = 0; f < floors.size(); f++) {
          System.out.println("Inspections for "+ floors.get(f).getName());
          for (Inspection floorUse : floors.get(f).listInspections()) {
              System.out.println(floorUse);
          }
          List<Facility> rooms = floors.get(f).getFacility();
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
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors);

          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms);
          }
      }
  }

  public void makeReservations(List<Facility> rooms, ApplicationContext context) throws ParseException{
      for (int q = 0; q < rooms.size(); q++) {
          Facility tempRoom = rooms.get(q);
          String start0 	= reservationFormatter(2018, 1, 5, 8, 15);
          String end0 		= reservationFormatter(2018, 1, 5, 10, 15);
          UseDetail useDetail0 = (UseDetail) context.getBean("useDetail");
          useDetail0.setStart(start0);
          useDetail0.setEnd(end0);
          useDetail0.setName("Reservation 1");
          useDetail0.setInfo("Example reservation");
          tempRoom.assignFacilityToUse(useDetail0);

          String start1 	= reservationFormatter(2018, 1, 5, 11, 15);
          String end1	= reservationFormatter(2018, 1, 5, 12, 15);
          UseDetail useDetail1 = (UseDetail) context.getBean("useDetail");
          useDetail1.setStart(start1);
          useDetail1.setEnd(end1);
          useDetail1.setName("Reservation 2");
          useDetail1.setInfo("Example reservation");
          tempRoom.assignFacilityToUse(useDetail1);

          String start2 	= reservationFormatter(2018, 1, 4, 8, 15);
          String end2 		= reservationFormatter(2018, 1, 4, 10, 15);
          UseDetail useDetail2 = (UseDetail) context.getBean("useDetail");
          useDetail2.setStart(start2);
          useDetail2.setEnd(end2);
          useDetail2.setName("Reservation 3");
          useDetail2.setInfo("Example reservation");
          tempRoom.assignFacilityToUse(useDetail2);

          String start3 	= reservationFormatter(2018, 1, 4, 11, 15);
          String end3	= reservationFormatter(2018, 1, 4, 12, 15);
          UseDetail useDetail3 = (UseDetail) context.getBean("useDetail");
          useDetail3.setStart(start3);
          useDetail3.setEnd(end3);
          useDetail3.setName("Reservation 4");
          useDetail3.setInfo("Example reservation");
          tempRoom.assignFacilityToUse(useDetail3);
      }
  }

  public void makeInspections(List<Facility> rooms, ApplicationContext context){
      String inspection1Start = reservationFormatter(2018, 1, 6, 11, 00);
      String inspection1End	= reservationFormatter(2018, 1, 6, 12, 00);
      String inspection2Start = reservationFormatter(2018, 1, 7, 11, 00);
      String inspection2End	= reservationFormatter(2018, 1, 7, 12, 00);
      String inspection3Start = reservationFormatter(2018, 8, 6, 11, 00);
      String inspection3End	= reservationFormatter(2018, 8, 6, 12, 00);

      Inspection inspection1 = (Inspection) context.getBean("inspection");
      inspection1.setStart(inspection1Start);
      inspection1.setEnd(inspection1End);
      inspection1.setInspector("Mr. Jones");
      inspection1.setInfo("Example inspection");
      rooms.get(2).performInspection(inspection1);

      Inspection inspection2 = (Inspection) context.getBean("inspection");
      inspection2.setStart(inspection2Start);
      inspection2.setEnd(inspection2End);
      inspection2.setInspector("Mr. Smith");
      inspection2.setInfo("Example inspection");
      rooms.get(2).performInspection(inspection2);

      Inspection inspection3 = (Inspection) context.getBean("inspection");
      inspection3.setStart(inspection3Start);
      inspection3.setEnd(inspection3End);
      inspection3.setInspector("Mr. James");
      inspection3.setInfo("Example inspection");
      rooms.get(2).performInspection(inspection3);

  }

  public void addIssues(List<Facility> rooms, ApplicationContext context){
    for (int q = 0; q < rooms.size(); q++) {
      Facility tempRoom = rooms.get(q);
      String details = "Issue number " + q;
      long time = (q%3)+1;
      long cost = 100;

      Issue newIssue = (Issue) context.getBean("issue");
      newIssue.setCost(cost);
      newIssue.setDetails(details);
      newIssue.setTime(time);

      tempRoom.addIssue(newIssue);
    }
  }

  public void addRequests(List<Facility> rooms){
    for (int q = 0; q < rooms.size(); q++) {
      Facility tempRoom = rooms.get(q);
      for (Issue issue : tempRoom.listIssues()) {
        tempRoom.makeFacilityMaintRequest(issue);
      }
    }
  }

  public void performMaint(List<Facility> rooms){
    for (int q = 0; q < rooms.size(); q++) {
      Facility tempRoom = rooms.get(q);
      for (Request request : tempRoom.listRequests()) {
    	  String date	= reservationFormatter(2018, 1, 9, 8, 00);
    	  String worker = "Tom";
        tempRoom.addMaintRecord(request, date, worker);
      }
    }
  }

  public void printIssues(Facility complex){
      System.out.println(complex.getName());
      System.out.println(complex.listIssues());
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors.getName());
          System.out.println(floors.listIssues());
          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms.getName());
              System.out.println(rooms.listIssues());
          }
      }
  }

  public void printRequests(Facility complex){
      System.out.println(complex.getName());
      System.out.println(complex.listRequests());
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors.getName());
          System.out.println(floors.listRequests());

          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms.getName());
              System.out.println(rooms.listRequests());
          }
      }
  }

  public void printRecords(Facility complex){
      System.out.println(complex.getName());
      System.out.println(complex.listRecords());
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors.getName());
          System.out.println(floors.listRecords());
          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms.getName());
              System.out.println(rooms.listRecords());
          }
      }
  }

  public void printDownTimes(Facility complex){
      System.out.println(complex.getName());
      System.out.println(complex.calcDowntime()+ " hrs");
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors.getName());
          System.out.println(floors.calcDowntime()+ " hrs");
          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms.getName());
              System.out.println(rooms.calcDowntime()+ " hrs");
          }
      }
  }

  public void printProblemRate(Facility complex){
      System.out.println(complex.getName());
      System.out.println(complex.calcProblemRate()+ " Issues per use");
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors.getName());
          System.out.println(floors.calcProblemRate()+ " Issues per use");
          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms.getName());
              System.out.println(rooms.calcProblemRate()+ " Issues per use");
          }
      }
  }

  public void printUsageRates(Facility complex) throws ParseException{
      System.out.println(complex);
      for (Facility floors : complex.getFacility()) {
          System.out.println(floors);
          for (Facility rooms : floors.getFacility()) {
              System.out.println(rooms);
              System.out.println(rooms.calcUsageRate() + " hours per use");
          }
      }
  }
}

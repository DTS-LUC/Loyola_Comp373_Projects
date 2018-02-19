import facility.Facility;

public class FacilityDemo {

// NOTE: Date & Time Pattern: "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
// 														2001-07-04T12:08:56.235-0700

		public void addRooms(Facility floor, int level){
			for (int i = 0; i < 5; i++) {
				Facility newRoom = new Facility(level + i + "", "Room "+level+i, 10);
				floor.addNewFacility(newRoom);
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

    public static void main (String args[]) {
			// 1. Build a large Facility
			Facility ApartmentComplex = new Facility("Big Complex", "An apartment complex", 200);
			// 2. Build 3 smaller floor Facilities with rooms
			Facility floor0 = new Facility("Basement", "Basement of the complex", 50);
			addRooms(floor0, 0);
			Facility floor1 = new Facility("Floor 1", "First floor of the complex", 50);
			addRooms(floor1, 1);
			Facility floor2 = new Facility("Floor 2", "Second floor of the complex", 50);
			addRooms(floor2, 2);
			Facility floor3 = new Facility("Floor 3", "Third floor of the complex", 50);
			addRooms(floor3, 3);
			// 3. Print all Facilities using listFacilities();
			printComplex(ApartmentComplex);
			// 4. remove floor
			ApartmentComplex.remove(floor3);
			// 5. listFacilities();
			//
			// 6. Make room maintenance requests
			// 7. listMaintRequest();
			// 8. Schedule maintenance
			// 9. listMaintenance();
			// 8. calculate cost
			// 9. Get down Time
			// 10. Add issue?
			// 11. listFacilityProblems();
			// 12. calcProblemRate()
			//
			// 13. Reserve rooms
			// 14. Show objectIsInUseDuringInterval()
			// 15. Reserve floor (Vacate subfacilities)
			// 16. listActualUsage()
			// 17. calcUsageRate()
			// 18. Add inspections
			// 19. listInspections()

    }
}

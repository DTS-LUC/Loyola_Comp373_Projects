public class FacilityClient {

    public static void main (String args[]) {
        FacilityUnit building = new FacilityUnit("Building");
        FacilityUnit floor1 = new FacilityUnit("Floor 1");
        FacilityUnit floor2 = new FacilityUnit("Floor 2");
        FacilityUnit room101 = new FacilityUnit("Room 101");
        FacilityUnit room102 = new FacilityUnit("Room 102");
        FacilityUnit room201 = new FacilityUnit("Room 201");
        FacilityUnit room202 = new FacilityUnit("Room 202");

        building.addSubUnits(floor1, floor2);
        floor1.addSubUnits(room101, room102);
        floor2.addSubUnits(room201, room202);
    }
}

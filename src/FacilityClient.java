import facility.FacilityUnit;
import maintenance.*;

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

        Issue buildingIssue = new Issue(building);
        buildingIssue.setDetails("something is wrong with building");
        buildingIssue.setCost(500);

        Request floor1Request = new Request(floor1);
        floor1Request.setDetails("something is wrong with Floor 1");
        floor1Request.setCost(250);

        Request buildingRequest = new Request(buildingIssue);

        Record buildingRecord = buildingRequest.setComplete();
        Record floor1Record = floor1Request.setComplete();

        FacilityMaintenance floor1Maintenance = floor1.getFacilityMaintenance();
        FacilityMaintenance buildingMaintenance = building.getFacilityMaintenance();

        System.out.println(floor1Maintenance.listIssues().size());
        System.out.println(buildingMaintenance.listIssues().size());
    }
}

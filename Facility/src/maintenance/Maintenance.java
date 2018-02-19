package maintenance;

import use.Use;
import maintenance.Issue;
import maintenance.Record;
import maintenance.Request;

import java.util.ArrayList;

public class Maintenance extends Use{

    private ArrayList<Issue> facilityIssues;
    private ArrayList<Request> maintenanceRequests;
    private ArrayList<Record> maintenanceRecords;

    public Maintenance(String name, String info, int capacity) {
  		super(name, info, capacity);

      this.facilityIssues     = new ArrayList<Issue>();
      this.maintenanceRequests = new ArrayList<Request>();
      this.maintenanceRecords  = new ArrayList<Record>();
    }

    public void addIssue(Issue issue) { facilityIssues.add(issue); }

    public void removeIssue(Issue fixed) { facilityIssues.remove(fixed);}

    public ArrayList<Issue> listIssues() { return this.facilityIssues;}

    public void makeFacilityMaintRequest(String details, Double time, Double cost){
      Request request = new Request(details, time, cost);
      maintenanceRequests.add(request);
    }

    public void makeFacilityMaintRequest(Issue issue){
      Request request = new Request(issue);
      maintenanceRequests.add(request);
    }

    public ArrayList<Request> listRequests() {return this.maintenanceRequests;}

    public void addMaintRecord(Request request, String dateCompleted, String workerName){
      request.setComplete();
      Record record = new Record(request, dateCompleted, workerName);
      maintenanceRecords.add(record);
    }

    public ArrayList<Record> listRecords() {return this.maintenanceRecords;}

   /* public double calcMaintenanceCost() {
        double sum = 0;
        for (Issue i : maintenance) {
            if (i instanceof Record) {
                Record rec = (Record)i;
                sum += rec.getCost();
            }
        }
        for (FacilityUnit fac : facility.getSubUnits()) {
            sum += fac.getFacilityMaintenance().calcMaintenanceCost();
        }
        return sum;
    }*/
}

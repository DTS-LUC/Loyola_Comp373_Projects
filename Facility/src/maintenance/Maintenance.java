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

  public void addIssue(String details, long time, long cost){
    Issue issue = new Issue(details, time, cost);
    facilityIssues.add(issue);
  }

  public void addIssue(Issue issue) { facilityIssues.add(issue); }

  public void removeIssue(Issue fixed) { facilityIssues.remove(fixed);}

  public ArrayList<Issue> listIssues() { return this.facilityIssues;}

  public void makeFacilityMaintRequest(String details, long time, long cost){
    Request request = new Request(details, time, cost);
    maintenanceRequests.add(request);
  }

  public void makeFacilityMaintRequest(Issue issue){
    Request request = new Request(issue);
    maintenanceRequests.add(request);
  }

  public ArrayList<Request> listRequests() {return this.maintenanceRequests;}

  public void addMaintRecord(Request request, String dateCompleted, String workerName){
    // TODO: Remove from issues
    request.setComplete();
    Record record = new Record(request, dateCompleted, workerName);
    maintenanceRecords.add(record);
  }

  public ArrayList<Record> listRecords() {return this.maintenanceRecords;}

  public long calcMaintenanceCost() {
    long cost = 0;
    for (Issue i: this.listIssues()) {
      cost += i.getCost();
    }
    return cost;
  }

  public long calcDowntime() {
     long time = 0;
     for (Issue i: this.listIssues()) {
       time += i.getTime();
     }
     return time;
  }

  public long calcProblemRate(){
    // Problem rate = Issues per use
    int issues = this.listIssues().size();
    int uses   = this.listActualUsage().size();
    long rate = issues/uses;
    return (rate);
  }
}

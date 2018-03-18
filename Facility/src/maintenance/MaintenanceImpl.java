package maintenance;

import use.Use;
import use.UseImpl;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceImpl extends UseImpl implements Maintenance{

    private List<Issue> facilityIssues;
    private List<Request> maintenanceRequests;
    private List<Record> maintenanceRecords;

    public MaintenanceImpl() {
  		super();

      this.facilityIssues     = new ArrayList<Issue>();
      this.maintenanceRequests = new ArrayList<Request>();
      this.maintenanceRecords  = new ArrayList<Record>();
    }

  //TODO: take in issue as argument, don't create one
  public void addIssue(String details, long time, long cost){
    Issue issue = new IssueImpl();
    issue.setDetails(details);
    issue.setTime(time);
    issue.setCost(cost);
    facilityIssues.add(issue);
  }

  public void addIssue(Issue issue) { facilityIssues.add(issue); }

  public void removeIssue(Issue fixed) { facilityIssues.remove(fixed);}

  public void removeIssue(String id) {
    for (int i = 0;i < facilityIssues.size(); i++) {
			Issue issue = facilityIssues.get(i);
			if (issue.getID().equals(id)) {
				facilityIssues.remove(i);
				break;
			}
    }
  }

  public List<Issue> listIssues() { return this.facilityIssues;}

  //TODO: take in request as argument, don't create one
  public void makeFacilityMaintRequest(String details, long time, long cost){
    Request request = new RequestImpl();
    request.setDetails(details);
    request.setTime(time);
    request.setCost(cost);
    maintenanceRequests.add(request);
  }

  //TODO: take in request as argument, don't create one
  public void makeFacilityMaintRequest(Issue issue){
    Request request = new RequestImpl();
    request.setIssue(issue);
    maintenanceRequests.add(request);
  }

  public List<Request> listRequests() {return this.maintenanceRequests;}

  //TODO: take in record as argument, don't create one
  public void addMaintRecord(Request request, String dateCompleted, String workerName){
    request.setComplete();
    removeIssue(request.getID());
    Record record = new RecordImpl();
    record.setRequest(request);
    record.setDateCompleted(dateCompleted);
    record.setWorkerName(workerName);
    maintenanceRecords.add(record);
  }

  public List<Record> listRecords() {return this.maintenanceRecords;}

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

  public double calcProblemRate(){
    // Problem rate = Issues per use
    double issues = this.listIssues().size();
    double uses   = this.listActualUsage().size();
    double rate = issues/uses;

    return rate;
  }
}

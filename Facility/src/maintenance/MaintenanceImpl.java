package maintenance;

import use.Use;
import use.UseImpl;

import java.util.List;

public class MaintenanceImpl extends UseImpl implements Maintenance{

    private List<Issue> facilityIssues;
    private List<Request> maintenanceRequests;
    private List<Record> maintenanceRecords;

    public MaintenanceImpl() { }

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

    public void makeFacilityMaintRequest(Request request){ maintenanceRequests.add(request); }

    public void makeFacilityMaintRequest(Issue issue){
      Request request = (Request) issue;
      request.setIssue(issue);
      maintenanceRequests.add(request);
    }

    public List<Request> listRequests() {return this.maintenanceRequests;}

    public void addMaintRecord(Request request, String dateCompleted, String workerName){
      request.setComplete();
      removeIssue(request.getID());
      Record record = (Record) request;
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

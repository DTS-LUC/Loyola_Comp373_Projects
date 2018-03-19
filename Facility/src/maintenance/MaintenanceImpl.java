package maintenance;

import use.Use;
import use.UseImpl;

import java.util.List;

public class MaintenanceImpl implements Maintenance{

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

    public List<Issue> getIssues() { return this.facilityIssues;}

    public void setIssues(List<Issue> issues) {this.facilityIssues = issues;}

    public void makeFacilityMaintRequest(Request request){ maintenanceRequests.add(request); }

    public List<Request> getRequests() {return this.maintenanceRequests;}

    public void setRequests(List<Request> requests) {this.maintenanceRequests = requests;}

    public void addMaintRecord(Request request, Record record, String dateCompleted, String workerName){
      request.setComplete();
      removeIssue(request.getID());
      record.setRequest(request);
      record.setDateCompleted(dateCompleted);
      record.setWorkerName(workerName);
      maintenanceRecords.add(record);
    }

    public List<Record> getRecords() {return this.maintenanceRecords;}

    public void setRecords(List<Record> records) {this.maintenanceRecords = records;}

    public long calcMaintenanceCost() {
      long cost = 0;
      for (Issue i: this.getIssues()) {
        cost += i.getCost();
      }
      return cost;
    }

    public long calcDowntime() {
      long time = 0;
      for (Issue i: this.getIssues()) {
        time += i.getTime();
      }
      return time;
    }

    public double calcProblemRate(double uses){
      // Problem rate = Issues per use
      double issues = this.getIssues().size();
		// NOTE Issue here, will need to access number of uses another way
			// - Can definetly just have that sent in the function parameters
      //double uses   = this.getUseDetails().size();
      double rate = issues/uses;

      return rate;
    }

}

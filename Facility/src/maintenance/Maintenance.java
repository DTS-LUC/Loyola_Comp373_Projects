package maintenance;

import use.Use;

import java.util.List;

public interface Maintenance extends Use {
    public void addIssue(Issue issue);
    public void removeIssue(Issue fixed);
    public void removeIssue(String id);
    public List<Issue> listIssues();
    public void makeFacilityMaintRequest(Request request);
    public void makeFacilityMaintRequest(Issue issue);
    public List<Request> listRequests();
    public void addMaintRecord(Request request, String dateCompleted, String workerName);
    public List<Record> listRecords();
    public long calcMaintenanceCost();
    public long calcDowntime();
    public double calcProblemRate();
}

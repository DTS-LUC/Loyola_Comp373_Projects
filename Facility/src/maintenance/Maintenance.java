package maintenance;

import use.Use;

import java.util.List;

public interface Maintenance{
    public void addIssue(Issue issue);
    public void removeIssue(Issue fixed);
    public void removeIssue(String id);
    public List<Issue> getIssues();
    public void setIssues(List<Issue> issues);
    public void makeFacilityMaintRequest(Request request);
    public List<Request> getRequests();
    public void setRequests(List<Request> requests);
    public void addMaintRecord(Request request, Record record, String dateCompleted, String workerName);
    public List<Record> getRecords();
    public void setRecords(List<Record> records);
    public long calcMaintenanceCost();
    public long calcDowntime();
    public double calcProblemRate(double uses);
}

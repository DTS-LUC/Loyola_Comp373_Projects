package maintenance;

import facility.FacilityUnit;

import java.util.ArrayList;
import java.util.List;

public class FacilityMaintenance {

    private FacilityUnit facility;

    public FacilityMaintenance(FacilityUnit facility) {
        this.facility = facility;
    }

    private List<Issue> maintenance = new ArrayList<Issue>();

    public void addIssue(Issue issue) { maintenance.add(issue); }

    public void removeIssue(Issue old) {
        maintenance.remove(old);
    }

    public List<Issue> listIssues() {
        List<Issue> issues = new ArrayList<Issue>(maintenance);
        for (FacilityUnit fac : facility.getSubUnits()) {
            issues.addAll(fac.getFacilityMaintenance().listIssues());
        }
        return issues;
    }

    public List<Request> listRequests() {
        List<Request> requests = new ArrayList<Request>();
        for (Issue i : maintenance) {
            if (i instanceof Request) {
                requests.add((Request)i);
            }
        }
        for (FacilityUnit fac : facility.getSubUnits()) {
            requests.addAll(fac.getFacilityMaintenance().listRequests());
        }
        return requests;
    }

    public List<Record> listRecords() {
        List<Record> records = new ArrayList<Record>();
        for (Issue i : maintenance) {
            if (i instanceof Record) {
                records.add((Record) i);
            }
        }
        for (FacilityUnit fac : facility.getSubUnits()) {
            records.addAll(fac.getFacilityMaintenance().listRecords());
        }
        return records;
    }

    public double calcMaintenanceCost() {
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
    }
}

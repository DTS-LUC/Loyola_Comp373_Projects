package maintenance;

import facility.FacilityUnit;

public class Issue {

    //default access is package private so that subclasses may use them directly
    FacilityUnit facility;
    String details;
    double cost;

    public Issue(FacilityUnit facility) {
        this.facility = facility;
        facility.getFacilityMaintenance().addIssue(this);
    }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }

    public double getCost() { return cost; }

    public void setCost(double cost) { this.cost = cost; }
}

package maintenance;

import java.util.Date;
import facility.FacilityUnit;

public class Request extends Issue {

    //default access is package private so that subclasses may use them directly
    Date dateCreated;
    Date scheduledDate;
    boolean complete = false;


    //create new request without existing issue
    public Request(FacilityUnit facility) {
        super(facility);
        this.dateCreated = new Date(); //use current date when created
    }

    //create new request from existing issue
    public Request(Issue issue) {
        super(issue.facility);
        this.dateCreated = new Date();
        this.cost = issue.cost;
        this.details = issue.details;
        facility.getFacilityMaintenance().removeIssue(issue);
    }

    public Date getDateCreated() { return dateCreated; }

    public void scheduleDate(Date date) {
        this.scheduledDate = date;
    }

    public Date getScheduledDate() { return scheduledDate; }

    public boolean isComplete() {
        return complete;
    }

    //keep record of request once completed
    public Record setComplete() {
        complete = true;
        return new Record(this);
    }
}

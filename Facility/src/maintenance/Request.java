package maintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Request extends Issue {

    //default access is package private so that subclasses may use them directly
    private String  dateCreated;
    private boolean complete;
    private final SimpleDateFormat 	sdf;

    //create new request without existing issue
    public Request(String details, long time, long cost) {
        super(details, time, cost);
        this.sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date created = new Date();
        this.dateCreated = sdf.format(created); //use current date when created
    }

    //create new request from existing issue
    public Request(Issue issue) {
        super(issue.getDetails(), issue.getTime(), issue.getCost());
        this.sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date created = new Date();
        this.dateCreated = sdf.format(created); //use current date when created
    }

    public String toString(){
      return ("Request: [ Created: " + dateCreated +
              " Details: " + this.getDetails() +
              " Estimated Time: " + this.getTime()+
              " Cost: " + this.getCost()+ " ]");
    }

    public void setDateCreated(String created){ this.dateCreated = created;}
    public String getDateCreated() { return this.dateCreated; }

    public boolean isComplete() { return complete;}
    //keep record of request once completed
    public void setComplete() { complete = true;}
    public void setIncomplete() { complete = false;}
  }

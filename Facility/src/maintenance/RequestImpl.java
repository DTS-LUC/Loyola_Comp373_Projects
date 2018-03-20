package maintenance;

import java.text.SimpleDateFormat;

public class RequestImpl extends IssueImpl implements Request{

    //default access is package private so that subclasses may use them directly
    private String  dateCreated;
    private boolean complete;
    private SimpleDateFormat 	sdf;


    public RequestImpl() { }

    public void setSimpleDateFormat(SimpleDateFormat sdf) {this.sdf = sdf;}

    public SimpleDateFormat getSimpleDateFormat() { return sdf; }

    public void setIssue(Issue issue) {
        details = issue.getDetails();
        time = issue.getTime();
        cost = issue.getCost();
        id = issue.getID();
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

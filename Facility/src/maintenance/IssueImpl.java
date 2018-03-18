package maintenance;

import java.util.UUID;

public class IssueImpl implements Issue {

    //default access is package private so that subclasses may use them directly
    String details;
    long time; // Time in hours, can be decimal
    long cost;
    String id;

    public IssueImpl() {
        this.id	= UUID.randomUUID().toString();
    }

    public String toString(){
      return ("Issue: [ Details: " + this.getDetails() +
              " Estimated Time: " + this.getTime()+
              " Cost: " + this.getCost()+ " ]");
    }

    public String getDetails() { return this.details; }

    public void setDetails(String details) { this.details = details; }

    public long getTime() { return this.time; }

    public void setTime(long time) { this.time = time; }

    public long getCost() { return this.cost; }

    public void setCost(long cost) { this.cost = cost; }

    public String getID(){ return this.id;}

    public void setID(String id) {this.id = id;}
}

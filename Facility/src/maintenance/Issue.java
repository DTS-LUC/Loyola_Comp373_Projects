package maintenance;

import java.util.UUID;

public class Issue {

    //default access is package private so that subclasses may use them directly
    String details;
    long time; // Time in hours, can be decimal
    long cost;
    String id;

    public Issue(String details, long time, long cost) {
        this.details  = details;
        this.time     = time;
        this.cost     = cost;
				this.id				= UUID.randomUUID().toString();
    }

		public Issue(String details, long time, long cost, String id) {
        this.details  = details;
        this.time     = time;
        this.cost     = cost;
				this.id				= id;
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
}

package maintenance;

public class Issue {

    //default access is package private so that subclasses may use them directly
    String details;
    long time; // Time in hours, can be decimal
    long cost;

    public Issue(String details, long time, long cost) {
        this.details  = details;
        this.time     = time;
        this.cost     = cost;
    }

    public String toString(){
      return ("Issue: [ Details: " + this.getDetails() +
              " Estimated Time: " + this.getTime()+
              " Cost: " + this.getCost()+ " ]");
    }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }

    public long getTime() { return time; }

    public void setTime(long time) { this.time = time; }

    public long getCost() { return cost; }

    public void setCost(long cost) { this.cost = cost; }
}

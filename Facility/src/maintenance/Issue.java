package maintenance;

public class Issue {

    //default access is package private so that subclasses may use them directly
    String details;
    double time; // Time in hours, can be decimal
    double cost;

    public Issue(String details, Double time, Double cost) {
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

    public double getTime() { return time; }

    public void setTime(double time) { this.time = time; }

    public double getCost() { return cost; }

    public void setCost(double cost) { this.cost = cost; }
}

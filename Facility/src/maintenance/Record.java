package maintenance;

public class Record extends Request {

    String  dateCompleted;
    String  workerName;

    public Record(Request request, String dateCompleted, String workerName) {
      super(request);
      this.dateCompleted = dateCompleted;
      this.workerName = workerName;
    }

    // TODO Calc actual time to repair and reset for issue

    public String toString(){
      return ("Record: [ Completed by: " + this.getWorkerName() +" Requested: " + this.getDateCreated()
  						+ ", Completed: " + this.getDateCompleted() + ", Details: "
  						+ this.getDetails() + " Cost: " + this.getCost()+ " ]");
    }

    public String getDateCompleted() { return this.dateCompleted;}
    public void setDateCompleted(String dateCompleted) { this.dateCompleted = dateCompleted;}
    public String getWorkerName(){ return this.workerName;}
    public void setWorkerName(String workerName){ this.workerName = workerName;}
}

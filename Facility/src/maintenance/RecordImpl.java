package maintenance;

public class RecordImpl extends RequestImpl implements Record {

    String  dateCompleted;
    String  workerName;

    public RecordImpl() { }

    public void setRequest(Request request) {
        details = request.getDetails();
        time = request.getTime();
        cost = request.getCost();
        id = request.getID();
    }



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

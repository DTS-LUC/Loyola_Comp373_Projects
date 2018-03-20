package maintenance;

public interface Record extends Request {
    public String getDateCompleted();
    public void setDateCompleted(String dateCompleted);
    public String getWorkerName();
    public void setWorkerName(String workerName);
    public void setRequest(Request request);
}

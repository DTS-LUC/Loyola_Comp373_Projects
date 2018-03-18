package maintenance;

public interface Issue {
    public String getDetails();
    public void setDetails(String details);
    public long getTime();
    public void setTime(long time);
    public long getCost();
    public void setCost(long cost);
    public String getID();
    public void setID(String id);
}

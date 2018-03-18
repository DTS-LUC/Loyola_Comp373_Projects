package maintenance;

import java.text.SimpleDateFormat;

public interface Request extends Issue {
    public void setSimpleDateFormat(SimpleDateFormat sdf);
    public SimpleDateFormat getSimpleDateFormat();
    public void setDateCreated(String created);
    public String getDateCreated();
    public boolean isComplete();
    public void setComplete();
    public void setIncomplete();
    public void setIssue(Issue issue);
}

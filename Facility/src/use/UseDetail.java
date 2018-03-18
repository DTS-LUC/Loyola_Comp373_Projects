package use;

import java.text.ParseException;

public interface UseDetail {
    public void setStart(String start);
    public String getStart();
    public void setEnd(String end);
    public String getEnd();
    public double getDuration() throws ParseException;
    public void setName(String name);
    public String getName();
    public void setInfo(String info);
    public String getInfo();
}

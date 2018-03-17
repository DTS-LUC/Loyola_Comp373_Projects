package use;

import facility.FacilityDetail;

import java.text.ParseException;
import java.util.List;

public interface Use extends FacilityDetail{
    public boolean objectIsInUseDuringInterval(String start, String end) throws ParseException;
    public void assignFacilityToUse(String start, String end, String name, String info) throws ParseException;
    public void removeObjectsDuringInterval(String start, String end) throws ParseException;
    public void performInspection(String start, String end, String inspector, String info);
    public List<Inspection> listInspections();
    public List<UseDetail> listActualUsage();
    public double calcUsageRate() throws ParseException;
}

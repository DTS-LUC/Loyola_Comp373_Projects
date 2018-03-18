package use;

import facility.FacilityDetail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public interface Use{
    public void setSimpleDateFormat(SimpleDateFormat sdf);
    public SimpleDateFormat getSimpleDateFormat();
    public void setUseDetails(List<UseDetail> useDetails);
    public List<UseDetail> getUseDetails();
    public void setInspections(List<Inspection> inspections);
    public List<Inspection> getInspections();
    public void assignFacilityToUse(UseDetail reservation) throws ParseException;
    public boolean objectIsInUseDuringInterval(String start, String end) throws ParseException;
    public void removeObjectsDuringInterval(String start, String end) throws ParseException;
    public void performInspection(Inspection inspect);
    public double calcUsageRate() throws ParseException;
}

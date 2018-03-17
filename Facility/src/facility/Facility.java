package facility;

import maintenance.Maintenance;

import java.text.ParseException;
import java.util.List;

public interface Facility extends Maintenance{
    public List<Facility> getFacility();
    public void setFacility(List<Facility> facilities);
    public int numFacilities();
    public void addNewFacility(Facility subFacility);
    public void removeFacility(Facility subFacility);
    public void vacateFacility(String start, String end) throws ParseException;
    public long totalMaintenanceCost();
    public double avgTotalProblemRate();

}

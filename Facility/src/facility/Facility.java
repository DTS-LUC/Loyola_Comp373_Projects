package facility;

import maintenance.Maintenance;
import use.UseDetail;

import java.text.ParseException;
import java.util.List;

public interface Facility extends Maintenance, Use{
    public List<Facility> getFacility();
    public void setFacility(List<Facility> facilities);
    public int numFacilities();
    public void addNewFacility(Facility subFacility);
    public void removeFacility(Facility subFacility);
    public void vacateFacility(UseDetail vacate) throws ParseException;
    public long totalMaintenanceCost();
    public double avgTotalProblemRate();

}

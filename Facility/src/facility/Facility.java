package facility;

import maintenance.Maintenance;
import use.Use;
import use.UseDetail;

import java.text.ParseException;
import java.util.List;

public interface Facility extends Maintenance, Use, FacilityDetail{
		public void setFacilityDetails(FacilityDetail details);
		public FacilityDetail getFacilityDetails();
		public List<Facility> getFacility();
    public void setFacility(List<Facility> facilities);
		public void setMaintenance(Maintenance maintenance);
		public Maintenance getMaintenance();
		public void setUse(Use use);
		public Use getUse();
    public int numFacilities();
    public void addNewFacility(Facility subFacility);
    public void removeFacility(Facility subFacility);
    public void vacateFacility(UseDetail vacate) throws ParseException;
    public long totalMaintenanceCost();
    public double avgTotalProblemRate();
	public double calcProblemRate();
}

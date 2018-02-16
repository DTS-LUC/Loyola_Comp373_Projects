package use;

import java.util.List;

import facility.FacilityDetail;

public class Use extends FacilityDetail{
	//TODO
	public List<UseDetail> usageHistory;
	public List<Inspection> inspections;
	
	public Use(String name, String info, int capacity) {
		super(name, info, capacity);
		// TODO Auto-generated constructor stub
	}
}

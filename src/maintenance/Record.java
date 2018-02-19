package maintenance;

import java.util.Date;

public class Record extends Request {

    private Date maintenanceDate;

    public Record(Request request) {
        super(request);
        maintenanceDate = new Date();
        this.complete = true;
        this.dateCreated = request.dateCreated;
        this.scheduledDate = request.scheduledDate;
        facility.getFacilityMaintenance().removeIssue(request);
    }

    public Date getMaintenanceDate() { return maintenanceDate; }
}

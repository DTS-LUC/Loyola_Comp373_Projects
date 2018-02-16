import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FacilityUnit {
    private String id;
    private int capacity;
    private List<FacilityUnit> subUnits = new ArrayList<FacilityUnit>();

    public FacilityUnit(String id) {
        this.id = id;
    }

    public List<FacilityUnit> getSubUnits() { return subUnits; }

    public void addSubUnits(FacilityUnit... units) { subUnits.addAll(Arrays.asList(units)); }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
}
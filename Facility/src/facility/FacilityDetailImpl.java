package facility;

public class FacilityDetailImpl {
	private String	name;
	private String 	info;
	private int			capacity;

	public FacilityDetailImpl() {}

	public void setName(String name){
		this.name = name;
		return;
	}

	public String getName(){
		return this.name;
	}

	public void setInfo(String info){
		this.info = info;
		return;
	}

	public String getInfo(){
		return this.info;
	}

	public void setCapacity(int capacity){
		this.capacity = capacity;
		return;
	}

	public int getCapacity(){
		return this.capacity;
	}
}

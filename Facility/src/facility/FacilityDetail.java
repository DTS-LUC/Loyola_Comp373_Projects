package facility;

public class FacilityDetail {
	private String	name;
	private String 	info;
	private int			capacity;
	private long		id;

	public FacilityDetail(String name, String info, int capacity) {
		this.name 		= name;
		this.info 		= info;
		this.capacity = capacity;
		// TODO Generate sufficently random ID
		// this.id = ;
	}

	public void setName(name){
		this.name = name;
		return;
	}

	public String getName(){
		return this.name;
	}

	public void setInfo(info){
		this.info = info;
		return;
	}

	public String getInfo(){
		return this.info;
	}

	public void setCapacity(capacity){
		this.capacity = capacity;
		return;
	}

	public int getCapacity(){
		return this.capacity;
	}
}

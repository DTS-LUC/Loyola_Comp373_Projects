package use;

public class UseDetail {

	private String start;
	private String end;
	private String name;
	private String info;

	public UseDetail(String start, String end, String name, String info){
		this.start	= start;
		this.end		=	end;
		this.name 	= name;
		this.info 	= info;
	}

	public void setStart(String start){
		this.start 	= start;
		return;
	}

	public String getStart(){
		return this.start;
	}

	public void setEnd(String end){
		this.end = end;
		return;
	}

	public String getEnd(){
		return this.end;
	}

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
}

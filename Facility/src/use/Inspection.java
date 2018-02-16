package use;

import java.time.LocalDateTime;

public class Inspection {

	private LocalDateTime time;
	private String 				inspector;
	private String 				info;

	public Inspection(String time, String inspector, String info){
		this.time 			=	time;
		this.inspector	=	inspector;
		this.info				=	info;
	}

	public void setTime(time){
		this.time = time;
		return;
	}

	public LocalDateTime getTime(){
		return this.time;
	}

	public void setInspector(inspector){
		this.inspector = inspector;
		return;
	}

	public String getInspector(){
		return this.inspector;
	}

	public void setInfo(info){
		this.info = info;
		return;
	}

	public String getInfo(){
		return this.info;
	}
}

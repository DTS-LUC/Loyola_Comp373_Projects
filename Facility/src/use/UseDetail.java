package use;

import java.time.LocalDateTime;

public class UseDetail {

	public class Inspection {

		private LocalDateTime time;
		private String name;
		private String info;

		public Inspection(LocalDateTime time, String name, String info){
			this.time = time;
			this.name = name;
			this.info = info;
		}

		public void setTime(time){
			this.time = time;
			return;
		}

		public LocalDateTime getTime(){
			// NOTE: Could also convert to string here
			return this.time
		}

		public void setName(name){
			this.name = name;
			return;
		}

		public String getName(){
			return this.name
		}

		public void setInfo(info){
			this.info = info;
			return;
		}

		public String getInfo(){
			return this.info
		}
	}

}

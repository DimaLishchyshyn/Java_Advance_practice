package ua.lviv.igs;

public class Time {

	private int hour;
	private int min;
	
	public Time() {};
	

	public Time(int hour, int min) throws TimeException {
		super();
		if ((hour >= 0 && hour < 24) && (min >= 0 && min < 60)) {
			this.hour = hour;
			this.min = min;
		}else {
			throw new TimeException();
		}
		

	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return hour + ":" + min;
	}
	
	
}



 @SuppressWarnings("serial")
class TimeException extends Exception {

	static String massage = "Введений час має бути від 0 до 24 для годин та від 0 до 60 для хвилин!";

	public TimeException() {
		super(massage);
	}

}

package ua.lviv.igs;

public class Seance {

	private Movie movie;
	private static Time startTime;
	private Time endTime;
	
	public static Time addEndTime(Time starTime, Time duration) throws TimeException {
		
		int hour = startTime.getHour() + duration.getHour();
		int min = startTime.getMin() + duration.getMin();
		 
		if(min > 60) { 
			hour++;
			min= min - 60;
		}
		return new Time(hour,min);
	
		}
	
	@SuppressWarnings("static-access")
	public Seance(Movie movie, Time startTime) throws TimeException {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = addEndTime(startTime, movie.getDuration());
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	@SuppressWarnings("static-access")
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Прем'єра: " + movie + "\n Початок в " + startTime + ", закінчується " + endTime + ".";
	}

}

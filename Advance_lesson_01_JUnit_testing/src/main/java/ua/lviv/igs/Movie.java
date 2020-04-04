package ua.lviv.igs;

public class Movie {

	public static Object movieSet;
	private String title;
	private Time duration;

	public Movie(String title, Time duration) {
		super();
		this.title = title;
		this.duration = duration;
	}

	public Movie(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "\n Назва кінострічки: " + title + "\n Час відтворення: " + duration.toString();
	}

}

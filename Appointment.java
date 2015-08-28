class Appointment {
	private String date;
	private int duration;
	Appointment(String date, int duration) {
		this.date = date;
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public int getDuration() {
		return duration;
	}

	public String toString() {
		return (date + "   " + duration);
	}


}
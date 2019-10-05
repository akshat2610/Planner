import java.lang.Math;

public class TimeOfDay implements Comparable<TimeOfDay>{
	/**
		@param hours hour of the day
		@param minutes minute of the day
		@param seconds second of the day
		@precondition hours >= 0 && hours <= 23
		@precondition minutes >= 0 && minutes <= 59
		@precondition seconds >= 0 && seconds <= 59
	*/
	public TimeOfDay(int hours, int minutes, int seconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
		returns a TimeOfDay object that is the given number of seconds away from the current object
		@param seconds the number of seconds to be added 
		@return a TimeOfDay object that is the given number of seconds away from the current object
		@precondition seconds > 0
	*/
	public TimeOfDay addSeconds(int seconds){
		int newDayHours = this.hours;
		int newDayMinutes = this.minutes;
		int newDaySeconds = this.seconds + Math.abs(seconds);

		newDayMinutes += newDaySeconds / SECONDS_PER_MINUTE;
		newDayHours += newDayMinutes / MINUTES_PER_HOUR;
		newDaySeconds %= SECONDS_PER_MINUTE;
		newDayMinutes %= MINUTES_PER_HOUR;

		if (newDayHours >= HOURS_PER_DAY) newDayHours -= HOURS_PER_DAY;

		return new TimeOfDay(newDayHours, newDayMinutes, newDaySeconds);
	}

	/**
		returns the absolute difference in seconds between this and the other TimeOfDay object for the same day.
		@param other another TimeOfDay object
		@return the absolute difference in seconds between this and the other object.
		Note: It returns the difference in times of the same day. 
	*/
	public int secondsFrom(TimeOfDay other){
		int otherTimeInSeconds = other.hours * MINUTES_PER_HOUR * SECONDS_PER_MINUTE 
								+ other.minutes * SECONDS_PER_MINUTE 
								+ other.seconds;
		int totalTimeInSeconds = hours * MINUTES_PER_HOUR * SECONDS_PER_MINUTE 
								+ minutes * SECONDS_PER_MINUTE 
								+ seconds;

		return Math.abs(totalTimeInSeconds - otherTimeInSeconds);
	}

	/**
		returns the hour of the day
		@return hours
	*/
	public int getHours(){
		return hours;
	}

	/**
		returns the minute of the day
		@return minutes;
	*/
	public int getMinutes(){
		return minutes;
	}

	/**
		returns the second of the day
		@return seconds
	*/
	public int getSeconds(){
		return seconds;
	}

	/**
		returns the time of day in 24-hour format
		@return time in 24-hour format
	*/
	@Override
	public String toString(){
		String time = "";

		if (hours < 10) time += "0";
		time += hours + ":";
		if (minutes < 10) time += "0";
		time += minutes + ":";
		if (seconds < 10) time += "0";
		time += seconds;

		return time;
	}

	public int compareTo(TimeOfDay otherTimeOfDay){
		if (hours == otherTimeOfDay.getHours()){
			if (minutes == otherTimeOfDay.getMinutes())
				return seconds - otherTimeOfDay.getSeconds();
			return minutes - otherTimeOfDay.getMinutes();
		}
		return hours - otherTimeOfDay.getHours();
	}

	@Override
	public boolean equals(Object obj){
		TimeOfDay otherTimeOfDay = (TimeOfDay)obj;
		return this.compareTo(otherTimeOfDay) == 0;
	}


	public final static short SECONDS_PER_MINUTE = 60;
	public final static short MINUTES_PER_HOUR = 60;
	public final static short HOURS_PER_DAY = 24;
	private int hours;
	private int minutes;
	private int seconds;
}
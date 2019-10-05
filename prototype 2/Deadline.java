import java.util.TreeSet;

public class Deadline implements Comparable<Deadline>{
	/**
		Constructs a deadline with a given day and time of day
		@param day a day
		@param time a time of the day
	*/
	public Deadline(Day day, TimeOfDay time){
		this.day = day;
		this.time = time;
	}

	/**
		returns the day of the deadline
		@return day of the deadline
	*/
	public Day getDay(){
		return day;
	}

	/**
		returns time of the day of the deadline
		@return the time of the day of the deadline
	*/
	public TimeOfDay getTimeOfDay(){
		return time;
	}

	/**
		returns 
			a positive value if this deadline is after the other deadline
			a negative value if this deadline is before the other deadline
			0 if both the deadlines are the same
		@return positive integer, negative integer, or 0
	*/
	public int compareTo(Deadline otherDeadline){
		if (day.compareTo(otherDeadline.getDay()) == 0)
			return time.compareTo(otherDeadline.getTimeOfDay());
		return day.compareTo(otherDeadline.getDay());
	}

	@Override
	public boolean equals(Object obj){
		Deadline otherDeadline = (Deadline)obj;
		return this.compareTo(otherDeadline) == 0;
	}

	@Override
	public String toString(){
		return day.toString() + " " + time.toString();
	}

	public static void main(String[] args){
		Day day1 = new Day (2019, 10, 3);
		Day day2 = new Day (2019, 10, 4);
		Day day3 = new Day (2018, 12, 31);

		TimeOfDay time = new TimeOfDay(8, 0, 0);
		TimeOfDay time2 = new TimeOfDay(7, 59, 59);

		Deadline deadline1 = new Deadline(day1, time);
		Deadline deadline2 = new Deadline(day2, time);
		Deadline deadline3 = new Deadline(day2, time2);
		Deadline deadline4 = new Deadline(day3, time);

		TreeSet<Deadline> deadlines = new TreeSet<>();
		deadlines.add(deadline1);
		deadlines.add(deadline2);
		deadlines.add(deadline3);
		deadlines.add(deadline4);

		for (Deadline deadline: deadlines)
			System.out.println(deadline);
	}

	private Day day;
	private TimeOfDay time;
}
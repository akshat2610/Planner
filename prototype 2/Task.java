import java.util.TreeSet;

public class Task implements Comparable<Task>{
	/**
		Constructs a task with the given name, deadline, priority, and number of hours required to complete the task
		@param name name of the task
		@param deadline deadline of the task
		@param priority priority of the task
		@param numHrsReqd estimated number of hours required to complete the task
	*/
	public Task(String name, Deadline deadline, int priority, int numHrsReqd){
		this.name = name;
		this.deadline = deadline;
		this.priority = priority;
		this.numHrsReqd = numHrsReqd;
	}

	/**
		returns the name of the task
		@return name of the task
	*/
	public String getName(){
		return name;
	}

	/**
		returns the deadline of the task
		@return the deadline of the task
	*/
	public Deadline getDeadline(){
		return deadline;
	}

	/**
		returns the priority of the task
		@return the priority of the task
	*/
	public int getPriority(){
		return priority;
	}

	/**
		returns the number of hours required to complete the task
		@return the number of hours required to complete the task
	*/
	public int getNumHrsReqd(){
		return numHrsReqd;
	}

	public int compareTo(Task otherTask){
		if (priority == otherTask.getPriority())
			return deadline.compareTo(otherTask.getDeadline());
		return otherTask.getPriority() - priority;
	}

	@Override
	public boolean equals(Object obj){
		Task otherTask = (Task)obj;
		return this.compareTo(otherTask) == 0 &&
				name.equals(otherTask.getName()) && 
				numHrsReqd == otherTask.getNumHrsReqd();
	}

	public static void main(String[] args){
		// Day day1 = new Day (2019, 10, 6);
		// Day day2 = new Day (2019, 10, 7);
		// Day day3 = new Day (2019, 10, 9);
		// TimeOfDay time = new TimeOfDay(23, 59, 59);

		// Deadline deadline1 = new Deadline(day1, time);
		// Deadline deadline2 = new Deadline(day2, time);
		// Deadline deadline3 = new Deadline(day3, time);

		// Task cs174HW = new Task("CS 174 HW 4", deadline1, 2, 6);
		// Task laundry = new Task("Laundry", deadline1, 1, 1);
		// Task cs151HW = new Task("CS 151 HW 3", deadline2, 2, 6);
		// Task cs157HW = new Task("CS 157 HW 2", deadline3, 2, 6);

		// TreeSet<Task> tasks = new TreeSet<>();
		// tasks.add(cs174HW);
		// tasks.add(cs151HW);
		// tasks.add(cs157HW);
		// tasks.add(laundry);

		Day day1 = new Day (2019, 10, 7);
		Day day2 = new Day (2019, 10, 13);
		Day day3 = new Day (2019, 10, 9);
		TimeOfDay time = new TimeOfDay(23, 59, 59);

		Deadline deadline1 = new Deadline(day1, time);
		Deadline deadline2 = new Deadline(day2, time);
		Deadline deadline3 = new Deadline(day3, time);
		Deadline deadline4 = new Deadline(day2, time);

		Task cs151= new Task("CS 151 HW 4", deadline1, 2, 5);
		Task cs157a= new Task("CS 157", deadline3, 3, 3); 
		Task cs149lec = new Task("CS 149 read lecture", deadline2, 5, 20);
		Task cs149hw = new Task("CS 149 submit prog", deadline4, 4, 2);

		TreeSet<Task> tasks = new TreeSet<>();
		tasks.add(cs151);
		tasks.add(cs157a);
		tasks.add(cs149lec);
		tasks.add(cs149hw);

		for (Task task: tasks)
			System.out.println(task.getName());
	}


	private String name;
	private Deadline deadline;
	private int priority;
	private int numHrsReqd;
}
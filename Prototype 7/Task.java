/**
 * Models a task on 
 * @author Akshat Bansal
*/
public class Task implements Record{
	/**
	 * Constructs a task record
	 * @param name name of the task
	 * @param category category of the task
	 * @param numHrsSpent number of hours worked on the task
	 * @param numHrsLeft number of hours still to work 
	 * @param priority priority of the task 
	 * @param deadline deadline of the task
	 * @param note optional note for the task
	*/
	public Task(String name, String category, int numHrsSpent, int numHrsLeft, String priority, String deadline, String note){
		this.name = name;
		this.category = category;
		this.numHrsSpent = numHrsSpent;
		this.numHrsLeft = numHrsLeft;
		this.priority = priority;
		this.deadline = deadline;
		this.note = note;
	}

	/**
	 * Returns the name of the task
	 * @return name of the task
	*/
	public String getName(){
		return name;
	}

	/**
	 * Returns the category of the task
	 * @return category of the task
	*/
	public String getCategory(){
		return category;
	}

	/**
	 * Returns the number of hours spent on the task
	 * @return number of hours spent on the task
	*/
	public int getHrsSpent(){
		return numHrsSpent;
	}

	/**
	 * Returns the number of hours left to work on the task
	 * @return number of hours left to work on the task
	*/
	public int getHrsLeft(){
		return numHrsLeft;
	}

	/**
	 * Returns the priority of the task
	 * @return priority of the task
	*/
	public String getPriority(){
		return priority;
	}

	/**
	 * Returns the deadline of the task
	 * @return deadline
	*/
	public String getDeadline(){
		return deadline;
	}

	/**
	 * Returns the optional note associated with the task
	 * @return optional note associated with the task
	*/
	public String getNote(){
		return note;
	}

	public void print(){
		System.out.println("TASK NAME:   " + name);
		System.out.println("CATEGORY:    " + category);
		System.out.println("#hrs spent:  " + numHrsSpent);
		System.out.println("#hrs to work:" + numHrsLeft);
		System.out.println("priority:    " + priority);
		System.out.println("deadline:    " + deadline);
		System.out.println("Note:        " + note);
	}

	private String name;
	private String category;
	private int numHrsSpent;
	private int numHrsLeft;
	private String priority;
	private String deadline;
	private String note;
}
/**
 * Models a task on
 * @author Akshat Bansal
*/
public class Task extends Activity implements java.io.Serializable, Comparable<Task>{
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
		super(name, category, numHrsSpent, note);
		this.numHrsLeft = numHrsLeft;
		this.priority = priority;
		this.deadline = deadline;
	}

	public Task(){
		//default constructor
	}

	@Override
	/**
	 * Adds more #hrs spent on the task and reduces the #hrs left to finish the task
	 * @param numHrs
	*/
	public void investHrs(int numHrs){
		super.investHrs(numHrs);
		numHrsLeft -= numHrs;
	}

	public void incrementHrsReqd(int hrs){
		numHrsLeft += hrs;
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

	public int compareTo(Task otherTask){
		/**
		String[] currentTaskDeadline = deadline.split("-");
		String[] otherTaskDeadline = otherTask.getDeadline().split("-");
		**/
		return 1;
	}


	public void print(){
		System.out.println("TASK NAME:   " + getName());
		System.out.println("CATEGORY:    " + getCategory());
		System.out.println("#hrs spent:  " + getHrsSpent());
		System.out.println("#hrs to work:" + numHrsLeft);
		System.out.println("priority:    " + priority);
		System.out.println("deadline:    " + deadline);
		System.out.println("Note:        " + getNote());
	}

	public static final double IMPORTANCE_WEIGHT = 0.8;
	public static final double URGENCY_WEIGHT = 0.2;

	private int numHrsLeft;
	private String priority;
	private String deadline;
}

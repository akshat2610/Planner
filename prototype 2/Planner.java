import java.util.Set;
import java.util.TreeSet;

public class Planner{
	/**
		Constructs a planner with workload = number of hours per week
		@param numHoursPerWeek number of hours the user wants to work in a week
	*/
	public Planner(int numHoursPerWeek){
		tasks = new TreeSet<>();
		this.numHoursPerWeek = numHoursPerWeek;
	}

	/**
		The algorithm should maximize some weighted product of the priority and the num of hours
		within the given wrokload limit. 
		Case 1: A very important task with a lot of hours required VS multiple less important tasks as
				they require less hours. 
		Case 2: 
	*/


	private Set<Task> tasks;
	private int numHoursPerWeek;
}
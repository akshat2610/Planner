import java.io.*;
/**
 * Models a task writer
 * @author Akshat Bansal
*/
public class TaskWriter{
	/**
	 * Constructs a task writer from a print writer
	 * @param thePrintWriter the print writer
	*/
	public TaskWriter(PrintWriter thePrintWriter){
		this.thePrintWriter = thePrintWriter;
	}

	/**
	 * Writes a task to the printwriter stream
	 * @param task the task to be written
	*/
	public void writeTask(Task task) throws IOException{
		thePrintWriter.println(task.getName());
		thePrintWriter.println(task.getCategory());
		thePrintWriter.println(task.getHrsSpent());
		thePrintWriter.println(task.getHrsLeft());
		thePrintWriter.println(task.getPriority());
		thePrintWriter.println(task.getDeadline());
		thePrintWriter.println(task.getNote());
		thePrintWriter.println();
	}

	private PrintWriter thePrintWriter;
}
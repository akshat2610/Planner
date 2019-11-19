import java.io.*;
/**
 * Models an activity writer
 * @author Akshat Bansal
*/
public class ActivityWriter{
	/**
	 * Constructs an activity writer from a print writer
	 * @param thePrintWriter the print writer
	*/
	public ActivityWriter(PrintWriter thePrintWriter){
		this.thePrintWriter = thePrintWriter;
	}

	/**
	 * Writes an activity to the printwriter stream
	 * @param activity the activity to be written
	*/
	public void writeActivity(Activity activity) throws IOException{
		thePrintWriter.println(activity.getName());
		thePrintWriter.println(activity.getCategory());
		thePrintWriter.println(activity.getHrsSpent());
		thePrintWriter.println(activity.getNote());
		thePrintWriter.println();
	}

	private PrintWriter thePrintWriter;
}
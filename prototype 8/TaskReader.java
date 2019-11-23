import java.io.*;
/**
 * Models a task reader class
 * @author Akshat Bansal
*/
public class TaskReader{
	/**
	 * Constructs a task reader from the given buffered reader
	 * @param theBufferedReader the buffered reader
	*/
	public TaskReader(BufferedReader theBufferedReader){
		this.theBufferedReader = theBufferedReader;
	}

    public Task readRecord() throws IOException{
    	String name = theBufferedReader.readLine();
    	if (name == null) return null;
    	String category = theBufferedReader.readLine();
    	int numHrsSpent = Integer.parseInt(theBufferedReader.readLine());
    	int numHrsLeft = Integer.parseInt(theBufferedReader.readLine());
    	String priority = theBufferedReader.readLine();
    	String deadline = theBufferedReader.readLine();
    	String note = theBufferedReader.readLine();
        //skip the space
        theBufferedReader.readLine();
    	return new Task(name, category, numHrsSpent, numHrsLeft, priority, deadline, note);
    }

	private BufferedReader theBufferedReader;
}
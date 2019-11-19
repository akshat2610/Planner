import java.io.*;
/**
 * Models a task reader class
 * @author Akshat Bansal
*/
public class ActivityReader{
	/**
	 * Constructs a task reader from the given buffered reader
	 * @param theBufferedReader the buffered reader
	*/
	public ActivityReader(BufferedReader theBufferedReader){
		this.theBufferedReader = theBufferedReader;
	}

    public Activity readRecord() throws IOException{
    	String name = theBufferedReader.readLine();
    	if (name == null) return null;
    	String category = theBufferedReader.readLine();
    	int numHrsSpent = Integer.parseInt(theBufferedReader.readLine());
    	String note = theBufferedReader.readLine();
    	theBufferedReader.readLine();
    	return new Activity(name, category, numHrsSpent, note);
    }

	private BufferedReader theBufferedReader;
}
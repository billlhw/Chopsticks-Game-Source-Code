package Game;
/*
 * A class responsible for creation of the stop watch and calculation of the time passed.
 */
public class Stopwatch {
	private long startTime = 0;
	  private long stopTime = 0;
	  private boolean running = false;//Initializes the variables

	  public void start() {
	    startTime = System.currentTimeMillis();
	    
	  }

	  public void stop() {
	    stopTime = System.currentTimeMillis();
	   
	  }
	
	  public long getElapsedTime() {
		    long elapsed;
		   
		      elapsed = ((stopTime - startTime) / 1000);
		    return elapsed;//Turns the time elapsed from milliseconds to seconds. 
		  }
	}



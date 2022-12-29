package net.pgfmc.startq;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import net.pgfmc.startq.actions.Backup;
import net.pgfmc.startq.actions.QuickFiles;
import net.pgfmc.startq.actions.Update;
import net.pgfmc.startq.util.OutputWindow;

public class Main {
	
	public static final OutputWindow WINDOW = new OutputWindow(); // The display window
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");
	public static String BACKUP_DIRECTORY;
	
	public static void main(String args[]) throws InterruptedException
	{
		
		if (args.length != 1)
		{
			WINDOW.put("Backup directory not found!");
			WINDOW.put("Please only put the backup directory in the JVM Arguments");
			
			WINDOW.put("Closing in 5 seconds...");
			TimeUnit.SECONDS.sleep(5);
			
			System.exit(1); // Turns the program off with error code 1
		}
		
		BACKUP_DIRECTORY = new File(args[0]).getAbsolutePath();
		
		// Gets all server jars in the working directory, error if none
		String[] jarsInWorkingDirectory = new File(WORKING_DIRECTORY).list((directory, filename) -> filename.equals("server.jar"));
		for (String file : new File(WORKING_DIRECTORY).list())
		{
			System.out.println(file);
		}
		
		if (jarsInWorkingDirectory == null)
		{
			WINDOW.put("No server found!");
			WINDOW.put("Place StartQ.jar in the working directory of the server.");
			
			WINDOW.put("Closing in 5 seconds...");
			TimeUnit.SECONDS.sleep(5);
			
			System.exit(2); // Turns the program off with error code 2
		}
		
		WINDOW.put("Working directory: " + WORKING_DIRECTORY);
		WINDOW.put("Backup directory: " + BACKUP_DIRECTORY);
		
		new Backup(); // Runs first
		new QuickFiles(); // Runs second
		try { new Update(); } catch (MalformedURLException e) { e.printStackTrace(); } // Runs third
		
		WINDOW.put("Done! Closing in 5 seconds...");
		TimeUnit.SECONDS.sleep(5);
		
		System.exit(0); // Turns the program off with no error code
		
	}
	
}

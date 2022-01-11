package net.pgfmc.startq;

import java.io.File;

public class Main {
	
	public static final String workingDir = System.getProperty("user.dir"); // The working directory
	
	public static ID id = ID.START;
	
	public static void main(String args[])
	{
		System.out.println("Working directory: " + workingDir);
		
		// Currently useless, but plan to be cool in the future
		Frame frame = new Frame();
		frame.createFrame();
		
		new StatusManager().run(frame);
	}
	
	/**
	 * Makes any directories that don't exist
	 */
	public static void mkDirs()
	{
		for (ID id : ID.values())
		{
			new File(id.getPath()).mkdirs();
			System.out.println("Path created for " + id.getName() + ": " + id.getPath());
		}
	}
	
}

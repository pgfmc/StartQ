package net.pgfmc.startq;

import net.pgfmc.startq.functions.UpdatePlugins;

public class StatusManager {
	
	public void run(Frame frame)
	{
		while (frame.getProgress() < 100)
		{
			System.out.println("Start ID: " + Main.id.getName());
			switch (Main.id) {
			case START:
				Main.mkDirs();
				break;
			case PLUGINS:
				UpdatePlugins.update();
				break;
			case BACKUPS:
				break;
			case DONE:
				frame.addProgress(1);
				break;
			default:
				frame.addProgress(1);
				break;
			}
			
			System.out.println("Finished ID: " + Main.id.getName());
			Main.id = Main.id.next();
		}
		
		System.out.println("Closing the program.");
		System.exit(0); // Turns the program off
	}

}

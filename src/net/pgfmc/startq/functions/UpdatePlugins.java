package net.pgfmc.startq.functions;

import java.io.File;

import net.pgfmc.startq.Main;
import net.pgfmc.startq.util.CopyDirectory;

public class UpdatePlugins {
	
	public static void update()
	{
		CopyDirectory.copy(new File(Main.id.getPath()), new File(Main.workingDir + File.separator + "plugins"));
		System.out.println("Done updating plugins!");
	}
}

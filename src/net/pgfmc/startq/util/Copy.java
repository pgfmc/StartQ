package net.pgfmc.startq.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.stream.Stream;

import net.pgfmc.startq.Main;

public class Copy {
	
	public static void copyDirectory(File source, File dest)
	{
		try {
			dest.mkdirs();
			source.mkdirs();
			
			Path sourceDirectory = source.toPath();
			Path destDirectory = dest.toPath();
			
			Main.WINDOW.put("Starting copy operation: " + sourceDirectory.toAbsolutePath().toString() + " to " + destDirectory.toAbsolutePath().toString() + " ...");
			
			try (Stream<Path> tree = Files.walk(sourceDirectory)) {
			    Iterator<Path> i = tree.iterator();
			    while (i.hasNext()) {
			        Path sourceFile = i.next();
			        Path destFile = destDirectory.resolve(sourceDirectory.relativize(sourceFile));
			        try {
				        if (Files.isDirectory(sourceFile)) {
				            Files.createDirectories(destFile);
				        } else {
				            Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
				            Main.WINDOW.put("Copied file: " + sourceFile.getFileName());
				            sourceFile.toFile().deleteOnExit();
				        }
			        } catch (IOException e)
			        {
			        	e.printStackTrace();
			        }
			    }
			}
			
		} catch (IOException e) {
			Main.WINDOW.put("Hit a roadblock; could not copy files.");
			e.printStackTrace();
		}
		
		Main.WINDOW.put("Finished copy operation!");
	}

}

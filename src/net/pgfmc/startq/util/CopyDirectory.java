package net.pgfmc.startq.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.stream.Stream;

public class CopyDirectory {
	
	public static void copy(File source, File dest)
	{
		try {
			dest.mkdirs(); // Just in case or for testing
			source.mkdirs();
			
			/*
			 * Copy all files and directories from source to dest
			 * Copied this code from someplace lol
			 */
			Path sourcePath = source.toPath();
			Path destPath = dest.toPath();
			
			// Don't ask me how this works lmao
			try (Stream<Path> tree = Files.walk(sourcePath)) {
			    Iterator<Path> i = tree.iterator();
			    while (i.hasNext()) {
			        Path sourceTemp = i.next();
			        Path destTemp = destPath.resolve(sourcePath.relativize(sourceTemp));
			        try {
				        if (Files.isDirectory(sourceTemp)) {
				            Files.createDirectories(destTemp);
				        } else {
				            Files.copy(sourceTemp, destTemp, StandardCopyOption.REPLACE_EXISTING);
				            System.out.println("Successfully copied over file: " + sourceTemp.getFileName());
				        }
			        } catch (IOException e)
			        {
			        	e.printStackTrace();
			        }
			    }
			}
			
		} catch (IOException e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
		
		System.out.println("Done copying files.");
	}

}

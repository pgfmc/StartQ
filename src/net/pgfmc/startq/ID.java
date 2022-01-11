package net.pgfmc.startq;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * enums that tell a function where to look for its work folder
 * 
 * @author bk
 */
public enum ID {
	START(""), // Starting
	PLUGINS("startQ" + File.separator + "plugins"),
	BACKUPS(""), // TODO
	DONE(""); // Turns the program off
	
	String path;
	
	private ID(String path)
	{
		this.path = path;
	}
	
	/**
	 * Get the name of the id
	 * @return
	 */
	public String getName()
	{
		return toString().toLowerCase();
	}
	
	/**
	 * Sets the next ID after this on
	 * 
	 * @return the next ID
	 */
	public ID next()
	{
		ID[] values = ID.values();
		List<ID> valuesList = Arrays.asList(values);
		
		return values[Math.min(valuesList.indexOf(this) + 1, valuesList.size() - 1)];
	}
	
	/**
	 * Get the path assigned to this enum
	 * 
	 * @return Path as String
	 */
	public String getPath()
	{
		return Main.workingDir + File.separator + path;
	}
}

package net.pgfmc.startq.api;

public abstract class StartQ {
	
	private static final StartQManager q = new StartQManager();
	
	protected final StartQManager getStartQManager()
	{
		return q;
	}
	
	public void onEnable() {}
	
	public void onDisable() {}
	
}
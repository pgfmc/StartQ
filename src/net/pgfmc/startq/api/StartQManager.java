package net.pgfmc.startq.api;

import java.net.Socket;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import net.pgfmc.startq.Main;
import net.pgfmc.startq.Main.State;
import net.pgfmc.startq.api.events.GenericServerEvent;
import net.pgfmc.startq.api.events.ServerStopEvent;
import net.pgfmc.startq.api.hooks.ServerListener;

public class StartQManager {

	private static Collection<ServerListener> listeners = new HashSet<>();
	
	public final void register(ServerListener listener)
	{
	    listeners.add(listener);
	}
	
	private final void fireEvent(GenericServerEvent event)
	{
	    for(ServerListener listener : listeners)
	    {
	        listener.onEvent(event);
	    }
	}
	
	private final void init() throws InterruptedException
	{
		while(Main.state == Main.State.ONLINE)
		{
			if (isConnected("192.168.1.148", 25565))
			{
				TimeUnit.SECONDS.sleep(10);
				continue;
			}
			
			fireEvent(new ServerStopEvent());
			Main.state = State.OFFLINE;
		}
	}
	
	protected final boolean isConnected(String host, int port)
	{
	    Socket s = null;
	    try
	    {
	        s = new Socket(host, port);
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	    finally
	    {
	        if(s != null)
	            try {s.close();}
	            catch(Exception e){}
	    }
	}
	
}

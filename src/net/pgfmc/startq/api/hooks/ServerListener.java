package net.pgfmc.startq.api.hooks;

import java.util.EventListener;

import net.pgfmc.startq.api.events.GenericServerEvent;

public interface ServerListener extends EventListener {
	abstract void onEvent(GenericServerEvent event);
}

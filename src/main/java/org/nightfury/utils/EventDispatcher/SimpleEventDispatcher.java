package org.nightfury.utils.EventDispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nightfury.utils.events.Event;
import org.nightfury.utils.handlers.EventHandler;

public class SimpleEventDispatcher implements EventDispatcher {

    private final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> handlers = new HashMap<>();

    @Override
    public <T extends Event> void registerHandler(Class<T> eventType, EventHandler<T> handler) {
        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler);
    }

    @Override
    public void dispatch(Event event) {
        List<EventHandler<? extends Event>> registeredHandlers = handlers.get(event.getClass());
        if (registeredHandlers != null) {
            for (EventHandler<? extends Event> handler : registeredHandlers) {
                @SuppressWarnings("unchecked")
                EventHandler<Event> typedHandler = (EventHandler<Event>) handler;
                typedHandler.handle(event);
            }
        }
    }
}

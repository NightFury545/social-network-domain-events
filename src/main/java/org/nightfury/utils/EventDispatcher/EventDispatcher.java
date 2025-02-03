package org.nightfury.utils.EventDispatcher;

import java.lang.reflect.InvocationTargetException;
import org.nightfury.utils.events.Event;
import org.nightfury.utils.handlers.EventHandler;

public interface EventDispatcher {

    <T extends Event> void registerHandler(Class<T> eventType, EventHandler<T> handler);

    void dispatch(Event event);
}

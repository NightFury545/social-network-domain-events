package org.nightfury.utils.handlers;

import org.nightfury.utils.events.Event;

public interface EventHandler<T extends Event> {

    void handle(T event);
}

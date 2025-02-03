package org.nightfury.utils.events;

import java.time.LocalDateTime;

public interface Event {
    LocalDateTime occurredOn = LocalDateTime.now();
}

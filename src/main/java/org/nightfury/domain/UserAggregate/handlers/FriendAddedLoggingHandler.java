package org.nightfury.domain.UserAggregate.handlers;

import org.nightfury.domain.UserAggregate.events.FriendRequestAcceptedEvent;
import org.nightfury.services.LoggingService;
import org.nightfury.utils.handlers.EventHandler;

public class FriendAddedLoggingHandler implements EventHandler<FriendRequestAcceptedEvent> {

    private final LoggingService loggingService;

    public FriendAddedLoggingHandler(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void handle(FriendRequestAcceptedEvent event) {
        loggingService.logFriendAdded(event.getSender(), event.getReceiver());
    }
}

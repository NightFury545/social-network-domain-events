package org.nightfury;

import org.nightfury.domain.UserAggregate.User;
import org.nightfury.domain.UserAggregate.events.FriendRequestAcceptedEvent;
import org.nightfury.domain.UserAggregate.events.FriendRequestSentEvent;
import org.nightfury.domain.UserAggregate.handlers.FriendAddedLoggingHandler;
import org.nightfury.domain.UserAggregate.handlers.FriendRequestNotificationHandler;
import org.nightfury.services.LoggingService;
import org.nightfury.services.NotificationService;
import org.nightfury.utils.EventDispatcher.EventDispatcher;
import org.nightfury.utils.EventDispatcher.SimpleEventDispatcher;

public class Main {

    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new SimpleEventDispatcher();

        LoggingService loggingService = new LoggingService();
        NotificationService notificationService = new NotificationService();

        eventDispatcher.registerHandler(FriendRequestSentEvent.class,
            new FriendRequestNotificationHandler(notificationService));
        eventDispatcher.registerHandler(FriendRequestAcceptedEvent.class,
            new FriendAddedLoggingHandler(loggingService));

        User user1 = new User(java.util.UUID.randomUUID(), "Alice");
        User user2 = new User(java.util.UUID.randomUUID(), "Bob");

        user1.sendFriendRequest(user2);
        for (var event : user1.getEvents()) {
            eventDispatcher.dispatch(event);
        }
        user1.clearDomainEvents();

        user2.acceptFriendRequest(user1);
        for (var event : user2.getEvents()) {
            eventDispatcher.dispatch(event);
        }
        user2.clearDomainEvents();
    }
}
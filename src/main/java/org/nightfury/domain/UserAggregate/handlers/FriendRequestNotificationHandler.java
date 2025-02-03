package org.nightfury.domain.UserAggregate.handlers;

import org.nightfury.domain.UserAggregate.events.FriendRequestSentEvent;
import org.nightfury.services.NotificationService;
import org.nightfury.utils.handlers.EventHandler;

public class FriendRequestNotificationHandler implements EventHandler<FriendRequestSentEvent> {

    private final NotificationService notificationService;

    public FriendRequestNotificationHandler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void handle(FriendRequestSentEvent event) {
        notificationService.sendFriendRequestNotification(event.getSender(), event.getReceiver());
    }
}

package org.nightfury.domain.UserAggregate.events;

import org.nightfury.utils.events.Event;

public class FriendRequestAcceptedEvent implements Event {

    private final String sender;
    private final String receiver;

    public FriendRequestAcceptedEvent(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
}

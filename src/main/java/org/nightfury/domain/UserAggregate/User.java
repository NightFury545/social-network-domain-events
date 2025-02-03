package org.nightfury.domain.UserAggregate;

import org.nightfury.domain.UserAggregate.events.*;

import java.util.*;
import org.nightfury.utils.events.Event;

public class User {
    private final UUID id;
    private final String username;
    private final Set<UUID> friends = new HashSet<>();
    private final List<Event> domainEvents = new ArrayList<>();

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<UUID> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public List<Event> getEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void sendFriendRequest(User receiver) {
        if (friends.contains(receiver.getId())) {
            throw new IllegalStateException("You are already friends with " + receiver.getUsername());
        }
        addDomainEvent(new FriendRequestSentEvent(this.id.toString(), receiver.getId().toString()));
    }

    public void acceptFriendRequest(User sender) {
        if (friends.contains(sender.getId())) {
            throw new IllegalStateException("You are already friends with " + sender.getUsername());
        }

        friends.add(sender.getId());
        sender.friends.add(this.id);

        addDomainEvent(new FriendRequestAcceptedEvent(sender.getId().toString(), this.id.toString()));
    }

    private void addDomainEvent(Event event) {
        domainEvents.add(event);
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }
}


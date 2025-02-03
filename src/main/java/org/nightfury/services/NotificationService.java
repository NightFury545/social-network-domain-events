package org.nightfury.services;

public class NotificationService {

    public void sendFriendRequestNotification(String sender, String receiver) {
        System.out.println("NOTIFICATION: " + receiver + ", you have a friend request from " + sender);
    }
}


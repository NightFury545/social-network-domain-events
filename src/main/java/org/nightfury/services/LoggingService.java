package org.nightfury.services;

public class LoggingService {

    public void logFriendAdded(String sender, String receiver) {
        System.out.println("LOG: " + sender + " and " + receiver + " are now friends.");
    }
}


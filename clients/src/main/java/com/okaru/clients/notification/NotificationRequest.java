package com.okaru.clients.notification;

import java.time.LocalDateTime;

public record NotificationRequest(String message, Integer customerId, String customerEmail) {
}

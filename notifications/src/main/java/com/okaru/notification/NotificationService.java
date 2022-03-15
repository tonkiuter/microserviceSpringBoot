package com.okaru.notification;

import com.okaru.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

//    private final NotificationResponse notificationResponse;

    public void sendMessage(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .customerId(notificationRequest.customerId())
                        .CustomerEmail(notificationRequest.customerEmail())
                        .message(notificationRequest.message())
                        .sender("Okaru")
                        .sentAt(LocalDateTime.now())
                        .build()
        );

    }

}

package com.okaru.notification;

import com.okaru.clients.fraud.NotificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

//    private final NotificationResponse notificationResponse;

    public String sendMessage(String msg, Integer customerId){
        notificationRepository.save(
                Notification.builder()
                        .customerId(customerId)
                        .message(msg)
                        .build()
        );

        return msg;
    }

}

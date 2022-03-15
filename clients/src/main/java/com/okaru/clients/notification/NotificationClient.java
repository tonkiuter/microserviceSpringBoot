package com.okaru.clients.notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "notification")
public interface NotificationClient {
//    @PostMapping(path = "api/v1/notification/{msg}/{customerId}")
//    NotificationResponse sendMessage(
//            @PathVariable("msg") String msg, @PathVariable("customerId") Integer customerId);

    @PostMapping(path = "api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}

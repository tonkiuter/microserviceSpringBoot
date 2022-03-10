package com.okaru.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("notification")
public interface NotificationClient {
    @GetMapping(path = "api/v1/notification/{msg}/{customerId}")
    NotificationResponse sendMessage(
            @PathVariable("msg") String msg, @PathVariable("customerId") Integer customerId);
}

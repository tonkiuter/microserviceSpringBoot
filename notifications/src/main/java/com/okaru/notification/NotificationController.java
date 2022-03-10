package com.okaru.notification;


import com.okaru.clients.fraud.NotificationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/notification/")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping(path= "{msg}/{customerId}")
    public NotificationResponse sentMessage(@PathVariable("msg") String msg, @PathVariable("customerId") Integer customerId){

        notificationService.sendMessage(msg, customerId);

        log.info("Message was sent succesfully with " + customerId + " id");

        return new NotificationResponse(msg, customerId);
    }
}

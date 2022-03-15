package com.okaru.notification;


import com.okaru.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

//    My mistake
//    @GetMapping(path= "{msg}/{customerId}")
//    public NotificationRequest sentMessage(@PathVariable("msg") String msg, @PathVariable("customerId") Integer customerId){
//
//        notificationService.sendMessage(msg, customerId);
//
//        log.info("Message was sent succesfully with " + customerId + " id");
//
//        return new NotificationRequest(msg, customerId);
//    }

    @PostMapping
    public void sentNotification(@RequestBody NotificationRequest notificationRequest){

        log.info("New Notification... {} ", notificationRequest);

        notificationService.sendMessage(notificationRequest);
    }
}

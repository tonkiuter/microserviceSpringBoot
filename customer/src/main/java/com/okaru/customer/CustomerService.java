package com.okaru.customer;

import com.okaru.clients.fraud.FraudCheckResponse;
import com.okaru.clients.fraud.FraudClient;
import com.okaru.clients.notification.NotificationClient;
import com.okaru.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    // Dependencia injectada de feign client
    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName() + "-kun")
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        String msg = "not a Fraud";

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("frauster");
        }
            notificationClient.sendNotification(
                    new NotificationRequest(
                            String.format("Hi %s, welcome to Amigoscode Course <3", customer.getFirstName()),
                            customer.getId(),
                            customer.getEmail()
                    )
            );
//        customerRepository.save(customer);
    }



}

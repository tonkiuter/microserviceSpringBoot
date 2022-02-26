package com.okaru.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}

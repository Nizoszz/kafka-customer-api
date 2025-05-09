package com.n1z0.customer_app.domain.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Customer {
    private String customerId;
    private String email;
    private String fullName;
    private String phone;
    private Document document;
    private Address address;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Customer(String customerId, String email, String fullName, String phone, Document document, Address address,
                    LocalDate createdAt, LocalDate updatedAt, LocalDate deletedAt) {
        this.customerId = customerId;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.document = document;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
    public static Customer create(String email, String fullName, String phone, Document document, Address address){
        var customerId = UUID.randomUUID();
        var date = LocalDate.now();
        return new Customer(customerId.toString(), email, fullName, phone, document, address, date, null, null);
    }
}

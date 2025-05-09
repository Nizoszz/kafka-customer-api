package com.n1z0.customer_app.util;

import com.n1z0.customer_app.domain.model.Customer;

public class CustomerFactory {
    public Customer createCustomer(){
        var address = new AddressFactory();
        var document = new DocumentFactory();
        return Customer.create("joselito@mail.com", "Joselito doe", "+5511987653212",document.createCpf(), address.createAddress());
    }
}

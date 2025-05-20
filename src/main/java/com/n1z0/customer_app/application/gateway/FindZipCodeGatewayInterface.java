package com.n1z0.customer_app.application.gateway;

import com.n1z0.customer_app.domain.model.Address;

public interface FindZipCodeGatewayInterface{
    Address findByZipCode(String zipCode);
}

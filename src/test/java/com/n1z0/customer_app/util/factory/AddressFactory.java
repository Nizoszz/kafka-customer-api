package com.n1z0.customer_app.util.factory;

import com.n1z0.customer_app.domain.model.Address;

public class AddressFactory{
    public Address createAddress(){
        return new Address("Rua das Acácias"," 123","Jardim Primavera"," São Paulo","SP", "04567-890");
    }
}

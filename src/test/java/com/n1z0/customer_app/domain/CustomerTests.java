package com.n1z0.customer_app.domain;

import com.n1z0.customer_app.domain.model.Address;
import com.n1z0.customer_app.domain.model.Customer;
import com.n1z0.customer_app.domain.model.Document;
import com.n1z0.customer_app.util.AddressFactory;
import com.n1z0.customer_app.util.CustomerFactory;
import com.n1z0.customer_app.util.DocumentFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerTests{
    private Customer customer;
    private Address address;
    private Document document;
    @BeforeEach
    public void setUp(){
        CustomerFactory customerFactory = new CustomerFactory();
        DocumentFactory documentFactory = new DocumentFactory();
        AddressFactory addressFactory = new AddressFactory();
        customer = customerFactory.createCustomer();
        address = addressFactory.createAddress();
        document = documentFactory.createCpf();
    }
    @Test
    void shouldCreateCustomerWithValidData() {
        assertNotNull(customer);
        assertEquals("joselito@mail.com", customer.getEmail());
        assertEquals("Joselito doe", customer.getFullName());
        assertEquals("+5511987653212", customer.getPhone());
        assertEquals(document.getValue(), customer.getDocument().getValue());
        assertEquals(document.getType(), customer.getDocument().getType());
        assertEquals(address.getStreet(), customer.getAddress().getStreet());
        assertEquals(address.getNumber(), customer.getAddress().getNumber());
        assertEquals(address.getNeighborhood(), customer.getAddress().getNeighborhood());
        assertEquals(address.getCity(), customer.getAddress().getCity());
        assertEquals(address.getState(), customer.getAddress().getState());
        assertEquals(address.getZipCode(), customer.getAddress().getZipCode());
        assertEquals(LocalDate.now(), customer.getCreatedAt());
    }

}

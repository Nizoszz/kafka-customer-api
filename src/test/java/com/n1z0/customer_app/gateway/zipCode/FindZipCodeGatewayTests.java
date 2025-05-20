package com.n1z0.customer_app.gateway.zipCode;

import com.n1z0.customer_app.infra.gateway.zipCode.FindZipCodeGateway;
import com.n1z0.customer_app.util.mock.FindZipCodeGatewayMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(properties = "spring.data.mongodb.uri=mongodb://root:secret@localhost:27017/mydatabase?authSource=admin")
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Import(FindZipCodeGatewayMock.class)
public class FindZipCodeGatewayTests{
    @Autowired
    private FindZipCodeGateway findZipCodeGateway;

    @Test
    void shouldFindCustomerZipCodeWithValidData() {
        var zipCode = findZipCodeGateway.findByZipCode("01001000");
        assertNotNull(zipCode);
        assertEquals("Praça da Sé", zipCode.getStreet());
        assertEquals("São Paulo", zipCode.getCity());
    }
}

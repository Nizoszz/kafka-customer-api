package com.n1z0.customer_app.util.mock;

import com.n1z0.customer_app.domain.model.Address;
import com.n1z0.customer_app.infra.gateway.zipCode.FindZipCodeGateway;
import com.n1z0.customer_app.infra.gateway.zipCode.dto.ViaCepAddress;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

import static org.mockito.Mockito.when;

@TestConfiguration
public class FindZipCodeGatewayMock{
    @Bean
    public FindZipCodeGateway findZipCodeGateway() {
        FindZipCodeGateway mock = Mockito.mock(FindZipCodeGateway.class);
        var viaCepResponse = new ViaCepAddress(
                "01001-000",
                "Praça da Sé",
                "SP",
                "São Paulo",
                "Sé"
        );
        when(mock.findByZipCode("01001000")).thenReturn(
                new Address(Objects.requireNonNull(viaCepResponse).getLogradouro(),viaCepResponse.getBairro(),viaCepResponse.getLocalidade(),viaCepResponse.getUf(),viaCepResponse.getCep())
        );

        return mock;
    }
}

package com.n1z0.customer_app.infra.gateway.zipCode;

import com.n1z0.customer_app.application.gateway.FindZipCodeGatewayInterface;
import com.n1z0.customer_app.domain.model.Address;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FindZipCodeGateway implements FindZipCodeGatewayInterface{
    private final ZipCodeFeignClient feignClient;

    public FindZipCodeGateway(ZipCodeFeignClient feignClient){
        this.feignClient = feignClient;
    }

    @Override
    public Address findByZipCode(String zipCode){
        var viaCepRequest= this.feignClient.findByZipCode(zipCode).getBody();
        return new Address(
                Objects.requireNonNull(viaCepRequest).getLogradouro(),
                viaCepRequest.getBairro(),
                viaCepRequest.getLocalidade(),
                viaCepRequest.getUf(),
                viaCepRequest.getCep()
        );
    }
}

package com.n1z0.customer_app.infra.gateway.zipCode;

import com.n1z0.customer_app.infra.gateway.zipCode.dto.ViaCepAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ZipCodeFeignClient", url = "https://viacep.com.br")
public interface ZipCodeFeignClient{
    @GetMapping("/ws/{zipCode}/json")
    ResponseEntity<ViaCepAddress> findByZipCode(@PathVariable String zipCode);
}

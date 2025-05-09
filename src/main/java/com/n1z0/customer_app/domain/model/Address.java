package com.n1z0.customer_app.domain.model;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String number, String neighborhood, String city, String state, String zipCode) {
        if(!this.isValid(street, number, neighborhood, city, state, zipCode)) {
            throw new IllegalArgumentException("Values cannot be null or blank");
        }
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    private boolean isValid(String street, String number, String neighborhood, String city, String state, String zipCode){
        if (street == null || street.isBlank()) return false;
        if (number == null || number.isBlank())return false;
        if (neighborhood == null || neighborhood.isBlank())return false;
        if (city == null || city.isBlank()) return false;
        if (state == null || state.isBlank()) return false;
        if (zipCode == null || zipCode.isBlank()) return false;
        String regex = "^(\\d{5}-\\d{3})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(zipCode).matches();
    }
}

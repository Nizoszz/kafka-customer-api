package com.n1z0.customer_app.domain;

import lombok.Getter;
@Getter
public class Document{
    private final String value;
    private final DocumentType type;

    public Document(String value){
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Document cannot be null or blank");
        }
        String cleaned = clean(value);
        this.type = determineType(cleaned);
        if(!this.isValid(cleaned)){
            throw new IllegalArgumentException("Invalid cpf/cnpj");
        }
        this.value = value;
    }
    private boolean isValid(String value) {
        if(!this.hasMinimumLength(value)) return false;
        if(this.isBlocked(value)) return false;
        return switch (type) {
            case CPF -> cpfValidate(value);
            case CNPJ -> cnpjValidate(value);
        };
    }
    private boolean cpfValidate(String cpf) {
        var firstVerifyDigit = this.calculateCpfDigit(cpf, 10);
        var secondVerifyDigit = this.calculateCpfDigit(cpf, 11);
        var calculatedDigit = String.valueOf(firstVerifyDigit) + secondVerifyDigit;
        var actualDigit = cpf.substring(9);
        return actualDigit.equals(calculatedDigit);
    }
    private String clean(String value) {
        return value.replaceAll("\\D", "");
    }
    private int calculateCpfDigit(String cpf, int factor){
        var total = 0;
        for(char digit : cpf.toCharArray()){
            if(factor > 1){
                total += Character.getNumericValue(digit) * factor--;
            }
        }
        var rest = total % 11;
        return rest < 2 ? 0 : 11 - rest;
    }
    private boolean cnpjValidate(String cnpj) {
        int[] firstWeights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] secondWeights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        var firstDigit = calculateCnpjDigit(cnpj, firstWeights);
        var secondDigit = calculateCnpjDigit(cnpj + firstDigit, secondWeights);
        var actualDigits = cnpj.substring(12);
        var expectedDigits = String.valueOf(firstDigit) + secondDigit;
        return actualDigits.equals(expectedDigits);
    }
    private int calculateCnpjDigit(String cnpj, int[] weights) {
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += Character.getNumericValue(cnpj.charAt(i)) * weights[i];
        }
        var rest = total % 11;
        return rest < 2 ? 0 : 11 - rest;
    }
    private boolean hasMinimumLength(String value){
        return value.length() == 11 || value.length() == 14;
    }
    private boolean isBlocked(String value){
        return value.chars().distinct().count() == 1;
    }
    private DocumentType determineType(String cleaned) {
        if (cleaned.length() == 11) return DocumentType.CPF;
        if (cleaned.length() == 14) return DocumentType.CNPJ;
       throw new IllegalArgumentException("Document type invalid");
    }

}

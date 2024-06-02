package com.example.BasiCalculator.logic_layer.validation;

import org.springframework.stereotype.Component;

@Component
public class OperationValidator {
    public void validSizeOfNumber(double num1, double num2) {
        if (String.valueOf(num1).length() >= 9) {
            throw new IllegalArgumentException("El parametro num1 no pueden tener más de 6 dígitos.");
        }
        if (String.valueOf(num2).length() >= 9) {
            throw new IllegalArgumentException("Los parametro num2 no pueden tener más de 6 dígitos.");
        }
        // We can add more validations
    }
}

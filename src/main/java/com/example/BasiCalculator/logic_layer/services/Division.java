package com.example.BasiCalculator.logic_layer.services;

public class Division implements EstrategiaOperacion{
    @Override
    public double realizarOperacion(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("División por cero");
        }
        return num1 / num2;
    }
}

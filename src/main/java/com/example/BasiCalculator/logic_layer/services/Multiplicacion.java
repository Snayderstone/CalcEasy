package com.example.BasiCalculator.logic_layer.services;

public class Multiplicacion implements EstrategiaOperacion{
    @Override
    public double realizarOperacion(double num1, double num2) {
        return num1 * num2;
    }
}

package com.example.BasiCalculator.data_layer.Models;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Operacion {
    private double num1;
    private double num2;
    private double resultado;
    private String tipoOperacion;
    private LocalDateTime fecha;

    public Operacion(String tipoOperacion, double num1, double num2, double resultado, LocalDateTime fecha) {
        this.tipoOperacion = tipoOperacion;
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = resultado;
        this.fecha = fecha;
    }
}

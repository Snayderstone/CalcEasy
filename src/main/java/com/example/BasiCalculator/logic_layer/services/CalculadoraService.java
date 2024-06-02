package com.example.BasiCalculator.logic_layer.services;

import com.example.BasiCalculator.data_layer.Models.Operacion;
import com.example.BasiCalculator.logic_layer.repositories.CacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculadoraService {

    @Autowired
    private CacheRepository cacheRepository;

    public double realizarOperacion(String tipoOperacion, double num1, double num2) {
        EstrategiaOperacion estrategia;
        switch (tipoOperacion.toLowerCase()) {
            case "suma":
                estrategia = new Suma();
                break;
            case "resta":
                estrategia = new Resta();
                break;
            case "multiplicacion":
                estrategia = new Multiplicacion();
                break;
            case "division":
                estrategia = new Division();
                break;
            default:
                throw new IllegalArgumentException("Tipo de operación no soportada");
        }
        double resultado = estrategia.realizarOperacion(num1, num2);
        Operacion operacion = new Operacion(tipoOperacion, num1, num2, resultado, LocalDateTime.now());
        cacheRepository.guardarOperacion(operacion);
        return resultado;
    }
    public List<Operacion> obtenerHistorial() {
        return cacheRepository.obtenerHistorial();
    }
}

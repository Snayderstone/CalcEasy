package com.example.BasiCalculator.logic_layer.controllers;

import com.example.BasiCalculator.data_layer.Models.Operacion;
import com.example.BasiCalculator.logic_layer.services.CalculadoraService;
import com.example.BasiCalculator.logic_layer.validation.OperationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    @Autowired
    private CalculadoraService calculadoraService;
    @Autowired
    private OperationValidator operacionValidator;

    @GetMapping("/operar")
    public ResponseEntity<String> realizarOperacion(@RequestParam("tipoOperacion") String tipoOperacion,
                                                    @RequestParam("num1") double num1,
                                                    @RequestParam("num2") double num2) {
        try {
            operacionValidator.validSizeOfNumber(num1, num2);
            double resultado = calculadoraService.realizarOperacion(tipoOperacion, num1, num2);
            return ResponseEntity.ok("Resultado: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/historial")
    public ResponseEntity<List<Operacion>> obtenerHistorial() {
        return ResponseEntity.ok(calculadoraService.obtenerHistorial());
    }
}

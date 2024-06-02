package com.example.BasiCalculator.logic_layer.repositories;

import com.example.BasiCalculator.data_layer.Models.Operacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CacheRepository {

    private List<Operacion> historial = new ArrayList<>();

    public void guardarOperacion(Operacion operacion) {
        historial.add(operacion);
    }

    public List<Operacion> obtenerHistorial() {
        return new ArrayList<>(historial);
    }
}

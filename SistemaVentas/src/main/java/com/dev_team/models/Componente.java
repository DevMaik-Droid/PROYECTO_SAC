package com.dev_team.models;

import java.io.InputStream;
import java.util.Date;
import lombok.Data;

@Data
public class Componente {

    private Integer idComponente;
    private String nombre;
    private String clave;
    private String marca;
    private String modelo;
    private String capacidad;
    private String velocidad;
    private InputStream imagen;
    private String descripcion;
    
    @Override
    public String toString() {
        if (getNombre().contains("RAM")) {
            return getCapacidad() + ", " + getVelocidad() + " - " + getMarca() + "-" + getModelo();
        } else if (getNombre().contains("HDD") || getNombre().contains("SDD")) {
            String tipo = getNombre().contains("SSD") ? "SSD" : "HDD";
            return tipo + "-" + getCapacidad() + "," + getVelocidad();
        } else {
            return getMarca() + "-" + getModelo();
        }

    }
}

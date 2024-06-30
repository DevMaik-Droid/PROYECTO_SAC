package com.dev_team.models;

import lombok.Data;

@Data
public class PlacaMadre {

    private int id;
    private String marca;
    private String modelo;
    private String socket_procesador;
    private String chipset;
    private String formato;
    private double precio;
    private int cantidad;
    private String observaciones;

}

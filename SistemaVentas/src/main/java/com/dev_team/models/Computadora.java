/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.models;

import java.io.InputStream;
import java.util.Date;
import lombok.Data;


@Data
public class Computadora {
    
    private Integer idComputadora;
    private String claveComputadora;
    private String  nombre;
    private String  procesador;
    private String  placaMadre;
    private String memoriaRam;
    private String almacenamiento;
    private String tarjeta;
    private String fuente;
    private String ccase;
    private String monitor;
    private String disipador;
    private String ventilador;
    private InputStream imagen;
    private Double precio;
    private String descripcion;
    private Date fechaCreacion;
    
}

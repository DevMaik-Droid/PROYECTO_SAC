
package com.dev_team.models;

import java.io.InputStream;
import java.util.Date;
import lombok.Data;

@Data
public class Laptop {
    private Integer idLaptop;
    private String claveLaptop;
    private String nombre;
    private String marca;
    private String modelo;
    private String procesador;
    private String memoriaRam;
    private String almacenamiento;
    private String conectividad;
    private String tarjetaGrafica;
    private String pantalla;
    private String bateria;
    private InputStream imagen;
    private String descripcion;
    private Date fechaCreacion;
    
    private byte[] bytes_image;
}

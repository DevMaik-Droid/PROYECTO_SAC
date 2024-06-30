package com.dev_team.models;

import java.io.InputStream;
import java.util.Date;
import lombok.Data;

@Data
public class Accesorios {

    private Integer idAccesorio;
    private String claveAccesorio;
    private String nombre;
    private String marca;
    private String modelo;
    private InputStream imagen;
    private String descripcion;
    private Date fechaRegistro;
}

package com.dev_team.models;

import java.util.Date;
import lombok.Data;

@Data
public class Producto {

    //Atributos
    private Long idProducto;
    private String claveProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private Double precioUnitario;
    private Integer stock;
    private Double precioTotal;
    private String disponibilidad;
    private Long idProveedor;
    private Long idUsuario;
    private String detalle;
    private Date fechaModicacion;
    
}

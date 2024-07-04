package com.venta.ventas.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tb_productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idp")
    private Long idProducto;

    @Column(name="claveProducto")
    private String claveProducto;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "categoriaProducto")
    private String categoriaProducto;

    @Column(name = "precioUnitario")
    private Double precioUnitario;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precioTotal")
    private Double precioTotal;

    @Column(name = "disponibilidad")
    private String disponibilidad;

    @Column(name = "idProveedor")
    private String idProveedor;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "fechaModificacion")
    private Date fechaModificacion;

}

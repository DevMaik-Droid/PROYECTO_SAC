package com.venta.ventas.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_ventas_web")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    private Long idCliete;
    private Long idProducto;

}

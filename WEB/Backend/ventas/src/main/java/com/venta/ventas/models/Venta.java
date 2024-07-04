package com.venta.ventas.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_ventas_web")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    private Long idCliente;
    private String claveP;

}

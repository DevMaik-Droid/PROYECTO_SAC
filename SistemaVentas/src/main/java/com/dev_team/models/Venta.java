/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.models;

import java.util.Date;
import lombok.Data;

@Data
public class Venta {

   private Long idVenta;
   private Integer cantidad;
   private Double precioUnitario;
   private Double descuento;
   private Double subTotal;
   private Double total;
   private String metodoPago;
   private Date fecha;
   private Long idCliente;
   private Long idProducto;
   private Long idUsuario;

}

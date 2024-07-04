package com.venta.ventas.models;


import lombok.Data;

@Data
public class VentaRequest {
    private Cliente cliente;
    private  Producto producto;
}

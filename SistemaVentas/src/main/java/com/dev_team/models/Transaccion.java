package com.dev_team.models;

import java.util.Date;
import lombok.Data;

@Data
public class Transaccion {

    private Long idTransaccion;
    private Double montoTotal;
    private Double montoPagado;
    private String tipoDePago;
    private String estado_pago;
    private String plazos;
    private Date fechaLiminte;
    private String observaciones;
    private Integer idProducto;
    private Long idProveedor;
    private Long idUsuario;
    private Date fecha;
}

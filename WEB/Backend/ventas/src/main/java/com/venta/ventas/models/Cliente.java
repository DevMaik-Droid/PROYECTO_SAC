package com.venta.ventas.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    public String departamento;
    private String direccion;
}

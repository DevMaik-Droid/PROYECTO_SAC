package com.dev_team.models;
//Atributos

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Proveedor {

    private Long idProveedor;
    private String empresa;
    private String proveedor;
    private String contacto;
    private String email;
    private String productoSuministrado;
    private String direccion;
    private String observaciones;
    private String estado;
    private Date fechaRegistro;

    public Proveedor(Long idProveedor, String nombre) {
        this.idProveedor = idProveedor;
        this.proveedor = nombre;
    }

    @Override
    public String toString() {
        return getProveedor();
    }
    
}

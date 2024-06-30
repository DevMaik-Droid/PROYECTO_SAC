package com.dev_team.models;

import lombok.Data;


@Data
public class Cliente {

    //Atributos
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String departamento;
    private String direccion;
    private String estado;

    
    
    @Override
    public String toString(){
        return getNombre() + " " + getApellido();
    }
}

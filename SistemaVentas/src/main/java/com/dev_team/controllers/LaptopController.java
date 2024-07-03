/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.controllers;

import com.dev_team.models.Laptop;
import com.dev_team.services.Service_Laptop;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarLaptop;
import java.io.InputStream;
import java.util.Arrays;
import javax.swing.JTextField;

/**
 *
 * @author DevMaik
 */
public class LaptopController  extends V_RegistrarLaptop{

    
    private InputStream input_image=null;
    
    public LaptopController() {
        btn_buscarImange.addActionListener( e ->{
            input_image = Utilidad.seleccionarImagen(lb_imagen);
        });
        btn_registrarLP.addActionListener(e ->{
            registrarLaptop();
        });
        
    }
    
    
    
    private void registrarLaptop(){
        
        Laptop laptop = new Laptop();
        
        laptop.setClaveLaptop(generarClave());
        laptop.setNombre(tf_nombre.getText());
        laptop.setMarca(tf_marca.getText());
        laptop.setModelo(tf_modeloLP.getText());
        laptop.setProcesador(tf_procesador.getText());
        laptop.setMemoriaRam(tf_memoriaRam.getText());
        laptop.setAlmacenamiento(tf_almacenamiento.getText());
        laptop.setConectividad(tf_conectividadLP1.getText());
        laptop.setTarjetaGrafica(tf_tarjetaGrafica.getText());
        laptop.setBateria(tf_bateriaLP.getText());
        laptop.setImagen(input_image);
        laptop.setDescripcion(ta_descripcionLaptop.getText());
        
        Service_Laptop laptop_service = new Service_Laptop();
        if (laptop_service.crear(laptop)) {
            Utilidad.mostrarMensaje("Laptop creada...");
            limpiarCampos();
        }else {
            Utilidad.mostrarMensaje("Error en crear");
        }
        
    }
    
    private static String generarClave() {
        return "L" + String.valueOf(Math.round(Math.random() * 10000)) + "P";
    }
    
    
    private void limpiarCampos(){
        JTextField[] tfs = {tf_almacenamiento,tf_bateriaLP,tf_conectividadLP1,tf_marca,tf_memoriaRam,tf_modeloLP,tf_nombre,tf_pantallaLP,tf_procesador,tf_tarjetaGrafica};
        Arrays.stream(tfs).forEach(x -> x.setText(""));
        
        lb_imagen.setIcon(null);
        ta_descripcionLaptop.setText("");
        
    }
}

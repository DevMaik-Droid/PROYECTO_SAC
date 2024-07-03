package com.dev_team.controllers;

import com.dev_team.models.Componente;
import com.dev_team.models.Computadora;
import com.dev_team.models.Producto;
import com.dev_team.services.Service_Componente;
import com.dev_team.services.Service_Computadora;
import com.dev_team.services.Service_Producto;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarComputadora;
import java.io.InputStream;
import java.util.List;

public class ComputadoraController extends V_RegistrarComputadora {

    private double precio;

    List<Producto> productos = (List<Producto>) new Service_Producto().listar();
    private InputStream imagen = null;
    
    public ComputadoraController() {
        cargarComboBox();
        btn_buscar.addActionListener(e -> {
            imagen = Utilidad.seleccionarImagen(lb_imagen);
        });
        
        btn_registrar.addActionListener(e -> registrarComputadora());
        
        
        cbx_procesadorCO.addActionListener(e -> actualizarPrecio());
        cbx_caseCO.addActionListener(e -> actualizarPrecio());
        cbx_disipadores.addActionListener(e -> actualizarPrecio());
        cbx_discoCO.addActionListener(e -> actualizarPrecio());
        cbx_gpu.addActionListener(e -> actualizarPrecio());
        cbx_ramCO.addActionListener(e -> actualizarPrecio());
        cbx_fuente.addActionListener(e -> actualizarPrecio());
        cbx_tarjetaMadre.addActionListener(e -> actualizarPrecio());
        cbx_ventiladores.addActionListener(e -> actualizarPrecio());
    }

    private void cargarComboBox() {

        List<Producto> lista_componentes = productos.stream()
                .filter(c -> c.getCategoriaProducto().contains("Componentes")).toList();
        lista_componentes.stream().filter(x -> x.getNombreProducto().contains("Placa"))
                .forEach(p -> cbx_tarjetaMadre.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("CPU"))
                .forEach(p -> cbx_procesadorCO.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("RAM"))
                .forEach(p -> cbx_ramCO.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("Almacenamiento"))
                .forEach(p -> cbx_discoCO.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("GPU"))
                .forEach(p -> cbx_gpu.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("Fuente"))
                .forEach(p -> cbx_fuente.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("Case"))
                .forEach(p -> cbx_caseCO.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("Monitor"))
                .forEach(p -> cbx_monitor.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("Ventiladores"))
                .forEach(p -> cbx_ventiladores.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));

        lista_componentes.stream().filter(c -> c.getNombreProducto().contains("Disipador"))
                .forEach(p -> cbx_disipadores.addItem(new Service_Componente().buscarCompenente(p.getClaveProducto())));
    }

    private void actualizarPrecio() {
        precio = 0;

        precio += obtenerPrecio((Componente) cbx_caseCO.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_procesadorCO.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_gpu.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_discoCO.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_disipadores.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_fuente.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_monitor.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_ramCO.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_tarjetaMadre.getSelectedItem());
        precio += obtenerPrecio((Componente) cbx_ventiladores.getSelectedItem());
        
        System.out.println(precio);
        tf_costo_total.setText(String.valueOf(precio));
    }

     private double obtenerPrecio(Componente componente) {   
        if (componente != null) {
            Producto producto = productos.stream()
                    .filter(x -> x.getClaveProducto().equals(componente.getClave()))
                    .findFirst()
                    .orElse(null);
           
            if (producto != null) {
                return producto.getPrecioUnitario();
            }
        }
        return 0;
    }

     
    private void registrarComputadora(){
        Computadora computadora = new Computadora();
        computadora.setClaveComputadora(generarClave());
        computadora.setNombre(tf_nombreCO.getText());
        computadora.setProcesador(((Componente) cbx_procesadorCO.getSelectedItem()).getClave());
        computadora.setPlacaMadre(((Componente) cbx_tarjetaMadre.getSelectedItem()).getClave());
        computadora.setMemoriaRam(((Componente) cbx_ramCO.getSelectedItem()).getClave());
        computadora.setAlmacenamiento(((Componente) cbx_discoCO.getSelectedItem()).getClave());
        computadora.setTarjeta(((Componente) cbx_gpu.getSelectedItem()).getClave());
        computadora.setFuente(((Componente) cbx_fuente.getSelectedItem()).getClave());
        computadora.setCcase(((Componente) cbx_caseCO.getSelectedItem()).getClave());
        computadora.setMonitor(((Componente) cbx_monitor.getSelectedItem()).getClave());
        computadora.setDisipador(((Componente) cbx_disipadores.getSelectedItem()).getClave());
        computadora.setVentilador(((Componente) cbx_ventiladores.getSelectedItem()).getClave());
        computadora.setImagen(imagen);
        computadora.setPrecio(Double.valueOf(tf_costo_total.getText()));
        computadora.setDescripcion(ta_descripcion.getText());
        Service_Computadora service_Computadora = new Service_Computadora();
        
        if(service_Computadora.crear(computadora)){
            Utilidad.mostrarMensaje("Computadora Creada");
        }else {
            Utilidad.mostrarMensaje("Error en crear la computadora.");
        }
    }
    
    private static String generarClave() {
        return "PC" + String.valueOf(Math.round(Math.random() * 10000));
    }
    
}

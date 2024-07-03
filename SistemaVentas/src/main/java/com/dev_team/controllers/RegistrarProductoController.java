package com.dev_team.controllers;

import com.dev_team.dashboard.Vista_Dashboard;
import com.dev_team.models.Accesorios;
import com.dev_team.models.Componente;
import com.dev_team.models.Computadora;
import com.dev_team.models.Laptop;
import com.dev_team.models.Producto;
import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Accesorios;
import com.dev_team.services.Service_Componente;
import com.dev_team.services.Service_Computadora;
import com.dev_team.services.Service_Laptop;
import com.dev_team.services.Service_Producto;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarProducto;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegistrarProductoController extends V_RegistrarProducto {

    public RegistrarProductoController() {
        ta_detalle.setEditable(false);
        
        cbx_clave.addActionListener(xx -> {
            if (cbx_clave.getSelectedIndex() > 0) {
                String categoria = cbx_categoria.getSelectedItem().toString();
                String clave = cbx_clave.getSelectedItem().toString();
                generarTexto(clave, categoria);
            }

        });

        cbx_categoria.addActionListener(x -> {
            cbx_clave.removeAllItems();
            cbx_proveedor.removeAllItems();
            String categoria = cbx_categoria.getSelectedItem().toString();
            cargarCBXClave(categoria);
            cargarCbxProveedor(categoria);
        });

        btn_registrar.addActionListener(x -> registrarProducto());

        tf_cantidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularPrecio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularPrecio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });
        tf_precioUnitario.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularPrecio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularPrecio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });
    }

    private void calcularPrecio() {
        if (!tf_precioUnitario.getText().isEmpty() && !tf_cantidad.getText().isEmpty()) {
            double precioUnitario = Double.parseDouble(tf_precioUnitario.getText());
            int cantidad = Integer.parseInt(tf_cantidad.getText());
            tf_precioTotal.setText(String.format("%.2f",(precioUnitario * cantidad)));
        }else{
            tf_precioTotal.setText("0");
        }

    }

    private void cargarCBXClave(String categoria) {
        cbx_clave.addItem("Seleccione Clave");
        if (categoria.equalsIgnoreCase("COMPONENTES")) {

            Service_Componente svc = new Service_Componente();
            List<Componente> lista_producto = (List<Componente>) svc.listarClaves();
            lista_producto.forEach(x -> cbx_clave.addItem(x.getClave()));

        } else if (categoria.equalsIgnoreCase("ACCESORIOS")) {
            Service_Accesorios svc = new Service_Accesorios();
            List<Accesorios> lista_producto = (List<Accesorios>) svc.listarClaves();
            lista_producto.forEach(x -> cbx_clave.addItem(x.getClaveAccesorio()));

        }else if (categoria.equalsIgnoreCase("LAPTOP")) {
            Service_Laptop svc = new Service_Laptop();
            List<Laptop> lista_producto = (List<Laptop>) svc.listarClaves();
            lista_producto.forEach(x -> cbx_clave.addItem(x.getClaveLaptop()));
        }
        else if (categoria.equalsIgnoreCase("COMPUTADORA")) {
            Service_Computadora svc = new Service_Computadora();
            List<Computadora> lista_producto = (List<Computadora>) svc.listar();
            lista_producto.forEach(x -> cbx_clave.addItem(x.getClaveComputadora()));
        }
        else {
            
        }
    }

    private void cargarCbxProveedor(String categoria) {
        List<Proveedor> proveedor = (List<Proveedor>) new Service_Proveedor().listar();
        proveedor.stream()
                .filter(p -> p.getProductoSuministrado().equalsIgnoreCase(categoria))
                .forEach(x -> cbx_proveedor.addItem(x));
    }

    
    private void generarTexto(String clave, String categoria) {
        String txt = "";
        System.out.println(clave);
        if (categoria.equalsIgnoreCase("Componentes")) {
            Service_Componente svc = new Service_Componente();
            Componente componente = svc.buscarCompenente(clave);
            tf_nombreProducto.setText(componente.getNombre());
            txt =" -Marca: " + componente.getMarca()
                    + "\n -Modelo: " + componente.getModelo()
                    + "\n -Capacidad: " + ((componente.getCapacidad() != null) ? componente.getCapacidad() : "No tiene")
                    + "\n -Velocidad: " + ((componente.getVelocidad() != null) ? componente.getVelocidad() : "No tiene");
        } else if (categoria.equalsIgnoreCase("Accesorios")) {
            Service_Accesorios svc = new Service_Accesorios();
            Accesorios accesorios = svc.buscarAccesorio(clave);
            tf_nombreProducto.setText(accesorios.getNombre());
            txt =  " -Marca: " + accesorios.getMarca()
                    + "\n -Modelo: " + accesorios.getModelo();
        }else if (categoria.equalsIgnoreCase("Laptop")) {
            Service_Laptop svc = new Service_Laptop();
            Laptop laptop = svc.buscarLaptop(clave);
            tf_nombreProducto.setText(laptop.getNombre());
            txt =  " -Marca: " + laptop.getMarca()
                    + "\n -Modelo: " + laptop.getModelo()
                    + "\n -Procesador: " + laptop.getProcesador()
                    + "\n -Memoria RAM: " + laptop.getMemoriaRam()
                    + "\n -Almacenamiento: " + laptop.getAlmacenamiento()
                    + "\n -TarjetaGrafica: " + laptop.getTarjetaGrafica()
                    + "\n -Pantalla: " + laptop.getPantalla();
        }else if (categoria.equalsIgnoreCase("Computadora")) {
            Service_Computadora svc = new Service_Computadora();
            Computadora computadora = svc.buscarComputadora(clave);
            List<Componente> lista_componentes = (List<Componente>) new Service_Componente().listar();
            
            tf_precioUnitario.setText(computadora.getPrecio()+"");
            tf_precioUnitario.setEditable(false);
            tf_nombreProducto.setText(computadora.getNombre());
            txt =  "\n -Procesador: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getProcesador())).findFirst().get().toString()
                    
                    + "\n -TarjetaGrafica: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getTarjeta())).findFirst().get().toString()
                    
                    + "\n -Placa Madre: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getPlacaMadre())).findFirst().get().toString()
                    
                    + "\n -Memoria RAM: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getMemoriaRam())).findFirst().get().toString()
                    
                    + "\n -Pantalla: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getMonitor())).findFirst().get().toString()
                    
                    + "\n -Almacenamiento: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getAlmacenamiento())).findFirst().get().toString()
                    
                    + "\n -Fuente: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getFuente())).findFirst().get().toString()
                    
                    + "\n -Case: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getCcase())).findFirst().get().toString()
                    
                    + "\n -Disipador: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getDisipador())).findFirst().get().toString()
                    
                    + "\n -Ventilador: " + lista_componentes.stream().filter(x -> x.getClave()
                            .equals(computadora.getVentilador())).findFirst().get().toString();
        }
       
        ta_detalle.setText(txt);
    }

    private void registrarProducto() {
        Producto producto = new Producto();

        producto.setClaveProducto(cbx_clave.getSelectedItem().toString());
        producto.setNombreProducto(tf_nombreProducto.getText());
        producto.setCategoriaProducto(cbx_categoria.getSelectedItem().toString());
        producto.setPrecioUnitario(Double.valueOf(tf_precioUnitario.getText()));
        producto.setStock(Integer.valueOf(tf_cantidad.getText()));
        producto.setPrecioTotal(Double.valueOf(tf_precioTotal.getText()));
        producto.setIdProveedor(((Proveedor) cbx_proveedor.getSelectedItem()).getIdProveedor());
        producto.setIdUsuario(Vista_Dashboard.idUsuario);
        producto.setDetalle(ta_detalle.getText());

        Service_Producto svc = new Service_Producto();
        if (svc.crear(producto)) {
            Utilidad.mostrarMensaje("Producto Creado");
        } else {
            Utilidad.mostrarMensaje("Error en crear");
        }

    }

}

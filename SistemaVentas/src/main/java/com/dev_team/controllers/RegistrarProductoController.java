package com.dev_team.controllers;

import com.dev_team.dashboard.Vista_Dashboard;
import com.dev_team.models.Accesorios;
import com.dev_team.models.Componente;
import com.dev_team.models.Producto;
import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Accesorios;
import com.dev_team.services.Service_Componente;
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
            tf_precioTotal.setText((precioUnitario * cantidad) + "");
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

        } else {

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

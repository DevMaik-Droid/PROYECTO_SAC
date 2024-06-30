package com.dev_team.controllers;

import com.dev_team.dashboard.Vista_Dashboard;
import com.dev_team.models.Accesorios;
import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Accesorios;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarAccesorios;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AccesorioController extends V_RegistrarAccesorios {

    InputStream imagen;

    public AccesorioController() {

        cargarCbxProveedor();
        btn_buscar.addActionListener(e -> {

            imagen = Utilidad.seleccionarImagen(lb_imagen);

        });
        btn_registrar.addActionListener(e -> {

            registrarAccesorio();

        });

        tf_cantidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                tf_precioTotal.setText(calcularPrecioTotal());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tf_precioTotal.setText(calcularPrecioTotal());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });

    }

    private String calcularPrecioTotal() {
        if (!tf_precioUnitario.getText().isEmpty()) {
            double precioUnitario = Double.parseDouble(tf_precioUnitario.getText());
            double cantidad = Double.parseDouble(tf_cantidad.getText());
            return String.valueOf(precioUnitario * cantidad);
        } else {
            return "";
        }
    }

    private void registrarAccesorio() {

        try {
            Service_Accesorios service = new Service_Accesorios();
            Accesorios accesorio = new Accesorios();

            accesorio.setNombre(tf_nombre.getText().toUpperCase().trim());
            accesorio.setMarca(tf_marca.getText().toUpperCase().trim());
            accesorio.setDescripcion(ta_descripcion.getText().trim());
            Proveedor prov = (Proveedor) cbx_proveedor.getSelectedItem();

            accesorio.setImagen(imagen);
            accesorio.setFechaRegistro(new Date());

            if (service.crear(accesorio)) {
                Utilidad.mostrarMensaje("Accesorio Creado");
            } else {
                Utilidad.mostrarMensaje("Error en crear accesorio");
            }

        } catch (NumberFormatException e) {
            Utilidad.mostrarMensaje("Error, verifique los datos");

        }

    }

    private void cargarCbxProveedor() {
        cbx_proveedor.addItem(new Proveedor(0L, "Seleccione Proveedor"));
        List<Proveedor> proveedor = (List<Proveedor>) new Service_Proveedor().listar();
        proveedor.stream()
                .filter(p -> p.getProductoSuministrado().equals("Accesorios"))
                .forEach(x -> cbx_proveedor.addItem(x));
    }

}

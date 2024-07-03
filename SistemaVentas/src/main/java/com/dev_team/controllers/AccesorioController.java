package com.dev_team.controllers;

import com.dev_team.models.Accesorios;
import com.dev_team.services.Service_Accesorios;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarAccesorios;
import java.io.InputStream;

public class AccesorioController extends V_RegistrarAccesorios {

    InputStream imagen;

    public AccesorioController() {

        btn_buscar.addActionListener(e -> {

            imagen = Utilidad.seleccionarImagen(lb_imagen);

        });
        btn_registrar.addActionListener(e -> {

            registrarAccesorio();

        });

    }

    private void registrarAccesorio() {

        try {
            Service_Accesorios service = new Service_Accesorios();
            Accesorios accesorio = new Accesorios();
            accesorio.setClaveAccesorio(generarClave());
            accesorio.setNombre(tf_nombre.getText().toUpperCase().trim());
            accesorio.setMarca(tf_marca.getText().toUpperCase().trim());
            accesorio.setDescripcion(ta_descripcion.getText().trim());
            accesorio.setModelo(tf_modelo.getText());
            accesorio.setImagen(imagen);

            if (service.crear(accesorio)) {
                Utilidad.mostrarMensaje("Accesorio Creado");
                limpiarCampos();
            } else {
                Utilidad.mostrarMensaje("Error en crear accesorio");
            }

        } catch (NumberFormatException e) {
            Utilidad.mostrarMensaje("Error, verifique los datos");

        }
    }

    private void limpiarCampos() {
        tf_marca.setText("");
        tf_modelo.setText("");
        tf_nombre.setText("");
        ta_descripcion.setText("");
        lb_imagen.setIcon(null);
    }

    private static String generarClave() {

        return "A" + String.valueOf(Math.round(Math.random() * 10000)) + "O";

    }
}

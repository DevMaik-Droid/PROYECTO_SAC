package com.dev_team.controllers;

import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarProveedor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProveedorController extends V_RegistrarProveedor {

    public ProveedorController() {

        btn_registrar.addActionListener(e -> {
            registrarProveedor();

        });

    }

    private void registrarProveedor() {

        if (validarCampos()) {
            Service_Proveedor service = new Service_Proveedor();
            Proveedor proveedor = new Proveedor();
            proveedor.setEmpresa(tf_empresa.getText().trim());
            proveedor.setProveedor(tf_proveedor.getText().trim());
            proveedor.setContacto(tf_contacto.getText().trim());
            proveedor.setDireccion(tf_direccion.getText().trim());
            proveedor.setEmail(tf_email.getText().trim());
            proveedor.setObservaciones(ta_informacionAdicional.getText());

            if (cbx_productoSuministrado.getSelectedIndex() > 0) {
                proveedor.setProductoSuministrado(cbx_productoSuministrado.getSelectedItem().toString());
            } else {
                Utilidad.mostrarMensaje("Seleccione producto suministrado");
            }
            
            if (service.crear(proveedor)) {
                mostrarMensaje("Proveedor Registrado");
                LimpiarCampos();
            } else {
                mostrarMensaje("Error en registrar");
            }

        } else {
            mostrarMensaje("Debe llenar todos los campos");
        }

    }

    private boolean validarCampos() {
        boolean valido = true;

        JTextField[] tfs = {tf_contacto, tf_direccion, tf_email, tf_proveedor};
        for (JTextField f : tfs) {
            if (f.getText().isEmpty()) {
                valido = false;
                break;
            }
        }

        return valido;
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void LimpiarCampos() {
        JTextField[] tfs = {tf_contacto, tf_direccion, tf_email, tf_proveedor, tf_empresa};
        for (JTextField f : tfs) {
            f.setText("");
        }
        cbx_productoSuministrado.setSelectedIndex(0);
        ta_informacionAdicional.setText("");
    }
}

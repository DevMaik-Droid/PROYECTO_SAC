package com.dev_team.controllers;

import com.dev_team.dashboard.Vista_Dashboard;
import com.dev_team.models.Componente;
import com.dev_team.models.Producto;
import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Componente;
import com.dev_team.services.Service_Producto;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_RegistrarComponentes;
import java.awt.Color;
import java.io.InputStream;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ComponentController extends V_RegistrarComponentes {

    private static final String[] CAPACIDADES_RAM = {"8 GB", "16 GB", "32 GB", "64 GB"};
    
    private static final String[] CAPACIDADES_HDD_SSD = {"250 GB", "500 GB", "1 TB", "2 TB", "4 TB"};

    private static final String[] VELOCIDADES_RAM = {
        "DDR5-6400 MHz", "DDR5-5600 MHz", "DDR5-5200 MHz", "DDR5-4800 MHz",
        "DDR4-4800 MHz", "DDR4-4600 MHz", "DDR4-4266 MHz", "DDR4-4000 MHz", "DDR4-3600 MHz",
        "DDR4-3200 MHz", "DDR4-2933 MHz", "DDR4-2666 MHz", "DDR4-2400 MHz", "DDR4-2133 MHz",
        "DDR3-3000 MHz", "DDR3-2666 MHz", "DDR3-2400 MHz", "DDR3-2133 MHz", "DDR3-1866 MHz",
        "DDR3-1600 MHz", "DDR3-1333 MHz", "DDR3-1066 MHz", "DDR3-800 MHz"
    };

    private static final String[] VELOCIDADES_HDD = {"5400 RPM", "7200 RPM"};

    private static final String[] VELOCIDADES_SSD = {
        "SATA SSD - 500 MB/s a 600 MB/s",
        "SATA SSD - 300 MB/s a 400 MB/s",
        "NVMe M.2 - NVMe PCIe Gen3 x4",
        "NVMe M.2 - NVMe PCIe Gen4 x4"
    };

    private InputStream input_image;

    public ComponentController() {

        btn_buscar.addActionListener(e -> {
            input_image = Utilidad.seleccionarImagen(lb_imagen);
        });

        btn_registrar.addActionListener(e -> {
            registrarComponente();
        });

        cbx_componente.addActionListener(c -> {
            String componente = cbx_componente.getSelectedItem().toString();
            actualizarComponentes(componente);
            tf_clave.setText(generarClave());
        });

    }


    private void actualizarComponentes(String componente) {
        activarComponentes(componente.contains("RAM") || componente.contains("SSD") || componente.contains("HDD"));

        if (componente.contains("RAM")) {
            
            agregarItemsComboBox(CAPACIDADES_RAM, VELOCIDADES_RAM);
            
        } else if (componente.contains("HDD")) {
            
            agregarItemsComboBox(CAPACIDADES_HDD_SSD, VELOCIDADES_HDD);
            
        } else if (componente.contains("SSD")) {
            
            agregarItemsComboBox(CAPACIDADES_HDD_SSD, VELOCIDADES_SSD);
            
        } else {
            cbx_capacidad.removeAllItems();
            cbx_velocidad.removeAllItems();
        }
    }

    private void activarComponentes(boolean accion) {
        Color fondo = accion ? Color.WHITE : Main_Colores.C_200;
        cbx_capacidad.setBackground(fondo);
        cbx_velocidad.setBackground(fondo);
        cbx_capacidad.setEnabled(accion);
        cbx_velocidad.setEnabled(accion);
    }

    private void agregarItemsComboBox(String[] capacidades, String[] velocidades) {
        cbx_capacidad.removeAllItems();
        cbx_velocidad.removeAllItems();
        Arrays.stream(capacidades).forEach(cbx_capacidad::addItem);
        Arrays.stream(velocidades).forEach(cbx_velocidad::addItem);
    }

    private void registrarComponente() {

        Componente componente = new Componente();
        Producto producto = new Producto();
        
        Service_Componente service = new Service_Componente();

        componente.setNombre(cbx_componente.getSelectedItem().toString());
        componente.setMarca(tf_marca.getText().trim().toUpperCase());
        componente.setModelo(tf_modelo.getText().trim().toUpperCase());
        componente.setClave(tf_clave.getText());
        String capacidad = "";
        String velocidad = "";
        
        if (cbx_capacidad.isEnabled()) {
            capacidad = cbx_capacidad.getSelectedItem().toString();
            velocidad = cbx_velocidad.getSelectedItem().toString();
        }
        componente.setCapacidad(capacidad);
        componente.setVelocidad(velocidad);
        componente.setImagen(input_image);
        componente.setDescripcion(ta_descripcion.getText().trim());

        if (service.crear(componente)) {
            Utilidad.mostrarMensaje("Componente Creado");
            limpiar();
        } else {
            mostrarMensaje("Error en registrar componente");
        }

    }

    private void limpiar() {
        tf_marca.setText("");
        tf_modelo.setText("");
        lb_imagen.setIcon(null);
        cbx_componente.setSelectedIndex(0);
        cbx_capacidad.removeAllItems();
        cbx_velocidad.removeAllItems();
        ta_descripcion.setText("");
        tf_clave.setText("");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);

    }
    
    private static String generarClave() {

        return "C" + String.valueOf(Math.round(Math.random() * 10000)) + "E";

    }

}

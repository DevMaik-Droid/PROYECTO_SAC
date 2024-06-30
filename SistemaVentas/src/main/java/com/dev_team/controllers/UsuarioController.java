package com.dev_team.controllers;

import com.dev_team.models.Usuario;
import com.dev_team.services.Service_Usuario;
import com.dev_team.views.V_RegistrarUsuario;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UsuarioController extends V_RegistrarUsuario {

    private InputStream input_image;

    public UsuarioController() {
        btn_registrar.addActionListener(e -> {
            registrarUsuario();

        });
        btn_buscarFoto.addActionListener(e -> {
            seleccionarImagen();
        });

    }

    private void registrarUsuario() {

        try {
            if (verificarCampos()) {
                if (pf_password.getText().trim().equals(pf_confPassword.getText().trim())) {

                    Service_Usuario service_Usuario = new Service_Usuario();
                    Usuario usuario = new Usuario();
                    usuario.setNombre(tf_nombre.getText().toUpperCase().trim());
                    usuario.setApellido(tf_apellido.getText().toUpperCase().trim());
                    usuario.setCi(tf_ci.getText().toUpperCase().trim());
                    usuario.setFechaNacimiento(dc_fechaNac.getDate());
                    usuario.setTelefono(tf_telefono.getText().trim());
                    usuario.setDireccion(tf_direccion.getText().trim());
                    usuario.setUsuario(tf_usuario.getText().trim());
                    usuario.setPassword(pf_confPassword.getText());
                    usuario.setClave(generarClave());
                    usuario.setFoto(input_image);
                    usuario.setEstado("Activo");
                    usuario.setObservaciones(ta_observaciones.getText());
                    usuario.setNivel(cbx_nivel.getSelectedItem().toString());
                    if(service_Usuario.crear(usuario)){
                        JOptionPane.showMessageDialog(null, "Usuario Registrado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al registrar.");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar los campos");
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Datos erroneos.");
        }

    }

    private Boolean verificarCampos() {
        boolean bandera = true;
        JTextField[] tfs = {tf_nombre, tf_apellido, tf_ci, tf_direccion, tf_telefono, tf_usuario};
        JPasswordField[] pfs = {pf_password, pf_confPassword};
        for (JTextField f : tfs) {
            if (f.getText().isBlank()) {
                bandera = false;
                break;
            }
        }
        if (bandera) {
            for (JPasswordField pf : pfs) {
                if (new String(pf.getPassword()).isBlank()) {
                    bandera = false;
                    break;
                }
            }
        }
        return bandera;
    }

    private String generarClave() {
        SimpleDateFormat format = new SimpleDateFormat("yy");
        String anio = format.format(dc_fechaNac.getDate());
        String nombre = tf_nombre.getText().toUpperCase().trim().substring(0, 2);
        String apellido = tf_apellido.getText().toUpperCase().trim().substring(0, 2);
        return nombre + anio + apellido;
    }

    private void seleccionarImagen() {
        File archivo = null;
        try {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "png");
            chooser.setFileFilter(filter);
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                archivo = chooser.getSelectedFile();
            }

            Image img = ImageIO.read(archivo).getScaledInstance(lb_foto.getWidth(), lb_foto.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(img);

            lb_foto.setIcon(icon);

            input_image = new FileInputStream(archivo);
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("No se seleciono la imagen");
        }
    }

}

package com.dev_team.views;

import com.dev_team.models.Usuario;
import com.dev_team.services.Service_Usuario;
import com.dev_team.utilidades.GradientDialog;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.Utilidad;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;

import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class D_AdmUsuario extends GradientDialog {

    Usuario us = null;
    private InputStream input_image;
    private boolean nueva_imagen = false;

    public D_AdmUsuario(boolean modal, Usuario us) {
        super(modal, Main_Colores.Fondo,Main_Colores.C_F800,Main_Colores.C_F700);
        this.us = us;
        initComponents();
        iniciarComponentes();
        setSize(new Dimension(700, 550));
        setTitle("Administracion de Usuario");
        setLocationRelativeTo(null);

    }

    private void iniciarComponentes() {
        tf_clave.setText(us.getClave());
        tf_nivel.setText(us.getUsuario());
        pf_password.setText(us.getPassword());
        pf_confirmar.setText(us.getPassword());
        tf_nombre.setText(us.getNombre());
        tf_apellido.setText(us.getApellido());
        dc_fechaNac.setDate(us.getFechaNacimiento());
        tf_ci.setText(us.getCi());
        tf_telefono.setText(us.getTelefono());
        tf_direccion.setText(us.getDireccion());
        lb_foto.setIcon(rec(us.getBytes_image()));
        cbx_estado.setSelectedItem(us.getEstado());

    }

    private Icon rec(byte[] bytes_image) {
        byte[] imagenbyte = bytes_image;
        ImageIcon imagen = new ImageIcon(imagenbyte);
        Image img = imagen.getImage().getScaledInstance(lb_foto.getWidth(), lb_foto.getHeight(), Image.SCALE_DEFAULT);
        return new ImageIcon(img);
    }

    private void eliminarUsuario(){
        
        
        int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro de elimnar al usuario.");

        if(opcion == 0){
            Service_Usuario svc = new Service_Usuario();
            if(svc.eliminar(us.getIdUsuario())){
                Utilidad.mostrarMensaje("Usuario Eliminado");
                this.dispose();
                
            }
            
        }
        
    }
    private void actualizarUsuario() {

        try {
            if (verificarCampos()) {
                if (pf_password.getText().trim().equals(pf_confirmar.getText().trim())) {

                    Service_Usuario service_Usuario = new Service_Usuario();
                    Usuario usuario = new Usuario();
                    usuario.setNombre(tf_nombre.getText().toUpperCase().trim());
                    usuario.setApellido(tf_apellido.getText().toUpperCase().trim());
                    usuario.setCi(tf_ci.getText().toUpperCase().trim());
                    usuario.setFechaNacimiento(dc_fechaNac.getDate());
                    usuario.setTelefono(tf_telefono.getText().trim());
                    usuario.setDireccion(tf_direccion.getText().trim());
                    usuario.setUsuario(tf_nivel.getText().trim());
                    usuario.setPassword(pf_confirmar.getText());

                    if (input_image == null) {
                        input_image = new ByteArrayInputStream(us.getBytes_image());
                        System.out.println("Almacenando anterior imagen");
                    }

                    usuario.setFoto(input_image);

                    usuario.setEstado(cbx_estado.getSelectedItem().toString());

                    if (service_Usuario.actualizar(usuario, tf_clave.getText())) {
                        JOptionPane.showMessageDialog(null, "Usuario Actualizado");
                    } else {
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
        JTextField[] tfs = {tf_nombre, tf_apellido, tf_ci, tf_direccion, tf_telefono, tf_nivel};
        JPasswordField[] pfs = {pf_password, pf_confirmar};
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

    private void seleccionarImagen() {
        File archivo = null;
        try {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "png");
            chooser.setFileFilter(filter);
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                archivo = chooser.getSelectedFile();
                System.out.println("Nueva imagen seleccionada");
            }

            Image img = ImageIO.read(archivo).getScaledInstance(lb_foto.getWidth(), lb_foto.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(img);

            lb_foto.setIcon(icon);

            input_image = new FileInputStream(archivo);

        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("No se seleciono la imagen");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        tf_apellido = new javax.swing.JTextField();
        tf_ci = new javax.swing.JTextField();
        tf_telefono = new javax.swing.JTextField();
        tf_direccion = new javax.swing.JTextField();
        tf_nivel = new javax.swing.JTextField();
        pf_password = new javax.swing.JPasswordField();
        tf_clave = new javax.swing.JTextField();
        pf_confirmar = new javax.swing.JPasswordField();
        dc_fechaNac = new com.toedter.calendar.JDateChooser();
        lb_foto = new javax.swing.JLabel();
        btn_actualizarIMG = new JButtonRound("Actualizar Imagen",30);
        btn_eliminar = new JButtonRound("ELIMINAR",30);
        cbx_estado = new javax.swing.JComboBox<>();
        btn_guardar1 = new JButtonRound("REGISTRAR",30);
        jLabel15 = new javax.swing.JLabel();
        tf_usuario1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setForeground(Main_Colores.C_100);
        jLabel1.setText("ADMINISTRAR USUARIO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 300, 30);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setText("Clave: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 70, 60, 20);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setForeground(Main_Colores.C_100);
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 149, 63, 20);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 189, 70, 20);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setForeground(Main_Colores.C_100);
        jLabel5.setText("Cedula de identidad:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 231, 150, 20);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel6.setForeground(Main_Colores.C_100);
        jLabel6.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 231, 160, 20);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setForeground(Main_Colores.C_100);
        jLabel7.setText("Telefono:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 299, 67, 20);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel8.setForeground(Main_Colores.C_100);
        jLabel8.setText("Direccion:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(250, 299, 73, 20);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel9.setForeground(Main_Colores.C_100);
        jLabel9.setText("Usuario:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(200, 70, 70, 20);

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel10.setForeground(Main_Colores.C_100);
        jLabel10.setText("Contraseña:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(360, 70, 88, 20);

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel11.setForeground(Main_Colores.C_100);
        jLabel11.setText("Foto");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(500, 151, 150, 20);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel12.setForeground(Main_Colores.C_100);
        jLabel12.setText("Estado:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(50, 369, 54, 20);

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Contraseña:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(360, 70, 88, 20);

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel14.setForeground(Main_Colores.C_100);
        jLabel14.setText("Confirmar");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(520, 70, 74, 20);

        tf_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_nombre.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_nombre);
        tf_nombre.setBounds(130, 140, 240, 30);

        tf_apellido.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_apellido.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_apellido);
        tf_apellido.setBounds(130, 184, 240, 30);

        tf_ci.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_ci.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_ci);
        tf_ci.setBounds(250, 254, 170, 30);

        tf_telefono.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_telefono.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_telefono);
        tf_telefono.setBounds(50, 324, 170, 30);

        tf_direccion.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_direccion.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_direccion);
        tf_direccion.setBounds(250, 324, 170, 30);

        tf_nivel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_nivel.setForeground(Main_Colores.Fondo);
        tf_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nivelActionPerformed(evt);
            }
        });
        getContentPane().add(tf_nivel);
        tf_nivel.setBounds(260, 400, 110, 20);

        pf_password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pf_password.setForeground(Main_Colores.Fondo);
        pf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(pf_password);
        pf_password.setBounds(360, 90, 140, 20);

        tf_clave.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_clave.setForeground(Main_Colores.Fondo);
        tf_clave.setEnabled(false);
        getContentPane().add(tf_clave);
        tf_clave.setBounds(60, 90, 90, 20);

        pf_confirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pf_confirmar.setForeground(Main_Colores.Fondo);
        getContentPane().add(pf_confirmar);
        pf_confirmar.setBounds(520, 90, 140, 20);

        dc_fechaNac.setBackground(new java.awt.Color(6, 18, 52));
        dc_fechaNac.setForeground(Main_Colores.Fondo);
        dc_fechaNac.setDateFormatString("dd - MMM - YYYY");
        dc_fechaNac.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        getContentPane().add(dc_fechaNac);
        dc_fechaNac.setBounds(50, 254, 170, 30);

        lb_foto.setBackground(new java.awt.Color(255, 255, 255));
        lb_foto.setOpaque(true);
        getContentPane().add(lb_foto);
        lb_foto.setBounds(500, 180, 150, 150);

        btn_actualizarIMG.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btn_actualizarIMG.setForeground(Main_Colores.Fondo);
        btn_actualizarIMG.setText("Actualizar Imagen");
        btn_actualizarIMG.setBorder(null);
        btn_actualizarIMG.setBorderPainted(false);
        btn_actualizarIMG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizarIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarIMGActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizarIMG);
        btn_actualizarIMG.setBounds(500, 340, 150, 30);

        btn_eliminar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btn_eliminar.setForeground(Main_Colores.Fondo);
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar);
        btn_eliminar.setBounds(500, 430, 130, 40);

        cbx_estado.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbx_estado.setForeground(Main_Colores.Fondo);
        cbx_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Ausente", "Inactivo" }));
        getContentPane().add(cbx_estado);
        cbx_estado.setBounds(50, 396, 160, 30);

        btn_guardar1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btn_guardar1.setForeground(Main_Colores.Fondo);
        btn_guardar1.setText("ACTUALIZAR");
        btn_guardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar1);
        btn_guardar1.setBounds(500, 380, 130, 40);

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel15.setForeground(Main_Colores.C_100);
        jLabel15.setText("Nivel:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(260, 380, 60, 20);

        tf_usuario1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_usuario1.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_usuario1);
        tf_usuario1.setBounds(200, 90, 130, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarIMGActionPerformed
        seleccionarImagen();
    }//GEN-LAST:event_btn_actualizarIMGActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        actualizarUsuario();
        this.dispose();
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
       eliminarUsuario();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void pf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_passwordActionPerformed

    private void tf_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nivelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizarIMG;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JComboBox<String> cbx_estado;
    protected com.toedter.calendar.JDateChooser dc_fechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_foto;
    private javax.swing.JPasswordField pf_confirmar;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_apellido;
    private javax.swing.JTextField tf_ci;
    private javax.swing.JTextField tf_clave;
    private javax.swing.JTextField tf_direccion;
    private javax.swing.JTextField tf_nivel;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_telefono;
    private javax.swing.JTextField tf_usuario1;
    // End of variables declaration//GEN-END:variables
}

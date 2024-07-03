package com.dev_team.views;

import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.GradientDialog;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.Utilidad;
import com.google.protobuf.Service;
import java.awt.Dimension;

public class D_AdmProveedor extends GradientDialog {

    Proveedor prov;
    public D_AdmProveedor(boolean modal,Proveedor p) {     
        super(modal, Main_Colores.Fondo,Main_Colores.C_F800,Main_Colores.C_F700);
        initComponents();
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 600));
        this.prov = p;
        iniciarComponenetes();
    }
    
    
    private void iniciarComponenetes(){
        
        tf_clave.setText(prov.getIdProveedor().toString());
        tf_nombre.setText(prov.getProveedor());
        tf_contacto.setText(prov.getContacto());
        tf_direccion.setText(prov.getDireccion());
        tf_email.setText(prov.getEmail());
        tf_empresa.setText(prov.getEmpresa());
        cbx_productoSumi.setSelectedItem(prov.getProductoSuministrado());
        dc_fechaRegistro.setDate(prov.getFechaRegistro());
        dc_fechaRegistro.setEnabled(false);
        cbx_estado.setSelectedItem(prov.getEstado());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        tf_contacto = new javax.swing.JTextField();
        tf_direccion = new javax.swing.JTextField();
        tf_clave = new javax.swing.JTextField();
        btn_actualizar = new JButtonRound("ACTUALIZAR",30);
        dc_fechaRegistro = new com.toedter.calendar.JDateChooser();
        cbx_productoSumi = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tf_empresa = new javax.swing.JTextField();
        cbx_estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setForeground(Main_Colores.C_100);
        jLabel1.setText("ADMINISTRAR PROVEEDOR");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 330, 32);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setText("Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 60, 20);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setForeground(Main_Colores.C_100);
        jLabel3.setText("Empresa:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 60, 70, 20);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 190, 46, 20);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel6.setForeground(Main_Colores.C_100);
        jLabel6.setText("Producto suministrado:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(230, 320, 190, 20);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setForeground(Main_Colores.C_100);
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 390, 90, 20);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel8.setForeground(Main_Colores.C_100);
        jLabel8.setText("Direccion:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(230, 240, 73, 20);

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel14.setForeground(Main_Colores.C_100);
        jLabel14.setText("Fecha de registro:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(30, 320, 160, 20);

        tf_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_nombre.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_nombre);
        tf_nombre.setBounds(110, 146, 350, 30);

        tf_email.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_email.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_email);
        tf_email.setBounds(110, 186, 350, 30);

        tf_contacto.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_contacto.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_contacto);
        tf_contacto.setBounds(30, 266, 170, 30);

        tf_direccion.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_direccion.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_direccion);
        tf_direccion.setBounds(230, 266, 230, 30);

        tf_clave.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_clave.setForeground(Main_Colores.Fondo);
        tf_clave.setEnabled(false);
        getContentPane().add(tf_clave);
        tf_clave.setBounds(30, 90, 120, 28);

        btn_actualizar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btn_actualizar.setForeground(Main_Colores.Fondo);
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar);
        btn_actualizar.setBounds(180, 460, 120, 40);

        dc_fechaRegistro.setForeground(Main_Colores.Fondo);
        dc_fechaRegistro.setDateFormatString("dd - MMM - YYYY");
        dc_fechaRegistro.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        getContentPane().add(dc_fechaRegistro);
        dc_fechaRegistro.setBounds(30, 340, 170, 30);

        cbx_productoSumi.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbx_productoSumi.setForeground(Main_Colores.Fondo);
        cbx_productoSumi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion:", "COMPUTADORA", "LAPTOP", "COMPONENTES", "ACCESORIOS" }));
        getContentPane().add(cbx_productoSumi);
        cbx_productoSumi.setBounds(230, 340, 220, 30);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setForeground(Main_Colores.C_100);
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 150, 70, 20);

        tf_empresa.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_empresa.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_empresa);
        tf_empresa.setBounds(230, 90, 220, 28);

        cbx_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "AUSENTE", "INACTIVO", " " }));
        getContentPane().add(cbx_estado);
        cbx_estado.setBounds(30, 410, 140, 30);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel9.setForeground(Main_Colores.C_100);
        jLabel9.setText("Contacto:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 240, 90, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        Proveedor pro = new Proveedor();
        pro.setIdProveedor(Long.valueOf(tf_clave.getText()));
        pro.setEmpresa(tf_empresa.getText());
        pro.setProveedor(tf_nombre.getText());
        pro.setEmail(tf_email.getText());
        pro.setContacto(tf_contacto.getText());
        pro.setDireccion(tf_direccion.getText());
        pro.setProductoSuministrado(cbx_productoSumi.getSelectedItem().toString());
        pro.setEstado(cbx_estado.getSelectedItem().toString());
        Service_Proveedor service_Proveedor = new Service_Proveedor();
        if(service_Proveedor.actualizar(pro)){
            Utilidad.mostrarMensaje("Proveedor Actualizado.");
            this.dispose();
        }
            
        
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JComboBox<String> cbx_estado;
    private javax.swing.JComboBox<String> cbx_productoSumi;
    protected com.toedter.calendar.JDateChooser dc_fechaRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tf_clave;
    private javax.swing.JTextField tf_contacto;
    private javax.swing.JTextField tf_direccion;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_empresa;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}

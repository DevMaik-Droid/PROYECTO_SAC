package com.dev_team.views;

import com.dev_team.models.Proveedor;
import com.dev_team.utilidades.GradientDialog;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import java.awt.Dimension;

public class D_AdmProveedor extends GradientDialog {

    Proveedor prov;
    public D_AdmProveedor(boolean modal,Proveedor p) {     
        super(modal, Main_Colores.Fondo,Main_Colores.C_F800,Main_Colores.C_F700);
        initComponents();
        setLocationRelativeTo(null);
        setSize(new Dimension(860, 535));
        this.prov = p;
        iniciarComponenetes();
    }
    
    
    private void iniciarComponenetes(){
        
        tf_clave.setText(prov.getIdProveedor().toString());
        tf_nombre.setText(prov.getProveedor());
        tf_contacto.setText(prov.getContacto());
        tf_direccionproveedor.setText(prov.getDireccion());
        tf_email.setText(prov.getEmail());
        cbx_productoSumi.setSelectedItem(prov.getProductoSuministrado());

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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        tf_contacto = new javax.swing.JTextField();
        tf_direccionproveedor = new javax.swing.JTextField();
        tf_clave = new javax.swing.JTextField();
        btn_guardar = new JButtonRound("ACTUALIZAR",30);
        cbx_estadoDePago = new javax.swing.JComboBox<>();
        dc_fechaRegistro = new com.toedter.calendar.JDateChooser();
        tb_historial_transacciones = new javax.swing.JScrollPane();
        tb_historialTransacciones = new javax.swing.JTable();
        cbx_productoSumi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setForeground(Main_Colores.C_100);
        jLabel1.setText("ADMINISTRAR PROVEEDOR");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 20, 330, 32);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setText("Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 60, 20);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setForeground(Main_Colores.C_100);
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 150, 70, 20);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 190, 46, 20);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel6.setForeground(Main_Colores.C_100);
        jLabel6.setText("Producto suministrado:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(230, 310, 190, 20);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setForeground(Main_Colores.C_100);
        jLabel7.setText("Contacto:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 240, 90, 20);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel8.setForeground(Main_Colores.C_100);
        jLabel8.setText("Direccion:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(230, 240, 73, 20);

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel14.setForeground(Main_Colores.C_100);
        jLabel14.setText("Fecha de registro:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(30, 310, 160, 20);

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel15.setForeground(Main_Colores.C_100);
        jLabel15.setText("Historial de transacciones:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(520, 90, 230, 18);

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel16.setForeground(Main_Colores.C_100);
        jLabel16.setText("Estado de pago:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(170, 70, 120, 20);

        tf_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_nombre.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_nombre);
        tf_nombre.setBounds(110, 146, 260, 30);

        tf_email.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_email.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_email);
        tf_email.setBounds(110, 186, 260, 30);

        tf_contacto.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_contacto.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_contacto);
        tf_contacto.setBounds(30, 266, 170, 30);

        tf_direccionproveedor.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_direccionproveedor.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_direccionproveedor);
        tf_direccionproveedor.setBounds(230, 266, 170, 30);

        tf_clave.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_clave.setForeground(Main_Colores.Fondo);
        tf_clave.setEnabled(false);
        getContentPane().add(tf_clave);
        tf_clave.setBounds(30, 90, 70, 28);

        btn_guardar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btn_guardar.setForeground(Main_Colores.Fondo);
        btn_guardar.setText("GUARDAR");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btn_guardar);
        btn_guardar.setBounds(350, 440, 120, 40);

        cbx_estadoDePago.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbx_estadoDePago.setForeground(Main_Colores.Fondo);
        cbx_estadoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion:", "Completo", "Pendiente", "Parcialmente pagado" }));
        cbx_estadoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_estadoDePagoActionPerformed(evt);
            }
        });
        getContentPane().add(cbx_estadoDePago);
        cbx_estadoDePago.setBounds(150, 90, 200, 30);

        dc_fechaRegistro.setForeground(Main_Colores.Fondo);
        dc_fechaRegistro.setDateFormatString("dd - MMM - YYYY");
        dc_fechaRegistro.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        getContentPane().add(dc_fechaRegistro);
        dc_fechaRegistro.setBounds(30, 334, 170, 30);

        tb_historialTransacciones.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tb_historialTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_historial_transacciones.setViewportView(tb_historialTransacciones);

        getContentPane().add(tb_historial_transacciones);
        tb_historial_transacciones.setBounds(440, 120, 400, 260);

        cbx_productoSumi.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbx_productoSumi.setForeground(Main_Colores.Fondo);
        cbx_productoSumi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion:", "Computadora", "Laptop", "Componentes", "Accesorios" }));
        getContentPane().add(cbx_productoSumi);
        cbx_productoSumi.setBounds(230, 330, 190, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_estadoDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_estadoDePagoActionPerformed
   
    }//GEN-LAST:event_cbx_estadoDePagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_estadoDePago;
    private javax.swing.JComboBox<String> cbx_productoSumi;
    protected com.toedter.calendar.JDateChooser dc_fechaRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTable tb_historialTransacciones;
    private javax.swing.JScrollPane tb_historial_transacciones;
    private javax.swing.JTextField tf_clave;
    private javax.swing.JTextField tf_contacto;
    private javax.swing.JTextField tf_direccionproveedor;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}

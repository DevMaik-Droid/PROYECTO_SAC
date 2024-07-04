package com.dev_team.views;

import com.dev_team.models.Producto;
import com.dev_team.services.Service_Producto;
import com.dev_team.utilidades.GradientDialog;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.Utilidad;

import java.awt.Dimension;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class D_AdmProductos extends GradientDialog {

    Producto producto = null;

    public D_AdmProductos(boolean modal, Producto producto) {
        super(modal, Main_Colores.Fondo,Main_Colores.C_F800,Main_Colores.C_F700);
        this.producto = producto;
        
        initComponents();
        iniciarComponentes();
        setSize(new Dimension(700, 550));
        setTitle("Administracion de Productos");
        setLocationRelativeTo(null);
        tf_categoria.setEditable(false);
        tf_nombre.setEditable(false);
        dc_Registro.setEnabled(false);
        tf_total.setEditable(false);
        tf_stockActual.setEditable(false);
        
        tf_stockNuevo.getDocument().addDocumentListener(new DocumentListener() {
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
        tf_precioU.getDocument().addDocumentListener(new DocumentListener() {
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
        if (!tf_precioU.getText().isEmpty() && !tf_stockNuevo.getText().isEmpty()) {
            double precioUnitario = Double.parseDouble(tf_precioU.getText());
            int cantidad = Integer.parseInt(tf_stockNuevo.getText());
            tf_total.setText(String.format("%.2f",(precioUnitario * cantidad)));
        }else{
            tf_total.setText("0");
        }

    }

    
    private void iniciarComponentes(){
        tf_nombre.setText(producto.getNombreProducto());
        tf_clave.setText(producto.getClaveProducto());
        tf_precioU.setText(producto.getPrecioUnitario()+"");
        tf_stockActual.setText(producto.getStock()+"");
        tf_categoria.setText(producto.getCategoriaProducto());
        dc_Registro.setDate(producto.getFechaModicacion());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_precioU = new javax.swing.JTextField();
        tf_stockActual = new javax.swing.JTextField();
        tf_clave = new javax.swing.JTextField();
        dc_Registro = new com.toedter.calendar.JDateChooser();
        btn_eliminar = new JButtonRound("ELIMINAR",30);
        btn_guardar1 = new JButtonRound("REGISTRAR",30);
        tf_categoria = new javax.swing.JTextField();
        tf_nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_stockNuevo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setForeground(Main_Colores.C_100);
        jLabel1.setText("ADMINISTRAR PRODUCTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 300, 30);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setText("Clave: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 70, 60, 20);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setForeground(Main_Colores.C_100);
        jLabel3.setText("Precio Unitario");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 210, 108, 20);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("Stock actual:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 130, 100, 20);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel6.setForeground(Main_Colores.C_100);
        jLabel6.setText("Fecha Registro");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 280, 160, 20);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel9.setForeground(Main_Colores.C_100);
        jLabel9.setText("Nombre:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(200, 70, 70, 20);

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel10.setForeground(Main_Colores.C_100);
        jLabel10.setText("Categoria");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(360, 70, 88, 20);

        tf_precioU.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_precioU.setForeground(Main_Colores.Fondo);
        tf_precioU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_precioUActionPerformed(evt);
            }
        });
        getContentPane().add(tf_precioU);
        tf_precioU.setBounds(50, 230, 140, 30);

        tf_stockActual.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_stockActual.setForeground(Main_Colores.Fondo);
        getContentPane().add(tf_stockActual);
        tf_stockActual.setBounds(50, 150, 170, 30);

        tf_clave.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_clave.setForeground(Main_Colores.Fondo);
        tf_clave.setEnabled(false);
        getContentPane().add(tf_clave);
        tf_clave.setBounds(50, 90, 90, 30);

        dc_Registro.setBackground(new java.awt.Color(6, 18, 52));
        dc_Registro.setForeground(Main_Colores.Fondo);
        dc_Registro.setDateFormatString("dd - MMM - YYYY");
        dc_Registro.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        getContentPane().add(dc_Registro);
        dc_Registro.setBounds(50, 310, 170, 30);

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
        btn_eliminar.setBounds(300, 410, 130, 40);

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
        btn_guardar1.setBounds(120, 410, 130, 40);

        tf_categoria.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_categoria.setForeground(Main_Colores.Fondo);
        tf_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_categoriaActionPerformed(evt);
            }
        });
        getContentPane().add(tf_categoria);
        tf_categoria.setBounds(360, 90, 130, 30);

        tf_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_nombre.setForeground(Main_Colores.Fondo);
        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(tf_nombre);
        tf_nombre.setBounds(200, 90, 130, 30);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setForeground(Main_Colores.C_100);
        jLabel5.setText("AgregarStock");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 210, 100, 20);

        tf_stockNuevo.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_stockNuevo.setForeground(Main_Colores.Fondo);
        tf_stockNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_stockNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(tf_stockNuevo);
        tf_stockNuevo.setBounds(210, 230, 140, 30);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setForeground(Main_Colores.C_100);
        jLabel7.setText("Total");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(380, 210, 36, 20);

        tf_total.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tf_total.setForeground(Main_Colores.Fondo);
        tf_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_totalActionPerformed(evt);
            }
        });
        getContentPane().add(tf_total);
        tf_total.setBounds(380, 230, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        Producto p = new Producto();
        p.setClaveProducto(tf_clave.getText());
        p.setStock(Integer.valueOf(tf_stockNuevo.getText()));
        p.setPrecioUnitario(Double.valueOf(tf_precioU.getText()));
        p.setPrecioTotal(Double.valueOf(tf_total.getText()));
        Service_Producto service_Producto = new Service_Producto();
        if(service_Producto.actualizarStock(p)){
            Utilidad.mostrarMensaje("Producto Actualizado");
            this.dispose();
        }else{
            Utilidad.mostrarMensaje("Error en actualizar");
            
        }
        
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
       
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tf_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_categoriaActionPerformed

    private void tf_precioUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_precioUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_precioUActionPerformed

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void tf_stockNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_stockNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_stockNuevoActionPerformed

    private void tf_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_totalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar1;
    private com.toedter.calendar.JDateChooser dc_Registro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tf_categoria;
    private javax.swing.JTextField tf_clave;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_precioU;
    private javax.swing.JTextField tf_stockActual;
    private javax.swing.JTextField tf_stockNuevo;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables
}

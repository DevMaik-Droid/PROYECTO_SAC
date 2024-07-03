package com.dev_team.views;

import com.dev_team.models.Proveedor;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.PanelGradient;
import com.dev_team.utilidades.Panel_Round;
import java.awt.Color;
import javax.swing.JPanel;



public class V_RegistrarAccesorios extends JPanel {

    /**
     * Creates new form V_RegistrarUsuario
     */
    public V_RegistrarAccesorios() {
       
        initComponents();
        panel_main.setBackground(Main_Colores.Fondo);
        setBackground(Main_Colores.Fondo_2);
    }

    
    private void iniciarComponentes(){
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new Panel_Round(20,Color.YELLOW,Color.ORANGE);
        panelTitle = new PanelGradient(Color.YELLOW,Color.ORANGE);
        jLabel14 = new javax.swing.JLabel();
        panel_form = new javax.swing.JPanel();
        tf_nombre = new javax.swing.JTextField();
        lb_imagen = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_descripcion = new javax.swing.JTextArea();
        btn_buscar = new JButtonRound("Buscar",20);
        btn_registrar = new JButtonRound("Registrar",20);
        jLabel13 = new javax.swing.JLabel();
        tf_marca = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tf_modelo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 51, 51));

        panel_main.setLayout(new java.awt.BorderLayout());

        panelTitle.setBackground(new java.awt.Color(51, 51, 255));
        panelTitle.setPreferredSize(new java.awt.Dimension(40, 40));
        panelTitle.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("REGISTRAR ACCESORIOS");
        panelTitle.add(jLabel14, java.awt.BorderLayout.CENTER);

        panel_main.add(panelTitle, java.awt.BorderLayout.NORTH);

        panel_form.setOpaque(false);
        panel_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_nombre.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 56, 229, 30));

        lb_imagen.setBackground(new java.awt.Color(255, 255, 255));
        lb_imagen.setOpaque(true);
        panel_form.add(lb_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 160, 160));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(Main_Colores.C_100);
        jLabel7.setText("Nombre:");
        panel_form.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Accesorio");
        panel_form.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 190, 20));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(Main_Colores.C_100);
        jLabel8.setText("Descripcion:");
        panel_form.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, -1));

        ta_descripcion.setColumns(20);
        ta_descripcion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        ta_descripcion.setForeground(Main_Colores.Fondo);
        ta_descripcion.setRows(5);
        ta_descripcion.setBorder(null);
        jScrollPane1.setViewportView(ta_descripcion);

        panel_form.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 480, 160));

        btn_buscar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btn_buscar.setForeground(Main_Colores.Fondo);
        btn_buscar.setText("Buscar");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_form.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 130, -1));

        btn_registrar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btn_registrar.setForeground(Main_Colores.Fondo);
        btn_registrar.setText("Registrar");
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        panel_form.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 210, 50));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setForeground(Main_Colores.C_100);
        jLabel13.setText("Marca:");
        panel_form.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 30, -1, 20));

        tf_marca.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_marca.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 56, 229, 30));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel16.setForeground(Main_Colores.C_100);
        jLabel16.setText("Modelo:");
        panel_form.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 130, -1));

        tf_modelo.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_modelo.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 150, 30));

        panel_main.add(panel_form, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_registrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btn_buscar;
    protected javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lb_imagen;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JPanel panel_form;
    private javax.swing.JPanel panel_main;
    protected javax.swing.JTextArea ta_descripcion;
    protected javax.swing.JTextField tf_marca;
    protected javax.swing.JTextField tf_modelo;
    protected javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}

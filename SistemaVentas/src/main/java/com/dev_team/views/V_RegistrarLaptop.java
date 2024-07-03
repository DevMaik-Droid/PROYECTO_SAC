package com.dev_team.views;

import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.PanelGradient;
import com.dev_team.utilidades.Panel_Round;
import java.awt.Color;
import javax.swing.JPanel;

public class V_RegistrarLaptop extends JPanel {

    /**
     * Creates new form V_RegistrarUsuario
     */
    public V_RegistrarLaptop() {
        initComponents();
        panel_main.setBackground(Main_Colores.Fondo);
        setBackground(Main_Colores.Fondo_2);

    }

    private void iniciarComponentes() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new Panel_Round(20,Color.ORANGE,Color.red);
        panel_form = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_descripcionLaptop = new javax.swing.JTextArea();
        btn_buscarLP = new javax.swing.JButton();
        btn_registrarLP = new JButtonRound("Registrar",30);
        tf_modeloLP = new javax.swing.JTextField();
        tf_almacenamiento = new javax.swing.JTextField();
        tf_pantallaLP = new javax.swing.JTextField();
        tf_marca = new javax.swing.JTextField();
        tf_bateriaLP = new javax.swing.JTextField();
        tf_conectividadLP1 = new javax.swing.JTextField();
        tf_procesador = new javax.swing.JTextField();
        tf_memoriaRam = new javax.swing.JTextField();
        tf_tarjetaGrafica = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        panelTitle = new PanelGradient(Color.ORANGE,Color.red);
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_form.setOpaque(false);
        panel_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setOpaque(true);
        panel_form.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 200, 170));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setForeground(Main_Colores.C_100);
        jLabel6.setText("Descripcion:");
        panel_form.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 120, -1));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(Main_Colores.C_100);
        jLabel7.setText("Marca:");
        panel_form.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(Main_Colores.C_100);
        jLabel9.setText("Memoria ram:");
        panel_form.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("Conectividad:");
        panel_form.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setForeground(Main_Colores.C_100);
        jLabel5.setText("Pantalla:");
        panel_form.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(Main_Colores.C_100);
        jLabel12.setText("Procesador:");
        panel_form.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setForeground(Main_Colores.C_100);
        jLabel11.setText("Almacenamiento:");
        panel_form.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 200, -1));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(Main_Colores.C_100);
        jLabel8.setText("Modelo:");
        panel_form.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel14.setForeground(Main_Colores.C_100);
        jLabel14.setText("Bateria:");
        panel_form.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Laptop");
        panel_form.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 200, 20));

        ta_descripcionLaptop.setColumns(20);
        ta_descripcionLaptop.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        ta_descripcionLaptop.setForeground(Main_Colores.Fondo);
        ta_descripcionLaptop.setRows(5);
        ta_descripcionLaptop.setBorder(null);
        jScrollPane1.setViewportView(ta_descripcionLaptop);

        panel_form.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 480, 90));

        btn_buscarLP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btn_buscarLP.setForeground(Main_Colores.Fondo);
        btn_buscarLP.setText("Buscar");
        btn_buscarLP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_form.add(btn_buscarLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 130, -1));

        btn_registrarLP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btn_registrarLP.setForeground(Main_Colores.Fondo);
        btn_registrarLP.setText("Registrar");
        btn_registrarLP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrarLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarLPActionPerformed(evt);
            }
        });
        panel_form.add(btn_registrarLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 200, 50));

        tf_modeloLP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_modeloLP.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_modeloLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 200, 30));

        tf_almacenamiento.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_almacenamiento.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_almacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 200, 30));

        tf_pantallaLP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_pantallaLP.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_pantallaLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 200, 30));

        tf_marca.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_marca.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 200, 30));

        tf_bateriaLP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_bateriaLP.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_bateriaLP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 200, 30));

        tf_conectividadLP1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_conectividadLP1.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_conectividadLP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 200, 30));

        tf_procesador.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_procesador.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_procesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 30));

        tf_memoriaRam.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_memoriaRam.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_memoriaRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 200, 30));

        tf_tarjetaGrafica.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_tarjetaGrafica.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_tarjetaGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 200, 30));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setForeground(Main_Colores.C_100);
        jLabel13.setText("Tarjeta grafica:");
        panel_form.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        panel_main.add(panel_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 45, 850, 630));

        panelTitle.setBackground(new java.awt.Color(51, 51, 255));
        panelTitle.setPreferredSize(new java.awt.Dimension(40, 40));
        panelTitle.setLayout(new java.awt.BorderLayout());

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("REGISTRAR LAPTOP");
        panelTitle.add(jLabel16, java.awt.BorderLayout.SOUTH);

        panel_main.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarLPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_registrarLPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btn_buscarLP;
    protected javax.swing.JButton btn_registrarLP;
    protected javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JPanel panel_form;
    private javax.swing.JPanel panel_main;
    protected javax.swing.JTextArea ta_descripcionLaptop;
    protected javax.swing.JTextField tf_almacenamiento;
    protected javax.swing.JTextField tf_bateriaLP;
    protected javax.swing.JTextField tf_conectividadLP1;
    protected javax.swing.JTextField tf_marca;
    protected javax.swing.JTextField tf_memoriaRam;
    protected javax.swing.JTextField tf_modeloLP;
    protected javax.swing.JTextField tf_pantallaLP;
    protected javax.swing.JTextField tf_procesador;
    protected javax.swing.JTextField tf_tarjetaGrafica;
    // End of variables declaration//GEN-END:variables
}

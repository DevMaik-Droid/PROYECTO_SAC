package com.dev_team.views;

import com.dev_team.models.Componente;
import com.dev_team.models.Producto;
import com.dev_team.utilidades.ComboBoxRender;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.PanelGradient;
import com.dev_team.utilidades.Panel_Round;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;


public class V_RegistrarComputadora extends JPanel {

    /**
     * Creates new form V_RegistrarUsuario
     */
    public V_RegistrarComputadora() {
        
        initComponents();
        panel_main.setBackground(Main_Colores.Fondo);
        setBackground(Main_Colores.Fondo_2);
        cbx_tarjetaMadre.setBackground(Color.BLUE);
        
    }

    
    private void iniciarComponentes(){
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new Panel_Round(20,Color.YELLOW,Color.GREEN);
        panelTitle = new PanelGradient(Color.YELLOW, Color.GREEN);
        jLabel17 = new javax.swing.JLabel();
        panel_form = new javax.swing.JPanel();
        lb_imagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_descripcion = new javax.swing.JTextArea();
        btn_buscar = new JButtonRound("Buscar",20);
        cbx_ramCO = new javax.swing.JComboBox<>();
        cbx_tarjetaMadre = new javax.swing.JComboBox<>();
        cbx_monitor = new javax.swing.JComboBox<>();
        cbx_procesadorCO = new javax.swing.JComboBox<>();
        cbx_discoCO = new javax.swing.JComboBox<>();
        btn_registrar = new JButtonRound("Registrar",20);
        cbx_caseCO = new javax.swing.JComboBox<>();
        tf_nombreCO = new javax.swing.JTextField();
        cbx_ventiladores = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbx_disipadores = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbx_gpu = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbx_fuente = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        tf_costo_total = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 51, 51));

        panel_main.setLayout(new java.awt.BorderLayout());

        panelTitle.setBackground(new java.awt.Color(51, 51, 255));
        panelTitle.setPreferredSize(new java.awt.Dimension(40, 40));
        panelTitle.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("REGISTRAR COMPUTADORA");
        panelTitle.add(jLabel17, java.awt.BorderLayout.PAGE_END);

        panel_main.add(panelTitle, java.awt.BorderLayout.PAGE_START);

        panel_form.setOpaque(false);
        panel_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_imagen.setBackground(new java.awt.Color(255, 255, 255));
        lb_imagen.setOpaque(true);
        panel_form.add(lb_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 190, 170));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel2.setForeground(Main_Colores.C_100);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Computadora");
        panel_form.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 190, 30));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setForeground(Main_Colores.C_100);
        jLabel6.setText("Descripcion:");
        panel_form.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 110, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(Main_Colores.C_100);
        jLabel9.setText("Memoria ram:");
        panel_form.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("Tarjeta Madre:");
        panel_form.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setForeground(Main_Colores.C_100);
        jLabel5.setText("Monitor:");
        panel_form.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(Main_Colores.C_100);
        jLabel12.setText("Procesador:");
        panel_form.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setForeground(Main_Colores.C_100);
        jLabel11.setText("Almacenamiento(SSD/HDD):");
        panel_form.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(Main_Colores.C_100);
        jLabel8.setText("Case:");
        panel_form.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel14.setForeground(Main_Colores.C_100);
        jLabel14.setText("Nombre:");
        panel_form.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        ta_descripcion.setColumns(20);
        ta_descripcion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        ta_descripcion.setForeground(Main_Colores.Fondo);
        ta_descripcion.setRows(5);
        ta_descripcion.setBorder(null);
        jScrollPane1.setViewportView(ta_descripcion);

        panel_form.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 470, 130));

        btn_buscar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btn_buscar.setForeground(Main_Colores.Fondo);
        btn_buscar.setText("Buscar");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_form.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 100, 30));

        cbx_ramCO.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_ramCO.setForeground(Main_Colores.Fondo);
        cbx_ramCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ramCOActionPerformed(evt);
            }
        });
        panel_form.add(cbx_ramCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 230, 30));

        cbx_tarjetaMadre.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_tarjetaMadre.setForeground(Main_Colores.Fondo);
        cbx_tarjetaMadre.setBorder(null);
        cbx_tarjetaMadre.setRenderer(new ComboBoxRender());
        panel_form.add(cbx_tarjetaMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 30));

        cbx_monitor.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_monitor.setForeground(Main_Colores.Fondo);
        panel_form.add(cbx_monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 220, 30));

        cbx_procesadorCO.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_procesadorCO.setForeground(Main_Colores.Fondo);
        cbx_procesadorCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_procesadorCOActionPerformed(evt);
            }
        });
        panel_form.add(cbx_procesadorCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 30));

        cbx_discoCO.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_discoCO.setForeground(Main_Colores.Fondo);
        panel_form.add(cbx_discoCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 230, 30));

        btn_registrar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btn_registrar.setForeground(Main_Colores.Fondo);
        btn_registrar.setText("Registrar");
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_form.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 120, 40));

        cbx_caseCO.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_caseCO.setForeground(Main_Colores.Fondo);
        cbx_caseCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_caseCOActionPerformed(evt);
            }
        });
        panel_form.add(cbx_caseCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 220, 30));

        tf_nombreCO.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_nombreCO.setForeground(Main_Colores.Fondo);
        panel_form.add(tf_nombreCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 190, 30));

        cbx_ventiladores.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_ventiladores.setForeground(Main_Colores.Fondo);
        panel_form.add(cbx_ventiladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 230, 30));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setForeground(Main_Colores.C_100);
        jLabel13.setText("Ventiladores:");
        panel_form.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel18.setForeground(Main_Colores.C_100);
        jLabel18.setText("Disipadores:");
        panel_form.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        cbx_disipadores.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_disipadores.setForeground(Main_Colores.Fondo);
        panel_form.add(cbx_disipadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 220, 30));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel19.setForeground(Main_Colores.C_100);
        jLabel19.setText("Tarjeta Grafica:");
        panel_form.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        cbx_gpu.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_gpu.setForeground(Main_Colores.Fondo);
        cbx_gpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_gpuActionPerformed(evt);
            }
        });
        panel_form.add(cbx_gpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 230, 30));

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel20.setForeground(Main_Colores.C_100);
        jLabel20.setText("Fuente:");
        panel_form.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        cbx_fuente.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbx_fuente.setForeground(Main_Colores.Fondo);
        panel_form.add(cbx_fuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 230, 30));

        jLabel21.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel21.setForeground(Main_Colores.C_100);
        jLabel21.setText("Costo Total:");
        panel_form.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));
        panel_form.add(tf_costo_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 200, 40));

        panel_main.add(panel_form, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_procesadorCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_procesadorCOActionPerformed

    }//GEN-LAST:event_cbx_procesadorCOActionPerformed

    private void cbx_ramCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_ramCOActionPerformed

    }//GEN-LAST:event_cbx_ramCOActionPerformed

    private void cbx_gpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_gpuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_gpuActionPerformed

    private void cbx_caseCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_caseCOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_caseCOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btn_buscar;
    protected javax.swing.JButton btn_registrar;
    protected javax.swing.JComboBox<Componente> cbx_caseCO;
    protected javax.swing.JComboBox<Componente> cbx_discoCO;
    protected javax.swing.JComboBox<Componente> cbx_disipadores;
    protected javax.swing.JComboBox<Componente> cbx_fuente;
    protected javax.swing.JComboBox<Componente> cbx_gpu;
    protected javax.swing.JComboBox<Componente> cbx_monitor;
    protected javax.swing.JComboBox<Componente> cbx_procesadorCO;
    protected javax.swing.JComboBox<Componente> cbx_ramCO;
    protected javax.swing.JComboBox<Componente> cbx_tarjetaMadre;
    protected javax.swing.JComboBox<Componente> cbx_ventiladores;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lb_imagen;
    private javax.swing.JPanel panelTitle;
    protected javax.swing.JPanel panel_form;
    private javax.swing.JPanel panel_main;
    protected javax.swing.JTextArea ta_descripcion;
    protected javax.swing.JTextField tf_costo_total;
    protected javax.swing.JTextField tf_nombreCO;
    // End of variables declaration//GEN-END:variables
}

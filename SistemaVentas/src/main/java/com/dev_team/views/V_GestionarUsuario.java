package com.dev_team.views;


import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.PanelGradient;
import com.dev_team.utilidades.Panel_Round;
import java.awt.Color;
import javax.swing.JPanel;

public class V_GestionarUsuario extends JPanel {

   
    
    public V_GestionarUsuario() {
        initComponents();
        setBackground(Main_Colores.Fondo_2);
        panel_table.setBackground(Color.WHITE);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTop = new javax.swing.JPanel();
        panel_topGestion = new PanelGradient(Main_Colores.Naranja1,Main_Colores.Naranja2);
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbx_filtrarGU = new javax.swing.JComboBox<>();
        tf_clave = new javax.swing.JTextField();
        btn_buscaUS = new JButtonRound("BUSCAR",20);
        tf_filtrar = new javax.swing.JTextField();
        PanelMid = new javax.swing.JPanel();
        panel_table = new Panel_Round(20,Color.MAGENTA,Color.BLUE);
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new org.jdesktop.swingx.JXTable();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.BorderLayout());

        PanelTop.setBackground(Main_Colores.Fondo_2);
        PanelTop.setPreferredSize(new java.awt.Dimension(1070, 159));

        panel_topGestion.setBackground(new java.awt.Color(19, 18, 54));
        panel_topGestion.setOpaque(false);
        panel_topGestion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GESTION DE USUARIOS");
        panel_topGestion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clave:");
        panel_topGestion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtrar:");
        panel_topGestion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        cbx_filtrarGU.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbx_filtrarGU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion:", "Cedula de identidad", "Nombre", "Apellido" }));
        panel_topGestion.add(cbx_filtrarGU, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 200, 30));

        tf_clave.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_clave.setBorder(null);
        tf_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_claveActionPerformed(evt);
            }
        });
        panel_topGestion.add(tf_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 130, 30));

        btn_buscaUS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_buscaUS.setText("BUSCAR");
        btn_buscaUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_topGestion.add(btn_buscaUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 100, 30));

        tf_filtrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_filtrar.setBorder(null);
        panel_topGestion.add(tf_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 200, 30));

        javax.swing.GroupLayout PanelTopLayout = new javax.swing.GroupLayout(PanelTop);
        PanelTop.setLayout(PanelTopLayout);
        PanelTopLayout.setHorizontalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTopLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_topGestion, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        PanelTopLayout.setVerticalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTopLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_topGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        add(PanelTop, java.awt.BorderLayout.PAGE_START);

        PanelMid.setForeground(new java.awt.Color(255, 255, 255));
        PanelMid.setOpaque(false);

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setPreferredSize(new java.awt.Dimension(800, 408));

        jScrollPane1.setBorder(null);

        tabla_usuarios.setForeground(new java.awt.Color(51, 51, 51));
        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"rtdfg", "dfgdfg", "dfgdfg", "dfgdfg"},
                {"dfgdf", "dfgdfg", "dfgdfg", "dfgdfgdf"},
                {"eeeeee", "sssss", "dfgsss", "dfgdfg"},
                {"dfgdfg", "dfgdf", "dfgdf", "dfgdf"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_usuarios.setColumnControlVisible(true);
        tabla_usuarios.setGridColor(new java.awt.Color(255, 255, 255));
        tabla_usuarios.setIntercellSpacing(new java.awt.Dimension(10, 0));
        tabla_usuarios.setShowGrid(false);
        jScrollPane1.setViewportView(tabla_usuarios);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tableLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelMidLayout = new javax.swing.GroupLayout(PanelMid);
        PanelMid.setLayout(PanelMidLayout);
        PanelMidLayout.setHorizontalGroup(
            PanelMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMidLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        PanelMidLayout.setVerticalGroup(
            PanelMidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMidLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel_table, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        add(PanelMid, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_claveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_claveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMid;
    private javax.swing.JPanel PanelTop;
    protected javax.swing.JButton btn_buscaUS;
    protected javax.swing.JComboBox<String> cbx_filtrarGU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_table;
    private javax.swing.JPanel panel_topGestion;
    protected org.jdesktop.swingx.JXTable tabla_usuarios;
    protected javax.swing.JTextField tf_clave;
    protected javax.swing.JTextField tf_filtrar;
    // End of variables declaration//GEN-END:variables
}

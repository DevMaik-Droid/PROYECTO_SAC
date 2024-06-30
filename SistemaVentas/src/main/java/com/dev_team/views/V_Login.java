          package com.dev_team.views;

import com.dev_team.dashboard.Vista_Dashboard;
import com.dev_team.models.Usuario;
import com.dev_team.services.Conexion;
import com.dev_team.utilidades.GradientSeparador;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.PanelGradient;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class V_Login extends javax.swing.JFrame {

    Point posicion;
    Point posicionInicial; //Variable para almacenar la posición inicial al iniciar el arrastre

    public V_Login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Login - SISTEMA DE VENTAS");
        this.setSize(new Dimension(800, 600));
        setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

        lb_barra.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent m) {
                // Almacenar la posición inicial del ratón dentro de la ventana
                posicion = m.getPoint();
                SwingUtilities.convertPointToScreen(posicion, lb_barra);
                // Almacenar la posición inicial de la ventana
                posicionInicial = getLocation();
            }
        });

        lb_barra.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent m) {
                // Calcular la nueva posición de lsa ventana en función del movimiento del ratón y la posición inicial de la ventana
                int x = posicionInicial.x + m.getXOnScreen() - posicion.x;
                int y = posicionInicial.y + m.getYOnScreen() - posicion.y;
                setLocation(x, y);
            }
        });

    }

    private Icon ponerImagen(String url) {
        Image image = new ImageIcon(getClass().getResource(url)).getImage().getScaledInstance(lb_fondo_login.getWidth(), lb_fondo_login.getHeight(), Image.SCALE_DEFAULT);
        Icon icon = new ImageIcon(image);
        return icon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_header = new javax.swing.JPanel();
        panel_titulo = new PanelGradient(Color.MAGENTA,Color.BLUE);
        panel_title = new javax.swing.JPanel();
        lb_barra = new javax.swing.JLabel();
        panel_acciones = new javax.swing.JPanel();
        lb_cerrar = new javax.swing.JLabel();
        panel_izquierdo = new javax.swing.JPanel();
        lb_fondo_login = new javax.swing.JLabel();
        panel_derecho = new javax.swing.JPanel();
        btn_mostrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ingresar = new JButtonRound("Ingresar",20);
        jSeparator1 = new GradientSeparador();
        jSeparator2 = new GradientSeparador();
        tf_usuario = new javax.swing.JTextField();
        pf_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_header.setLayout(new java.awt.BorderLayout());

        panel_titulo.setPreferredSize(new java.awt.Dimension(100, 30));
        panel_titulo.setLayout(new javax.swing.BoxLayout(panel_titulo, javax.swing.BoxLayout.LINE_AXIS));

        panel_title.setOpaque(false);
        panel_title.setLayout(new java.awt.BorderLayout());

        lb_barra.setBackground(Main_Colores.C_900
        );
        lb_barra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_barra.setForeground(new java.awt.Color(255, 255, 255));
        lb_barra.setText("\t Login - Bienvenido");
        lb_barra.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        lb_barra.setPreferredSize(new java.awt.Dimension(1500, 20));
        lb_barra.setVerifyInputWhenFocusTarget(false);
        lb_barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lb_barraMouseDragged(evt);
            }
        });
        lb_barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_barraMousePressed(evt);
            }
        });
        panel_title.add(lb_barra, java.awt.BorderLayout.CENTER);

        panel_titulo.add(panel_title);

        panel_acciones.setOpaque(false);
        panel_acciones.setPreferredSize(new java.awt.Dimension(70, 30));
        panel_acciones.setRequestFocusEnabled(false);
        panel_acciones.setLayout(new java.awt.BorderLayout());

        lb_cerrar.setBackground(new java.awt.Color(255, 51, 51));
        lb_cerrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        lb_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cerrar.setText("X");
        lb_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_cerrar.setOpaque(true);
        lb_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_cerrarMouseExited(evt);
            }
        });
        panel_acciones.add(lb_cerrar, java.awt.BorderLayout.CENTER);

        panel_titulo.add(panel_acciones);

        panel_header.add(panel_titulo, java.awt.BorderLayout.NORTH);

        panel_izquierdo.setBackground(Main_Colores.Fondo);
        panel_izquierdo.setLayout(new java.awt.BorderLayout());

        lb_fondo_login.setBackground(new java.awt.Color(255, 255, 255));
        lb_fondo_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_fondo_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login_logo.jpeg"))); // NOI18N
        lb_fondo_login.setOpaque(true);
        lb_fondo_login.setPreferredSize(new java.awt.Dimension(400, 500));
        panel_izquierdo.add(lb_fondo_login, java.awt.BorderLayout.CENTER);

        panel_header.add(panel_izquierdo, java.awt.BorderLayout.WEST);

        panel_derecho.setBackground(Main_Colores.Fondo);
        panel_derecho.setPreferredSize(new java.awt.Dimension(400, 500));
        panel_derecho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_mostrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-eye-30.png"))); // NOI18N
        btn_mostrar.setBorder(null);
        btn_mostrar.setBorderPainted(false);
        btn_mostrar.setContentAreaFilled(false);
        btn_mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mostrar.setFocusPainted(false);
        btn_mostrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ophthalmology-30.png"))); // NOI18N
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        panel_derecho.add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 40, -1));

        jLabel3.setFont(new java.awt.Font("Gotham Thin", 0, 40)); // NOI18N
        jLabel3.setForeground(Main_Colores.C_100);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesión");
        panel_derecho.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 400, 53));

        jLabel4.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel4.setForeground(Main_Colores.C_100);
        jLabel4.setText("USUARIO:");
        panel_derecho.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, 30));

        jLabel5.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel5.setForeground(Main_Colores.C_100);
        jLabel5.setText("CONTRASEÑA:");
        panel_derecho.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 30));

        btn_ingresar.setBackground(Main_Colores.Fondo_2);
        btn_ingresar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btn_ingresar.setForeground(Main_Colores.C_100);
        btn_ingresar.setText("Ingresar");
        btn_ingresar.setBorder(null);
        btn_ingresar.setBorderPainted(false);
        btn_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingresar.setFocusPainted(false);
        btn_ingresar.setFocusable(false);
        btn_ingresar.setRequestFocusEnabled(false);
        btn_ingresar.setVerifyInputWhenFocusTarget(false);
        btn_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseExited(evt);
            }
        });
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        panel_derecho.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 210, 60));

        jSeparator1.setBackground(Main_Colores.Fondo);
        jSeparator1.setForeground(Main_Colores.Fondo);
        panel_derecho.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 310, 10));

        jSeparator2.setBackground(Main_Colores.Fondo);
        jSeparator2.setForeground(Main_Colores.Fondo);
        panel_derecho.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 310, 10));

        tf_usuario.setBackground(Main_Colores.Fondo);
        tf_usuario.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        tf_usuario.setForeground(Main_Colores.C_100);
        tf_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_usuario.setBorder(null);
        tf_usuario.setCaretColor(new java.awt.Color(231,231,231));
        panel_derecho.add(tf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 240, 40));

        pf_password.setBackground(Main_Colores.Fondo);
        pf_password.setFont(pf_password.getFont().deriveFont(pf_password.getFont().getSize()+7f));
        pf_password.setForeground(Main_Colores.C_100);
        pf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pf_password.setBorder(null);
        pf_password.setCaretColor(new java.awt.Color(231,231,231));
        pf_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pf_passwordKeyPressed(evt);
            }
        });
        panel_derecho.add(pf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 250, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-password-40 (1).png"))); // NOI18N
        panel_derecho.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 40, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-40.png"))); // NOI18N
        panel_derecho.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 40, 50));

        panel_header.add(panel_derecho, java.awt.BorderLayout.EAST);

        getContentPane().add(panel_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        iniciarSession();

    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void iniciarSession() {
        if (!tf_usuario.getText().isEmpty() && !pf_password.getText().isEmpty()) {

            Connection cnt = Conexion.conectar();
            String sql = String.format("SELECT * FROM tb_usuario WHERE usuario = '%s' AND contrasenia = '%s'", tf_usuario.getText().trim(), pf_password.getText().trim());

            try (PreparedStatement pst = cnt.prepareStatement(sql)) {

                ResultSet rst = pst.executeQuery();
                if (rst.next()) {
                    Usuario us = new Usuario();
                    us.setIdUsuario(rst.getLong("idUsuario"));
                    us.setNombre(rst.getString("nombre"));
                    us.setApellido(rst.getString("apellido"));
                    us.setCi(rst.getString("ci"));
                    us.setFechaNacimiento(rst.getDate("fecha_nacimiento"));
                    us.setTelefono(rst.getString("telefono"));
                    us.setDireccion(rst.getString("direccion"));
                    us.setUsuario(rst.getString("usuario"));
                    us.setPassword(rst.getString("contrasenia"));
                    byte[] bs_image = rst.getBytes("foto");
                    us.setBytes_image(bs_image);
                    us.setFoto_recuperada(new ImageIcon(bs_image).getImage());
                    us.setClave(rst.getString("clave"));
                    us.setEstado(rst.getString("estado"));
                    us.setNivel(rst.getString("nivel"));
                    JOptionPane.showMessageDialog(null, "Bienvenido - ".concat(us.getNombre()));

                    Vista_Dashboard filtro = new Vista_Dashboard(us);
                    filtro.setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro al usuario.");
                }

                cnt.close();
            } catch (Exception e) {
                System.out.println("Error al iniciar sesion: " + e.getMessage());
            }
        }
    }

    private void btn_ingresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseEntered
        btn_ingresar.setBackground(new Color(49, 51, 70));
    }//GEN-LAST:event_btn_ingresarMouseEntered

    private void btn_ingresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseExited
        btn_ingresar.setBackground(new Color(41, 41, 65));
    }//GEN-LAST:event_btn_ingresarMouseExited
    boolean bandera = false;
    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed

        if (!bandera) {
            pf_password.setEchoChar((char) 0);
            btn_mostrar.setIcon(new ImageIcon(getClass().getResource("/images/icons8-ophthalmology-30.png")));
            bandera = true;
        } else {
            pf_password.setEchoChar('\u2022');
            btn_mostrar.setIcon(new ImageIcon(getClass().getResource("/images/icons8-eye-30.png")));
            bandera = false;
        }

    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void lb_barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_barraMouseDragged
        // Calcular la nueva posición de la ventana en función del movimiento del ratón y la posición inicial de la ventana
        int x = posicionInicial.x + evt.getXOnScreen() - posicion.x;
        int y = posicionInicial.y + evt.getYOnScreen() - posicion.y;
        setLocation(x, y);
    }//GEN-LAST:event_lb_barraMouseDragged

    private void lb_barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_barraMousePressed
        // Almacenar la posición inicial del ratón dentro de la ventana
        posicion = evt.getPoint();
        SwingUtilities.convertPointToScreen(posicion, lb_barra);
        // Almacenar la posición inicial de la ventana
        posicionInicial = getLocation();
    }//GEN-LAST:event_lb_barraMousePressed

    private void lb_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarMouseClicked

        int c = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar?");
        if (c == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_lb_cerrarMouseClicked

    private void lb_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarMouseEntered
        lb_cerrar.setBackground(Color.red);
        lb_cerrar.setForeground(Color.white);
        lb_barra.setBackground(Color.red);
        lb_barra.setText("Cerrar ventana");
        lb_barra.setForeground(Color.white);
    }//GEN-LAST:event_lb_cerrarMouseEntered

    private void lb_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarMouseExited
        lb_cerrar.setBackground(Color.white);
        lb_cerrar.setForeground(new Color(37, 32, 47));

        lb_barra.setBackground(Main_Colores.C_900);
        lb_barra.setText("\t Login - Bienvenido");
        lb_barra.setForeground(Color.WHITE);
    }//GEN-LAST:event_lb_cerrarMouseExited

    private void pf_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_passwordKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarSession();
        }
    }//GEN-LAST:event_pf_passwordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_barra;
    private javax.swing.JLabel lb_cerrar;
    private javax.swing.JLabel lb_fondo_login;
    private javax.swing.JPanel panel_acciones;
    private javax.swing.JPanel panel_derecho;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_izquierdo;
    private javax.swing.JPanel panel_title;
    private javax.swing.JPanel panel_titulo;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_usuario;
    // End of variables declaration//GEN-END:variables

}

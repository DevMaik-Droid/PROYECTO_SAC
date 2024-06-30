package com.dev_team.dashboard;

import com.dev_team.controllers.AccesorioController;
import com.dev_team.controllers.ComponentChartsControllers;
import com.dev_team.controllers.ComponentController;
import com.dev_team.controllers.ComputadoraController;
import com.dev_team.controllers.DashBoadController;
import com.dev_team.controllers.GestionProductosController;
import com.dev_team.controllers.GestionUsuarioController;
import com.dev_team.controllers.ProveedorController;
import com.dev_team.controllers.GestionProveedorController;
import com.dev_team.controllers.RegistrarProductoController;
import com.dev_team.controllers.UsuarioController;
import com.dev_team.controllers.VentasController;
import com.dev_team.models.Usuario;
import com.dev_team.services.Conexion;
import com.dev_team.utilidades.JButtonRound;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.Panel_Round;
import com.dev_team.views.D_AdmUsuario;
import com.dev_team.views.V_ChartsComponentes;
import com.dev_team.views.V_Dashboard;
import com.dev_team.views.V_GestionarProductos;
import com.dev_team.views.V_GestionarProveedores;
import com.dev_team.views.V_GestionarUsuario;
import com.dev_team.views.V_RegistrarAccesorios;
import com.dev_team.views.V_RegistrarComponentes;
import com.dev_team.views.V_RegistrarComputadora;
import com.dev_team.views.V_RegistrarLaptop;
import com.dev_team.views.V_RegistrarProducto;
import com.dev_team.views.V_RegistrarProveedor;
import com.dev_team.views.V_RegistrarUsuario;
import com.dev_team.views.V_Ventas;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Vista_Dashboard extends javax.swing.JFrame {

    private static Vista_Dashboard main;
    public static Long idUsuario;
    Point posicion;
    Point posicionInicial; // Variable para almacenar la posición inicial al iniciar el arrastre
    Usuario usuario;

    public Vista_Dashboard(Usuario us) {

        this.usuario = us;
        initComponents();

        try {

            Vista_Dashboard.idUsuario = usuario.getIdUsuario();
            lb_foto.setIcon(ponerFoto());
            lb_barra.setText("\t Nivel - ".concat(usuario.getNivel()));

            lb_nombre.setText(usuario.getNombre());
            lb_apellido.setText(usuario.getApellido());
        } catch (Exception e) {
        }

        panel_acciones.setLayout(new GridLayout(1, 3, 0, 0));

        if (usuario.getNivel().equalsIgnoreCase("Gerente")) {
            iniciarAccionesGen();
        } else if (usuario.getNivel().equalsIgnoreCase("Administrativo")) {
            iniciarAccionesAdm();
        }

        setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

        maximizar.setText("");
        maximizar.setIcon(ponerIcono("/images/iconoMinimizar.png", maximizar));

        jButton1.setText("[-]");

        setResizable(true);
        setLocationRelativeTo(null);
        setSize(1280, 800);

        panel_header.setBackground(Main_Colores.Fondo);
    }

    private Icon ponerFoto() {
        Image img = new ImageIcon(usuario.getFoto_recuperada()).getImage().getScaledInstance(lb_foto.getWidth(), lb_foto.getHeight(), Image.SCALE_DEFAULT);
        Icon icon = new ImageIcon(img);
        return icon;

    }

    private Icon ponerIcono(String url, JLabel label) {
        Image img = new ImageIcon(getClass().getResource(url)).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        Icon icon = new ImageIcon(img);
        return icon;

    }

    private void iniciarAccionesAdm() {
        main = this;
        menu.addEvent((int index, int indexSubMenu) -> {
            if (index == 0 && indexSubMenu == 0) {
                showForm(new Form_Empty(0 + " " + 0));
            } else if (index == 1 && indexSubMenu == 1) {
                V_RegistrarProveedor prov = new ProveedorController();
                showForm(prov);
            } else if (index == 1 && indexSubMenu == 2) {
                V_GestionarProveedores gest = new GestionProveedorController();
                showForm(gest);
            } else if (index == 2 && indexSubMenu == 1) {
                V_RegistrarComputadora computadora = new ComputadoraController();
                showForm(computadora);
            } else if (index == 2 && indexSubMenu == 2) {
                showForm(new V_RegistrarLaptop());
            } else if (index == 2 && indexSubMenu == 3) {
                V_RegistrarAccesorios accesorios = new AccesorioController();
                showForm(accesorios);
            } else if (index == 2 && indexSubMenu == 4) {
                V_RegistrarComponentes componentes = new ComponentController();
                showForm(componentes);
            } else if (index == 3 && indexSubMenu == 1) {
                V_RegistrarProducto producto = new RegistrarProductoController();
                showForm(producto);

            } else if (index == 3 && indexSubMenu == 2) {
                V_GestionarProductos gestionarProductos = new GestionProductosController();
                showForm(gestionarProductos);

            } else if (index == 4 && indexSubMenu == 1) {
                V_ChartsComponentes charts = new ComponentChartsControllers();
                showForm(charts);
            } else {
                showForm(new Form_Empty(index + " " + indexSubMenu));
            }
        });
        menu.setSelectedIndex(0, 0);
    }

    private void iniciarAccionesGen() {
        main = this;
        menu.addEvent((var index, var indexSubMenu) -> {
            if (index == 0 && indexSubMenu == 0) {
                V_Dashboard vh = new DashBoadController();
                showForm(vh);
            } else if (index == 1 && indexSubMenu == 1) {
                V_RegistrarUsuario usr = new UsuarioController();
                showForm(usr);
            } else if (index == 1 && indexSubMenu == 2) {
                V_GestionarUsuario gestionarUsuario = new GestionUsuarioController();
                showForm(gestionarUsuario);
            } else if (index == 2 && indexSubMenu == 1) {
                V_RegistrarProveedor prov = new ProveedorController();
                showForm(prov);
            } else if (index == 2 && indexSubMenu == 2) {
                V_GestionarProveedores gest = new GestionProveedorController();
                showForm(gest);
            } else if (index == 3 && indexSubMenu == 1) {
                V_RegistrarComputadora computadora = new ComputadoraController();
                showForm(computadora);
            } else if (index == 3 && indexSubMenu == 2) {
                showForm(new V_RegistrarLaptop());
            } else if (index == 3 && indexSubMenu == 3) {
                V_RegistrarAccesorios accesorios = new AccesorioController();
                showForm(accesorios);
            } else if (index == 3 && indexSubMenu == 4) {
                V_RegistrarComponentes componentes = new ComponentController();
                showForm(componentes);
            } else if (index == 3 && indexSubMenu == 5) {
                V_RegistrarProducto producto = new RegistrarProductoController();
                showForm(producto);

            } else if (index == 3 && indexSubMenu == 6) {
                V_GestionarProductos gestionarProductos = new GestionProductosController();
                showForm(gestionarProductos);

            } else if (index == 4 && indexSubMenu == 1) {
                V_RegistrarProducto producto = new RegistrarProductoController();
                showForm(producto);

            } else if (index == 4 && indexSubMenu == 2) {
                V_GestionarProductos gestionarProductos = new GestionProductosController();
                showForm(gestionarProductos);

            }
            
            else if (index == 7 && indexSubMenu == 1) {
                     try {

                    Connection con = Conexion.conectar();
                    String url = "src/main/java/com/dev_team/reports/rep_cliente.jasper";
                    String url_imagen = "src/main/java/com/dev_team/reports";

                    InputStream inputStream = JRLoader.getFileInputStream(url);
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("IMAGEN_URL", url_imagen);

                    JasperPrint jp = JasperFillManager.fillReport(inputStream, parametros, con);
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setTitle("REPORTE DE CLIENTES");
                    jv.setVisible(true);
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error en generar reporte:" + e.getMessage());
                }

// reporte 7 2 usuarios
            } else if (index == 7 && indexSubMenu == 2) {
                try {

                    Connection con = Conexion.conectar();
                    String url = "src/main/java/com/dev_team/reports/rep_usuario.jasper";
                    String url_imagen = "src/main/java/com/dev_team/reports";

                    InputStream inputStream = JRLoader.getFileInputStream(url);
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("URL_IMAGEN", url_imagen);

                    JasperPrint jp = JasperFillManager.fillReport(inputStream, parametros, con);
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setTitle("REPORTE DE USUARIOS");
                    jv.setVisible(true);
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error en generar reporte:" + e.getMessage());
                }

                // reporte 7 3 PRROVEEDORES               
            }else if (index == 7 && indexSubMenu == 3){
                  try {

                    Connection con = Conexion.conectar();
                    String url = "src/main/java/com/dev_team/reports/rep_proveedores.jasper";
                    String url_imagen = "src/main/java/com/dev_team/reports";

                    InputStream inputStream = JRLoader.getFileInputStream(url);
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("IMAGEN_URL", url_imagen);

                    JasperPrint jp = JasperFillManager.fillReport(inputStream, parametros, con);
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setTitle("REPORTE DE PROVEEDORES");
                    jv.setVisible(true);
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error en generar reporte:" + e.getMessage());
                }
 
     // reporte 7 3 PRODUCTOS             
            }else if (index == 7 && indexSubMenu == 4){
                  try {

                    Connection con = Conexion.conectar();
                    String url = "src/main/java/com/dev_team/reports/rep_productos.jasper";
                    String url_imagen = "src/main/java/com/dev_team/reports";

                    InputStream inputStream = JRLoader.getFileInputStream(url);
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("IMAGEN_URL", url_imagen);

                    JasperPrint jp = JasperFillManager.fillReport(inputStream, parametros, con);
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setTitle("REPORTE DE PRODUCTOS");
                    jv.setVisible(true);
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error en generar reporte:" + e.getMessage());
                }
                  
                                
            } else if (index == 8 && indexSubMenu == 1) {
                V_Ventas ventas = new VentasController();
                showForm(ventas);
            } else {
                showForm(new Form_Empty(index + " " + indexSubMenu));
            }
            
            
        });
        menu.setSelectedIndex(0, 0);
    }

    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    private void abrirVentanaAdmUsuario(Usuario usuario) {

        D_AdmUsuario dialog_usuario = new D_AdmUsuario(true, usuario);
        dialog_usuario.setVisible(true);

    }

    public static Vista_Dashboard getMain() {
        return main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_header = new javax.swing.JPanel();
        panel_title = new javax.swing.JPanel();
        panel_title_1 = new javax.swing.JPanel();
        lb_barra = new javax.swing.JLabel();
        panel_acciones = new javax.swing.JPanel();
        maximizar = new javax.swing.JLabel();
        lb_cerrar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jPanel1 = new Panel_Round(0,Color.MAGENTA,Color.BLUE);
        lb_nombre = new javax.swing.JLabel();
        lb_apellido = new javax.swing.JLabel();
        btn_ajustesUsuario = new javax.swing.JButton();
        lb_foto = new JButtonRound("",100);
        menu = new com.dev_team.dashboard.menu.Menu(usuario.getNivel());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 650));

        panel_header.setBackground(new java.awt.Color(51, 51, 51));
        panel_header.setLayout(new java.awt.BorderLayout());

        panel_title.setPreferredSize(new java.awt.Dimension(100, 30));
        panel_title.setLayout(new javax.swing.BoxLayout(panel_title, javax.swing.BoxLayout.LINE_AXIS));

        panel_title_1.setLayout(new java.awt.BorderLayout());

        lb_barra.setBackground(Main_Colores.C_900
        );
        lb_barra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_barra.setForeground(new java.awt.Color(255, 255, 255));
        lb_barra.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        lb_barra.setOpaque(true);
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
        panel_title_1.add(lb_barra, java.awt.BorderLayout.CENTER);

        panel_title.add(panel_title_1);

        panel_acciones.setPreferredSize(new java.awt.Dimension(120, 30));
        panel_acciones.setRequestFocusEnabled(false);

        maximizar.setBackground(new java.awt.Color(153, 0, 255));
        maximizar.setForeground(new java.awt.Color(255, 255, 255));
        maximizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maximizar.setText("[--]");
        maximizar.setOpaque(true);
        maximizar.setPreferredSize(new java.awt.Dimension(35, 16));
        maximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizarMouseClicked(evt);
            }
        });

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

        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_accionesLayout = new javax.swing.GroupLayout(panel_acciones);
        panel_acciones.setLayout(panel_accionesLayout);
        panel_accionesLayout.setHorizontalGroup(
            panel_accionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_accionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(maximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_accionesLayout.setVerticalGroup(
            panel_accionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb_cerrar))
            .addGroup(panel_accionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(maximizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        panel_title.add(panel_acciones);

        panel_header.add(panel_title, java.awt.BorderLayout.NORTH);

        body.setBackground(new java.awt.Color(204, 204, 204));
        body.setPreferredSize(new java.awt.Dimension(1200, 700));
        body.setRequestFocusEnabled(false);
        body.setLayout(new java.awt.BorderLayout());
        panel_header.add(body, java.awt.BorderLayout.CENTER);

        panelMenu.setBackground(new java.awt.Color(30, 32, 47));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 700));
        panelMenu.setLayout(new javax.swing.BoxLayout(panelMenu, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setBackground(Main_Colores.Fondo);
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_nombre.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        lb_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lb_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nombre.setText("Miguel Angel");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 150, 20));

        lb_apellido.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        lb_apellido.setForeground(new java.awt.Color(255, 255, 255));
        lb_apellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_apellido.setText("Quispe Gutierrez");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, 20));

        btn_ajustesUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-setting-30.png"))); // NOI18N
        btn_ajustesUsuario.setBorder(null);
        btn_ajustesUsuario.setBorderPainted(false);
        btn_ajustesUsuario.setContentAreaFilled(false);
        btn_ajustesUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ajustesUsuario.setFocusPainted(false);
        btn_ajustesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajustesUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ajustesUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 30, 30));

        lb_foto.setBorder(null);
        lb_foto.setBorderPainted(false);
        lb_foto.setContentAreaFilled(false);
        lb_foto.setFocusPainted(false);
        jPanel1.add(lb_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 60));

        panelMenu.add(jPanel1);

        menu.setBackground(new java.awt.Color(51, 0, 102));
        menu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu.setForeground(new java.awt.Color(153, 153, 0));
        menu.setOpaque(false);
        menu.setPreferredSize(new java.awt.Dimension(150, 460));
        panelMenu.add(menu);

        panel_header.add(panelMenu, java.awt.BorderLayout.WEST);

        getContentPane().add(panel_header, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarMouseEntered
        lb_cerrar.setBackground(Color.red);
        lb_cerrar.setForeground(Color.white);
        lb_barra.setBackground(Color.red);
        lb_barra.setText("Cerrar ventana");
        lb_barra.setForeground(Color.white);
    }//GEN-LAST:event_lb_cerrarMouseEntered

    private void lb_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarMouseExited
        lb_cerrar.setBackground(Color.white);
        lb_cerrar.setForeground(new Color(73, 181, 172));

        lb_barra.setBackground(Main_Colores.C_900);
        lb_barra.setText("\t Nivel - " + usuario.getNivel());
        lb_barra.setForeground(Color.WHITE);
    }//GEN-LAST:event_lb_cerrarMouseExited

    private void lb_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarMouseClicked

        int c = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar?");
        if (c == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_lb_cerrarMouseClicked


    private void maximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizarMouseClicked
        this.setState(JFrame.ICONIFIED);


    }//GEN-LAST:event_maximizarMouseClicked

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

    private void btn_ajustesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajustesUsuarioActionPerformed
        abrirVentanaAdmUsuario(usuario);
    }//GEN-LAST:event_btn_ajustesUsuarioActionPerformed
    int antes;
    boolean bandera = false;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!bandera) {
            antes = this.getExtendedState();
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            bandera = true;
        } else {
            setExtendedState(antes);
            bandera = false;
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_ajustesUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_barra;
    private javax.swing.JLabel lb_cerrar;
    private javax.swing.JButton lb_foto;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel maximizar;
    private com.dev_team.dashboard.menu.Menu menu;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panel_acciones;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_title;
    private javax.swing.JPanel panel_title_1;
    // End of variables declaration//GEN-END:variables
}

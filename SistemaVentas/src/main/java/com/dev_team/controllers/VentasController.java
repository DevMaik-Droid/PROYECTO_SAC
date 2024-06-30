/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.controllers;

import com.dev_team.dashboard.Vista_Dashboard;
import com.dev_team.models.Cliente;
import com.dev_team.models.Producto;
import com.dev_team.models.Venta;
import com.dev_team.services.Service_Cliente;
import com.dev_team.services.Service_Producto;
import com.dev_team.services.Service_Ventas;
import com.dev_team.utilidades.Main_Colores;
import com.dev_team.utilidades.MultilineaCellRenderer;
import com.dev_team.utilidades.Table_Cell_Render;
import com.dev_team.utilidades.Table_Header_Render;
import com.dev_team.utilidades.Utilidad;
import com.dev_team.views.V_Ventas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.JXList;

public class VentasController extends V_Ventas {

    private DefaultListModel<Cliente> model_list;
    private List<Cliente> lista_clientes;
    private JXList list;
    private List<Producto> lista_productos;
    private final Service_Cliente cvc_cliente = new Service_Cliente();
    Service_Producto svc_producto = new Service_Producto();

    private int cantidad_maxima;

    public VentasController() {
        lista_clientes = (List<Cliente>) cvc_cliente.listar();

        lista_productos = (List<Producto>) svc_producto.listar();

        generarLista();
        generarTablaProductos();
        sh_buscarCliente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarLista(sh_buscarCliente.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarLista(sh_buscarCliente.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });

        list.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                Cliente cliente = (Cliente) list.getSelectedValue();
                if (cliente != null) {
                    actualizarCampos(cliente);
                }
            }
        });
        tb_productos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (validarCliente()) {
                    int fila = tb_productos.rowAtPoint(e.getPoint());
                    int columna = 0;
                    Long idProducto = Long.valueOf(tb_productos.getValueAt(fila, columna).toString());
                    Producto p = lista_productos.stream().filter(x -> Objects.equals(x.getIdProducto(), idProducto)).findFirst().orElse(null);
                    tf_precio.setText(p.getPrecioUnitario() + "");
                    tf_id_producto.setText(p.getIdProducto() + "");
                    cantidad_maxima = p.getStock();
                } else {
                    Utilidad.mostrarMensaje("Verique datos del cliente");
                }

            }

        });

        btn_vender.addActionListener(x -> {
            registrarVenta();
        });

        tf_descuento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });
        tf_cantidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               
            }

        });

        tf_id_producto.setEditable(false);
        tf_precio.setEditable(false);
        tf_total.setEditable(false);
        this.repaint();
    }

    private void calcularTotal() {

        try {
            int cantidad = (!tf_cantidad.getText().isEmpty()) ? Integer.parseInt(tf_cantidad.getText()) : 0;

            if (cantidad <= cantidad_maxima) {
                if (!tf_descuento.getText().isEmpty() && !tf_cantidad.getText().isEmpty()) {
                    double subtotal = Double.parseDouble(tf_cantidad.getText()) * Double.parseDouble(tf_precio.getText());
                    double total = subtotal - ((Double.parseDouble(tf_descuento.getText()) / 100) * subtotal);
                    tf_total.setText(String.format("%.2f", total));
                } else {
                    tf_total.setText("0");
                }
            } else {
                Utilidad.mostrarMensaje("Cantidad supera al stock"); 
                
            }
        } catch (NumberFormatException e) {
            Utilidad.mostrarMensaje("Ingrese datos validos");
        }

    }

    private void actualizarCampos(Cliente c) {
        tf_nombre.setText(c.getNombre());
        tf_apellido.setText(c.getApellido());
        tf_email.setText(c.getEmail());
        tf_telefono.setText(c.getTelefono());
    }

    private void generarLista() {
        model_list = new DefaultListModel<>();
        lista_clientes.forEach(model_list::addElement);
        list = new JXList(model_list);
        list.setForeground(Main_Colores.Fondo);
        list.setBackground(Color.WHITE);
        list.setSelectionForeground(Main_Colores.Fondo);
        list.setSelectionBackground(Main_Colores.C_200);
        list.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        panel_cliente.add(new JScrollPane(list), BorderLayout.CENTER);
    }

    private void filtrarLista(String entrada) {
        model_list.clear();
        lista_clientes.stream().filter(x -> x.getNombre().toUpperCase().contains(entrada.toUpperCase())).forEach(model_list::addElement);

    }

    private void generarTablaProductos() {

        Object[] columas = {"ID", "NOMBRE", "CATEGORIA", "PRECIO", "STOCK", "DETALLE"};
        DefaultTableModel model = new DefaultTableModel(columas, 0);

        for (Producto p : lista_productos) {
            Object[] datos = new Object[columas.length];
            datos[0] = p.getIdProducto();
            datos[1] = p.getNombreProducto();
            datos[2] = p.getCategoriaProducto();
            datos[3] = p.getPrecioUnitario();
            datos[4] = p.getStock();
            datos[5] = p.getDetalle();
            model.addRow(datos);
        }

        tb_productos.setModel(model);

        TableColumnModel columnModel = tb_productos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(150);

        tb_productos.setRowHeight(60);
        tb_productos.getTableHeader().setDefaultRenderer(new Table_Header_Render());
        tb_productos.setDefaultRenderer(Object.class, new Table_Cell_Render()); // Personalizar celdas
        tb_productos.setDefaultEditor(Object.class, null);
        // Asignar el MultiLineCellRenderer a la columna "DETALLE"
        columnModel.getColumn(5).setCellRenderer(new MultilineaCellRenderer());

    }

    private Cliente listarCliente() {
        Cliente cliente = lista_clientes.stream()
                .filter(x -> x.getNombre().equals(tf_nombre.getText()) && x.getApellido().equals(tf_apellido.getText()))
                .findFirst().orElse(null);
        return cliente;
    }

    private void registrarVenta() {

        Venta venta = new Venta();
        Cliente cl = listarCliente();
        // registrar id_cliente
        if (cl != null) {
            venta.setIdCliente(cl.getIdCliente());
        } else {
            Cliente cliente1 = new Cliente();
            cliente1.setNombre(tf_nombre.getText());
            cliente1.setApellido(tf_apellido.getText());
            cliente1.setTelefono(tf_telefono.getText());
            cliente1.setEmail(tf_email.getText());
            cliente1.setDepartamento("no aplica");
            cliente1.setDireccion("no aplica");
            cliente1.setEstado("1");

            if (cvc_cliente.crear(cliente1)) {
                System.out.println("cliente Creado");
            } else {
                System.out.println("Error en crear cliente");
            }
            lista_clientes = (List<Cliente>) cvc_cliente.listar();
            cl = listarCliente();
            venta.setIdCliente(cl.getIdCliente());
            generarLista();
        }
        venta.setIdProducto(Long.valueOf(tf_id_producto.getText()));
        venta.setIdUsuario(Vista_Dashboard.idUsuario);
        venta.setCantidad(Integer.valueOf(tf_cantidad.getText()));
        venta.setPrecioUnitario(Double.valueOf(tf_precio.getText()));
        venta.setMetodoPago(cbx_metodo.getSelectedItem().toString());

        double subtotal = venta.getPrecioUnitario() * venta.getCantidad();

        venta.setSubTotal(subtotal);
        venta.setDescuento(Double.valueOf(tf_descuento.getText()));
        venta.setTotal(Double.valueOf(tf_total.getText()));

        Service_Ventas svc_ventas = new Service_Ventas();
        if (svc_ventas.crear(venta)) {
            Utilidad.mostrarMensaje("Venta Creada");
            svc_producto.actualizarStock(venta.getIdProducto(), venta.getCantidad(),cantidad_maxima);
            System.out.println("Producto actualizado");
            lista_productos = (List<Producto>) svc_producto.listar();
            generarTablaProductos();
            limpiarDatos();
        }
    }

    private void limpiarDatos() {

        JTextField textos[] = {tf_apellido, tf_cantidad, tf_descuento, tf_email, tf_id_producto, tf_nombre, tf_precio, tf_telefono, tf_total};
        Arrays.stream(textos).forEach(x -> x.setText(""));
    }

    private Boolean validarCliente() {
        JTextField tfs_cliente[] = {tf_apellido, tf_email, tf_nombre, tf_telefono};

        for (JTextField t : tfs_cliente) {

            if (t.getText().isEmpty()) {
                return false;
            }

        }
        return true;
    }
}

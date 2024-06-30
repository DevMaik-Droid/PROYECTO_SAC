package com.dev_team.controllers;

import com.dev_team.models.Cliente;
import com.dev_team.models.Producto;
import com.dev_team.models.Venta;
import com.dev_team.services.Service_Cliente;
import com.dev_team.services.Service_Producto;
import com.dev_team.services.Service_Ventas;

import com.dev_team.utilidades.JXTableRenderer;
import com.dev_team.utilidades.MultilineaCellRenderer;

import com.dev_team.utilidades.Table_Header_Render;
import com.dev_team.views.V_Dashboard;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DashBoadController extends V_Dashboard {

    private List<Producto> productos;
    private List<Venta> list_ventas;
    private List<Cliente> list_clientes;

    public DashBoadController() {

        list_clientes = (List<Cliente>) new Service_Cliente().listar();
        productos = (List<Producto>) new Service_Producto().listar();
        list_ventas = (List<Venta>) new Service_Ventas().listar();

        lb_clientes.setText(list_clientes.size() + "");

        lb_ventas.setText(list_ventas.size() + "");

        double total = list_ventas.stream().mapToDouble(Venta::getTotal).sum();
        lb_ganancias.setText(total + " Bs");

        cbx_opciones.addActionListener(x -> {
            String op = cbx_opciones.getSelectedItem().toString();
            generarTabla(op);
        });

        generarTablaProductos();
    }

    private void generarTabla(String s) {
        switch (s) {
            case "PRODUCTOS" ->
                generarTablaProductos();
            case "CLIENTES" ->
                generarTablaCliente();
            case "VENTAS" ->
                generarTablaVentas();
        }

    }

    private void generarTablaProductos() {

        Object[] columas = {"CLAVE", "NOMBRE", "CATEGORIA", "PRECIO", "STOCK", "DETALLE", "ESTADO"};
        DefaultTableModel model = new DefaultTableModel(columas, 0);

        for (Producto p : productos) {
            Object[] datos = new Object[columas.length];

            datos[0] = p.getClaveProducto();
            datos[1] = p.getNombreProducto();
            datos[2] = p.getCategoriaProducto();
            datos[3] = p.getPrecioUnitario();
            datos[4] = p.getStock();
            datos[5] = p.getDetalle();
            datos[6] = p.getDisponibilidad();
            model.addRow(datos);
        }

        tb_dashboard.setModel(model);

        TableColumnModel columnModel = tb_dashboard.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(150);

        tb_dashboard.setRowHeight(60);
        tb_dashboard.setBorder(null);
        tb_dashboard.setRowMargin(0);
        tb_dashboard.setColumnMargin(0);

        tb_dashboard.getTableHeader().setDefaultRenderer(new Table_Header_Render());
        tb_dashboard.setDefaultRenderer(Object.class, new JXTableRenderer(true)); // Personalizar celdas

        // Asignar el MultiLineCellRenderer a la columna "DETALLE"
        columnModel.getColumn(5).setCellRenderer(new MultilineaCellRenderer());
//dddd
    }

    private void generarTablaCliente() {

        Object[] columas = {"ID", "NOMBRE", "APELLIDO", "EMAIL", "TELEFONO", "DIRECCION", "DEPARTAMENTO"};
        DefaultTableModel model = new DefaultTableModel(columas, 0);

        for (Cliente c : list_clientes) {
            Object[] datos = new Object[columas.length];

            datos[0] = c.getIdCliente();
            datos[1] = c.getNombre();
            datos[2] = c.getApellido();
            datos[3] = c.getEmail();
            datos[4] = c.getTelefono();
            datos[5] = c.getDireccion();
            datos[6] = c.getDepartamento();
            model.addRow(datos);
        }

        tb_dashboard.setModel(model);

        TableColumnModel columnModel = tb_dashboard.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(100);

        tb_dashboard.setRowHeight(30);
        tb_dashboard.setBorder(null);
        tb_dashboard.setRowMargin(0);
        tb_dashboard.setColumnMargin(0);

        tb_dashboard.getTableHeader().setDefaultRenderer(new Table_Header_Render());
        tb_dashboard.setDefaultRenderer(Object.class, new JXTableRenderer()); // Personalizar celdas
    }
    
    private void generarTablaVentas() {

        Object[] columas = {"ID", "CANTIDAD","DESCUENTO", "TOTAL", "PAGO"};
        DefaultTableModel model = new DefaultTableModel(columas, 0);

        for (Venta v : list_ventas) {
            Object[] datos = new Object[columas.length];

            datos[0] = v.getIdVenta();
            datos[1] = v.getCantidad();
            datos[2] = v.getDescuento();
            datos[3] = v.getTotal();
            datos[4] = v.getMetodoPago();
            model.addRow(datos);
        }

        tb_dashboard.setModel(model);

        /*TableColumnModel columnModel = tb_dashboard.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(100);*/

        tb_dashboard.setRowHeight(30);
        tb_dashboard.setBorder(null);
        tb_dashboard.setRowMargin(0);
        tb_dashboard.setColumnMargin(0);

        tb_dashboard.getTableHeader().setDefaultRenderer(new Table_Header_Render());
        tb_dashboard.setDefaultRenderer(Object.class, new JXTableRenderer()); // Personalizar celdas
    }

}

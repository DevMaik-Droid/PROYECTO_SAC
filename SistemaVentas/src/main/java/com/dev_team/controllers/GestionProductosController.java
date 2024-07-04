
package com.dev_team.controllers;

import com.dev_team.models.Producto;
import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Producto;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.Table_Cell_Render;
import com.dev_team.utilidades.Table_Header_Render;
import com.dev_team.views.D_AdmProductos;
import com.dev_team.views.D_AdmProveedor;
import com.dev_team.views.V_GestionarProductos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class GestionProductosController extends V_GestionarProductos{

    
    Service_Producto service = new Service_Producto();
    List<Producto> lista_productos;
    String opcion = "";

    public GestionProductosController() {

        lista_productos = (List<Producto>) service.listar();
        GenerarTabla(lista_productos);

        tabla_productos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int fila = tabla_productos.rowAtPoint(e.getPoint());
                    int columna = 0;

                    if (fila > -1) {
                        abrirDialogoUsuario(fila, columna);
                    }
                }

            }

        });
        /*

        tf_filtrar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                opcion = cbx_filtrar.getSelectedItem().toString();
                filtrarProveedor(opcion, tf_filtrar.getText().trim());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                opcion = cbx_filtrar.getSelectedItem().toString();
                filtrarProveedor(opcion, tf_filtrar.getText().trim());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        cbx_filtrar.addActionListener(e -> {
            filtrarProveedor(cbx_filtrar.getSelectedItem().toString(), tf_filtrar.getText());
        });*/

    }

    // logica para filtrar usuarios
    /*public void filtrarProveedor(String opcion, String cadena) {

        List<Proveedor> lists;
        switch (opcion) {
            case "Producto" -> {
                lists = lista_productos.stream()
                        .filter(us -> us.getProductoSuministrado().startsWith(cadena.toUpperCase()))
                        .collect(Collectors.toList());
                GenerarTabla(lists);
            }
            case "Telefono" -> {
                lists = lista_productos.stream()
                        .filter(us -> us.getContacto().startsWith(cadena) || us.getContacto().contains(cadena))
                        .collect(Collectors.toList());
                GenerarTabla(lists);
            }
            case "Nombre" -> {
                lists = lista_productos.stream()
                        .filter(us -> us.getProveedor().startsWith(cadena))
                        .collect(Collectors.toList());
                GenerarTabla(lists);
            }
            default -> {
                GenerarTabla(lista_productos);
            }
        }
    }*/

    private void GenerarTabla(List<Producto> lista) {

        Object[] columas = {"CLAVE", "NOMBRE", "CATEGORIA", "PRECIO", "STOCK", "DETALLE", "ESTADO"};
        DefaultTableModel model = new DefaultTableModel(columas, 0);

        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MMM/yyyy");

        for (Producto p : lista) {
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
        
        tabla_productos.setModel(model);
        
        TableColumnModel columnModel = tabla_productos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(110);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(70);
        
        tabla_productos.setRowHeight(30);
        tabla_productos.getTableHeader().setDefaultRenderer(new Table_Header_Render());
        tabla_productos.setDefaultRenderer(Object.class, new Table_Cell_Render()); // Personalizar celdas
        tabla_productos.setDefaultEditor(Object.class, null);
    }

    private void abrirDialogoUsuario(int fila, int columna) {
        String clave = tabla_productos.getValueAt(fila, columna).toString();

        Producto producto = lista_productos.stream()
                .filter(pro -> pro.getClaveProducto().equals(clave))
                .findFirst()
                .orElse(null);
        if (producto != null) {
            abrirVentanaAdmUsuario(producto);
        }

    }

    private void abrirVentanaAdmUsuario(Producto producto) {
        D_AdmProductos dialog_usuario = new D_AdmProductos(true, producto);
        dialog_usuario.setVisible(true);
    }

    
    
    
    
}

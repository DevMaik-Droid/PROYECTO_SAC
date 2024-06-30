package com.dev_team.controllers;

import com.dev_team.models.Proveedor;
import com.dev_team.services.Service_Proveedor;
import com.dev_team.utilidades.JXTableRenderer;
import com.dev_team.utilidades.Table_Cell_Render;
import com.dev_team.utilidades.Table_Header_Render;
import com.dev_team.views.D_AdmProveedor;
import com.dev_team.views.V_GestionarProveedores;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class GestionProveedorController extends V_GestionarProveedores {

    Service_Proveedor service = new Service_Proveedor();
    List<Proveedor> lista_proveedores;
    String opcion = "";

    public GestionProveedorController() {

        lista_proveedores = (List<Proveedor>) service.listar();
        GenerarTabla(lista_proveedores);

        tabla_proveedores.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int fila = tabla_proveedores.rowAtPoint(e.getPoint());
                    int columna = 0;

                    if (fila > -1) {
                        abrirDialogoUsuario(fila, columna);
                    }
                }

            }

        });

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
        });

        repaint();
    }

    // logica para filtrar usuarios
    public void filtrarProveedor(String opcion, String cadena) {

        List<Proveedor> lists;
        switch (opcion) {
            case "Producto" -> {
                lists = lista_proveedores.stream()
                        .filter(us -> us.getProductoSuministrado().startsWith(cadena.toUpperCase()))
                        .collect(Collectors.toList());
                GenerarTabla(lists);
            }
            case "Telefono" -> {
                lists = lista_proveedores.stream()
                        .filter(us -> us.getContacto().startsWith(cadena) || us.getContacto().contains(cadena))
                        .collect(Collectors.toList());
                GenerarTabla(lists);
            }
            case "Nombre" -> {
                lists = lista_proveedores.stream()
                        .filter(us -> us.getProveedor().startsWith(cadena))
                        .collect(Collectors.toList());
                GenerarTabla(lists);
            }
            default -> {
                GenerarTabla(lista_proveedores);
            }
        }
    }

    private void GenerarTabla(List<Proveedor> lista) {

        Object[] columas = {"ID", "NOMBRE", "TELEFONO", "EMAIL", "PRODUCTO", "FECHA REGISTRO", "ESTADO"};
        DefaultTableModel model = new DefaultTableModel(columas, 0);

        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MMM/yyyy");

        for (Proveedor p : lista) {
            Object[] datos = new Object[columas.length];
            
            datos[0] = p.getIdProveedor();
            datos[1] = p.getProveedor();
            datos[2] = p.getContacto();
            datos[3] = p.getEmail();
            datos[4] = p.getProductoSuministrado();
            datos[5] = formato_fecha.format(p.getFechaRegistro());
            datos[6] = p.getEstado();
            model.addRow(datos);
        }
        
        tabla_proveedores.setModel(model);
        
        TableColumnModel columnModel = tabla_proveedores.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(110);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(70);
        
        tabla_proveedores.setRowMargin(0);
        tabla_proveedores.setColumnMargin(0);
        tabla_proveedores.setRowHeight(30);
        tabla_proveedores.getTableHeader().setDefaultRenderer(new Table_Header_Render());
        tabla_proveedores.setDefaultRenderer(Object.class, new JXTableRenderer()); // Personalizar celdas
        tabla_proveedores.setDefaultEditor(Object.class, null);
    }

    private void abrirDialogoUsuario(int fila, int columna) {
        int id = Integer.parseInt(tabla_proveedores.getValueAt(fila, columna).toString());

        Proveedor proveedor = lista_proveedores.stream()
                .filter(prov -> prov.getIdProveedor() == id)
                .findFirst()
                .orElse(null);
        if (proveedor != null) {
            abrirVentanaAdmUsuario(proveedor);
        }

    }

    private void abrirVentanaAdmUsuario(Proveedor proveedor) {
        D_AdmProveedor dialog_usuario = new D_AdmProveedor(true, proveedor);
        dialog_usuario.setVisible(true);
    }

}

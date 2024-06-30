package com.dev_team.dashboard.menu;

import com.dev_team.models.Usuario;
import com.dev_team.utilidades.Main_Colores;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();
    private final String nivel;

    public Menu(String nivel) {
        this.nivel = nivel;
        init();

    }

    private void init() {
        setBackground(Main_Colores.Fondo);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();

        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        scroll.setBackground(Main_Colores.Fondo);
        crearMenuGeneral();

    }

    private void crearMenuGeneral() {
        if (nivel.equals("GERENTE")) {
            addTitle("MAIN");
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Dashboard"));
            addTitle("ADMINISTRACION");
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PEOPLE, "Usuarios", "Registrar", "Gestionar"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.BORDER_INNER, "Proveedor", "Registrar", "Gestionar"));
            
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Inventario", "Añadir Computadora", "Añadir Laptop", "Añadir Accesorios", "Añadir Componentes"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Productos","Registrar Producto", "Gestionar Productos"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PIE_CHART_OUTLINED, "Graficos Estadisticos", "Componentes", "Accesorios", "Computadora", "Laptop"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.VIEW_LIST, "Clientes", "Gestion de clientes"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INSERT_EMOTICON, "Reportes", "Clientes", "Usuarios", "Proveedores", "Productos"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INSERT_EMOTICON, "Ventas", "Vender"));
        
        }else if (nivel.equalsIgnoreCase("Administrativo")) {
            addTitle("Inventario");
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Dashboard"));
            addTitle("ADMINISTRACION");
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.BORDER_INNER, "Proveedor", "Registrar", "Gestionar"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Inventario", "Añadir Computadora", "Añadir Laptop", "Añadir Accesorios", "Añadir Componentes"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Productos","Registrar Producto", "Gestionar Productos"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PIE_CHART_OUTLINED, "Graficos Estadisticos", "Componentes", "Accesorios", "Computadora", "Laptop"));
            addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INSERT_EMOTICON, "Reportes", "Productos"));
        }

    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);
        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent((int index1, int indexSubMenu) -> {
            if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                clearSelected();
                setSelectedIndex(index1, indexSubMenu);
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(Main_Colores.C_200); // Cambia el color del texto a blanco
        label.setBackground(Main_Colores.Fondo); // Cambia el color de fondo a azul oscuro
        label.setOpaque(true); // Establece la opacidad para que el color de fondo sea visible
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;
}

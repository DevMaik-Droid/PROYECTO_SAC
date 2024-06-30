/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;

/**
 *
 * @author DevMaik
 */
public class JXTableRenderer extends DefaultTableRenderer {

    private final Font font_sustom = new Font("Verdana", Font.PLAIN, 12);

    private Color color1, color2;
    private Boolean control;

    public JXTableRenderer() {
        this(Color.WHITE, new Color(230, 230, 230), false);
    }

    public JXTableRenderer(Boolean control) {
        this(Color.WHITE, new Color(230, 230, 230), control);
    }

    public JXTableRenderer(Color color1, Color color2) {
        this(color1, color2, false);

    }

    public JXTableRenderer(Color color1, Color color2, Boolean control) {
        this.color1 = color1;
        this.color2 = color2;
        this.control = control;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        // Obtén el componente de la superclase
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Establece la fuente personalizada
        com.setFont(font_sustom);
        table.setSelectionBackground(new Color(51, 51, 51));
        // Maneja la selección y el enfoque para que no sobrescriban los colores de fondo

        if (isSelected) {
            com.setBackground(table.getSelectionBackground());
            com.setForeground(table.getSelectionForeground());
        } else {
            if (row % 2 == 0) {
                com.setBackground(color1);  // Color 1
            } else {
                com.setBackground(color2);  // Color2
            }
            com.setForeground(new Color(51, 51, 51));
        }

        if (control) {
            if (column == 4) {
                int dato = Integer.parseInt(value.toString());

                if (dato >= 5) {
                    com.setBackground(com.getBackground());

                } else if (dato == 0) {
                    com.setBackground(new Color(255, 153, 153));
                } else if (dato < 5) {
                    com.setBackground(new Color(255, 255, 153));
                }
            }
        }

        return com;

    }

}

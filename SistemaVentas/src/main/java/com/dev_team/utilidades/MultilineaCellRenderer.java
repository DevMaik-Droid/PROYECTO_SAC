
package com.dev_team.utilidades;

import javax.swing.*;
import java.awt.*;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;

public class MultilineaCellRenderer extends DefaultTableRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JTextArea textArea = new JTextArea(String.valueOf(value));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(true);

        if (isSelected) {
            textArea.setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            if (row % 2 == 0) {
                textArea.setBackground(new Color(230, 230, 230));  // Color 1
            } else {
                textArea.setBackground(new Color(255, 255, 255));  // Color2
            }
            textArea.setForeground(new Color(51, 51, 51));
        }
        

        textArea.setFont(table.getFont());
        return textArea;
    }
}


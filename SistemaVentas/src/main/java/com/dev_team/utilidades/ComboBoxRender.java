
package com.dev_team.utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author DevMaik
 */
public class ComboBoxRender extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        label.setBackground(isSelected ? Main_Colores.C_400 : Color.BLUE);// fondoItemCombobox
        
        label.setForeground(Main_Colores.C_300);// Texto ComboBox
        return label;
    }
}

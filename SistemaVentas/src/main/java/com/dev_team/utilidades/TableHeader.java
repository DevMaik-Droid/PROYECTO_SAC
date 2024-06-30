package com.dev_team.utilidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class TableHeader extends JLabel {
    Border topBorder = BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK);    
    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(51, 51, 51));
        setFont(new Font("sansserif", 1, 14));
        setForeground(new Color(255, 255, 255));
        setBorder(topBorder);
        setHorizontalAlignment(JLabel.CENTER);
        
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(51, 51, 51));
        grphcs.drawLine(0, getHeight() - 2, getWidth(), getHeight() - 2);
        //drawLine(x1=linea)
    }
}

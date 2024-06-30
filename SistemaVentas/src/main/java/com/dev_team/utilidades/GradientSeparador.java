/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.utilidades;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JSeparator;

public class GradientSeparador extends JSeparator{
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear área con esquinas redondeadas
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 0, 0);
        Area area = new Area(roundRect);
        g2d.setColor(getBackground());
        g2d.fill(area);


        /*Borde de Abajo*/
        area.subtract(new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight() - 3)));
        g2d.setPaint(new GradientPaint(0, 0, new Color(255, 51, 255), getWidth(), 0, Main_Colores.MAIN_COLOR_2));
        g2d.fill(area);
        g2d.dispose();
        super.paintComponent(g);
    }
}


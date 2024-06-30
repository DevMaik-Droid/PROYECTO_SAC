package com.dev_team.utilidades;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

public class PanelGradient extends JPanel {

    private final Color startColor;
    private final Color endColor;

    public PanelGradient(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Coordenadas de inicio y fin del gradiente
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(width, height);

        // Crear el gradiente lineal
        GradientPaint gradientPaint = new GradientPaint(start, startColor, end, endColor);

        // Establecer el gradiente como pintura para el contexto gráfico
        g2d.setPaint(gradientPaint);

        // Dibujar un rectángulo con el gradiente
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
    }
}

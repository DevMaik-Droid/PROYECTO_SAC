package com.dev_team.utilidades;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class GradientDialog extends JDialog {

    private Color[] colors;
    private float[] fractions;

    public GradientDialog(boolean modal, Color color1, Color color2, Color color3) {
        super((Frame) null, modal);
        colors = new Color[]{color1, color2, color3};
        fractions = new float[]{0.0f, 0.5f, 1.0f};

        // Establece el tamaño del diálogo
        setSize(400, 300);

        // Agrega un JPanel personalizado al diálogo
        GradientPanel panel = new GradientPanel();
        setContentPane(panel);
    }

    private class GradientPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Habilita el suavizado para mejorar la apariencia del gradiente
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Define el gradiente lineal con tres colores
            GradientPaint gradient = new GradientPaint(0, 0, colors[0], getWidth(), getHeight(), colors[2]);
            g2d.setPaint(gradient);

            // Dibuja el gradiente en el fondo del panel
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}

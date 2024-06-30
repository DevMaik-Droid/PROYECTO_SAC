package com.dev_team.controllers;

import com.dev_team.models.Componente;
import com.dev_team.services.Service_Componente;
import com.dev_team.views.V_ChartsComponentes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ComponentChartsControllers extends V_ChartsComponentes {

    List<Componente> comp;

    public ComponentChartsControllers() {
        comp = (List<Componente>) new Service_Componente().listar();

        iniciarComboBox();
        cbx_graficar.addActionListener(e -> {
            String filtro = cbx_graficar.getSelectedItem().toString();
            

        });

    }
/*
    private void generarGrafico(String filtro) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        comp.stream().filter(x -> x.getComponente().equals(filtro))
                .forEach(x -> dataset.setValue(x.getCantidad(), x.getComponente(), x.getMarca()));

        JFreeChart barChart = ChartFactory.createBarChart("Componentes", "Categorias", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot categoryPlot = barChart.getCategoryPlot();
        BarRenderer render = (BarRenderer) categoryPlot.getRenderer();
        
        render.setSeriesPaint(1, Color.BLUE);
        render.setSeriesPaint(2, Color.CYAN);
        render.setSeriesPaint(3, Color.DARK_GRAY);
        render.setGradientPaintTransformer(null);
        ChartPanel chartPanel = new ChartPanel(barChart);

        panel_grafico.removeAll();
        panel_grafico.add(chartPanel, BorderLayout.CENTER);
        panel_grafico.validate();
    }*/

    private void iniciarComboBox() {
        Set<String> componentes = new HashSet<>();
        comp.forEach(x -> componentes.add(x.getNombre()));
        componentes.forEach(cbx_graficar::addItem);
    }

    private XYDataset createDataset() {
        XYSeries series = new XYSeries("Data");

        // Agregar datos al conjunto de datos
        series.add(1, 10);
        series.add(2, 20);
        series.add(3, 30);
        series.add(4, 40);
        series.add(5, 50);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

}

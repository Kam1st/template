package com.hatteea.template;

import javafx.scene.chart.BarChart;

public abstract class SortTemplate {
    protected int[] array;
    protected BarChart<String, Number> barChart;

    public SortTemplate(int[] array, BarChart<String, Number> barChart) {
        this.array = array;
        this.barChart = barChart;
    }

    public abstract void sort();

    public abstract void updateChart();

}

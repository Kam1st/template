package com.hatteea.template;

import javafx.animation.Timeline;
import javafx.scene.chart.XYChart;

public abstract class SortTemplate {

    public abstract void sort(Integer[] array, Timeline timeline, XYChart.Series<String, Number> series);

    public void sortAndDisplay(Integer[] array) {
        // Default timeline and series
        Timeline timeline = new Timeline();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        SortingStepsView sortingStepsView = new SortingStepsView();
        sortingStepsView.setArray(array);
        sortingStepsView.createSortingStepsView("Quick Sort"); // Default to Quick Sort
    }
}

package com.hatteea.template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Arrays;

public class SortingStepsView {
    private Integer[] array;
    private int stepIndex = 0;

    public void setArray(Integer[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public Parent createSortingStepsView(String sortType) {
        VBox root = new VBox();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Sorting Steps");
        xAxis.setLabel("Index");
        yAxis.setLabel("Value");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (int i = 0; i < array.length; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), array[i]));
        }

        barChart.getData().add(series);
        root.getChildren().add(barChart);

        Timeline timeline = new Timeline();
        switch (sortType) {
            case "Quick Sort":
                QuickSort quickSort = new QuickSort();
                quickSort.sort(array, timeline, series);
                break;
            case "Merge Sort":
                MergeSort mergeSort = new MergeSort();
                mergeSort.sort(array, timeline, series);
                break;
            default:
                break;
        }

        timeline.play();

        return root;
    }
}

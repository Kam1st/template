package com.hatteea.template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

import java.util.Arrays;

public class QuickSort extends SortTemplate {
    @Override
    public void sort(Integer[] array, Timeline timeline, XYChart.Series<String, Number> series) {
        quickSort(array, 0, array.length - 1, timeline, series);
    }

    private void quickSort(Integer[] array, int low, int high, Timeline timeline, XYChart.Series<String, Number> series) {
        if (low < high) {
            int pi = partition(array, low, high, timeline, series);
            quickSort(array, low, pi - 1, timeline, series);
            quickSort(array, pi + 1, high, timeline, series);
        }
    }

    private int partition(Integer[] array, int low, int high, Timeline timeline, XYChart.Series<String, Number> series) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                updateChart(array, timeline, series);
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        updateChart(array, timeline, series);
        return i + 1;
    }

    private void updateChart(Integer[] array, Timeline timeline, XYChart.Series<String, Number> series) {
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            series.getData().clear();
            for (int i = 0; i < array.length; i++) {
                series.getData().add(new XYChart.Data<>(String.valueOf(i), array[i]));
            }
        }));
    }
}

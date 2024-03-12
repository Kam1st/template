package com.hatteea.template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

import java.util.Arrays;

public class MergeSort extends SortTemplate {
    @Override
    public void sort(Integer[] array, Timeline timeline, XYChart.Series<String, Number> series) {
        mergeSort(array, 0, array.length - 1, timeline, series);
    }

    private void mergeSort(Integer[] array, int l, int r, Timeline timeline, XYChart.Series<String, Number> series) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m, timeline, series);
            mergeSort(array, m + 1, r, timeline, series);
            merge(array, l, m, r, timeline, series);
        }
    }

    private void merge(Integer[] array, int l, int m, int r, Timeline timeline, XYChart.Series<String, Number> series) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Integer[] L = Arrays.copyOfRange(array, l, m + 1);
        Integer[] R = Arrays.copyOfRange(array, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            updateChart(array, timeline, series);
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            updateChart(array, timeline, series);
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            updateChart(array, timeline, series);
        }
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

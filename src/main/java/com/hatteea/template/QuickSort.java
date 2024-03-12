package com.hatteea.template;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class QuickSort extends SortTemplate {

    public QuickSort(int[] array, BarChart<String, Number> barChart) {
        super(array, barChart);
    }

    @Override
    public void sort() {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                updateChart();
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        updateChart();
        return i + 1;
    }

    public void updateChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (int i = 0; i < array.length; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), array[i]));
        }
        barChart.getData().clear();
        barChart.getData().add(series);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

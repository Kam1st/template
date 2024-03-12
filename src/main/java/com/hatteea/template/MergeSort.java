package com.hatteea.template;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


public class MergeSort extends SortTemplate {

    public MergeSort(int[] array, BarChart<String, Number> barChart) {
        super(array, barChart);
    }

    @Override
    public void sort() {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            updateChart();
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            updateChart();
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            updateChart();
        }
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

package com.hatteea.template;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class HelloApplication extends Application {
    private SortTemplate sortTemplate;
    private TextField inputField;

    private Label label;

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        label = new Label("Entrez les nombres à trier");
        inputField = new TextField();
        inputField.setPromptText("Entrez les nombres à trier");


        ToggleGroup algorithmGroup = new ToggleGroup();
        RadioButton quickSortButton = new RadioButton("Quick Sort");
        quickSortButton.setToggleGroup(algorithmGroup);
        quickSortButton.setSelected(true);
        RadioButton mergeSortButton = new RadioButton("Merge Sort");
        mergeSortButton.setToggleGroup(algorithmGroup);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        Button startButton = new Button("Commencer");

        startButton.setOnAction(event -> {
            String input = inputField.getText();
            int[] array = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (quickSortButton.isSelected()) {
                sortTemplate = new QuickSort(array, barChart);
            } else {
                sortTemplate = new MergeSort(array, barChart);
            }

            sortTemplate.sort();
        });

        root.getChildren().addAll(label, inputField, quickSortButton, mergeSortButton, startButton, barChart);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tri de nombres");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
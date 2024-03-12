package com.hatteea.template;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sorting Algorithm Visualizer");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER_LEFT);

        ComboBox<String> algorithmComboBox = new ComboBox<>();
        algorithmComboBox.getItems().addAll("Quick Sort", "Merge Sort");
        algorithmComboBox.setValue("Quick Sort");

        Slider speedSlider = new Slider(1, 10, 5);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        speedSlider.setMajorTickUnit(1);
        speedSlider.setBlockIncrement(1);

        TextField arrayInput = new TextField();
        arrayInput.setPromptText("Enter numbers separated by commas");

        Button startButton = new Button("Start Sorting");
        startButton.setOnAction(e -> {
            String[] arrayStrings = arrayInput.getText().split(",");
            Integer[] array = new Integer[arrayStrings.length];
            for (int i = 0; i < arrayStrings.length; i++) {
                array[i] = Integer.parseInt(arrayStrings[i].trim());
            }

            SortTemplate sortingAlgorithm;
            String selectedAlgorithm = algorithmComboBox.getValue();
            if (selectedAlgorithm.equals("Quick Sort")) {
                sortingAlgorithm = new QuickSort();
            } else if (selectedAlgorithm.equals("Merge Sort")) {
                sortingAlgorithm = new MergeSort();
            } else {
                // Default to Quick Sort
                sortingAlgorithm = new QuickSort();
            }

            sortingAlgorithm.sortAndDisplay(array);

            SortingStepsView sortingStepsView = new SortingStepsView();
            sortingStepsView.setArray(array);

            SortingStepsApplication sortingStepsApp = new SortingStepsApplication();
            sortingStepsApp.setSortingStepsView(sortingStepsView);
            sortingStepsApp.start(new Stage());
        });

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.getChildren().addAll(startButton);

        root.getChildren().addAll(
                new Label("Select Algorithm:"),
                algorithmComboBox,
                new Label("Enter Array (comma-separated):"),
                arrayInput,
                new Label("Select Speed:"),
                speedSlider,
                hbox
        );

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

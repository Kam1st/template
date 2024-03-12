package com.hatteea.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingStepsApplication extends Application {

    private SortingStepsView sortingStepsView;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.getChildren().add(sortingStepsView.createSortingStepsView());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sorting Steps Visualization");
        primaryStage.show();
    }

    public void setSortingStepsView(SortingStepsView sortingStepsView) {
        this.sortingStepsView = sortingStepsView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SeeData extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        PieChart pieChart = new PieChart();
        pieChart.setTranslateX(100);
        pieChart.setTranslateY(200);

        pieChart.setData(getData());


        Group root = new Group();
        root.getChildren().add(pieChart);

        Scene scene = new Scene(root,300,600, Color.RED);

        stage.setScene(scene);
        stage.setTitle("App");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList(
                new PieChart.Data("Tbilisi", 10),
                new PieChart.Data("Kutaisi",13)
        );
        return observableList;
    }
}
package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

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
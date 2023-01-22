package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FlightScheduleForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flight Schedule Form");

        // Create a grid layout for the form
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create labels for the form fields
        Label directionLabel = new Label("Direction:");
        GridPane.setConstraints(directionLabel, 0, 0);

        Label dateLabel = new Label("Date:");
        GridPane.setConstraints(dateLabel, 0, 1);

        Label seatsLabel = new Label("Number of Seats:");
        GridPane.setConstraints(seatsLabel, 0, 2);

        Label priceLabel = new Label("Total Price:");
        GridPane.setConstraints(priceLabel, 0, 3);

        // Create form fields
        TextField directionField = new TextField();
        directionField.setPromptText("Enter the flight direction");
        GridPane.setConstraints(directionField, 1, 0);

        DatePicker datePicker = new DatePicker();
        GridPane.setConstraints(datePicker, 1, 1);

        TextField seatsField = new TextField();
        seatsField.setPromptText("Enter the number of seats");
        GridPane.setConstraints(seatsField, 1, 2);

        TextField priceField = new TextField();
        priceField.setPromptText("Enter the total price");
        GridPane.setConstraints(priceField, 1, 3);

        // Create a submit button
        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);

        // Add all elements to the grid layout
        grid.getChildren().addAll(directionLabel, directionField, dateLabel, datePicker, seatsLabel, seatsField, priceLabel, priceField, submitButton);

        // Create a scene and display the form
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
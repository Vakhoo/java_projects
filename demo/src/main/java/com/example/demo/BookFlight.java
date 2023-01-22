package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class BookFlight extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Fly");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label destination = new Label("Destination:");
        grid.add(destination, 0, 1);

        TextField destinationTextField = new TextField();
        grid.add(destinationTextField, 1, 1);

        Label date = new Label("date:");
        grid.add(date, 0, 2);
        TextField dateTextField = new TextField();
        grid.add(dateTextField, 1, 2);

        Label place = new Label("place:");
        grid.add(place, 0, 3);
        TextField placeTextField = new TextField();
        grid.add(placeTextField, 1, 3);

        Label price = new Label("price:");
        grid.add(price, 0, 4);
        TextField priceTextField = new TextField();
        grid.add(priceTextField, 1, 4);

        Button btn = new Button("Save");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                DatabaseConnection conn = new DatabaseConnection();
                conn.save(destinationTextField.getText(), dateTextField.getText(), placeTextField.getText(), parseInt(priceTextField.getText()));
                System.out.println(destinationTextField.getText());
            }
        });


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("lng-and-lat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 610, 425);
        stage.setTitle("Elevation Finder");
        stage.getIcons().add(new Image("file:elevation-icon.jpg"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
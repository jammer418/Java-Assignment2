package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.assignment2.MainViewController;

public class ResultsViewController implements Initializable{
    @FXML
    public Label resultLabel;


    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        SceneManager.changeScenes(event,"lng-and-lat-view.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}

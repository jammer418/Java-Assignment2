package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class MainViewController {

    @FXML
    private TextField latTextField;

    @FXML
    private TextField lngTextField;

    @FXML
    private Label results;


    public static String parseString(String input) {
        StringBuilder result = new StringBuilder();
        boolean decimalPointFound = false;
        int digitsAfterDecimal = 0;

        for (char c : input.toCharArray()) {
            if (c == '.') {
                decimalPointFound = true;
                digitsAfterDecimal = 0;
            }

            if (!decimalPointFound) {
                result.append(c);
            } else {
                if (Character.isDigit(c)) {
                    digitsAfterDecimal++;
                }
                if (digitsAfterDecimal <= 2) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    @FXML
    private void subCoordinates(ActionEvent event) throws IOException, InterruptedException {
        String elevationResults = (ApiUtility.submitLocation(latTextField.getText(), lngTextField.getText()));

        if(elevationResults != null){
            results.setText(parseString(elevationResults) + " m");
        }else {
            results.setText("Coordinates Invalid!");
        }



    }

    @FXML
    private void switchBtn(ActionEvent event) throws IOException {
        SceneManager.changeScenes(event,"results-view.fxml");
    }

}
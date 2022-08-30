package com.example.mental_health_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstPage  implements Initializable {
    @FXML
    public static ScrollPane background;
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.styleProperty().set("-fx-backgound: #E8E2E2; ");
    }
}

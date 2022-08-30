package com.example.mental_health_project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
public class TakeTestController {
    public Button ocdBtn ,anxietyBtn,depressionBtn,adhdBtn,home;
    public void ocdgo() throws IOException {
        Stage s = (Stage) ocdBtn.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("ocdtest.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void anxietygo() throws IOException {
        Stage s = (Stage) anxietyBtn.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("anxietyTest.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void depressiongo() throws IOException {
        Stage s = (Stage) depressionBtn.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("depressionTest.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void adhdgo() throws IOException {
        Stage s = (Stage) adhdBtn.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("adhdTest.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void home() throws IOException {
        Stage s = (Stage) home.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("first_page.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }

}

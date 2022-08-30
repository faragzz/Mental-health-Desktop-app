package com.example.mental_health_project;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.awt.Color.red;

public class Checkpassword extends Thread {
    private Label checkpass;
    private TextField pass;
    private String text;
    private int colorText;

    public Checkpassword(TextField password, Label passcheck) {
        this.checkpass = passcheck;
        this.pass = password;
    }
    @Override
    public void run(){
        while(true) {
            if (pass.getText().length() >= 7) {
                text = "Strong";
                colorText = 1;
            } else if (pass.getText().length() > 4) {
                text = "medium";
                colorText = 2;
            } else {
                text = "weak";
                colorText = 3;
            }

            Platform.runLater(() -> {
                switch(colorText){
                    case 1:
                        checkpass.setStyle("-fx-text-fill:green");
                        break;
                    case 2:
                        checkpass.setStyle("-fx-text-fill:orange");
                        break;
                    case 3:
                        checkpass.setStyle("-fx-text-fill:red");
                        break;
                }
                checkpass.setText(text);

            });


            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

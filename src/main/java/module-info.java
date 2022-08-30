module com.example.mental_health_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires java.desktop;


    opens com.example.mental_health_project to javafx.fxml;
    exports com.example.mental_health_project;
}
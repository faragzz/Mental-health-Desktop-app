package com.example.mental_health_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class tableController implements Initializable {

    public Button back,search;
    public TextField addRating,searchBar;
    @FXML
    private TableColumn<Doctor,String> age;

    @FXML
    private TableColumn<Doctor,String> name;

    @FXML
    private TableColumn<Doctor,String>rating;

    @FXML
    private TableColumn<Doctor,String>specialization;

    @FXML
    private TableView<Doctor> table;

    public ObservableList<Doctor> data = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {


            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from doctor");

            data = FXCollections.observableArrayList();
            while (rs.next()) {
                data.add(new Doctor(rs.getString("name"), rs.getString("age"), rs.getString("specialization"), rs.getString("rating"),rs.getString("email")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        name.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Doctor, String>("age"));
        specialization.setCellValueFactory(new PropertyValueFactory<Doctor, String>("specialization"));
        rating.setCellValueFactory(new PropertyValueFactory<Doctor, String>("rating"));

        table.setItems(data);
    }
    //send email
    public void showData() throws SQLException {
        data = table.getSelectionModel().getSelectedItems();
        String doctorEmail = data.get(0).getEmail();
        System.out.println(doctorEmail);
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("select * from currentuser ;");
        String pemail = null;
        String pname = null;
        String page = null;
        String pnumber = null;
        String pgender = null;
        while (rs.next()) {
            pname = rs.getString(2);
            pgender = rs.getString(7);
            page = rs.getString(3);
            pemail = rs.getString(4);
            pnumber = rs.getString(5);
        }
        System.out.println(pemail);
        sendmail send = new sendmail(" whyme14u@gmail.com", "a.khaled46462@gmail.com", "mf12Asss","patient name :"+pname+"\npatient age :"+page+"\npatient mobile number :"+pnumber+"\npatient gender :"+pgender+"\npatient email :"+pemail);


    }
    public void addDoctorRating() {
        //UPDATE `doctor`.`doctors` SET `rating` = '5' WHERE (`DID` = '1');
        String GetaddRating = addRating.getText();

        try {
            data = table.getSelectionModel().getSelectedItems();
            String doctorEmail = data.get(0).getEmail();
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from doctor");
            int counter = 0;
            while (rs.next()) {
                counter++;
                if (doctorEmail.equals(rs.getString(5))) {
                    PreparedStatement posted = connection.prepareStatement("UPDATE doctor SET rating = '"+GetaddRating+"' WHERE DID = '"+counter+"';");
                    posted.executeUpdate();
                    break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        updateTable();
    }
    public void updateTable(){
        try {


            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from doctor");

            data = FXCollections.observableArrayList();
            while (rs.next()) {
                data.add(new Doctor(rs.getString("name"), rs.getString("age"), rs.getString("specialization"), rs.getString("rating"),rs.getString("email")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        name.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Doctor, String>("age"));
        specialization.setCellValueFactory(new PropertyValueFactory<Doctor, String>("specialization"));
        rating.setCellValueFactory(new PropertyValueFactory<Doctor, String>("rating"));

        table.setItems(data);
    }
    public void searchFor() {
        try{
        String GetsearchBar = searchBar.getText();
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from doctor where name like '%"+GetsearchBar+"%' or age like '"+GetsearchBar+"'  or specialization like '"+GetsearchBar+"' or rating = '"+GetsearchBar+"' ; ");
            data = FXCollections.observableArrayList();
            while (rs.next()) {
                data.add(new Doctor(rs.getString("name"), rs.getString("age"), rs.getString("specialization"), rs.getString("rating"),rs.getString("email")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        name.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Doctor, String>("age"));
        specialization.setCellValueFactory(new PropertyValueFactory<Doctor, String>("specialization"));
        rating.setCellValueFactory(new PropertyValueFactory<Doctor, String>("rating"));

        table.setItems(data);
    }


        public void viewDoctors() throws IOException {  // scene 2

        Stage s = (Stage) back.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("first_page.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }

}

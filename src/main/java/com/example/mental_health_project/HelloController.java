package com.example.mental_health_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {

    @FXML
    public TextField name, age, email, mobilenumber, password, confirm_password;// scene 2
    public Button logout;
    public TextField signinEmail;
    public PasswordField signinPassword;
    public Button signin, gotosignup,viewd,later,takeTest;
    public Button goTosSgnIn, gotosignupDoctor; // scene 2
    public RadioButton radioMale;
    public boolean searchEmailInDB = true;
    //------------------ scene 2
    public TextField Dname, Dage, Demail, DmobileNumber, Dspecialization;
    public RadioButton Dmale, Dfemale;
    //------------------------send to doctor sene
    public TextField messageTObeSendToDoctor;
    public Label passcheck,allReadySignUp;//scene 2
    public Label rscheckemail;


    @FXML

    public void signup() throws SQLException {
        String getname = name.getText().toLowerCase();
        String getage = age.getText();
        String getemail = email.getText().toLowerCase();
        String getmobilenumber = mobilenumber.getText();
        String getpassword = password.getText().toLowerCase();
        String getConfirmPassword = confirm_password.getText().toLowerCase();
        if (getemail.contains("@") && getemail.contains(".com") && getpassword.equals(getConfirmPassword)) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer");
            String serchName = getname;
            if (searchEmailInDB) {
                while (rs.next()) {
                    if (serchName.equals(rs.getString(2))) {
                        searchEmailInDB = true;
                        break;
                    }
                }
            }
            boolean allreadysignin = false;
            if (searchEmailInDB) {
                allReadySignUp.setStyle("-fx-text-fill:red");
                allReadySignUp.setText("email already signed in");
                allReadySignUp.setVisible(true);
                System.out.println("email already signed in");
                allreadysignin = true;
            }
            if (!getpassword.equals(getConfirmPassword)) {
                System.out.println("invalid email");
            }
            else if(!allreadysignin){
                String gender = radioHandeler();
                DBC customerDatabase = new DBC();
                customerDatabase.insertValues(getname, getage, getemail, getmobilenumber, getpassword, gender);

            }
        }
    }

    public void signinbtn() throws SQLException, IOException {
        String GetsigninEmail = signinEmail.getText().toLowerCase();
        String GetsigninPassword = signinPassword.getText().toLowerCase();
        System.out.println(GetsigninEmail + " " + GetsigninPassword);

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from customer");
        boolean Flag = false;
        while (rs.next()) {
            if(GetsigninEmail.equals(rs.getString(4))) {
                Flag = true;
                break;
            }
        }
        if (Flag) {
            if (GetsigninPassword.equals(rs.getString(6))) {
                viewDoctors();
                String name = rs.getString(2);
                String age = rs.getString(3);
                String email = rs.getString(4);
                String mobileNumber = rs.getString(5);
                String password = rs.getString(6);
                String gender = rs.getString(7);

                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
                PreparedStatement posted = c.prepareStatement("INSERT INTO currentuser (CUName,CUage,CUemail,CUmobileNumber,CUpassword,CUgender) VALUES ('" +name+"','"+age+"','"+email+"','"+mobileNumber+"','"+password+"','"+gender+"')");
                posted.executeUpdate();
            }
        }
        else {
            rscheckemail.setStyle("-fx-text-fill:red");
            rscheckemail.setText("email is not found");
            rscheckemail.setVisible(true);
        }
    }

    public void signup_page() throws IOException {
        Stage s = (Stage) signin.getScene().getWindow();
        s.close();
        FXMLLoader fx = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root2 = fx.load();
        HelloController hello = fx.getController();
        hello.startThread();
        Stage stage = new Stage();
        stage.setTitle("Sign up page");
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void startThread(){
        Checkpassword cp = new Checkpassword(password,passcheck);
        cp.start();
    }
    public void signin_page() throws IOException {  // scene 2

        Stage s = (Stage) goTosSgnIn.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("first_page.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }

    public void signin_pageDoctoradd() throws IOException {  // scene 2

        Stage s = (Stage) Dname.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("first_page.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }

    public void signupDoctor() throws IOException {
        Stage s = (Stage) gotosignupDoctor.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("doctor_add_details.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }

    public String radioHandeler() {
        if (radioMale.isSelected()) {
            return "M";


        } else {
            return "F";

        }
    }

    public void Submit_Details() {
        String GetDname = Dname.getText();
        String GetAge = Dage.getText();
        String GetDspecialization = Dspecialization.getText();
        String GetDemail = Demail.getText();
        String GetDmobileNumber = DmobileNumber.getText();
        DBC doctorDatabase = new DBC();
        String Dgender = doctorradioHandeler();
        doctorDatabase.insertValuesDoctor(GetDname, GetAge, GetDspecialization, GetDemail, GetDmobileNumber, Dgender);
    }

    public String doctorradioHandeler() {
        if (Dmale.isSelected()) {
            return "M";


        } else {
            return "F";

        }
    }
    public void viewDoctors() throws IOException {  // scene 2

        Stage s = (Stage) viewd.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("view_doctor_list.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void  logoutCurrentUser() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
        Statement s = c.createStatement();
        PreparedStatement posted = c.prepareStatement("delete from currentuser ;");
        posted.executeUpdate();
    }

    public void takeTest() throws IOException {
        Stage s = (Stage) takeTest.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("TakeTestPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
//    public void setText()
}

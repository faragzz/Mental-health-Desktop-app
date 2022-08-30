package com.example.mental_health_project;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Vector;

public class ocdTest {
    @FXML
    public Button next,done,back,totest;
    public Label rs;
    @FXML
    public RadioButton never,rarely,sometimes,often,veryoften ;//Toogle group one
    @FXML
    public RadioButton never1,rarely1,sometimes1,often1,veryoften1;//Toogle group two
    @FXML
    public RadioButton never11,rarely11,sometimes11,often11,veryoften11;//Toogle group three
    @FXML
    public RadioButton never111,rarely111,sometimes111,often111,veryoften111;//Toogle group four
    @FXML
    public RadioButton never112,rarely112,sometimes112,often112,veryoften112;//Toogle group five
    @FXML
    public RadioButton never113,rarely113,sometimes113,often113,veryoften113;//Toogle group six
    @FXML
    public RadioButton never114,rarely114,sometimes114,often114,veryoften114;//Toogle group seven
    @FXML
    public RadioButton never115,rarely115,sometimes115,often115,veryoften115;//Toogle group eight
    @FXML
    AnchorPane ab;
    int count = 0;
    public Vector <ocdTest> preOcdTests = new Vector<>();

    public void start() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ocdNext.fxml"));
        Parent root2 =loader.load();
        ocdTest ocd = loader.getController();
        preOcdTests.add(this);
        ocd.setCounter(preOcdTests);

        Stage stage =(Stage) ab.getScene().getWindow();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void goToTest() throws IOException {
        Stage s = (Stage) totest.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("TakeTestPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void setCounter(Vector <ocdTest> preOcdTests){
        this.preOcdTests = preOcdTests;
    }
    public void done() throws IOException {
        preOcdTests.add(this);
        int points=calc();
        String view = null;
        if(points>30){
            view="system recommends seeing a doctor urgently";
        }
//        points < 30 && > 15
        else if(points >= 15 && points<= 30){
            view = "system recommends seeing a doctor";
        }
        else if(points<15){
            view = "system can not detect the problem";
        }
        System.out.println(points);
        rs.setText("Result : "+view);
        rs.setVisible(true);
    }
    //add often
    public int calc(){
//        1. Never (0 points)
//        2. Rarely (1 point)
//        3. Sometimes (2 points)
//        4. Often (3 points)
//        5. Very Often (5 points)
        //one
        for(ocdTest x : preOcdTests){
            System.out.println("hi");
            if(x.rarely!=null && x.rarely.isSelected()){
                count++;
            }
            else if(x.sometimes!=null && x.sometimes.isSelected()){
                count+=2;
            }
            else if(x.often!=null && x.often.isSelected()){
                count+=3;
            }
            else if(x.veryoften!=null && x.veryoften.isSelected()){
                count+=5;
            }
            //two
            if(x.rarely1!=null && x.rarely1.isSelected()){
                count++;
            }
            else if(x.sometimes1!=null && x.sometimes1.isSelected()){
                count+=2;
            }
            else if(x.often1!=null && x.often1.isSelected()){
                count+=3;
            }
            else if(x.veryoften1!=null && x.veryoften1.isSelected()){
                count+=5;
            }
            //three
            if(x.rarely11!=null && x.rarely11.isSelected()){
                count++;
            }
            else if(x.sometimes11!=null && x.sometimes11.isSelected()){
                count+=2;
            }
            else if(x.often11!=null && x.often11.isSelected()){
                count+=3;
            }
            else if(x.veryoften11!=null && x.veryoften11.isSelected()){
                count+=5;
            }
            //four
            if(x.rarely111!=null && x.rarely111.isSelected()){
                count++;
            }
            else if(x.sometimes111!=null && x.sometimes111.isSelected()){
                count+=2;
            }
            else if(x.often111!=null && x.often111.isSelected()){
                count+=3;
            }
            else if(x.veryoften111!=null && x.veryoften111.isSelected()){
                count+=5;
            }
            //five
            if(x.rarely112!=null && x.rarely112.isSelected()){
                count++;
            }
            else if(x.sometimes112!=null && x.sometimes112.isSelected()){
                count+=2;
            }
            else if(x.often112!=null && x.often112.isSelected()){
                count+=3;
            }
            else if(x.veryoften112!=null && x.veryoften112.isSelected()){
                count+=5;
            }
            //six
            if(x.rarely113!=null && x.rarely113.isSelected()){
                count++;
            }
            else if(x.sometimes113!=null && x.sometimes113.isSelected()){
                count+=2;
            }
            else if(x.often113!=null && x.often113.isSelected()){
                count+=3;
            }
            else if(x.veryoften113!=null && x.veryoften113.isSelected()){
                count+=5;
            }
            //seven
            if(x.rarely114!=null && x.rarely114.isSelected()){
                count++;
            }
            else if(x.sometimes114!=null && x.sometimes114.isSelected()){
                count+=2;
            }
            else if(x.often114!=null && x.often114.isSelected()){
                count+=3;
            }
            else if(x.veryoften114!=null && x.veryoften114.isSelected()){
                count+=5;
            }
            //eight
            if(x.rarely115!=null && x.rarely115.isSelected()){
                count++;
            }
            else if(x.sometimes115!=null && x.sometimes115.isSelected()){
                count+=2;
            }
            else if(x.often115!=null && x.often115.isSelected()){
                count+=3;
            }
            else if(x.veryoften115!=null && x.veryoften115.isSelected()){
                count+=5;
            }
        }
        return  count;
    }
}
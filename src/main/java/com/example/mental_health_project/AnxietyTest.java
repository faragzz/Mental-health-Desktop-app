package com.example.mental_health_project;

import javafx.event.ActionEvent;
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

public class AnxietyTest {
    @FXML
    public Button toTest,next,done;
    public Label rs;
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
    public RadioButton never116,rarely116,sometimes116,often116,veryoften116;//Toogle group nine
    @FXML
    public RadioButton never117,rarely117,sometimes117,often117,veryoften117;//Toogle group ten
    @FXML
    public RadioButton never118,rarely118,sometimes118,often118,veryoften118;//Toogle group eleven
    @FXML
    public AnchorPane ab;
    int count = 0;
    public Vector<AnxietyTest> preOcdTests = new Vector<>();

    public void start() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("anxietynext.fxml"));
        Parent root2 =loader.load();
        AnxietyTest anx = loader.getController();
        preOcdTests.add(this);
        anx.setCounter(preOcdTests);

        Stage stage =(Stage) ab.getScene().getWindow();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void goToTest() throws IOException {
        Stage s = (Stage) toTest.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("TakeTestPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
public void setCounter(Vector <AnxietyTest> preOcdTests){
    this.preOcdTests = preOcdTests;

}
public void done() throws IOException {
        preOcdTests.add(this);
        int points=calc();
        String view = null;
        if(points>40){
            view="system recommends seeing a doctor urgently";
        }
//        points < 30 && > 15
        else if(points >= 20 && points<= 40){
            view = "system recommends seeing a doctor";
        }
        else if(points<20){
            view = "system can not detect the problem";
        }
        System.out.println(view);
        System.out.println(points);
    rs.setText("Result : "+view);
    rs.setVisible(true);
//
//        result.setText(view);
//        resultIs.setVisible(true);
//        result.setVisible(true);
    }
public int calc(){
//        1. Never (0 points)
//        2. Rarely (1 point)
//        3. Sometimes (2 points)
//        4. Often (3 points)
//        5. Very Often (5 points)
    //one
    for(AnxietyTest x : preOcdTests){

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
        //nine
        if(x.rarely116!=null && x.rarely116.isSelected()){
            count++;
        }
        else if(x.sometimes116!=null && x.sometimes116.isSelected()){
            count+=2;
        }
        else if(x.often116!=null && x.often116.isSelected()){
            count+=3;
        }
        else if(x.veryoften116!=null && x.veryoften116.isSelected()){
            count+=5;
        }
        //ten
        if(x.rarely117!=null && x.rarely117.isSelected()){
            count++;
        }
        else if(x.sometimes117!=null && x.sometimes117.isSelected()){
            count+=2;
        }
        else if(x.often117!=null && x.often117.isSelected()){
            count+=3;
        }
        else if(x.veryoften117!=null && x.veryoften117.isSelected()){
            count+=5;
        }
        //eleven
        if(x.rarely118!=null && x.rarely118.isSelected()){
            count++;
        }
        else if(x.sometimes118!=null && x.sometimes118.isSelected()){
            count+=2;
        }
        else if(x.often118!=null && x.often118.isSelected()){
            count+=3;
        }
        else if(x.veryoften118!=null && x.veryoften118.isSelected()){
            count+=5;
        }
    }
    return  count;
}

}

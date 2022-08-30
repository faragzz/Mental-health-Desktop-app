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

public class DepressionTest {
    public Button back,next,toTest,done;
    public Label rsx;
    public RadioButton rarely,sometimes,often,Always ;//Toggle group one
    @FXML
    public RadioButton rarely1,sometimes1,often1,Always1;//Toggle group two
    @FXML
    public RadioButton rarely11,sometimes11,often11,Always11;//Toggle group three
    @FXML
    public RadioButton rarely111,sometimes111,often111,Always111;//Toggle group four
    @FXML
    public RadioButton rarely112,sometimes112,often112,Always112;//Toggle group five
    @FXML
    public RadioButton rarely113,sometimes113,often113,Always113;//Toggle group six
    @FXML
    public RadioButton rarely114,sometimes114,often114,Always114;//Toggle group seven
    @FXML
    public RadioButton rarely115,sometimes115,often115,Always115;//Toggle group eight
    @FXML
    public RadioButton rarely116,sometimes116,often116,Always116;//Toggle group nine
    @FXML
    public RadioButton rarely117,sometimes117,often117,Always117;//Toggle group ten
    @FXML
    AnchorPane ab;
    int count = 0;
    public Vector<DepressionTest> preOcdTests = new Vector<>(); //vector of classes


    public void start() throws IOException { //get previous data from the class

        FXMLLoader loader = new FXMLLoader(getClass().getResource("depressionNext.fxml"));
        Parent root2 =loader.load();
        DepressionTest ocd = loader.getController();
        preOcdTests.add(this);
        ocd.setCounter(preOcdTests);

        Stage stage =(Stage) ab.getScene().getWindow();
        stage.setScene(new Scene(root2));
        stage.show();
    }

    public void back() throws IOException {// back btn
        Stage s = (Stage) back.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("depressionTest.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void goToTest() throws IOException {//back btn to the test page selection
        Stage s = (Stage) toTest.getScene().getWindow();
        s.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("TakeTestPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void setCounter(Vector <DepressionTest> preOcdTests){// setting the class
        this.preOcdTests = preOcdTests;

    }
    public void done() throws IOException {
        preOcdTests.add(this); //adding the class in the vector
        int points=calc();
        String view = null;
        if(points>35){
            view="system recommends seeing a doctor urgently";
        }
//        points < 30 && > 15
        else if(points >= 15 && points<= 35){
            view = "system recommends seeing a doctor";
        }
        else if(points<15){
            view = "system can not detect the problem";
        }
//        result.setText(view);
//        resultIs.setVisible(true);
//        result.setVisible(true);
        System.out.println(view);
        System.out.println(points);
        rsx.setVisible(true);
        rsx.setText("Result : "+view);


    }
    public int calc(){// calc points
//        1. Rarely(0 points)
//        2. Sometimes (1 points)
//        3. Often (3 points)
//        4. Always (5 points)
        //one
        for(DepressionTest x : preOcdTests){
            if(x.sometimes!=null && x.sometimes.isSelected()){
                count++;
            }
            else if(x.often!=null && x.often.isSelected()){
                count+=3;
            }
            else if(x.Always!=null && x.Always.isSelected()){
                count+=5;
            }
            //two
            if(x.sometimes1!=null && x.sometimes1.isSelected()){
                count++;
            }
            else if(x.often1!=null && x.often1.isSelected()){
                count+=3;
            }
            else if(x.Always1!=null && x.Always1.isSelected()){
                count+=5;
            }
            //three
            if(x.sometimes11!=null && x.sometimes11.isSelected()){
                count++;
            }
            else if(x.often11!=null && x.often11.isSelected()){
                count+=3;
            }
            else if(x.Always11!=null && x.Always11.isSelected()){
                count+=5;
            }
            //four
            if(x.sometimes111!=null && x.sometimes111.isSelected()){
                count++;
            }
            else if(x.often111!=null && x.often111.isSelected()){
                count+=3;
            }
            else if(x.Always111!=null && x.Always111.isSelected()){
                count+=5;
            }
            //five
            if(x.sometimes112!=null && x.sometimes112.isSelected()){
                count++;
            }
            else if(x.often112!=null && x.often112.isSelected()){
                count+=3;
            }
            else if(x.Always112!=null && x.Always112.isSelected()){
                count+=5;
            }
            //six
            if(x.sometimes113!=null && x.sometimes113.isSelected()){
                count++;
            }
            else if(x.often113!=null && x.often113.isSelected()){
                count+=3;
            }
            else if(x.Always113!=null && x.Always113.isSelected()){
                count+=5;
            }
            //seven
            if(x.sometimes114!=null && x.sometimes114.isSelected()){
                count++;
            }
            else if(x.often114!=null && x.often114.isSelected()){
                count+=3;
            }
            else if(x.Always114!=null && x.Always114.isSelected()){
                count+=5;
            }
            //eight
            if(x.sometimes115!=null && x.sometimes115.isSelected()){
                count++;
            }
            else if(x.often115!=null && x.often115.isSelected()){
                count+=3;
            }
            else if(x.Always115!=null && x.Always115.isSelected()){
                count+=5;
            }
            //nine
            if(x.sometimes116!=null && x.sometimes116.isSelected()){
                count++;
            }
            else if(x.often116!=null && x.often116.isSelected()){
                count+=3;
            }
            else if(x.Always116!=null && x.Always116.isSelected()){
                count+=5;
            }
            //ten
            if(x.sometimes117!=null && x.sometimes117.isSelected()){
                count++;
            }
            else if(x.often117!=null && x.often117.isSelected()){
                count+=3;
            }
            else if(x.Always117!=null && x.Always117.isSelected()){
                count+=5;
            }
        }
        return  count;
    }
}

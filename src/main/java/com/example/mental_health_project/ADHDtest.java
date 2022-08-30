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
public class ADHDtest {
    public Button next,next1,toTest,done;
    public Label rs;
    public RadioButton rarely,sometimes,often,Always ;//Toogle group one
    @FXML
    public RadioButton rarely1,sometimes1,often1,Always1;//Toogle group two
    @FXML
    public RadioButton rarely11,sometimes11,often11,Always11;//Toogle group three
    @FXML
    public RadioButton rarely111,sometimes111,often111,Always111;//Toogle group four
    @FXML
    public RadioButton rarely112,sometimes112,often112,Always112;//Toogle group five
    @FXML
    public RadioButton rarely113,sometimes113,often113,Always113;//Toogle group six
    @FXML
    public RadioButton rarely114,sometimes114,often114,Always114;//Toogle group seven
    @FXML
    public RadioButton rarely115,sometimes115,often115,Always115;//Toogle group eight
    @FXML
    public RadioButton rarely116,sometimes116,often116,Always116;//Toogle group nine
    @FXML
    public RadioButton rarely117,sometimes117,often117,Always117;//Toogle group ten
    @FXML
    public RadioButton rarely118,sometimes118,often118,Always118;//Toogle group eleven
    @FXML
    public RadioButton rarely119,sometimes119,often119,Always119;//Toogle group twelve
    public AnchorPane ab;
    public AnchorPane cd;
    int count = 0;
    public Vector<ADHDtest> adhd = new Vector<>();

    public void start() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("adhdNext.fxml"));
        Parent root2 =loader.load();
        ADHDtest anx = loader.getController();
        adhd.add(this);
        anx.setCounter(adhd);

        Stage stage =(Stage) ab.getScene().getWindow();
        stage.setScene(new Scene(root2));
        stage.show();
    }
    public void start1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adhdNext1.fxml"));
        Parent root2 =loader.load();
        ADHDtest anx = loader.getController();
        anx.setCounter(adhd);
        Stage stage =(Stage) cd.getScene().getWindow();
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
    public void setCounter(Vector <ADHDtest> adhd){
        this.adhd = adhd;
    }

    public void done() throws IOException {
        adhd.add(this);
        System.out.println("result ");
        int points=calc();
        String view = null;
        if(points>45){
            view="system recommends seeing a doctor urgently";
        }
//        points < 30 && > 15
        else if(points >= 15 && points<= 45){
            view = "system recommends seeing a doctor";
        }
        else if(points<15){
            view = "system can not detect the problem";
        }
        System.out.println("result "+view);
        rs.setText("Result : "+view);
        rs.setVisible(true);

    }
    public int calc(){
//        1. Rarely(0 points)
//        2. Sometimes (1 points)
//        3. Often (3 points)
//        4. Always (5 points)
        //one
        for(ADHDtest x : adhd){
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
            //eleven
            if(x.sometimes118!=null && x.sometimes118.isSelected()){
                count++;
            }
            else if(x.often118!=null && x.often118.isSelected()){
                count+=3;
            }
            else if(x.Always118!=null && x.Always118.isSelected()){
                count+=5;
            }
            //twelve
            if(x.sometimes119!=null && x.sometimes119.isSelected()){
                count++;
            }
            else if(x.often119!=null && x.often119.isSelected()){
                count+=3;
            }
            else if(x.Always119!=null && x.Always119.isSelected()){
                count+=5;
            }

        }
        return  count;
    }
}

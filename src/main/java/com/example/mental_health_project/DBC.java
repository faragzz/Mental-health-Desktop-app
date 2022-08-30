package com.example.mental_health_project;
import java.sql.*;


public class DBC {

    public void show(){
        try {//display customer table form the database

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root","");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
        }catch (Exception e){
            System.out.println("Failed");
        }

    }
    //insert customer data in database
        public void insertValues (String name ,String age, String email,String mobilenumber,String password,String gender){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
            Statement statement = connection.createStatement();
            PreparedStatement posted = connection.prepareStatement("INSERT INTO customer (CName,Cage,Cemail,CmobileNumber,Cpassword,Cgender) VALUES ('" +name+"','"+age+"','"+email+"','"+mobilenumber+"','"+password+"','"+gender+"')");
            posted.executeUpdate();
            ResultSet rs = statement.executeQuery("select * from customer");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
            }
            System.out.println("ok");
        }catch (Exception e){
            System.out.println("failed to insert");
        }
    }

    //insert doctor data in database
        public void insertValuesDoctor(String getDname, String getAge, String getDspecialization, String getDemail, String getDmobileNumber, String dgender){
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mental", "root", "");
                Statement statement = connection.createStatement();
                PreparedStatement posted = connection.prepareStatement("INSERT INTO doctor (name,age,specialization,email,mobileNumber,gender) VALUES ('" +getDname+"','"+getAge+"','"+getDspecialization+"','"+getDemail+"','"+getDmobileNumber+"','"+dgender+"')");
                posted.executeUpdate();
                ResultSet rs = statement.executeQuery("select * from doctor");
                while (rs.next()) {
                    System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
                }
                System.out.println("ok");
            }catch (Exception e){
                System.out.println("vxvd");
                System.out.println("failed to insert");
            }
        }
}
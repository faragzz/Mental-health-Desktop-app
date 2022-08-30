package com.example.mental_health_project;

import javafx.scene.control.Button;

import java.nio.Buffer;

public class Doctor {
     private String name;
     private String age;
     private String specialization;
     private String rating;

     private String email;
    public Doctor(String name, String age, String specialization, String rating,String email) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.rating = rating;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getRating() {
        return rating;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}

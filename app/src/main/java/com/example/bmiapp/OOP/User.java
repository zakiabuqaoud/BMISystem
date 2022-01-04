package com.example.bmiapp.OOP;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.Date;

public class User {
    public static User user;
    private FirebaseAuth mAuth;
    private ArrayList<Food> foods = new ArrayList<Food>();
    private ArrayList<Record> records = new ArrayList<Record>();
    private String name,email,password,gender,birthDay;

    public User(){}
    public User(String name, String email, String password, String re_password, AppCompatActivity context)throws UserException{
        if(!name.matches("[A-Za-z\\s]+")){throw new UserException("the name is error");}
        if(!email.matches("[A-Za-z][\\w]{0,31}@[\\w]{2,10}\\.com")){throw new UserException("the email is error");}
        if(!password.equals("re_password")){throw new UserException("the password is conflict");}
        if(password.length()<3){throw new UserException("the password is short");}
        this.name = name;
        this.email = email;
        this.password = password;
        FireBaseConnection.registration(this,context);
    }
    //mAuth
    public void setMAuth(FirebaseAuth mAuth){
        this.mAuth=mAuth;
    }
    public FirebaseAuth getMAuth(){
        return mAuth;
    }
    //name
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    //email
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    //password
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    //food
    public void setFoods(ArrayList<Food> foods){
        this.foods=foods;
    }
    public ArrayList<Food> getFoods(){
        return foods;
    }
    //record
    public void setRecords(ArrayList<Record> records){
        this.records=records;
    }
    public ArrayList<Record> getRecords(){
        return records;
    }
    //birthOfDay
    public void setBirthDay(String birthDay){
        this.birthDay=birthDay;
    }
    public String getBirthDay(){
        return birthDay;
    }

    //gender
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }

    public void updateList(DataSnapshot snapshot, AppCompatActivity context){}



}

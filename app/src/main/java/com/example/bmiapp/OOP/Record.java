package com.example.bmiapp.OOP;

import java.util.Date;

public class Record {
    public String key,status,date, time;
    public int length,weight;
    public User user;
    public Record(int length,int weight,String date, String time){
        this.length= length;
        this.weight= weight;
        this.time=time;
        this.date= date;
    }
    public Record(){}
    //key
    public void setKey(String key){
        this.key =key;
    }
    public String getKey(){
        return key;
    }
    //length
    public void setLength(int length){
        this.length =length;
    }
    public int getLength(){
        return length;
    }
    //weight
    public void setWeight(int weight){
        this.weight =weight;
    }
    public int getWeight(){
        return weight;
    }
    //date
    public void setDte(String date){
        this.date=date;
    }
    public String getDate() {
        return date;
    }
}

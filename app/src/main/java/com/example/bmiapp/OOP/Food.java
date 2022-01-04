package com.example.bmiapp.OOP;

public class Food {
    private String key,name,category,photo;
    private double calorie;
    public Food(){}
    public Food(String name, String category, double calorie){
        this.name = name;
        this.category = category;
        this.calorie = calorie;
    }
    //key
    public void setKey(String key){
        this.key =key;
    }
    public String getKey(){
        return key;
    }
    //name
    public void setName(String name){
        this.name =name;
    }
    public String getName(){
        return name;
    }
    //category
    public void setCategory(String category){
        this.category =category;
    }
    public String getCategory(){
        return category;
    }
    //photo
    public void setPhoto(String photo){
        this.photo =photo;
    }
    public String getPhoto(){
        return photo;
    }
    //calorie
    public void setCalorie(double calorie){
        this.calorie =calorie;
    }
    public double getCalorie(){
        return calorie;
    }


}

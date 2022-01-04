package com.example.bmiapp.OOP;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bmiapp.activity_home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class FireBaseConnection {
    public static void addListenerForUserUpdate(AppCompatActivity context){
        DB.getCurrentUserData().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User.user.updateList(snapshot, context);
                activity_home.check();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public static void createUserData(User user, AppCompatActivity context){
       DB.getCurrentUserName().setValue(user.getName());
    }
    public static void completeUserData(int weight, int length){
        DB.getCurrentUserName().child("gender").setValue(User.user.getGender());
        DB.getCurrentUserName().child("BirthOfDate").setValue(User.user.getBirthDay());
        DB.getCurrentUserName().child("length").setValue(length);
        DB.getCurrentUserName().child("width").setValue(weight);
    }
    public static void registration(User user, AppCompatActivity context){
        FirebaseAuth mAuth= FirebaseAuth.getInstance();
        user.setMAuth(mAuth);
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            createUserData(user,context);
                        }else{
                            Toast.makeText(context, "error,The user information was not saved" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public static void login(AppCompatActivity context){
        try{
            User.user.setMAuth(FirebaseAuth.getInstance());
            User.user.getMAuth().signInWithEmailAndPassword(User.user.getEmail(),User.user.getPassword())
                    .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                User.user.setMAuth(FirebaseAuth.getInstance());
                                addListenerForUserUpdate(context);
                                DB.getCurrentUserData().child("login").setValue(new Date().toString());
                                Intent moveToHome ;
                                moveToHome = new Intent(context,activity_home.class);
                                context.startActivity(moveToHome);
                                context.finish();
                            }else{
                                Toast.makeText(context, "error, Invalid Email and Password " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public static void logout(){
        User.user.getMAuth().signOut();
    }
    public static void addRecord(Record record){
        String key = DB.getCurrentUserRecords().push().getKey();
        record.setKey(key);
        DB.getCurrentUserRecords().child("key").setValue(record);
    }
    public static void removeRecord(Record record){
        DB.getCurrentUserRecords().child(record.getKey()).removeValue();
    }
    public static void addFood(Food food){
        String key = DB.getCurrentUserFoods().push().getKey();
        food.setKey(key);
        DB.getCurrentUserFoods().child("key").setValue(food);
    }
    public static void removeFood(Food food){
        DB.getCurrentUserFoods().child(food.getKey()).removeValue();
    }
    public static class DB{
        public static DatabaseReference getUsers(){
            return FirebaseDatabase.getInstance().getReference("users");
        }
        public static DatabaseReference getCurrentUserData(){
            return getUsers().child(User.user.getMAuth().getCurrentUser().getUid());
        }
        public static DatabaseReference getCurrentUserFoods(){
            return getCurrentUserData().child("foods");
        }
        public static DatabaseReference getCurrentUserRecords(){
            return getCurrentUserData().child("records");
        }
        public static DatabaseReference getCurrentUserName(){
            return getCurrentUserData().child("name");
        }
        public static DatabaseReference getCurrentUserBirthDay(){
            return getCurrentUserData().child("birthday");
        }
        public static DatabaseReference getCurrentUserGender(){
            return getCurrentUserData().child("gender");
        }


    }

}

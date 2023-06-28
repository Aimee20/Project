package com.example.mynutriscanapplication;

import android.database.sqlite.SQLiteOpenHelper;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Permit to define the name of the table
@Entity(tableName = "User")
public class User{
    //Permit to define the primary key of the table
    @PrimaryKey(autoGenerate = true)
    private int id;
    /*@ColumnInfo(name = "email", unique =true)*/
    private String email;
    private String password;
    private String username;
    private String prenom;
    public User(int id,String email, String password, String username, String prenom) {
        this.id=id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.prenom = prenom;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}

package com.example.mynutriscanapplication;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

//insertion des données dans la table user
        @Insert
        void insert(User user);

        @Query("SELECT * FROM User WHERE email = :email")
        User getUserByEmail(String email);
}


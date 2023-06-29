package com.example.mynutriscanapplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //Singleton permet d'obtenir une seule et unique instance  de référence
    private static volatile AppDatabase INSTANCE;

    //DAO
    public abstract UserDao userDao();

    public static AppDatabase getInstance(Context context) {

        if (INSTANCE == null) {

            synchronized (AppDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),

                                    AppDatabase.class, "MyDatabase.db")

                            .build();

                }

            }

        }

        return INSTANCE;
    }
}


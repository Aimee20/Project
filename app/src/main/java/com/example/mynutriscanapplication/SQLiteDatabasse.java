package com.example.mynutriscanapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.room.Query;

public class SQLiteDatabasse extends SQLiteOpenHelper {
    public SQLiteDatabasse(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    String[] projection = {
            "id",
            "email",
            "password"
    };

    Cursor cursor = AppDatabase@Query(
            "users",
            projection,
            null,
            null,
            null,
            null,
            null
    );

}

package com.example.mynutriscanapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDatabasse extends SQLiteOpenHelper {
    public SQLiteDatabasse(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créez vos tables et effectuez d'autres opérations de création ici
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Mettez à jour votre schéma de base de données ici, si nécessaire
    }

    public void myMethod() {
        SQLiteDatabase db = getReadableDatabase();
        // Utilisez l'objet db pour effectuer des opérations de lecture sur la base de données
    }
}

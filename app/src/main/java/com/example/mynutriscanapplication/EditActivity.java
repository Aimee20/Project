package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    EditText surnameeditTextTextPersonName;
    EditText nameeditTextTextPersonName;
    ImageView editimageView;
    Button confirmebutton;
    User user;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        surnameeditTextTextPersonName =findViewById(R.id.surnameeditTextTextPersonName);
        nameeditTextTextPersonName = findViewById(R.id.nameeditTextTextPersonName);
        editimageView = findViewById(R.id.editimageView);
        confirmebutton = findViewById(R.id.confirmebutton);
        // Chargement des informations existantes (si disponibles)
        loadPersonalInfo();
        confirmebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the values of the differents field of the text and the enregistrement
                String V1= surnameeditTextTextPersonName.getText().toString();
                String V2 = nameeditTextTextPersonName.getText().toString();
                //Do the different opérations on enregistrement
                // Mise à jour des informations personnelles
                savePersonalInfo(V1, V2);
                // Affichez un message ou effectuez une action appropriée pour indiquer que les modifications ont été enregistrées
                Toast.makeText(EditActivity.this,"Informations mis à jour", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditActivity.this,AccueilActivity.class);
                startActivity(intent);

            }
        });
    }
    // Chargement des informations personnelles existantes (si disponibles)
    private void loadPersonalInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName", "");
        String lastName = sharedPreferences.getString("lastName", "");

        surnameeditTextTextPersonName.setText(firstName);
        nameeditTextTextPersonName.setText(lastName);
    }

    // Sauvegarde des nouvelles informations personnelles
    private void savePersonalInfo(String firstName, String lastName) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", firstName);
        editor.putString("lastName", lastName);
        editor.apply();
    }

}
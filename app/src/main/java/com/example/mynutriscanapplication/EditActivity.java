package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
        confirmebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the values of the differents field of the text and the enregistrement
                String V1= surnameeditTextTextPersonName.getText().toString();
                String V2 = nameeditTextTextPersonName.getText().toString();
                //Do the different opérations on enregistrement
                user.setUsername(V1);
                user.setPrenom(V2);
                Toast.makeText(EditActivity.this,"Information enregistrée", Toast.LENGTH_SHORT).show();
                // Affichez un message ou effectuez une action appropriée pour indiquer que les modifications ont été enregistrées
            }
        });
    }

}
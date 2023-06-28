package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    /*This part is for the declaration on the variable*/
    TextView LogintextView;
    TextView courrieltexteView;
    TextView passwordtextView;
    Button connectionbutton;
    Button inscriptionbutton;
    Button forgetbutton;
    EditText editTextTextEmailAddress;
    EditText editTextTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            //Retrieve references to the necessary UI elements
            LogintextView = findViewById(R.id.LogintextView);
            courrieltexteView = findViewById(R.id.courrieltextView);
            passwordtextView = findViewById(R.id.passwordtextView);
            connectionbutton = findViewById(R.id.connectionbutton);
            connectionbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Logic of connection
                    // Get the values of the different fields such as:e-mail et password
                    String email = editTextTextEmailAddress.getText().toString();
                    String password = editTextTextPassword.getText().toString();

                    //Call the login function;
                    Login.login(LoginActivity.this, email, password);
                }
            });
            inscriptionbutton = findViewById(R.id.inscriptionbutton);
            inscriptionbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this,InscriptionActivity2.class);
                    startActivity(intent);
                }
            });
            forgetbutton = findViewById(R.id.forgetbutton);
            forgetbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this,MotdepasseoublieActivity.class);
                    startActivity(intent);
                }
            });
            editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
            editTextTextPassword = findViewById(R.id.editTextTextPassword);
        }
    }

package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MotdepasseoublieActivity extends AppCompatActivity {
    TextView forgetpasstextView;
    TextView emailtextView;
    TextView passtextView;
    TextView passconfirmetextView;
    EditText editTextTextEmailAddress3;
    EditText editTextTextPassword3;
    EditText editTextTextPassword5;
    Button next2button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motdepasseoublie);
        forgetpasstextView =findViewById(R.id.forgetpasstextView);
        emailtextView =findViewById(R.id.emailtextView);
        passtextView =findViewById(R.id.passtextView);
        passconfirmetextView =findViewById(R.id.passconfirmetextView);
        editTextTextPassword3 =findViewById(R.id.editTextTextPassword3);
        editTextTextPassword5 =findViewById(R.id.editTextTextPassword5);
        next2button =findViewById(R.id.next2button);
    }
}
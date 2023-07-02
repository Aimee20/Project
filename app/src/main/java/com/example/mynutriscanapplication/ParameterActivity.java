package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ParameterActivity extends AppCompatActivity {
    ImageButton EditorimageButton;
    ImageView ParameterimageView;
    ImageView barreimageView;
    TextView NumbertextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);
        EditorimageButton = findViewById(R.id.EditorimageButton);
        EditorimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParameterActivity.this,EditActivity.class);
                startActivity(intent);
            }
        });
        ParameterimageView = findViewById(R.id.ParameterimageView);
        barreimageView = findViewById(R.id.barreimageView);
        NumbertextView = findViewById(R.id.NumbertextView);
    }
}
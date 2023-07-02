package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    /*This part is for the declaration on the variable*/
    TextView LogintextView;
    TextView courrieltexteView;
    TextView passwordtextView;
    private Button connectionbutton;
    Button inscriptionbutton;
    Button forgetbutton;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;

    private AppDatabase appDatabase;
    private UserDao userDao;

    //Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            //Retrieve references to the necessary UI elements
            LogintextView = findViewById(R.id.LogintextView);
            courrieltexteView = findViewById(R.id.courrieltextView);
            passwordtextView = findViewById(R.id.passwordtextView);
            connectionbutton = findViewById(R.id.connectionbutton);
            appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"my-database").allowMainThreadQueries().build();

            connectionbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Logic of connection
                    // Get the values of the different fields such as:e-mail et password
                    String email = editTextTextEmailAddress.getText().toString();
                    String password = editTextTextPassword.getText().toString();
                    userDao = appDatabase.userDao();

                    // Vérifier les informations d'identification
                   User user = userDao.getUserByEmail(email);//
                    if (user != null && user.getPassword().equals(password)) {
                        // Connexion réussie
                        Toast.makeText(LoginActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                        // Démarrer une nouvelle page
                        Intent intent = new Intent(LoginActivity.this,FavorisActivity.class);
                        startActivity(intent);
                    } else {
                        // Informations d'identification invalides
                        // Afficher un message d'erreur ou effectuer une action appropriée
                        Toast.makeText(LoginActivity.this, "Échec de la connexion. Veuillez vérifier vos informations d'identification.", Toast.LENGTH_SHORT).show();
                    }
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

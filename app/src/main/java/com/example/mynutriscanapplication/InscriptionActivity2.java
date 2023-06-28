package com.example.mynutriscanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InscriptionActivity2 extends AppCompatActivity {
    TextView inscriptiontextView;
    private TextView surnametextView;
    private TextView nametextView;
    TextView passwordtextView1;
    TextView confirmetextView;
    private TextView mailtextView;
    EditText editTextTextPersonName;
    EditText editTextTextPersonName2;
    private EditText editTextTextPassword2;
    EditText editTextTextPassword3;
    EditText editTextTextEmailAddress2;
    private Button next1button;
    private AppDatabase appDatabase;
    private UserDao userDao;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);
        inscriptiontextView =findViewById(R.id.inscriptiontextView);
        surnametextView =findViewById(R.id.surnametextView);
        nametextView =findViewById(R.id.nametextView);
        passwordtextView1 =findViewById(R.id.passwordtextView1);
        confirmetextView =findViewById(R.id.confirmetextView);
        mailtextView =findViewById(R.id.mailtextView);
        editTextTextPersonName =findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 =findViewById(R.id.editTextTextPersonName2);
        editTextTextPassword2 =findViewById(R.id.editTextTextPassword2);
        editTextTextPassword3 =findViewById(R.id.editTextTextPassword3);
        editTextTextEmailAddress2 =findViewById(R.id.editTextTextEmailAddress2);
        next1button =findViewById(R.id.next1button);
        // Initialiser la base de données
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "my-database")
                .allowMainThreadQueries() // Attention : ne pas utiliser en production
                .build();
        userDao = appDatabase.userDao();

        // Appeler la méthode pour créer un comptesignUp
        next1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les valeurs saisies par l'utilisateur
                String email = editTextTextEmailAddress2.getText().toString();
                String password = editTextTextPassword2.getText().toString();
                String username = surnametextView.getText().toString();
                String prenom = nametextView.getText().toString();
                // Appeler la méthode pour créer un compte
                signUp(email, password, username, prenom);
            }
        });
    }
    private void signUp(String email, String password, String username, String prenom) {
        // Effectuer la logique de création de compte ici

        // Vérifier si l'utilisateur existe déjà
        User existingUser = userDao.getUserByEmail(email);
        if (existingUser != null) {
            Toast.makeText(this, "Un compte avec cet email existe déjà", Toast.LENGTH_SHORT).show();
        } else {
            // Créer un nouvel utilisateur
            User newUser = new User(id,email, password, username, prenom);
            userDao.insert(newUser);

            // Compte créé avec succès
            Toast.makeText(this, "Compte créé avec succès", Toast.LENGTH_SHORT).show();

            // Rediriger vers l'écran de connexion ou effectuer une autre action appropriée
            Intent intent = new Intent(InscriptionActivity2.this,LoginActivity.class);
            startActivity(intent);
        }
        }
    }
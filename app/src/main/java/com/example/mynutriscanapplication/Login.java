package com.example.mynutriscanapplication;

import android.content.Context;
import android.widget.Toast;

public class Login {
    public static void login(Context context, String email, String password) {
        // Exemple de vérification simple
        // Connexion échouée
        if (email.equals("example@example.com") && password.equals("password")) {
            // Connexion réussie
            Toast.makeText(context,"Connexion réussie", Toast.LENGTH_SHORT).show();
            // Rediriger vers l'écran principal ou effectuer une autre action appropriée
        } else
            Toast.makeText(context, "Échec de la connexion. Veuillez vérifier vos informations d'identification.", Toast.LENGTH_SHORT).show();
    }
}

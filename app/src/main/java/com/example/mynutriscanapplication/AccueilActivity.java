package com.example.mynutriscanapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AccueilActivity extends AppCompatActivity {
    EditText editTextTextPersonName4;
    EditText editTextTextPersonName3;
    TextView datetextView;
    ImageButton PictureimageButton;
    ImageButton profilimageButton;
    ImageButton FavorisimageButton;
    ImageButton ParameterimageButton;
    ImageView imageView;
    //Constant to identify the action of image capture
    private int REQUEST_IMAGE_CAPTURE = 1;
    int REQUEST_CAMERA_PERMISSION = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        imageView = findViewById(R.id.imageView);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        datetextView = findViewById(R.id.datetextView);
        //Associating your UI button with a Button object for the device
        PictureimageButton = findViewById(R.id.PictureimageButton);
        PictureimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(AccueilActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    // La permission n'est pas accordée, demander à l'utilisateur la permission
                    Toast.makeText(AccueilActivity.this,"You have already granted this permission",Toast.LENGTH_SHORT).show();
                } else {
                    // La permission est déjà accordée, vous pouvez accéder à la caméra
                    requestPermissions();
                }
                //Adds a click listener to the button to initiate the image capture intent
                //dispatchTakePictureIntent();
            }
        });
        profilimageButton = findViewById(R.id.profilimageButton);
        profilimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        FavorisimageButton = findViewById(R.id.FavorisimageButton);
        FavorisimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        ParameterimageButton = findViewById(R.id.ParameterimageButton);
        ParameterimageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, ParameterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void requestPermissions()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
        {
            new AlertDialog.Builder(this)
                    .setTitle("Permisson needed")
                    .setMessage("This permissions is needed beacause of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(AccueilActivity.this, new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();
        }else{
            ActivityCompat.requestPermissions(AccueilActivity.this, new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION);
        }
    }

    //@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, vous pouvez accéder à la caméra
                Toast.makeText(this, "Permission Granted",Toast.LENGTH_SHORT).show();
            } else {
                // Permission refusée, vous devez gérer cette situation (ex: afficher un message à l'utilisateur)
                Toast.makeText(this, "Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Setting the dispatchTakePictureIntent() method to create and launch the image capture intent
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //Manage the result of the intention in the method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // The image has been captured successfully, you can now process the captured image
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // Do something with the captured image, for example, display it in an ImageView
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
package com.example.formulaireapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nom, email, phone, adresse, ville;
    private Button btnEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        ville = findViewById(R.id.ville);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        btnEnvoyer.setOnClickListener(v -> {

            String sNom = nom.getText().toString().trim();
            String sEmail = email.getText().toString().trim();
            String sPhone = phone.getText().toString().trim();
            String sAdresse = adresse.getText().toString().trim();
            String sVille = ville.getText().toString().trim();

            if (sNom.isEmpty() || sEmail.isEmpty()) {
                Toast.makeText(this, "Nom et Email sont obligatoires.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
                Toast.makeText(this, "Email invalide.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent i = new Intent(MainActivity.this, Screen2Activity.class);

            i.putExtra("nom", sNom);
            i.putExtra("email", sEmail);
            i.putExtra("phone", sPhone);
            i.putExtra("adresse", sAdresse);
            i.putExtra("ville", sVille);

            startActivity(i);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        nom.setText("");
        email.setText("");
        phone.setText("");
        adresse.setText("");
        ville.setText("");
    }
}
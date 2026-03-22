package com.example.formulaireapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour, btnPartager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);
        btnPartager = findViewById(R.id.btnPartager);

        Intent intent = getIntent();

        String nom = intent.getStringExtra("nom");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville = intent.getStringExtra("ville");

        String resume = "Nom : " + safe(nom) +
                "\nEmail : " + safe(email) +
                "\nPhone : " + safe(phone) +
                "\nAdresse : " + safe(adresse) +
                "\nVille : " + safe(ville);

        recap.setText(resume);

        btnRetour.setOnClickListener(v -> finish());

        btnPartager.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, recap.getText().toString());
            startActivity(Intent.createChooser(shareIntent, "Partager via"));
        });
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
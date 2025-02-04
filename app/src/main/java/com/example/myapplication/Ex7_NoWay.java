package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex7_NoWay extends AppCompatActivity {
    private String numeroTel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.appel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //on récupère le numéro de téléphone
            numeroTel = bundle.getString("numeroTel");
            TextView telephone = findViewById(R.id.editTextPhone);
            telephone.setText(numeroTel);
        }

        findViewById(R.id.button3).setOnClickListener(v -> {
            finish();
        });
        Uri uri = Uri.parse("tel:" + numeroTel);

        findViewById(R.id.appeler).setOnClickListener(v -> {
            //il faut récuper le numéro de téléphone pour lancer l'appel, via Uri
            Intent appel = new Intent(Intent.ACTION_DIAL, uri);

            startActivity(appel);

        });
    }
}
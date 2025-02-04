package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex7_page_recup extends AppCompatActivity {

    private TextView nom;
    private TextView prenom;
    private TextView age;
    private TextView telephone;
    private TextView domaine;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_recup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //on récupère les information transmise via un bundle :
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nom = findViewById(R.id.editTextText);
            prenom = findViewById(R.id.editTextText2);
            age = findViewById(R.id.editTextText3);
            telephone = findViewById(R.id.editTextPhone);
            domaine = findViewById(R.id.editTextTextMultiLine2);
            nom.setText(bundle.getString("nom"));
            prenom.setText(bundle.getString("prenom"));
            age.setText(bundle.getString("age"));
            telephone.setText(bundle.getString("numeroTel"));
            domaine.setText(bundle.getString("domaine"));
        }

        findViewById(R.id.button).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.button2).setOnClickListener(v -> {
            Intent intent = new Intent(Ex7_page_recup.this, Ex7_NoWay.class);
            intent.putExtra("numeroTel", telephone.getText().toString());
            startActivity(intent);
        });

    }
}
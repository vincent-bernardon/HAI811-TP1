package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectExo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.select_exo); //c'est la vue
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.selectexo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonExo2 = findViewById(R.id.button_exo2);
        buttonExo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectExo.this, MainActivity.class); //pas bien compris pour quoi il faut spécifier la classe si jamais diapo 61
                startActivity(intent);
            }
        });

        Button buttonExo3 = findViewById(R.id.button_exo3);
        buttonExo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectExo.this, Exo3.class);
                startActivity(intent);
            }
        });

        Button buttonExo4 = findViewById(R.id.button_exo4);
        buttonExo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectExo.this, Exo4.class);
                startActivity(intent);
            }
        });
    }
}

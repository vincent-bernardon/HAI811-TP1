package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.ArrayMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Exo9 extends AppCompatActivity {
    private ArrayMap<String, ArrayList<String>> events = new ArrayMap<>();

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.agenda);//choix de la page
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.addEvent);
        button.setOnClickListener(v -> {
            //demander de saisir une date et une description dans champ et les récupéré
            AlertDialog.Builder builder = new AlertDialog.Builder(Exo9.this);
            builder.setTitle("Ajouter un événement");
            LinearLayout layout = new LinearLayout(Exo9.this);
            layout.setOrientation(LinearLayout.VERTICAL);

            TextInputEditText date = new TextInputEditText(Exo9.this);
            date.setHint("Date");
            layout.addView(date);

            TextInputEditText description = new TextInputEditText(Exo9.this);
            description.setHint("Description");
            layout.addView(description);

            builder.setView(layout);

            builder.setPositiveButton("Ajouter", (dialog, which) -> {
                //ajouter l'événement à la map
                String key = date.getText().toString();
                String value = description.getText().toString();
                if (events.containsKey(key)) {
                    events.get(key).add(value);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(value);
                    events.put(key, list);
                }

                TextView textView = findViewById(R.id.textView2);
                StringBuilder text = new StringBuilder();
                for (String evkey : events.keySet()) {
                    text.append(evkey).append(" : ");
                    for (String evvalue : events.get(evkey)) {
                        text.append(evvalue).append(", ");
                    }
                    text.delete(text.length() - 2, text.length());
                    text.append("\n");
                }
                textView.setText(text.toString());


            });

            builder.setNegativeButton("Annuler", (dialog, which) -> dialog.cancel());
            builder.show();

        });










    }
}
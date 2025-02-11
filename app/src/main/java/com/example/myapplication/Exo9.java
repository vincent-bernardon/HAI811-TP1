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
    private LinearLayout eventListLayout; //permet de stocker les événements et gracea cela de les supp

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

        eventListLayout = findViewById(R.id.eventListLayout);

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

                updateEventList();


            });

            builder.setNegativeButton("Annuler", (dialog, which) -> dialog.cancel());
            builder.show();

        });


        updateEventList();







    }


    private void updateEventList() {
        eventListLayout.removeAllViews(); //on supprime les évènement pour les raficher
        for (String key : events.keySet()) {
            LinearLayout list = new LinearLayout(this);
            list.setOrientation(LinearLayout.VERTICAL);

            TextView eventText = new TextView(this);
            eventText.setText("\n" + key + " : ");
            list.addView(eventText);

            for (String value : events.get(key)) {
                LinearLayout delLayout = new LinearLayout(this);
                delLayout.setOrientation(LinearLayout.HORIZONTAL);

                TextView event = new TextView(this);
                event.setText(value);
                LinearLayout.LayoutParams eventParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f); //param pour le textview
                event.setLayoutParams(eventParams);
                delLayout.addView(event);

                Button deleteButton = new Button(this);
                deleteButton.setText("X");
                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); //param pour le bouton
                deleteButton.setLayoutParams(buttonParams);
                deleteButton.setOnClickListener(v -> {
                    events.get(key).remove(value);
                    if (events.get(key).isEmpty()) {
                        events.remove(key);
                    }
                    updateEventList();
                });
                delLayout.addView(deleteButton);

                list.addView(delLayout);
            }
            eventListLayout.addView(list);
        }
    }
}
package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Exo8 extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.destination);//choix de la page
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ville, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.ville, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.textView3);
            //afficher une liste de trager possible
            ArrayAdapter<CharSequence> adaptertrajet = null;
            if (spinner.getSelectedItem().toString().equals("Narbonne") && spinner2.getSelectedItem().toString().equals("Montpellier")) {
                adaptertrajet = ArrayAdapter.createFromResource(this, R.array.NvM, android.R.layout.simple_list_item_1);

            } else if (spinner.getSelectedItem().toString().equals("Montpellier") && spinner2.getSelectedItem().toString().equals("Narbonne")) {
                adaptertrajet = ArrayAdapter.createFromResource(this, R.array.MvN, android.R.layout.simple_list_item_1);

            } else if (spinner.getSelectedItem().toString().equals("Narbonne") && spinner2.getSelectedItem().toString().equals("Beziers")) {
                adaptertrajet = ArrayAdapter.createFromResource(this, R.array.NvB, android.R.layout.simple_list_item_1);

            } else if (spinner.getSelectedItem().toString().equals("Beziers") && spinner2.getSelectedItem().toString().equals("Narbonne")) {
                adaptertrajet = ArrayAdapter.createFromResource(this, R.array.BvN, android.R.layout.simple_list_item_1);

            } else if (spinner.getSelectedItem().toString().equals("Montpellier") && spinner2.getSelectedItem().toString().equals("Beziers")) {
                adaptertrajet = ArrayAdapter.createFromResource(this, R.array.MvB, android.R.layout.simple_list_item_1);

            } else if (spinner.getSelectedItem().toString().equals("Beziers") && spinner2.getSelectedItem().toString().equals("Montpellier")) {
                adaptertrajet = ArrayAdapter.createFromResource(this, R.array.BvM, android.R.layout.simple_list_item_1);
            }

            if (adaptertrajet != null) {
                StringBuilder trajetText = new StringBuilder();
                for (int i = 0; i < adaptertrajet.getCount(); i++) {
                    trajetText.append(adaptertrajet.getItem(i)).append("\n"); //retour a la ligne entre chaque trajet
                }
                textView.setText(trajetText.toString());
            } else {
                textView.setText("Aucun train disponible");
            }
        });







    }
}
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
    private ArrayList<String> NvM = new ArrayList<>();
    private ArrayList<String> NvB = new ArrayList<>();
    private ArrayList<String> MvB = new ArrayList<>();
    private ArrayList<String> BvM = new ArrayList<>();
    private ArrayList<String> MvN = new ArrayList<>();
    private ArrayList<String> BvN = new ArrayList<>();

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

        NvM.add("Train n°14 : 8h00 ; arrivée à 10h00");
        NvM.add("Train n°15 : 10h00 ; arrivée à 12h00");
        NvM.add("Train n°16 : 12h00 ; arrivée à 14h00");
        MvN.add("Train n°17 : 14h00 ; arrivée à 16h00");
        MvN.add("Train n°18 : 16h00 ; arrivée à 18h00");
        NvB.add("Train n°19 : 18h00 ; arrivée à 20h00");
        NvB.add("Train n°20 : 20h00 ; arrivée à 22h00");
        BvN.add("Train n°21 : 22h00 ; arrivée à 00h00");
        BvM.add("Train n°22 : 00h00 ; arrivée à 02h00");
        BvM.add("Train n°23 : 02h00 ; arrivée à 04h00");
        MvB.add("Train n°24 : 04h00 ; arrivée à 06h00");

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
            String tajets = "";
            if(spinner.getSelectedItem().toString().equals("Narbonne") && spinner2.getSelectedItem().toString().equals("Montpellier")){

                for (int i = 0; i < NvM.size(); i++) {
                    tajets += NvM.get(i) + "\n";
                }

            }else if(spinner.getSelectedItem().toString().equals("Montpellier") && spinner2.getSelectedItem().toString().equals("Narbonne")) {

                for (int i = 0; i < MvN.size(); i++) {
                    tajets += MvN.get(i) + "\n";
                }
            }else if(spinner.getSelectedItem().toString().equals("Narbonne") && spinner2.getSelectedItem().toString().equals("Beziers")) {

                for (int i = 0; i < NvB.size(); i++) {
                    tajets += NvB.get(i) + "\n";
                }
            }else if(spinner.getSelectedItem().toString().equals("Beziers") && spinner2.getSelectedItem().toString().equals("Narbonne")) {

                for (int i = 0; i < BvN.size(); i++) {
                    tajets += BvN.get(i) + "\n";
                }
            }else if(spinner.getSelectedItem().toString().equals("Montpellier") && spinner2.getSelectedItem().toString().equals("Beziers")) {

                for (int i = 0; i < MvB.size(); i++) {
                    tajets += MvB.get(i) + "\n";
                }
            }else if(spinner.getSelectedItem().toString().equals("Beziers") && spinner2.getSelectedItem().toString().equals("Montpellier")) {

                for (int i = 0; i < BvM.size(); i++) {
                    tajets += BvM.get(i) + "\n";
                }
            }
            textView.setText(tajets);
        });







    }
}
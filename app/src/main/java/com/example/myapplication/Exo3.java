package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Exo3 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        parti 1
//        setContentView(R.layout.activity_exo3);//choix de la page
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

//        parti 2, on dois reconstituer en java le layout fait en xml
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL); //on dispose les éléments de manière verticale (donc les uns en dessous des autres)

        //mettre de l'espacement entre le haut et le premier élément sinon on ne vois pas le premier élément
        linearLayout.setPadding(100, 300, 100, 200);

        TextView titre = new TextView(this);
        titre.setText(getString(R.string.exo3));
        linearLayout.addView(titre);

        LinearLayout nomLayout = new LinearLayout(this);
        nomLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView nomLabel = new TextView(nomLayout.getContext());
            nomLabel.setText(getString(R.string.nom));
            nomLabel.setWidth(200);
            nomLayout.addView(nomLabel);
            TextInputEditText nom = new TextInputEditText(nomLayout.getContext());
            nom.setWidth(600);
            nomLayout.addView(nom);

        linearLayout.addView(nomLayout);


        LinearLayout prenomLayout = new LinearLayout(this);
        prenomLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView prenomLabel = new TextView(prenomLayout.getContext());
            prenomLabel.setText(getString(R.string.pr_nom));
            prenomLabel.setWidth(200);
            prenomLayout.addView(prenomLabel);
            TextInputEditText prenom = new TextInputEditText(prenomLayout.getContext());
            prenom.setWidth(600);
            prenomLayout.addView(prenom);

        linearLayout.addView(prenomLayout);


        LinearLayout ageLayout = new LinearLayout(this);
        ageLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView ageLabel = new TextView(ageLayout.getContext());
            ageLabel.setText(getString(R.string.age));
            ageLabel.setWidth(200);
            ageLayout.addView(ageLabel);

            TextInputEditText age = new TextInputEditText(ageLayout.getContext());
            age.setWidth(600);
            ageLayout.addView(age);

        linearLayout.addView(ageLayout);


        LinearLayout numeroTelLayout = new LinearLayout(this);
        numeroTelLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView numeroTelLabel = new TextView(numeroTelLayout.getContext());
            numeroTelLabel.setText(getString(R.string.num_ro_de_t_l_phone));
            numeroTelLabel.setWidth(200);
            numeroTelLayout.addView(numeroTelLabel);
            TextInputEditText numeroTel = new TextInputEditText(numeroTelLayout.getContext());
            numeroTel.setWidth(600);
            numeroTelLayout.addView(numeroTel);

        linearLayout.addView(numeroTelLayout);

        LinearLayout domaineLayout = new LinearLayout(this);
        domaineLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView domaineLabel = new TextView(domaineLayout.getContext());
            domaineLabel.setText(getString(R.string.domaine_de_comp_tences));
            domaineLabel.setWidth(200);
            domaineLayout.addView(domaineLabel);
            TextInputEditText domaine = new TextInputEditText(domaineLayout.getContext());
            domaine.setWidth(600);
            domaineLayout.addView(domaine);

        linearLayout.addView(domaineLayout);

        Button button = new Button(this);
        button.setText(getString(R.string.valider));
        linearLayout.addView(button);

        setContentView(linearLayout);






        


    }
}
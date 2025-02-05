package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Exo4 extends AppCompatActivity {

    private boolean isFrench = true;
    private boolean isSwithce = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isFrench", isFrench);
        outState.putBoolean("isSwithce", isSwithce);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            isFrench = savedInstanceState.getBoolean("isFrench");
            isSwithce = savedInstanceState.getBoolean("isSwithce");
        }
        EdgeToEdge.enable(this);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL); //on dispose les éléments de manière verticale (donc les uns en dessous des autres)

        //mettre de l'espacement entre le haut et le premier élément sinon on ne vois pas le premier élément
        linearLayout.setPadding(100, 300, 100, 200);

        LinearLayout titleLayout = new LinearLayout(this);
        titleLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView titre = new TextView(this);
        titre.setText(getString(R.string.exo4));
        titleLayout.addView(titre);

        View espace = new View(this);
        LinearLayout.LayoutParams spacerParams = new LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.MATCH_PARENT);
        titleLayout.addView(espace, spacerParams);

        Switch lange = new Switch(this);
        lange.setChecked(!isSwithce);
        lange.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isFrench = isChecked;
            isSwithce = !isSwithce;
            recreate();
        });
        if(isFrench) {
            lange.setText(getString(R.string.changer_la_language));
        }else{
            lange.setText(getString(R.string.change_language));
        }

        titleLayout.addView(lange);

        linearLayout.addView(titleLayout);

        LinearLayout nomLayout = new LinearLayout(this);
        nomLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView nomLabel = new TextView(nomLayout.getContext());
        if(isFrench){
            nomLabel.setText(getString(R.string.nom));
        }else{
            nomLabel.setText(getString(R.string.last_name));
        }
        nomLabel.setWidth(200);
        nomLayout.addView(nomLabel);
        TextInputEditText nom = new TextInputEditText(nomLayout.getContext());
        nom.setWidth(600);
        nomLayout.addView(nom);

        linearLayout.addView(nomLayout);


        LinearLayout prenomLayout = new LinearLayout(this);
        prenomLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView prenomLabel = new TextView(prenomLayout.getContext());
        if(isFrench){
            prenomLabel.setText(getString(R.string.pr_nom));
        }else{
            prenomLabel.setText(getString(R.string.first_name));
        }
        prenomLabel.setWidth(200);
        prenomLayout.addView(prenomLabel);
        TextInputEditText prenom = new TextInputEditText(prenomLayout.getContext());
        prenom.setWidth(600);
        prenomLayout.addView(prenom);

        linearLayout.addView(prenomLayout);


        LinearLayout ageLayout = new LinearLayout(this);
        ageLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView ageLabel = new TextView(ageLayout.getContext());
        if(isFrench){
            ageLabel.setText(getString(R.string.age));

        }else{
            ageLabel.setText(getString(R.string.yo));
        }
        ageLabel.setWidth(200);
        ageLayout.addView(ageLabel);

        TextInputEditText age = new TextInputEditText(ageLayout.getContext());
        age.setWidth(600);
        ageLayout.addView(age);

        linearLayout.addView(ageLayout);


        LinearLayout numeroTelLayout = new LinearLayout(this);
        numeroTelLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView numeroTelLabel = new TextView(numeroTelLayout.getContext());
        if(isFrench){
            numeroTelLabel.setText(getString(R.string.num_ro_de_t_l_phone));

        }else{
            numeroTelLabel.setText(getString(R.string.phone_number));
        }
        numeroTelLabel.setWidth(200);
        numeroTelLayout.addView(numeroTelLabel);
        TextInputEditText numeroTel = new TextInputEditText(numeroTelLayout.getContext());
        numeroTel.setWidth(600);
        numeroTelLayout.addView(numeroTel);

        linearLayout.addView(numeroTelLayout);

        LinearLayout domaineLayout = new LinearLayout(this);
        domaineLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView domaineLabel = new TextView(domaineLayout.getContext());
        if(isFrench){
            domaineLabel.setText(getString(R.string.domaine_de_comp_tences));

        }else{
            domaineLabel.setText(getString(R.string.domain_of_expertise));
        }
        domaineLabel.setWidth(200);
        domaineLayout.addView(domaineLabel);
        TextInputEditText domaine = new TextInputEditText(domaineLayout.getContext());
        domaine.setWidth(600);
        domaineLayout.addView(domaine);

        linearLayout.addView(domaineLayout);

        Button button = new Button(this);
        if(isFrench){
            button.setText(getString(R.string.valider));

        }else{
            button.setText(getString(R.string.check));
        }
        linearLayout.addView(button);

        setContentView(linearLayout);





    }
}
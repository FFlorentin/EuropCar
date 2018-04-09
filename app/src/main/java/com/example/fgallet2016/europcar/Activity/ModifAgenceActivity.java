package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fgallet2016.europcar.Fragment.ModifAgenceFragment;
import com.example.fgallet2016.europcar.R;

public class ModifAgenceActivity extends AppCompatActivity {


    private EditText raison_social;
    private EditText siret;
    private EditText voie;
    private EditText code_postal;
    private EditText ville;
    private Button bouton_modifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_agence);

        this.raison_social = findViewById(R.id.raison_social);
        this.siret = findViewById(R.id.siret);
        this.voie = findViewById(R.id.voie);
        this.code_postal = findViewById(R.id.code_postal);
        this.ville = findViewById(R.id.ville);
        this.bouton_modifier = findViewById(R.id.bouton_modifier);



        bouton_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModifAgenceActivity.this, LocationVehiculeActivity.class);
                intent.putExtra("raison_social", raison_social.getText().toString());
                intent.putExtra("siret", siret.getText().toString());
                intent.putExtra("voie", voie.getText().toString());
                intent.putExtra("code_postal", code_postal.getText().toString());
                intent.putExtra("ville", ville.getText().toString());
                startActivity(intent);
            }
        });
    }
}

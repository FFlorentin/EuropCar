package com.example.fgallet2016.europcar.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fgallet2016.europcar.Model.Vehicule;
import com.example.fgallet2016.europcar.R;
import com.example.fgallet2016.europcar.Service.VehiculeService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ReservationActivity extends AppCompatActivity {

    private TextView idVehicule;
    private TextView libelleText;
    private TextView locationMin;
    private TextView locationMax;
    private TextView tarifMin;
    private TextView tarifMax;
    private TextView nbPlace;
    private EditText editText;

    private VehiculeService vehicules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        editText = (EditText) findViewById(R.id.edit_date_debut);

      /*  editText.OnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(classname.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id_vehicule");
        String libelle = intent.getStringExtra("libelle");
        Integer location_min = intent.getIntExtra("location_min",0);
        Integer location_max = intent.getIntExtra("location_max",0);
        Float tarif_min = intent.getFloatExtra("tarif_min",0);
        Float tarif_max = intent.getFloatExtra("tarif_max",0);
        Integer nb_place = intent.getIntExtra("nb_place",0);

        // Appel du service pour récupérer le véhicule
     //   Vehicule vehicule = this.vehicules.getVehiculeById(id);

        idVehicule = findViewById(R.id.id_vehicule);
        libelleText = findViewById(R.id.libelle);
        locationMin = findViewById(R.id.location_min);
        locationMax = findViewById(R.id.location_max);
        tarifMin = findViewById(R.id.tarif_min);
        tarifMax = findViewById(R.id.tarif_max);
        nbPlace = findViewById(R.id.nb_place);

        idVehicule.setText(id);
        libelleText.setText(libelle);
        locationMin.setText(String.valueOf(location_min));
        locationMax.setText(String.valueOf(location_max));
        tarifMin.setText(String.valueOf(tarif_min));
        tarifMax.setText(String.valueOf(tarif_max));
        nbPlace.setText(String.valueOf(nb_place));



    }



    Calendar myCalendar = Calendar.getInstance();


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

   /*edittext.OnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            new DatePickerDialog(classname.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    });*/

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        //edittext.setText(sdf.format(myCalendar.getTime()));
    }

}

package com.example.fgallet2016.europcar.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fgallet2016.europcar.DAO.ReservationDAO;
import com.example.fgallet2016.europcar.Fragment.RetourFragment;
import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.R;
import com.example.fgallet2016.europcar.Service.ReservationService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RetourActivity extends AppCompatActivity implements RetourFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retour);

    }

    @Override
    protected void onResume() {
        super.onResume();

        String id = getIntent().getStringExtra("id");
        ReservationService service = new ReservationService();
        Reservation reservation = service.getReservationById(id);

        if (reservation != null){
            TextView libelle = findViewById(R.id.libelle);
            TextView dateDebut = findViewById(R.id.date_debut);
            TextView dateFin = findViewById(R.id.date_fin);
            TextView tarifJournalier = findViewById(R.id.tarif_journalier);

            libelle.setText(reservation.getVehicule());
            dateDebut.setText(reservation.getDateDebut());
            dateFin.setText(reservation.getDateFin());
            tarifJournalier.setText(reservation.getTarifJournalier());

        }
    }

    private Uri file;

    @Override
    public void prendre_photo() {
        // Vérifier les permissions
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // La permission doit être demandée
            ActivityCompat.requestPermissions(this,
                    new String[] {
                            Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    },
                    42);
        } else {
            // La permission a déjà été donnée, lancer l'appareil photo
            takePicture();
        }

        Button prendrePhoto = findViewById(R.id.ajouter_photo);
        prendrePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }

    public void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Préparation du fichier qui recevra la photo
        // Récupération du répertoire "Album" de l'appareil
        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES), "LiveCoding"
        );
        // Si le répertoire "LiveCoding" n'existe pas, le créer
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
        }
        // Création d'un nom de fichier unique
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        // Création du fichier dans le répertoire
        file = Uri.fromFile(new File(mediaStorageDir.getPath()
                + File.separator +
                timestamp + ".jpg"));

        // Désactiver la sécurité sur les URI
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        // Lancement de l'activité de prise de vue
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(intent, 42);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 42) {
            if (grantResults.length >= 3
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED
                    && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                // La permission a déjà été donnée, lancer l'appareil photo
                takePicture();
            } else {
                Toast.makeText(this,
                        "Impossible d'obtenir les permissions nécessaires, veuillez réessayer",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}

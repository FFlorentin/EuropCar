package com.example.fgallet2016.europcar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fgallet2016.europcar.Activity.LocationVehiculeActivity;
import com.example.fgallet2016.europcar.R;

public class ModifAgenceFragment extends Fragment {

    public ModifAgenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_modif_agence, container, false);

        return v;

    }



}

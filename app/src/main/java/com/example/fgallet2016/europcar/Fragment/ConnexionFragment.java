package com.example.fgallet2016.europcar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fgallet2016.europcar.DAO.UtilisateurDAO;
import com.example.fgallet2016.europcar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConnexionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConnexionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConnexionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText emailUser;
    private EditText motDePasse;
    private EditText token;
    private Button seConnecter;

    private OnFragmentInteractionListener mListener;

    public ConnexionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConnexionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConnexionFragment newInstance(String param1, String param2) {
        ConnexionFragment fragment = new ConnexionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_connexion, container, false);

        emailUser = v.findViewById(R.id.adresse_mail);
        motDePasse = v.findViewById(R.id.mot_de_passe);
        token = v.findViewById(R.id.token);
        seConnecter = v.findViewById(R.id.se_connecter);


        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isError = false;
                if (emailUser.getText().toString().isEmpty()) {
                    emailUser.setError("Veuillez saisir un email");
                    isError = true;
                }
                if (motDePasse.getText().toString().isEmpty()) {
                    motDePasse.setError("Veuillez saisir un mot de passe");
                    isError = true;
                }
                if (token.getText().toString().isEmpty()) {
                    token.setError("Veuillez saisir votre token");
                    isError = true;
                }


                if (!isError) {
                    mListener.seConnecter();
                }
            }
        });

        return v;
    }

/*    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void seConnecter();
    }
}

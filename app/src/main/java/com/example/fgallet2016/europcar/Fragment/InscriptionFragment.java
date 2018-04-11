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

import com.example.fgallet2016.europcar.DAO.UtilisateurDAO;
import com.example.fgallet2016.europcar.Model.Utilisateur;
import com.example.fgallet2016.europcar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InscriptionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InscriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InscriptionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText emailUser;
    private EditText passwordUser;
    private EditText confirmPasswordUser;
    private EditText token;
    private Button sinscrire;

    private UtilisateurDAO utilisateurDAO;

    private OnFragmentInteractionListener mListener;

    public InscriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InscriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InscriptionFragment newInstance(String param1, String param2) {
        InscriptionFragment fragment = new InscriptionFragment();
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
        View v = inflater.inflate(R.layout.fragment_inscription, container, false);

        this.sinscrire = v.findViewById(R.id.bouton_inscription);

        this.emailUser = v.findViewById(R.id.adresse_mail);
        this.passwordUser = v.findViewById(R.id.mot_de_passe);
        this.confirmPasswordUser = v.findViewById(R.id.confirm_mot_de_passe);
        this.token = v.findViewById(R.id.token);

        sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isError = false;

                if (emailUser.getText().toString().isEmpty()){
                    emailUser.setError("Veuillez saisir une adresse email");
                    isError = true;
                }
                if (passwordUser.getText().toString().isEmpty()){
                    passwordUser.setError("Veuillez saisir un mot de passe");
                    isError = true;
                }
                if (!passwordUser.getText().toString().equals(confirmPasswordUser.getText().toString())){
                    confirmPasswordUser.setError("Les mots de passes ne sont pas identiques");
                    isError = true;
                }
                if (token.getText().toString().isEmpty()){
                    token.setError("Veuillez saisir un token");
                    isError = true;
                }

                if (!isError){
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setEmail(emailUser.getText().toString());
                    utilisateur.setPassword(passwordUser.getText().toString());
                    utilisateur.setToken(token.getText().toString());
                    utilisateurDAO.insert(utilisateur);

                    mListener.ajoutInscrit();
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
        void ajoutInscrit();
    }
}

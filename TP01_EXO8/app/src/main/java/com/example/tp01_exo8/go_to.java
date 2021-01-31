package com.example.tp01_exo8;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.tp01_exo8.R.id.lv_horaires;


public class go_to extends Fragment {

    private SendMessages sendMessages;

    private static final String[] VILLES = new String[]{"Paris","Montpellier","Lyon","Nime","Lille","Strasbourg",
            "Grenoble","Tours","Perpignan","Toulouse","Marseille",
            "Nantes","Nice","Bordeaux","Rennes"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sendMessages = (SendMessages) context;
    }

    public go_to() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment.
        final View rootView = inflater.inflate(R.layout.fragment_go_to, container, false);
        // get the user inputs
        final AutoCompleteTextView et_depart = rootView.findViewById(R.id.et_depart);
        final  AutoCompleteTextView et_arriver = rootView.findViewById(R.id.et_ariver);
        final Button b_seartch =  rootView.findViewById(R.id.b_search);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_dropdown_item_1line, VILLES);
        et_depart.setAdapter(adapter2);
        et_arriver.setAdapter(adapter2);

        b_seartch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rootView.getContext(), "search clicked", Toast.LENGTH_SHORT).show();
                String d = et_depart.getText().toString() ;
                String a = et_arriver.getText().toString() ;
                sendMessages.iAmMSG(d+":"+a);
            }
        });
        // Return the View for the fragment's UI.
        return rootView;
    }

    // Interface - fragment to activity
    public interface SendMessages {
        void iAmMSG(String msg);
    }
}
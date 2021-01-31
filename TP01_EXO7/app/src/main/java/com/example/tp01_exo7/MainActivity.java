package com.example.tp01_exo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp_domain_competance ;
    EditText et_nom ,et_prenom,et_age,et_mobile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_domain_competance=(Spinner)findViewById(R.id.sp_domainCompetance);
        Resources res = getResources();
        String[] com = res.getStringArray(R.array.com);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,com);
        sp_domain_competance.setAdapter(adapter);


        et_nom =(EditText)findViewById(R.id.et_nom);
        et_prenom =(EditText)findViewById(R.id.et_prenom);
        et_age =(EditText)findViewById(R.id.et_age);
        et_mobile =(EditText)findViewById(R.id.et_mobile);
    }

    public void b_validate(View view) {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Are you sure !!!!!");
        builder.setMessage("Etes vous sur de bien vouloir valider les informations ");
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Informations enregistrer",Toast.LENGTH_LONG).show();
                // close alert dialog
                et_nom.setBackgroundColor(Color.RED);
                et_prenom.setBackgroundColor(Color.CYAN);
                dialog.cancel();
            }
        });
        builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"NON",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

        // create the alerte and return it
        builder.create().show();*/


        Intent i = new Intent(this,Activity2.class);
        String nom ,prenom,age,domaine,mobile ;
        nom = et_nom.getText().toString();
        prenom =et_prenom.getText().toString();
        age = et_age.getText().toString();
        mobile =et_mobile.getText().toString();
        domaine =sp_domain_competance.getSelectedItem().toString();

        i.putExtra("nom",nom);
        i.putExtra("prenom",prenom);
        i.putExtra("age",age);
        i.putExtra("domaine",domaine);
        i.putExtra("mobile",mobile);
        startActivity(i);
        finish();
    }
}
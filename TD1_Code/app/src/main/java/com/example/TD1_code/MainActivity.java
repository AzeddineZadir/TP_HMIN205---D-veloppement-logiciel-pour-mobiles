package com.example.TD1_code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView tv1 =  (TextView) findViewById(R.id.tv1);
        EditText et = new EditText(this);
        tv1.setText("Hello, Android");

    /*     LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(tv);
        ll.addView(et);
        setContentView(ll);*/

        Button button = (Button) findViewById(R.id.mainbutton);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),"Message Bouton 1", Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                tv1.setVisibility(View.VISIBLE);
                //tv1.setText("Exercice4");
                tv1.setText(R.string.ex4);
            }
        });
        button2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tv1.setVisibility(View.VISIBLE);
                tv1.setText("long click");
                return true;
            }
        });

    }


}
package com.example.tp01_exo7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    TextView tv_mobile_to_call ;
    Button b_call ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        tv_mobile_to_call = (TextView)findViewById(R.id.tv_mobile_to_call);
        tv_mobile_to_call.setText(getIntent().getExtras().getString("mobile"));
        b_call = (Button)findViewById(R.id.b_call);
    }

    public void b_call(View view) {
        Intent i  = new Intent(Intent.ACTION_CALL);
        String num = tv_mobile_to_call.getText().toString() ;
        if (num.trim().isEmpty()){
            i.setData(Uri.parse("tel:000000000"));
        }else{
            i.setData(Uri.parse("tel:"+num));
        }

        // check permession
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"veuillez approuvez la permission de lappel svp",Toast.LENGTH_LONG).show();
            requestPermissions();
        }else{
            startActivity(i);
        }

    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
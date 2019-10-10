package com.xcheko51x.detectarred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout clFondo;
    Button btnVerificaRed;
    TextView tvEstadoRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clFondo = findViewById(R.id.clFondo);
        btnVerificaRed = findViewById(R.id.btnVerificaRed);
        tvEstadoRed = findViewById(R.id.tvEstadoRed);

        btnVerificaRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericaEstadoRed();
            }
        });
    }

    public void vericaEstadoRed() {
        ConnectivityManager conectividad = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conectividad.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            // Si hay conexion a internet en este momento
            clFondo.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            tvEstadoRed.setText("ESTAS ONLINE");
        } else {
            // Si no hay conexion a internet en este momento
            clFondo.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            tvEstadoRed.setText("ESTAS OFFLINE");
        }
    }
}

package com.example.serviciosocial.tabs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {
        private FragmentTabHost tabHost;
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,
        getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("pest_dispositivos_layout").setIndicator("Datos Dispositivo"),
        DatosDispositivo.class, null);

        tabHost.addTab(tabHost.newTabSpec("pest_datos_adicionales").setIndicator("Datos Adicionales"),
        DatosAdicionales.class, null);

        tabHost.addTab(tabHost.newTabSpec("pest_datos_unidad").setIndicator("Datos Unidad"),
        DatosUnidad.class, null);

        tabHost.addTab(tabHost.newTabSpec("pest_datos_personal").setIndicator("Datos del Personal"),
        DatosPersonal.class, null);
        }
        }
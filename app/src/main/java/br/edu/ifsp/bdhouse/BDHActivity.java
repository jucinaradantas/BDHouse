package br.edu.ifsp.bdhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BDHActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            BDHActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdh);
    }

    public void lauchUsuario(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, UsuarioActivity.class);
        startActivity(intent);
    }
    public void lauchVisitas(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, VisitaActivity.class);
        startActivity(intent);
    }
    public void lauchAlarme(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, AlarmeActivity.class);
        startActivity(intent);
    }
    public void lauchLuzes(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, LuzesActivity.class);
        startActivity(intent);
    }
    public void lauchEletrodomestico(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, EletrodomesticoActivity.class);
        startActivity(intent);
    }
    public void lauchPortao(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,PortaoActivity.class);
        startActivity(intent);
    }
    public void lauchTeto(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,TetoActivity.class);
        startActivity(intent);
    }
    public void lauchSolo(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,SoloActivity.class);
        startActivity(intent);
    }
    public void lauchAr(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,ArActivity.class);
        startActivity(intent);
    }
}

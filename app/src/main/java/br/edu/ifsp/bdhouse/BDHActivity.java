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

    public void lauchVisitas(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, VisitaActivity.class);
        startActivity(intent);
    }
}

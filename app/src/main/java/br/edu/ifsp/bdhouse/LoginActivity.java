package br.edu.ifsp.bdhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void lauchBDH(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, BDHActivity.class);
        startActivity(intent);
    }
}

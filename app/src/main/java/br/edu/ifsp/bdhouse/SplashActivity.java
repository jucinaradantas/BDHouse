package br.edu.ifsp.bdhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import br.edu.ifsp.bdhouse.BDHActivity;
import br.edu.ifsp.bdhouse.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarBDHActivity();
            }
        }, 4000);
    }

    private void mostrarBDHActivity() {
        Intent intent = new Intent(
                SplashActivity.this,BDHActivity.class);
        startActivity(intent);
        finish();
    }
}

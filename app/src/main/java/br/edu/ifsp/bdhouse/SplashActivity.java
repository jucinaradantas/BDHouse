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
                mostrarLoginActivity();
            }
        }, 4000);
    }

    private void mostrarLoginActivity() {
        Intent intent = new Intent(
                SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

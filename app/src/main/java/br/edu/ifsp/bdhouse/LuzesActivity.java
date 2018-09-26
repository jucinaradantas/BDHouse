package br.edu.ifsp.bdhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LuzesActivity extends AppCompatActivity {
    ListView comodos;
    private static final String LOG_TAG =
            LuzesActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luzes);


    }
}

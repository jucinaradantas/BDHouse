package br.edu.ifsp.bdhouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class UsuarioActivity extends AppCompatActivity {


    ListView listView;
    private static final String LOG_TAG =
            UsuarioActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);


    }


    public void lauchUsuario_Inserir(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,Usuario_InserirActivity.class);
        startActivity(intent);
    }
    public void lauchUsuario_Editar(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,Usuario_EditarActivity.class);
        startActivity(intent);
    }

}

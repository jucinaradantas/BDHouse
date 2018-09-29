package br.edu.ifsp.bdhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

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
    public void launchUsuario_Editar(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,Usuario_EditarActivity.class);
        startActivity(intent);
    }

}

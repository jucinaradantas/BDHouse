package br.edu.ifsp.bdhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UsuarioActivity extends AppCompatActivity {


    ListView listView;
    private static final String LOG_TAG =
            UsuarioActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        List<User> users = new ArrayList<User>();
        //populando manualmente para testa
        User user1 = new User();
        user1.nome = "Calos";
        user1.login = "carlos123";
        user1.id = 10 ;
        users.add(user1);
        user1 = new User();
        user1.nome = "João Pedro";
        user1.login = "joaopedro";
        user1.id = 11 ;
        users.add(user1);

        listView = (ListView) findViewById(R.id.listUsers);

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_list_item_1, users);

        listView.setAdapter(adapter);
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

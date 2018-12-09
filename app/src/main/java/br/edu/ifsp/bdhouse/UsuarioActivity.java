package br.edu.ifsp.bdhouse;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioActivity extends AppCompatActivity {

    List<User> users;
    ArrayAdapter<User> adapter;

    ListView listView;
    private static final String LOG_TAG =
            UsuarioActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        users = new ArrayList<User>();
        //populando manualmente para testa
        //User user1 = new User();
        //user1.nome = "Calos";
        //user1.login = "carlos123";
        //user1.id = 10 ;
        //users.add(user1);
        //user1 = new User();
        //user1.nome = "João Pedro";
        //user1.login = "joaopedro";
        //user1.id = 11 ;
        //users.add(user1);

        //metodo que consome api
        APIGetUsers api = new APIGetUsers();
        api.execute();

        listView = (ListView) findViewById(R.id.listUsers);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
                        User user = users.get(position);
                        Toast.makeText(getBaseContext(), "Usuário selecionado: " + user.toString(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(),Usuario_EditarActivity.class);
                        intent.putExtra("SelectedUser", user);
                        startActivity(intent);
                    }
                }
        );
        adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_list_item_1, users);


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

    private class APIGetUsers extends AsyncTask<String, Void, String[]> {

        //private String endereco= "http://10.0.0.100/";
        ProgressDialog dialog;

        @Override
        protected String[] doInBackground(String... params) {
            try {
                String endereco = Login.endereco  + "usuario/getusers";

                URL url = new URL(endereco );
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                Scanner scanner = new Scanner(is);
                String conteudo = scanner.useDelimiter("\\A").next();


                String result[] = new String[1];
                JSONArray jsonarray = new JSONArray(conteudo);

                if(jsonarray.length() > 0){
                    for (int i = 0; i < jsonarray.length(); i++){
                        JSONObject jsonObject = jsonarray.getJSONObject(i);
                        User user = new User();
                        user.login = jsonObject.getString("login");
                        user.id = jsonObject.getInt("id");
                        user.grupo_usuario_id = jsonObject.getInt("grupo_usuario_id");
                        user.nome = jsonObject.getString("nome");
                        users.add(user);
                    }

                    result[0] = "Sucesso na leitura !";
                    scanner.close();
                    return result;
                }
                //Toast.makeText(getBaseContext(), "Falha no login! Credenciais inválidas", Toast.LENGTH_SHORT).show();
                scanner.close();
                return null;
            } catch (Exception e) {
                String message = e.getMessage();
                //Toast.makeText(getBaseContext(), "Falha no login!", Toast.LENGTH_SHORT).show();
                return null;
            }

        }

        @Override
        protected void onPreExecute() {
            //dialog = new ProgressDialog(LoginActivity.this);
        }

        @Override
        protected void onPostExecute(String[] result) {

            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            if (result == null) {
                Toast.makeText(getBaseContext(), "Falha na leitura de usuários.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

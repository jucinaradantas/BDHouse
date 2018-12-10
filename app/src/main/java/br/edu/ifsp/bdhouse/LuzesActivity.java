package br.edu.ifsp.bdhouse;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuzesActivity extends AppCompatActivity {

    List<Comodo> comodos;
    ArrayAdapter<Comodo> adapter;

    ListView listView;

    private static final String LOG_TAG =
            LuzesActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luzes);

        comodos = new ArrayList<Comodo>();
        APIGetComodos api = new APIGetComodos();
        api.execute();

        listView = (ListView) findViewById(R.id.listComodos);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
                        Toast.makeText(getBaseContext(), "Desculpe o transtorno, esta funcionalidade ainda não foi implementada. " , Toast.LENGTH_SHORT).show();
                    }
                }
        );
        adapter = new ArrayAdapter<Comodo>(this,
                android.R.layout.simple_list_item_1, comodos);

    }

    private class APIGetComodos extends AsyncTask<String, Void, String[]> {

        //private String endereco= "http://10.0.0.100/";
        ProgressDialog dialog;

        @Override
        protected String[] doInBackground(String... params) {
            try {
                String endereco = Login.endereco  + "comodo/getcomodos";

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
                        Comodo comodo = new Comodo();
                        comodo.id = jsonObject.getInt("id");
                        comodo.nome = jsonObject.getString("nome");
                        comodos.add(comodo);
                    }

                    result[0] = "Sucesso na leitura !";
                    scanner.close();
                    return result;
                }
                scanner.close();
                return null;
            } catch (Exception e) {
                String message = e.getMessage();
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

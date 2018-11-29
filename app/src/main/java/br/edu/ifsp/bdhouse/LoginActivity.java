package br.edu.ifsp.bdhouse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import android.widget.EditText;
import android.widget.Toast;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    public EditText email, password;
    private static final String LOG_TAG =
            LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.senha);
    }
    public void lauchBDH(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        //trecho do login
        boolean logado = false;
        String params[] = new String[2];
        params[0] = email.getText().toString();
        params[1] = password.getText().toString();

        APILogin apiLogin = new APILogin();
        apiLogin.execute(params);
        //fim do trecho do login

        //se nao tiver acesso a aplicacao do api comente o trecho acima e descomente as duas linhas abaixo

        //Intent intent = new Intent(this, BDHActivity.class);
        //startActivity(intent);
    }

    private class APILogin extends AsyncTask<String, Void, String[]> {
        private String endereco = "http://127.0.0.1:8000/";
        //private String endereco= "http://10.0.0.100/";
        ProgressDialog dialog;

        @Override
        protected String[] doInBackground(String... params) {
            try {
                URL url = new URL(endereco + "usuario/mobilelogin?login=" + params[0] + "&senha=" + params[1]);
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                Scanner scanner = new Scanner(is);
                String conteudo = scanner.useDelimiter("\\A").next();
                //Login.loggedUser.password = jsonObject.getString("password");
                String result[] = new String[1];
                if (!conteudo.equals("0")) {
                    JSONObject jsonObject = new JSONObject(conteudo);
                    User user = new User();
                    Login.loggedUser = user;
                    Login.loggedUser.login = jsonObject.getString("login");
                    Login.loggedUser.senha = jsonObject.getString("senha");
                    Login.loggedUser.nome = jsonObject.getString("nome");
                    result[0] = "Bem vindo " + Login.loggedUser.nome + " !";
                    return result;
                }
                scanner.close();
                return null;
            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getBaseContext(), "Falha no login!", Toast.LENGTH_SHORT).show();
                return null;
            }

        }

        @Override
        protected void onPreExecute() {
            //dialog = new ProgressDialog(LoginActivity.this);
        }

        @Override
        protected void onPostExecute(String[] result) {
            if (result != null) {
                if (result != null && result.length == 1) {
                    Toast.makeText(getBaseContext(), result[0], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), BDHActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Falha no login!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "Falha no login!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    }

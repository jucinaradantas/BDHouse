package br.edu.ifsp.bdhouse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Usuario_InserirActivity extends AppCompatActivity {

    public EditText nome, login, parentesco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario__inserir);
        nome = (EditText) findViewById(R.id.insertUserNome);
        login = (EditText) findViewById(R.id.insertUserLogin);
        parentesco = (EditText) findViewById(R.id.insertUserParentesco);
    }

    public void inserirUsuario(View view){
        String[] s = new String[3];
        s[0] = nome.getText().toString();
        s[1] = login.getText().toString();
        s[2] = parentesco.getText().toString();
        if(s[0].isEmpty() || s[1].isEmpty() || s[2].isEmpty()){
            Toast.makeText(getBaseContext(), "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{
            InsertUserAPI api = new InsertUserAPI();
            api.execute(s);
        }
    }

    private class InsertUserAPI extends AsyncTask<String, Void, String[]> {

        //private String endereco= "http://10.0.0.100/";
        ProgressDialog dialog;

        @Override
        protected String[] doInBackground(String... params) {
            try {
                String endereco = Login.endereco + "usuario/insert?nome=" + params[0] + "&login=" + params[1] + "&parentesco=" + params[1];

                URL url = new URL(endereco );
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                Scanner scanner = new Scanner(is);
                String conteudo = scanner.useDelimiter("\\A").next();
                //Login.loggedUser.password = jsonObject.getString("password");
                String result[] = new String[1];
                if (!conteudo.equals("0")) {
                    JSONObject jsonObject = new JSONObject(conteudo);
                    User user = new User();
                    user.login = jsonObject.getString("login");
                    user.nome = jsonObject.getString("nome");
                    result[0] = "Usuário cadastrado : " + user.toString() + " !";
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
            if (result != null) {
                if (result != null && result.length == 1) {
                    Toast.makeText(getBaseContext(), result[0], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), UsuarioActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Falha no cadastro!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "Falha no cadastro!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

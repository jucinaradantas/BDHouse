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

public class VisitaActivity extends AppCompatActivity {


    ListView listView;
    private static final String LOG_TAG =
            VisitaActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);

        listView= findViewById(R.id.listview);

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("João");
        arrayList.add("Caio");
        arrayList.add("Mario");
        arrayList.add("Ana Maria");
        arrayList.add("José");

        ArrayAdapter arrayAdapter=new ArrayAdapter( this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


        Button ex = (Button) findViewById(R.id.btnEx1);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ex = new AlertDialog.Builder(VisitaActivity.this);
                ex.setTitle("Aviso");
                ex.setIcon(R.drawable.ic_fechar)
                        .setMessage("Excluir Cadastro da Visita?")
                        .setCancelable(false)
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                AlertDialog alertDialog = ex.create();
                alertDialog.show();
            }
        });
    }


    public void lauchVisita_Inserir(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,Visita_InserirActivity.class);
        startActivity(intent);
    }
    public void lauchVisita_Editar(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,Visita_EditarActivity.class);
        startActivity(intent);
    }

}

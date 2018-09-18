package br.usjt.sin.progmulti.servicedeskccp3anbua;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText buscaFilaEdiText;
    public static final String NOME_FILA = "nome_fila";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//Somente depois da arvores ser contruida
        buscaFilaEdiText = (EditText) findViewById(R.id.buscaFilaEditText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //Expressao lambida que resume o que foi realizado no metodo acima, passa apenas o metodo e o corpo do metodo
        // O compilador realizada a transfusao do metodo abaixo o que for colocado no metodo será executado
        fab.setOnClickListener((v) -> {
            Intent intent = new Intent(this, ListarChamadosActivity.class);
            String texto = buscaFilaEdiText.getEditableText().toString();
            intent.putExtra(NOME_FILA, texto);
            startActivity(intent);
        });
    }


}

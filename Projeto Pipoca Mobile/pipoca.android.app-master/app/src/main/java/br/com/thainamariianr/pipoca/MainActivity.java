package br.com.dennissiqueira.pipoca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import br.com.dennissiqueira.pipoca.R;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerGenero;
    public static final String CHAVE = "br.com.dennissiqueira.pipoca";
    String genero = "Todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGenero = (Spinner)findViewById(R.id.spinnerGenero);
        spinnerGenero.setOnItemSelectedListener(new FilmeSelecionado());
    }

    public void listarFilmes(View view){
        Intent intent = new Intent(this, ListaFilmes.class);

        intent.putExtra(CHAVE, genero);
        startActivity(intent);
    }

    private class FilmeSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            genero = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}

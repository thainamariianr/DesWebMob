package com.example.thain.projetopais;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
/**
 * THAINA MARIANE SOUZA SILVA 816118386
 */
public class MainActivity extends Activity {
    Spinner spinnerContinente;
    public static final String CHAVE = "com.example.thain.projetopais.txtContinente";
    String continente = "Todos";

    @Override
    /**
     * THAINA MARIANE SOUZA SILVA 816118386
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = (Spinner)findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new PaisSelecionado());
    }
    /**
     * THAINA MARIANE SOUZA SILVA 816118386
     */
    public void listarPaises(View view){
        Intent intent = new Intent(this, ListaPaisesActivity.class);
        intent.putExtra(CHAVE, continente);
        startActivity(intent);
    }
    /**
     * THAINA MARIANE SOUZA SILVA 816118386
     */
    private class PaisSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
        }

        @Override
        /**
         * THAINA MARIANE SOUZA SILVA 816118386
         */
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}

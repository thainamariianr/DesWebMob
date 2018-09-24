package com.example.thain.projetopais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * THAINA MARIANE SOUZA SILVA 816118386
 */
public class ListaPaisesActivity extends Activity {
    /**
     * THAINA MARIANE SOUZA SILVA 816118386
     */
    public static final String PAIS = "com.example.thain.projetopais.pais";
    Activity atividade;
    ArrayList<Pais> paises;
    ArrayList<String> nomes;

    @Override
    /**
     * THAINA MARIANE SOUZA SILVA 816118386
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE);
        paises = Data.listarPaises(continente);
        nomes = Data.listarNomes(paises);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            /**
             * THAINA MARIANE SOUZA SILVA 816118386
             */
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises.get(position));

                startActivity(intent);

            }

        });
    }

    public ArrayList<String> buscaPaises(String chave) {
        ArrayList<String> lista = geraListaPaises();
        if (chave == null || chave.length() == 0) {
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for (String nome : lista) {
                if (nome.toUpperCase().contains(chave.toUpperCase())) {
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    private ArrayList<String> geraListaPaises() {
        return null;
    }

}





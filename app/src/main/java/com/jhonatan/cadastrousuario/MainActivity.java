package com.jhonatan.cadastrousuario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 //Declaração dos componentes visuais e do adaptador da lista
    RecyclerView recyclerView;
    UserAdapter adapter;
    Button btnCadastrar;

    //Atenção: Atributo estatico (static) permite que os dados persistam na memoria
    //Enquanto o app estiver aberto e sejam acessados diretamente por outras telas(Activies)
    public static List<String> listaNomes = new ArrayList<>();

    // Método de inicialização de Activity (Ponto de entrada da tela)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Vincula o arquivo de layouat XML (activy_main.xml) a essa classe java
        setContentView(R.layout.activity_main);

        //Regra de negócio :Insere um texto no topo da lista, caso ela esteja vazia
        if(listaNomes.isEmpty()){
            listaNomes.add("Nome de cadastro");
        }

        //mapeando de componentes do RecyclerView do XML para objeto java
        recyclerView = findViewById(R.id.recyclerView);

        //Define o LayoutManager: organiza itens da lista numa coluna verdical simples
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Instancia o adaptor passando a nossa lista de nomes
        adapter = new UserAdapter(listaNomes);
        // Conecta o adaptador ao Recycler View para que os dados sejam desenhados na tela
        recyclerView.setAdapter(adapter);

        //Mapeia o botão de cadastro
        btnCadastrar = findViewById(R.id.button);
        btnCadastrar.setOnClickListener(v -> {
            startActivities(new Intent(MainActivity.this, CreateUser.class));
        });
    }
    //Método chamado sempre que a tela volta a ficar visivel para o usuario
    @Override
    protected void onResume(){
        super.onResume();
        //Avisar o adaptador que a fonte de dados (listaNomes) pode ter sido alterada
        //Na outra tela , forçando a atualização visual da lista
        adapter.notifyDataSetChanged();
    }

}
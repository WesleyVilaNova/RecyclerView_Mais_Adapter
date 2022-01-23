package com.example.recyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.Adapter.AdapterProduto;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.Onclick;
import com.example.recyclerview.models.Produto;
import com.example.recyclerview.repository.DataSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Onclick {

    private List<Produto> produtoList = new ArrayList<>();
    private AdapterProduto adapterProduto;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iniciarComponentes(); // iniciando o findView no onCreate
        iniciarRecyclerView(); // iniciando o RecyclerView no onCreate

    }

    private void iniciarComponentes() {
        recyclerView = findViewById(R.id.recyclerView_produtos);
    }


    private void iniciarRecyclerView(){
        produtoList = new DataSource().produtoList(); // Iniciando a lista antes do RecyclerView

        // Configurando o RecyclerView a forma de exibição
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recycler vai pegar um LayoutManager e recebe um novo tipo de exibição -> LinearLayout nessa classe (this )
        recyclerView.setHasFixedSize(true); // melhorar a perfomace do recyclerView

        // Configurando o Adapter
        adapterProduto = new AdapterProduto(produtoList,this);
        recyclerView.setAdapter(adapterProduto);
    }


    @Override
    public void onClickListener(Produto produto) {
    }
}
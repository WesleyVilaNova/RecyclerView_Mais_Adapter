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
    AdapterProduto adapterProduto;
    RecyclerView rvProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iniciarComponentes();
        iniciarRecyclerView();

    }

    private void iniciarComponentes() {
        rvProdutos = findViewById(R.id.recyclerView_produtos);
    }


    private void iniciarRecyclerView(){
        produtoList = new DataSource().produtoList();
        rvProdutos.setLayoutManager(new LinearLayoutManager(this ));
        rvProdutos.setHasFixedSize(true);
        adapterProduto = new AdapterProduto(produtoList, this);
        rvProdutos.setAdapter(adapterProduto);
    }


    @Override
    public void onClickListener(Produto produto) {
    }
}
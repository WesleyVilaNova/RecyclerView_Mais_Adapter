package com.example.recyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.recyclerview.ui.Adapter.AdapterProduto;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.Onclick;
import com.example.recyclerview.models.Produto;
import com.example.recyclerview.repository.DataSource;
import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Onclick {

    private List<Produto> produtoList = new ArrayList<>();
    private AdapterProduto adapterProduto;
    private SwipeableRecyclerView recyclerView;

    private ImageButton ibAdd;
    private ImageButton ibVerMais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iniciarComponentes();
        iniciarRecyclerView();
        ouvinteClick();

    }

    private void iniciarComponentes() {
        ibAdd = findViewById(R.id.ib_add);
        ibVerMais = findViewById(R.id.ib_mais);

        recyclerView = findViewById(R.id.recyclerView_produtos);
        produtoList = new DataSource().produtoList();
    }

    private void ouvinteClick(){
        ibVerMais.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this,ibVerMais);
            popupMenu.getMenuInflater().inflate(R.menu.menu_toolbar,popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(menuItem -> {
                if (menuItem.getItemId() == R.id.menu_sobre){
                    Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show();
                }else if (menuItem.getItemId() == R.id.ib_add) {
                    startActivity(new Intent(this, FormProdutoActivity.class));
                }
                return true;
            });

            popupMenu.show();

        });
    }


    private void iniciarRecyclerView(){

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapterProduto = new AdapterProduto(produtoList,this);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.setListener(new SwipeLeftRightCallback.Listener() {
            // Foi implementado dependências no projeto
            @Override
            public void onSwipedLeft(int position) {
            }

            @Override
            public void onSwipedRight(int position) {
                produtoList.remove(position);
                adapterProduto.notifyItemRemoved(position);

            }
        });
    }


    @Override
    public void onClickListener(Produto produto) {
    }
}
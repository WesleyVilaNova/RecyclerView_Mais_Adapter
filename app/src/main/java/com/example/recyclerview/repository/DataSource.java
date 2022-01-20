package com.example.recyclerview.repository;

import android.icu.text.DateFormat;

import com.example.recyclerview.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public List<Produto> produtoList(){
        List<Produto> listaDeProdutos = new ArrayList<>();

        Produto produto1 = new Produto();
        produto1.setNome("Tênis Nike ALFA");
        produto1.setSubText("Modelo 2022");
        produto1.setValor(599.99);

        Produto produto2 = new Produto();
        produto2.setNome("Bola futebol Adidas ");
        produto2.setSubText("Modelo 2034");
        produto2.setValor(799.99);

        Produto produto3 = new Produto();
        produto3.setNome("Chuteira Nike");
        produto3.setSubText("Modelo Speed");
        produto3.setValor(999.99);

        Produto produto4 = new Produto();
        produto4.setNome("Rede Campo");
        produto4.setSubText("Campo profissional");
        produto4.setValor(239.99);

        Produto produto5 = new Produto();
        produto5.setNome("Bolsa técnico");
        produto5.setSubText("Bolsa Extra Grande");
        produto5.setValor(599.99);

        Produto produto6 = new Produto();
        produto6.setNome("Bolsa técnico");
        produto6.setSubText("Bolsa Pequena");
        produto6.setValor(199.99);

        Produto produto7 = new Produto();
        produto7.setNome("Bolsa técnico");
        produto7.setSubText("Bolsa média");
        produto7.setValor(299.99);

        Produto produto8 = new Produto();
        produto8.setNome("Bola Futsal");
        produto8.setSubText("Bola Profissional Adulto");
        produto8.setValor(59.99);

        Produto produto9 = new Produto();
        produto9.setNome("Bola Futsal Adidas");
        produto9.setSubText("Modelo Profissional Adulto");
        produto9.setValor(89.99);

        Produto produto10 = new Produto();
        produto10.setNome("Chuteira Nike");
        produto10.setSubText("Modelo Speed ");
        produto10.setValor(239.99);


        listaDeProdutos.add(produto1);
        listaDeProdutos.add(produto2);
        listaDeProdutos.add(produto3);
        listaDeProdutos.add(produto4);
        listaDeProdutos.add(produto5);
        listaDeProdutos.add(produto6);
        listaDeProdutos.add(produto7);
        listaDeProdutos.add(produto8);
        listaDeProdutos.add(produto9);
        listaDeProdutos.add(produto10);
        listaDeProdutos.add(produto1);
        listaDeProdutos.add(produto2);
        listaDeProdutos.add(produto3);
        listaDeProdutos.add(produto4);
        listaDeProdutos.add(produto5);
        listaDeProdutos.add(produto6);
        listaDeProdutos.add(produto7);
        listaDeProdutos.add(produto8);
        listaDeProdutos.add(produto9);
        listaDeProdutos.add(produto10);

         return listaDeProdutos;
    }
}

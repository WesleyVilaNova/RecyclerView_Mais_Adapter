package com.example.recyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.Onclick;
import com.example.recyclerview.models.Produto;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.MyViewHolder>{

    private Onclick onclick;
    private List<Produto> produtoList;

    public AdapterProduto(List<Produto> produtoList, Onclick onclick) {
        this.produtoList = produtoList;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produtos,parent , false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produto produto = produtoList.get(position);

        holder.text_principal.setText(produto.getNome());
        holder.text_secundario.setText(produto.getSubText());
        holder.valor.setText( " Preço: " + produto.getValor());

        holder.itemView.setOnClickListener(view -> onclick.onClickListener(produto));

    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_principal , text_secundario , valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_principal = itemView.findViewById(R.id.text_principal);
            text_secundario = itemView.findViewById(R.id.text_secundario);
            valor = itemView.findViewById(R.id.valor);
        }
    }
}

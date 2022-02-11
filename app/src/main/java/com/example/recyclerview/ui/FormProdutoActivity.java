package com.example.recyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.Onclick;

public class FormProdutoActivity extends AppCompatActivity {

    EditText edit_nome , edit_valor, edit_quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_produto);

        edit_nome = findViewById(R.id.edit_produto);
        edit_quantidade = findViewById(R.id.edit_quantidade);
        edit_valor = findViewById(R.id.edit_valor);
    }

    public void salvarProduto(View view) {
        String nome = edit_nome.getText().toString();
        String quantidade = edit_quantidade.getText().toString();
        String valor = edit_valor.getText().toString();
            if (!nome.isEmpty()){
                if (!quantidade.isEmpty()){
                    int qtd = Integer.parseInt(quantidade);
                    if (qtd >= 1) {
                        if (!valor.isEmpty()){
                            double valorProduto = Double.parseDouble(valor);
                            if (valorProduto >=1){
                                Toast.makeText(this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();
                                edit_nome.setText("");
                                edit_quantidade.setText("");
                                edit_valor.setText("");
                            }else {
                                edit_valor.requestFocus();
                                edit_valor.setError("Informe o preço do produto");
                            }
                        }else {
                            edit_valor.requestFocus();
                            edit_valor.setError("Informe um valor válido");
                        }
                    }else {
                        edit_quantidade.requestFocus();
                        edit_quantidade.setError("Informe um valor maior que 0 (zero)");
                    }
                }else {
                    edit_quantidade.requestFocus();
                    edit_quantidade.setError("Informe a Quantidade");
                }

            }else {
                edit_nome.requestFocus();
                edit_nome.setError("Informe o produto");
            }
    }

    public void voltarPag(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
package com.example.appcadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appcadprodutos.DBHelper.ProdutosBd;
import com.example.appcadprodutos.Modelo.Produtos;

public class FormularioProdutos extends AppCompatActivity {

    EditText editText_Nome, editText_Descricao, editText_Quantidade;
    Button btn_Cadastrar;
    Produtos editarProduto, produto;
    ProdutosBd bdHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produtos);

        bdHelper = new ProdutosBd(FormularioProdutos.this);

        Intent intent = getIntent();
        editarProduto = (Produtos) intent.getSerializableExtra("Produto-escolhido");

        editText_Nome = (EditText) findViewById(R.id.editText_Nome);
        editText_Descricao = (EditText) findViewById(R.id.editText_Descricao);
        editText_Quantidade = (EditText) findViewById(R.id.editText_Quantidade);

        btn_Cadastrar = (Button) findViewById((R.id.btn_Cadastrar));

        if (btn_Cadastrar != null){
            btn_Cadastrar.setText("Modificar");}
        else{
            btn_Cadastrar.setText(("Cadastrar"));
        }

        btn_Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produto.setNomeProduto(editText_Nome.getText().toString());
                produto.setDescricao(editText_Quantidade.getText().toString());
                produto.setQuantidade(Integer.parseInt(editText_Quantidade.getText().toString()));

                if(btn_Cadastrar.getText().toString().equals("Cadastrar")){
                    bdHelper.salvarProduto(produto);
                    bdHelper.close();
                }else{
                    bdHelper.alterarProduto(produto);
                    bdHelper.close();
                }

            }
        });


    }
}
package com.example.appcadprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.appcadprodutos.DBHelper.ProdutosBd;
import com.example.appcadprodutos.Modelo.Produtos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ProdutosBd dbHelper;
    ArrayList<Produtos> listView_Produtos;
    Produtos produto;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = {ListView} findViewById(R.id.listView_Produtos);

        Button btn_Cadastrar = (Button) findViewById(R.id.btn_Cadastrar);
        btn_Cadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent  = new Intent(MainActivity.this, FormularioProdutos.class);
                startActivity(intent);
            }
        });

    }
}
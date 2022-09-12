package com.example.appcadprodutos.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.appcadprodutos.Modelo.Produtos;

import java.util.ArrayList;

public class ProdutosBd extends SQLiteOpenHelper {


    //construtor

    private static final String DATABASE = "dbprodutos";
    private static final int VERSION = 1;

    public ProdutosBd (Context context){
        super(context, DATABASE, null, VERSION);

    }


   //métodos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String produto = "CREATE TABLE produtos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nomeproduto TEXT NOT NULL, descricao TEXT NOT NULL, quantidade INTEGER)";
        sqLiteDatabase.execSQL(produto);

    }

    //aqui salva

    public void salvarProduto(Produtos produto){
        ContentValues values = new ContentValues();

        values.put("nomeproduto",produto.getNomeProduto());
        values.put("descricao",produto.getDescricao());
        values.put("quantidade",produto.getQuantidade());

        getWritableDatabase().insert("produtos",null,values);
    }


    //metodo alterar concluido

    public void alterarProduto(Produtos produto){

        ContentValues values = new ContentValues();

        values.put("nomeproduto",produto.getNomeProduto());
        values.put("descricao",produto.getDescricao());
        values.put("quantidade",produto.getQuantidade());

        String [] args = {String.valueOf(produto.getId())};
        getWritableDatabase().update("produtos",values, "id=?", args);

    }


    //metodo deletar

    public void deletarProduto(Produtos produto){

        String [] args = {String.valueOf(produto.getId())};
        getWritableDatabase().delete("produtos", "id=?", args);


    }
    // lista - mostrar

    public ArrayList<Produtos> getLista(){
        String [] columns = {"id", "nomeproduto", "descricao", "quantidade"};
        Cursor cursor = getWritableDatabase().query("produtos", columns, null,null, null, null, null, null);
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();

        while (cursor.moveToNext()){
            Produtos produto = new Produtos();
            produto.setId(cursor.getLong(0));
            produto.setNomeProduto(cursor.getString(1));
            produto.setDescricao(cursor.getString(2));
            produto.setQuantidade(cursor.getInt(3));

            produtos.add(produto);

        }

        return produtos;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

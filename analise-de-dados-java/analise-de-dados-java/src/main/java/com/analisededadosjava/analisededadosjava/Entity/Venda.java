package com.analisededadosjava.analisededadosjava.Entity;

import java.util.ArrayList;

public class Venda {
    private final int id;
    private final int idVenda;
    private final ArrayList<Produto> produtos;
    private final String nomeVendedor;
    private double valorVenda;

    public Venda(String[] array) {
        this.produtos = new ArrayList<>();
        this.id = Integer.parseInt(array[0]);
        this.idVenda = Integer.parseInt(array[1]);
        String[] arrayProdutos = array[2].split(",");
        for (String s : arrayProdutos) {
            String[] arrayProduto = s.replace("[", "").replace("]", "").split("-");
            Produto produto = new Produto(arrayProduto);
            produtos.add(produto);
        }
        this.nomeVendedor = array[3];
        for (Produto produto : produtos) {
            this.valorVenda += produto.getValorVendaItem();
        }
    }

    public int getQuantidadeProdutos() {
        return produtos.size();
    }

    public int getId() {
        return id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public double getValorVenda() {
        return valorVenda;
    }

}

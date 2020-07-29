package com.analisededadosjava.analisededadosjava;

import java.util.ArrayList;

public class Venda {
    private int id;
    private int idVenda;
    private ArrayList<Produto> produtos;
    private String nomeVendedor;
    private double valorVenda;

    public Venda(String[] array) {
        this.produtos = new ArrayList<>();
        this.id = Integer.parseInt(array[0]);
        this.idVenda = Integer.parseInt(array[1]);
        String arrayProdutos[] = array[2].split(",");
        for( int i = 0 ; i < arrayProdutos.length; i++){
            String arrayProduto[] = arrayProdutos[i].replace("[","").replace("]", "").split("-");
            Produto produto = new Produto(arrayProduto);
            produtos.add(produto);
        }
        this.nomeVendedor = array[3];
        for(Produto produto : produtos){
            this.valorVenda += produto.getValorVendaItem();
        }
    }
    public int getQuantidadeProdutos(){
        return produtos.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

}

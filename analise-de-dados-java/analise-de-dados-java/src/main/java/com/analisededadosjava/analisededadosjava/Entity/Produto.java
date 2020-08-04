package com.analisededadosjava.analisededadosjava.Entity;

public class Produto {

    private int idProduto;
    private int quantidade;
    private double preço;

    public Produto(String[] array) {
        this.idProduto = Integer.parseInt(array[0]);
        this.quantidade = Integer.parseInt(array[1]);
        this.preço = Double.parseDouble(array[2]);
    }

    public double getValorVendaItem() {
        return this.quantidade * this.preço;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreço() {
        return preço;
    }

}

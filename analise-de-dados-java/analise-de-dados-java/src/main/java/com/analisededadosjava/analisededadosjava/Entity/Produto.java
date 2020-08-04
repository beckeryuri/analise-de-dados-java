package com.analisededadosjava.analisededadosjava.Entity;

public class Produto {

    private final int idProduto;
    private final int quantidade;
    private final double preço;

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

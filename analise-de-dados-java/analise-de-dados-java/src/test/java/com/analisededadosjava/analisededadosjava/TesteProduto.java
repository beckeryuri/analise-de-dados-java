package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteProduto {

    @Test
    public void deveCriarUmProdutoAPartirDeUmArray(){
        String dado = "[1-10-100]";
        String arrayProduto[] = dado.replace("[","").replace("]", "").split("-");
        Produto produto = new Produto(arrayProduto);
        Assertions.assertEquals( 1, produto.getIdProduto());
        Assertions.assertEquals( 10, produto.getQuantidade());
        Assertions.assertEquals( 100, produto.getPreço(), 1e-9);
        Assertions.assertEquals(1000, produto.getValorVendaItem(), 1e-9);
    }
    @Test
    public void deveRetornarIdDoProduto(){
        String dado = "[1-10-100]";
        String arrayProduto[] = dado.replace("[","").replace("]", "").split("-");
        Produto produto = new Produto(arrayProduto);
        Assertions.assertEquals( 1, produto.getIdProduto());
    }
    @Test
    public void deveRetornarQuantidadeDoProduto(){
        String dado = "[1-10-100]";
        String arrayProduto[] = dado.replace("[","").replace("]", "").split("-");
        Produto produto = new Produto(arrayProduto);
        Assertions.assertEquals( 10, produto.getQuantidade());
    }
    @Test
    public void deveRetornarPreçoDoProduto(){
        String dado = "[1-10-100]";
        String arrayProduto[] = dado.replace("[","").replace("]", "").split("-");
        Produto produto = new Produto(arrayProduto);
        Assertions.assertEquals( 100, produto.getPreço(), 1e-9);
    }
    @Test
    public void deveRetornarValorTotalDaVendaDoItem(){
        String dado = "[1-10-100]";
        String arrayProduto[] = dado.replace("[","").replace("]", "").split("-");
        Produto produto = new Produto(arrayProduto);
        Assertions.assertEquals(1000, produto.getValorVendaItem(), 1e-9);
    }

}

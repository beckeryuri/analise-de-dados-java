package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteVenda {

    @Test
    public void deveRetornarId(){
        String dado = "003ç08ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        String arrayDados[] = dado.split("ç");
        Venda venda = new Venda(arrayDados);
        Assertions.assertEquals(3, venda.getId());
    }
    @Test
    public void deveRetornarIdDaVenda(){
        String dado = "003ç08ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        String arrayDados[] = dado.split("ç");
        Venda venda = new Venda(arrayDados);
        Assertions.assertEquals(8, venda.getIdVenda());
    }
    @Test
    public void deveRetornarNomeDoVendedorQueRealizouAVenda(){
        String dado = "003ç08ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        String arrayDados[] = dado.split("ç");
        Venda venda = new Venda(arrayDados);
        Assertions.assertEquals("Pedro",venda.getNomeVendedor());
    }
    @Test
    public void deveRetornarQuantidadeDeProdutosDaVenda(){
        String dado = "003ç08ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        String arrayDados[] = dado.split("ç");
        Venda venda = new Venda(arrayDados);
        Assertions.assertEquals(3, venda.getQuantidadeProdutos());
    }
    @Test
    public void deveRetornarValorDaVenda(){
        String dado = "003ç08ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        String arrayDados[] = dado.split("ç");
        Venda venda = new Venda(arrayDados);
        Assertions.assertEquals(1199, venda.getValorVenda(), 1e-9);
    }

}

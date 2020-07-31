package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TesteVendas {

    @Test
    public void deveAdicionarUmaVenda() {

        Verificador verificador = new Verificador();
        Vendas vendas = new Vendas();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        Venda venda = new Venda(verificador.divideDado(dado));
        vendas.adicionarVenda(venda);
        Assertions.assertEquals(1, vendas.getQuantidadeVendas());
    }

    @Test
    public void deveRetornarIdMaiorVenda() {

        Verificador verificador = new Verificador();
        Vendas vendas = new Vendas();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        Venda venda = new Venda(verificador.divideDado(dado));
        String dado2 = "003ç11ç[1-10-100,2-30-2.50,3-40-5]çJoao";
        Venda venda2 = new Venda(verificador.divideDado(dado2));
        vendas.adicionarVenda(venda);
        vendas.adicionarVenda(venda2);
        Assertions.assertEquals(11, vendas.getMaiorVenda());
    }

    @Test
    public void deveRetonarPiorVendedor() {

        Verificador verificador = new Verificador();
        Vendas vendas = new Vendas();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        Venda venda = new Venda(verificador.divideDado(dado));
        String dado2 = "003ç11ç[1-10-100,2-30-2.50,3-40-5]çJoao";
        Venda venda2 = new Venda(verificador.divideDado(dado2));
        vendas.adicionarVenda(venda);
        vendas.adicionarVenda(venda2);
        Assertions.assertEquals("O vendedor que vendeu o menor valor do mês foi o vendedor Pedro vendendo um valor de: R$1199.0", vendas.getPiorVendedor());
    }

    @Test
    public void deveRetonarVendasPorNome() {

        Verificador verificador = new Verificador();
        Vendas vendas = new Vendas();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        Venda venda = new Venda(verificador.divideDado(dado));
        String dado2 = "003ç11ç[1-10-100,2-30-2.50,3-40-5]çJoao";
        Venda venda2 = new Venda(verificador.divideDado(dado2));
        vendas.adicionarVenda(venda);
        vendas.adicionarVenda(venda2);
        Assertions.assertEquals(1199, vendas.getTotalVendasPorNome("Pedro"), 1e-9);
    }

    @Test
    public void deveRetonarListaDeIdsDeVenda() {

        Verificador verificador = new Verificador();
        Vendas vendas = new Vendas();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        Venda venda = new Venda(verificador.divideDado(dado));
        String dado2 = "003ç11ç[1-10-100,2-30-2.50,3-40-5]çJoao";
        Venda venda2 = new Venda(verificador.divideDado(dado2));
        vendas.adicionarVenda(venda);
        vendas.adicionarVenda(venda2);
        ArrayList<Integer> listaIdVenda = new ArrayList<>();
        listaIdVenda.add(10);
        listaIdVenda.add(11);
        Assertions.assertEquals(listaIdVenda, vendas.getListaIdVenda());
    }

    @Test
    public void deveRetonarNomeDosVendedores() {

        Verificador verificador = new Verificador();
        Vendas vendas = new Vendas();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        Venda venda = new Venda(verificador.divideDado(dado));
        String dado2 = "003ç11ç[1-10-100,2-30-2.50,3-40-5]çJoao";
        Venda venda2 = new Venda(verificador.divideDado(dado2));
        vendas.adicionarVenda(venda);
        vendas.adicionarVenda(venda2);
        ArrayList<String> nomeVendedores = new ArrayList<>();
        nomeVendedores.add("Pedro");
        nomeVendedores.add("Joao");
        Assertions.assertEquals(nomeVendedores, vendas.getVendedores());
    }

}

package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TesteVendedores {

    @Test
    public void deveAdicionarUmVendedor() {
        Verificador verificador = new Verificador();
        Vendedores vendedores = new Vendedores();
        String dado = "001ç1234567891234çPedroç50000";
        Vendedor vendedor = new Vendedor(verificador.divideDado(dado));
        vendedores.adicionarVendedor(vendedor);
        Assertions.assertEquals(1, vendedores.getQuantidadeVendedores());
    }

    @Test
    public void deveRetornarListaDeCpfs() {
        Verificador verificador = new Verificador();
        Vendedores vendedores = new Vendedores();
        String dado = "001ç1234567891234çPedroç50000";
        Vendedor vendedor = new Vendedor(verificador.divideDado(dado));
        String dado2 = "001ç1234555551234çJoaoç50000";
        Vendedor vendedor2 = new Vendedor(verificador.divideDado(dado2));
        vendedores.adicionarVendedor(vendedor);
        vendedores.adicionarVendedor(vendedor2);
        ArrayList<String> listaCpf = new ArrayList<>();
        listaCpf.add("1234567891234");
        listaCpf.add("1234555551234");
        Assertions.assertEquals(listaCpf, vendedores.getListaCpf());
    }

}

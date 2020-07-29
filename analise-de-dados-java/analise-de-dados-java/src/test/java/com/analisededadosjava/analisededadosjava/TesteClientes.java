package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TesteClientes {

    @Test
    public void deveAdicionarUmCliente(){
        Verificador verificador = new Verificador();
        Clientes clientes = new Clientes();
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        Cliente cliente = new Cliente(verificador.divideDado(dado));
        clientes.adicionarCliente(cliente);
        Assertions.assertEquals(1, clientes.getQuantidadeClientes());
    }

    @Test
    public void deveRetornarListaDeCnpj(){
        Verificador verificador = new Verificador();
        Clientes clientes = new Clientes();
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        Cliente cliente = new Cliente(verificador.divideDado(dado));
        clientes.adicionarCliente(cliente);
        ArrayList<String> listaCnpj = new ArrayList<>();
        listaCnpj.add("2345675434544345");
        Assertions.assertEquals( listaCnpj, clientes.getListaCnpj());
    }

}

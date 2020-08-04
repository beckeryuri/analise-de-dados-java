package com.analisededadosjava.analisededadosjava;

import com.analisededadosjava.analisededadosjava.Entity.Cliente;
import com.analisededadosjava.analisededadosjava.Repository.Clientes;
import com.analisededadosjava.analisededadosjava.Util.Verificador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TesteClientes {

    @Test
    public void deveAdicionarUmCliente() {
        Verificador verificador = new Verificador();
        Clientes clientes = new Clientes();
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        Cliente cliente = new Cliente(verificador.divideDado(dado));
        clientes.adicionarCliente(cliente);
        Assertions.assertEquals(1, clientes.getQuantidadeClientes());
    }

    @Test
    public void deveRetornarListaDeCnpj() {
        Verificador verificador = new Verificador();
        Clientes clientes = new Clientes();
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        Cliente cliente = new Cliente(verificador.divideDado(dado));
        clientes.adicionarCliente(cliente);
        String dado2 = "002ç2345555534544345çPedro da RochaçRural";
        Cliente cliente2 = new Cliente(verificador.divideDado(dado2));
        clientes.adicionarCliente(cliente);
        clientes.adicionarCliente(cliente2);
        ArrayList<String> listaCnpj = new ArrayList<>();
        listaCnpj.add("2345675434544345");
        listaCnpj.add("2345555534544345");
        Assertions.assertEquals(listaCnpj, clientes.getListaCnpj());
    }

}

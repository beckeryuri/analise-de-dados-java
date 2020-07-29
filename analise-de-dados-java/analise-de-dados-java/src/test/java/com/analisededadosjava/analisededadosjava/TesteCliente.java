package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteCliente {
    @Test
    public void deveRetornarIdDoCliente(){
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        String arrayDados[] = dado.split("ç");
        Cliente cliente = new Cliente(arrayDados);
        Assertions.assertEquals(2, cliente.getId());
    }
    @Test
    public void deveRetornarCnpjDoCliente(){
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        String arrayDados[] = dado.split("ç");
        Cliente cliente = new Cliente(arrayDados);
        Assertions.assertEquals("2345675434544345", cliente.getCnpj());
    }
    @Test
    public void deveRetornarNomeDoCliente(){
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        String arrayDados[] = dado.split("ç");
        Cliente cliente = new Cliente(arrayDados);
        Assertions.assertEquals("Jose da Silva", cliente.getNome());
    }
    @Test
    public void deveRetornarBusinessAreaDoCliente(){
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        String arrayDados[] = dado.split("ç");
        Cliente cliente = new Cliente(arrayDados);
        Assertions.assertEquals("Rural", cliente.getBusinessArea());
    }
}

package com.analisededadosjava.analisededadosjava;

import com.analisededadosjava.analisededadosjava.Util.Verificador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteVerificador {

    @Test
    public void deveDividirDado() {
        Verificador verificador = new Verificador();
        String dado = "001ç1234567891234çPedroç50000";
        String[] array = verificador.divideDado(dado);
        Assertions.assertEquals("001", array[0]);
        Assertions.assertEquals("1234567891234", array[1]);
        Assertions.assertEquals("Pedro", array[2]);
        Assertions.assertEquals("50000", array[3]);
    }

    @Test
    public void dadoDivididoDevePossuirQuatroStrings() {
        Verificador verificador = new Verificador();
        String dado = "001ç1234567891234çPedroç50000";
        String[] array = verificador.divideDado(dado);
        Assertions.assertEquals(4, array.length);
    }

    @Test
    public void deveVerificarEAdicionarVendedor() {
        Verificador verificador = new Verificador();
        String dado = "001ç1234567891234çPedroç50000";
        verificador.verificaDado(dado);
        Assertions.assertEquals(1, verificador.getVendedores().getQuantidadeVendedores());
    }

    @Test
    public void deveAdicionarApenasUmVendedorPorCpf() {
        Verificador verificador = new Verificador();
        String dado = "001ç1234567891234çPedroç50000";
        String dado1 = "001ç1234567891234çJoaoç35000";
        verificador.verificaDado(dado);
        verificador.verificaDado(dado1);
        Assertions.assertEquals(1, verificador.getVendedores().getQuantidadeVendedores());
    }

    @Test
    public void deveVerificarEAdicionarCliente() {
        Verificador verificador = new Verificador();
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        verificador.verificaDado(dado);
        Assertions.assertEquals(1, verificador.getClientes().getQuantidadeClientes());
    }

    @Test
    public void deveAdicionarUmClientePorCnpj() {
        Verificador verificador = new Verificador();
        String dado = "002ç2345675434544345çJose da SilvaçRural";
        String dado1 = "002ç2345675434544345çFernando AlvesçRural";
        verificador.verificaDado(dado);
        verificador.verificaDado(dado1);
        Assertions.assertEquals(1, verificador.getClientes().getQuantidadeClientes());
    }

    @Test
    public void deveVerificarEAdicionarVenda() {
        Verificador verificador = new Verificador();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        verificador.verificaDado(dado);
        Assertions.assertEquals(1, verificador.getVendas().getQuantidadeVendas());
    }

    @Test
    public void deveAdicionarUmaVendaPorIdVenda() {
        Verificador verificador = new Verificador();
        String dado = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        String dado1 = "003ç10ç[2-30-2.50,3-40-3.10]çCleber";
        verificador.verificaDado(dado);
        verificador.verificaDado(dado1);
        Assertions.assertEquals(1, verificador.getVendas().getQuantidadeVendas());
    }

}

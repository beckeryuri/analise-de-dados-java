package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteVendedor {
    @Test
    public void deveRetornarIdVendedor() {
        String dado = "001ç1234567891234çPedroç50000";
        String arrayDados[] = dado.split("ç");
        Vendedor vendedor = new Vendedor(arrayDados);
        Assertions.assertEquals(1, vendedor.getId());
    }

    @Test
    public void deveRetornarCpfDoVendedor() {
        String dado = "001ç1234567891234çPedroç50000";
        String arrayDados[] = dado.split("ç");
        Vendedor vendedor = new Vendedor(arrayDados);
        Assertions.assertEquals("1234567891234", vendedor.getCpf());
    }

    @Test
    public void deveRetonarNomeDoVendedor() {
        String dado = "001ç1234567891234çPedroç50000";
        String arrayDados[] = dado.split("ç");
        Vendedor vendedor = new Vendedor(arrayDados);
        Assertions.assertEquals("Pedro", vendedor.getNome());
    }

    @Test
    public void deveRetornarSalarioDoVendedor() {
        String dado = "001ç1234567891234çPedroç50000";
        String arrayDados[] = dado.split("ç");
        Vendedor vendedor = new Vendedor(arrayDados);
        Assertions.assertEquals(50000, vendedor.getSalario(), 1e-9);
    }
}

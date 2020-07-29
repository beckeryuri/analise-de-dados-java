package com.analisededadosjava.analisededadosjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteVerificador {

    @Test
    public void deveDividirDado(){
        Verificador verificador = new Verificador();
        String dado = "001ç1234567891234çPedroç50000";
        String[] array = verificador.divideDado(dado);
        Assertions.assertEquals( "001", array[0]);
        Assertions.assertEquals( "1234567891234", array[1]);
        Assertions.assertEquals( "Pedro", array[2]);
        Assertions.assertEquals( "50000", array[3]);
    }
    
}

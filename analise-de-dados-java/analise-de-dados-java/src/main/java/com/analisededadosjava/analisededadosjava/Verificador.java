package com.analisededadosjava.analisededadosjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verificador {

    Logger logger = LoggerFactory.getLogger(Verificador.class);

    Clientes clientes = new Clientes();
    Vendedores vendedores = new Vendedores();
    Vendas vendas = new Vendas();

    public String[] divideDado(String dado){
        String arrayDado[] = dado.split("ç");
        return arrayDado;
    }

    public void verificaDado(String dado) {

        String[] codigosValidos = {"001", "002", "003"};
        String[] arrayDividido = this.divideDado(dado);

        if ( arrayDividido[0].equals(codigosValidos[0]) && !vendedores.getListaCpf().contains( arrayDividido[1] )) {
            Vendedor vendedor = new Vendedor(arrayDividido);
            vendedores.adicionarVendedor(vendedor);
            logger.info("Vendedor criado");
        }
        if ( arrayDividido[0].equals(codigosValidos[1]) && !clientes.getListaCnpj().contains( arrayDividido[1] )) {
            Cliente cliente = new Cliente(arrayDividido);
            this.clientes.adicionarCliente(cliente);
            logger.info("Cliente criado");
        }
        if ( arrayDividido[0].equals(codigosValidos[2]) && !vendas.getListaIdVenda().contains( Integer.parseInt(arrayDividido[1] ) )) {
            Venda venda = new Venda(arrayDividido);
            vendas.adicionarVenda(venda);
            logger.info("Venda adicionada");
        }
        if( !arrayDividido[0].equals( codigosValidos[0]) && !arrayDividido[0].equals( codigosValidos[1]) && !arrayDividido[0].equals( codigosValidos[2]) ){
            logger.warn("Dado ignorado pois o código é inválido");
        }
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Vendedores getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

}

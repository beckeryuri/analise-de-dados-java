package com.analisededadosjava.analisededadosjava.Util;

import com.analisededadosjava.analisededadosjava.Entity.Cliente;
import com.analisededadosjava.analisededadosjava.Entity.Venda;
import com.analisededadosjava.analisededadosjava.Entity.Vendedor;
import com.analisededadosjava.analisededadosjava.Repository.Clientes;
import com.analisededadosjava.analisededadosjava.Repository.Vendas;
import com.analisededadosjava.analisededadosjava.Repository.Vendedores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verificador {

    Logger logger = LoggerFactory.getLogger(Verificador.class);

    Clientes clientes = new Clientes();
    Vendedores vendedores = new Vendedores();
    Vendas vendas = new Vendas();

    public String[] divideDado(String dado) {
        return dado.split("ç");
    }

    public void verificaVendedor(String[] arrayDividido) {
        String codigoVendedor = "001";

        if (arrayDividido[0].equals(codigoVendedor) && !this.vendedores.getListaCpf().contains(arrayDividido[1]) && arrayDividido.length == 4) {
            Vendedor vendedor = new Vendedor(arrayDividido);
            this.vendedores.adicionarVendedor(vendedor);
            logger.info("Vendedor adicionado.");
        } else if (arrayDividido[0].equals(codigoVendedor) && this.vendedores.getListaCpf().contains(arrayDividido[1]) && arrayDividido.length == 4) {
            logger.info("Vendedor não adicionado pois CPF já foi cadastrado.");
        }
    }

    public void verificaCliente(String[] arrayDividido) {
        String codigoCliente = "002";
        if (arrayDividido[0].equals(codigoCliente) && !this.clientes.getListaCnpj().contains(arrayDividido[1]) && arrayDividido.length == 4) {
            Cliente cliente = new Cliente(arrayDividido);
            this.clientes.adicionarCliente(cliente);
            logger.info("Cliente adicionado.");
        } else if (arrayDividido[0].equals(codigoCliente) && this.clientes.getListaCnpj().contains(arrayDividido[1]) && arrayDividido.length == 4) {
            logger.info("Cliente não adicionado pois CNPJ já foi cadastrado.");
        }
    }

    public void verificaVenda(String[] arrayDividido) {
        String codigoVenda = "003";
        if (arrayDividido[0].equals(codigoVenda) &&
                !this.vendas.getListaIdVenda().contains(Integer.parseInt(arrayDividido[1])) &&
                arrayDividido.length == 4 &&
                vendedores.verificaVendedor(arrayDividido[3])) {

            Venda venda = new Venda(arrayDividido);
            this.vendas.adicionarVenda(venda);
            logger.info("Venda adicionada.");

        } else if (arrayDividido[0].equals(codigoVenda) &&
                this.vendas.getListaIdVenda().contains(Integer.parseInt(arrayDividido[1])) &&
                arrayDividido.length == 4 &&
                vendedores.verificaVendedor(arrayDividido[3])) {
            logger.info("Venda não adicionada pois ID da venda já foi cadastrado.");
        }else if(arrayDividido[0].equals(codigoVenda) && !vendedores.verificaVendedor(arrayDividido[3])){
            logger.info("Venda não adicionada pois vendedor não foi encontrado");
        }
    }

    public void verificaInvalido(String[] arrayDividido) {
        String[] codigosValidos = {"001", "002", "003"};
        if (!arrayDividido[0].equals(codigosValidos[0]) && !arrayDividido[0].equals(codigosValidos[1]) && !arrayDividido[0].equals(codigosValidos[2])) {
            logger.info("Dado ignorado pois o código é inválido.");
        } else if (arrayDividido.length != 4) {
            logger.info("Dado ignorado pois possui excesso ou ausência de informações.");
        }
    }


    public void verificaDado(String dado) {

        String[] arrayDividido = this.divideDado(dado);

        this.verificaVendedor(arrayDividido);
        this.verificaCliente(arrayDividido);
        this.verificaVenda(arrayDividido);
        this.verificaInvalido(arrayDividido);

    }

    public Clientes getClientes() {
        return clientes;
    }

    public Vendedores getVendedores() {
        return vendedores;
    }

    public Vendas getVendas() {
        return vendas;
    }


}

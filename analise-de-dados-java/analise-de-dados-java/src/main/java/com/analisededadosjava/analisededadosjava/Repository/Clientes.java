package com.analisededadosjava.analisededadosjava.Repository;

import com.analisededadosjava.analisededadosjava.Entity.Cliente;

import java.util.ArrayList;

public class Clientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<String> getListaCnpj() {
        ArrayList<String> lista = new ArrayList<>();
        String cnpj;
        for (Cliente cliente : this.clientes) {
            cnpj = cliente.getCnpj();
            if (!lista.contains(cnpj)) {
                lista.add(cnpj);
            }
        }
        return lista;
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public int getQuantidadeClientes() {
        return clientes.size();
    }

}

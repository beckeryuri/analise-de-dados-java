package com.analisededadosjava.analisededadosjava;

import java.util.ArrayList;

public class Clientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<String> getListaCnpj(){
        ArrayList<String> lista = new ArrayList();
        String cnpj;
        for(Cliente cliente : this.clientes){
            cnpj = cliente.getCnpj();
            if(!lista.contains(cnpj)){
                lista.add(cnpj);
            }
        }
        return lista;
    }

    public void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public int getQuantidadeClientes(){
        return clientes.size();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}

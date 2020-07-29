package com.analisededadosjava.analisededadosjava;

import java.util.ArrayList;

public class Vendedores {

    private ArrayList<Vendedor> vendedores = new java.util.ArrayList<>();

    public ArrayList<String> getListaCpf(){
        ArrayList<String> lista = new ArrayList();
        String cpf;
        for(Vendedor vendedor : this.vendedores){
            cpf = vendedor.getCpf();
            if(!lista.contains(cpf)){
                lista.add(cpf);
            }
        }
        return lista;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public int getQuantidadeVendedores(){
        return vendedores.size();
    }

    public void adicionarVendedor(Vendedor vendedor){
        this.vendedores.add(vendedor);
    }

}

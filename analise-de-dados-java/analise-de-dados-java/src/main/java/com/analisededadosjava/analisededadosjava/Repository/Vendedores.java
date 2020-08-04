package com.analisededadosjava.analisededadosjava.Repository;

import com.analisededadosjava.analisededadosjava.Entity.Vendedor;

import java.util.ArrayList;

public class Vendedores {

    private final ArrayList<Vendedor> vendedores = new java.util.ArrayList<>();

    public ArrayList<String> getListaCpf() {
        ArrayList<String> lista = new ArrayList<>();
        String cpf;
        for (Vendedor vendedor : this.vendedores) {
            cpf = vendedor.getCpf();
            if (!lista.contains(cpf)) {
                lista.add(cpf);
            }
        }
        return lista;
    }

    public ArrayList<String> getNomeVendedores() {
        ArrayList<String> vendedores = new ArrayList<>();
        String vendedor;
        for (Vendedor indice : this.vendedores) {
            vendedor = indice.getNome();
            if (!vendedores.contains(vendedor)) {
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }

    public Boolean verificaVendedor(String nome) {
        boolean existe = false;
        for (Vendedor indice : this.vendedores) {
            if (indice.getNome().equals(nome)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public int getQuantidadeVendedores() {
        return vendedores.size();
    }

    public void adicionarVendedor(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

}

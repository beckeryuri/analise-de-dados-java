package com.analisededadosjava.analisededadosjava.Entity;

public class Cliente {

    private final int id;
    private final String cnpj;
    private final String nome;
    private final String businessArea;

    public Cliente(String[] array) {
        this.id = Integer.parseInt(array[0]);
        this.cnpj = array[1];
        this.nome = array[2];
        this.businessArea = array[3];
    }

    public int getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getBusinessArea() {
        return businessArea;
    }
}

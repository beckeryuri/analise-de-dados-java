package com.analisededadosjava.analisededadosjava;

public class Cliente {

    private int id;
    private String cnpj;
    private String nome;
    private String businessArea;

    public Cliente(String[] array) {
        this.id = Integer.parseInt(array[0] );
        this.cnpj = array[1];
        this.nome = array[2];
        this. businessArea = array[3];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}

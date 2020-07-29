package com.analisededadosjava.analisededadosjava;

public class Vendedor {
    private int id;
    private String cpf;
    private String nome;
    private double salario;

    public Vendedor(String[] array) {
        this.id = Integer.parseInt(array[0]);
        this.cpf = array[1];
        this.nome = array[2];
        this.salario = Double.parseDouble(array[3]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}

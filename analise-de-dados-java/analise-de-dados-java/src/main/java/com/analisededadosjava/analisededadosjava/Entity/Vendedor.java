package com.analisededadosjava.analisededadosjava.Entity;

public class Vendedor {
    private final int id;
    private final String cpf;
    private final String nome;
    private final double salario;

    public Vendedor(String[] array) {
        this.id = Integer.parseInt(array[0]);
        this.cpf = array[1];
        this.nome = array[2];
        this.salario = Double.parseDouble(array[3]);
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

}

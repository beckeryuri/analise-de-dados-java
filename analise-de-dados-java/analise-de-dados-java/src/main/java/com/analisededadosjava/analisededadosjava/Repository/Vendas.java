package com.analisededadosjava.analisededadosjava.Repository;

import com.analisededadosjava.analisededadosjava.Entity.Venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Vendas {

    private final ArrayList<Venda> vendas = new ArrayList<>();

    public ArrayList<Integer> getListaIdVenda() {

        ArrayList<Integer> ids = new ArrayList<>();
        int id;
        for (Venda venda : this.vendas) {
            id = venda.getIdVenda();
            ids.add(id);
        }
        return ids;
    }

    public ArrayList<String> getVendedores() {
        ArrayList<String> vendedores = new ArrayList<>();
        String vendedor;
        for (Venda venda : this.vendas) {
            vendedor = venda.getNomeVendedor();
            if (!vendedores.contains(vendedor)) {
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }

    public double getTotalVendasPorNome(String nome) {
        double totalVendas = 0;
        for (Venda venda : this.vendas) {
            if (venda.getNomeVendedor().equals(nome)) {
                totalVendas += venda.getValorVenda();
            }
        }
        return totalVendas;
    }

    public ArrayList<String> getVendedoresComNenhumaVenda(Vendedores vendedores){
        ArrayList<String> nomes = vendedores.getNomeVendedores();
        ArrayList<String> naoVenderam = new ArrayList<>();

        for(String nome : nomes){
            if(this.getTotalVendasPorNome(nome) == 0){
                naoVenderam.add(nome);
            }
        }
        return naoVenderam;

    }

    public ArrayList<String> getPiorVendedor() {
        ArrayList<String> vendedores = getVendedores();
        Map<String, Double> vendasPorVendedor = new HashMap<>();
        String nomePiorVendedor;
        String valorPiorVenda;
        for (String vendedore : vendedores) {
            vendasPorVendedor.put(vendedore, getTotalVendasPorNome(vendedore));
        }
        Map<String, Double> piorVendedor =
                vendasPorVendedor.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .limit(1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        valorPiorVenda = piorVendedor.values().toString().replace("[", "").replace("]", "");
        nomePiorVendedor = piorVendedor.keySet().toString().replace("[", "").replace("]", "");

        ArrayList<String> dadosPiorVendedor = new ArrayList<>();
        dadosPiorVendedor.add(valorPiorVenda);
        dadosPiorVendedor.add(nomePiorVendedor);

        return dadosPiorVendedor;
    }

    public int getMaiorVenda() {
        double maiorVenda = 0;
        int idMaiorVenda = 0;
        for (Venda venda : vendas) {
            if (venda.getValorVenda() > maiorVenda) {
                maiorVenda = venda.getValorVenda();
                idMaiorVenda = venda.getIdVenda();
            }
        }
        return idMaiorVenda;
    }

    public int getQuantidadeVendas() {
        return vendas.size();
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

}

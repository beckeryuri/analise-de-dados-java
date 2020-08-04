package com.analisededadosjava.analisededadosjava.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

@Component
public class ManipuladorDeArquivos {

    Logger logger = LoggerFactory.getLogger(ManipuladorDeArquivos.class);


    public void deveLimparPasta() {
        File folder = new File("/home/becker/data/in");
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
        logger.info("Arquivos da pasta in foram deletados.");
    }

    public void deveEscreverReport(ManipuladorDeArquivos manipulador) {
        Verificador verificado =  manipulador.verificaDados();
        manipulador.escrituraDeArquivos(verificado);
        System.out.println(verificado.getVendedores().getNomeVendedores());

    }

    public Verificador verificaDados(){
        ArrayList<String> dados = this.ordenaDados();
        Verificador verificador = new Verificador();
        dados.forEach(verificador::verificaDado);
        return verificador;
    }

    public ArrayList<String> ordenaDados(){
        Verificador verificar = new Verificador();
        ArrayList<String> formatado = this.formataQuebraDeLInha(this.leituraDeArquivos());
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<String> vendedores = new ArrayList<>();
        ArrayList<String> vendas = new ArrayList<>();
        ArrayList<String> outros = new ArrayList<>();
        ArrayList<String> ordenado = new ArrayList<>();
        for(String indice : formatado){
            String[] dividido = verificar.divideDado(indice);

            switch (dividido[0]) {
                case "001":
                    clientes.add(indice);
                    break;
                case "002":
                    vendedores.add(indice);
                    break;
                case "003":
                    vendas.add(indice);
                    break;
                default:
                    outros.add(indice);
                    break;
            }
        }
        ordenado.addAll(clientes);
        ordenado.addAll(vendedores);
        ordenado.addAll(vendas);
        ordenado.addAll(outros);
        return ordenado;
    }

    public ArrayList<String> leituraDeArquivos() {

        int qtdArquivosLidos = 0;

        FileFilter filter = file -> file.getName().endsWith(".dat");

        File path = new File("/home/becker/data/in");

        File[] files = path.listFiles(filter);

        ArrayList<String> entradaDados = new ArrayList<>();

        for (File file : files) {
            qtdArquivosLidos++;
            try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String line = br.readLine();
                while (line != null) {
                    entradaDados.add(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        logger.info("O total de " + qtdArquivosLidos + " arquivos foram lidos.");
        return entradaDados;
    }

    public ArrayList<String> formataQuebraDeLInha(ArrayList<String> dados){
        ArrayList<String> formatado = new ArrayList<>();

        for(int i = 0; i <dados.size(); i++){

            String[] separada = dados.get(i).split("ç");
            if(separada.length < 4 ){
                formatado.add(dados.get(i) + dados.get(i + 1));
            }
            if(separada.length == 4 ){
                formatado.add(dados.get(i));
            }
        }
        return formatado;
    }

    public void escrituraDeArquivos(Verificador verificado) {

        try {
            String quantidadeClientes = verificado.getClientes().getQuantidadeClientes() > 0 ?
                    "A quantidade de clientes registrados nos arquivos processados é: " + verificado.getClientes().getQuantidadeClientes() + "." :
                    "Nenhum cliente foi registrado.";

            String quantidadeVendedores = verificado.getVendedores().getQuantidadeVendedores() > 0 ?
                    "A quantidade de vendedores registrados nos arquivos processados é: " + verificado.getVendedores().getQuantidadeVendedores() + "." :
                    "Nenhum vendedor foi registrado.";

            String piorvendedor = verificado.getVendas().getQuantidadeVendas() > 0 ?
                    "Dos vendedores que fizeram alguma venda, o pior vendedor é o vendedor " + verificado.getVendas().getPiorVendedor().get(1).toUpperCase() +
                            " vendendo um total de: R$" + verificado.getVendas().getPiorVendedor().get(0) + "." :
                    "Não foi possível acessar o maior vendedor pois nenhuma venda foi registrada.";

            String maiorVenda = verificado.getVendas().getQuantidadeVendas() > 0 ?
                    "O ID da venda de maior valor é: " + verificado.getVendas().getMaiorVenda() + "." :
                    "Não foi possível acessar a maior venda pois nenhuma venda foi registrada";

            ArrayList<String> naoVenderam = verificado.getVendas().getVendedoresComNenhumaVenda(verificado.getVendedores());

            String naoVenderamStr = "Os vendedores " + naoVenderam.toString().replace("[", "").replace("]", "")+ " não fizeram nenhuma venda.";

            Date date = new Date();

            File file = new File("/home/becker/data/out/" + date.toString().replace(" ", "_") + ".done.dat");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(quantidadeClientes);
            bw.newLine();
            bw.write(quantidadeVendedores);
            bw.newLine();
            bw.write(maiorVenda);
            bw.newLine();
            bw.write(piorvendedor);
            bw.newLine();
            if(!naoVenderam.isEmpty()){
                bw.write(naoVenderamStr);
            }
            bw.close();

            logger.info("Um novo relátorio foi escrito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

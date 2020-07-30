package com.analisededadosjava.analisededadosjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;

public class ManipuladorDeArquivos {

    Logger logger = LoggerFactory.getLogger(ManipuladorDeArquivos.class);

    public void deveLimparPasta(){
        File folder = new File("/home/becker/data/in");
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
        logger.info("Arquivos da pasta in foram deletados.");
    }

    public void deveEscreverReport(ManipuladorDeArquivos manipulador){

        Verificador verificado = manipulador.leituraDeArquivos();
        manipulador.escrituraDeArquivos(verificado);

    }

    public Verificador leituraDeArquivos() {
        Verificador verificar = new Verificador();

        int qtdArquivosLidos = 0;

        FileFilter filter = file -> file.getName().endsWith(".dat");

        File path = new File("/home/becker/data/in");

        File[] files = path.listFiles(filter);

        for (File file : files) {
            qtdArquivosLidos++;
            try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String line = br.readLine();
                while (line != null) {
                    verificar.verificaDado(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        logger.info("O total de " + qtdArquivosLidos + " arquivos foram lidos.");
        return verificar;
    }
    public void escrituraDeArquivos(Verificador verificado) {

        try {
            String quantidadeClientes = verificado.getClientes().getQuantidadeClientes() > 0 ?
                "A quantidade de clientes registrados nos arquivos processados é: " +  verificado.getClientes().getQuantidadeClientes() + "." :
                    "Nenhum cliente foi registrado.";

            String quantidadeVendedores = verificado.getVendedores().getQuantidadeVendedores() > 0 ?
                    "A quantidade de vendedores registrados nos arquivos processados é: " +  verificado.getVendedores().getQuantidadeVendedores() + "." :
                        "Nenhum vendedor foi registrado.";

            String piorvendedor = verificado.getVendas().getQuantidadeVendas() > 0 ?
                    "O maior vendedor é o vendedor " + verificado.getVendas().getPiorVendedor().get(1).toUpperCase() +
                            " vendendo um total de: R$" + verificado.getVendas().getPiorVendedor().get(0)+ ".":
                    "Não foi possível acessar o maior vendedor pois nenhuma venda foi registrada.";

            String maiorVenda =  verificado.getVendas().getQuantidadeVendas() > 0 ?
                    "O ID da venda de maior valor é: " + verificado.getVendas().getMaiorVenda() + "." :
                    "Não foi possível acessar a maior venda pois nenhuma venda foi registrada";

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
            bw.close();

            logger.info("Um novo relátorio foi escrito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

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
            String quantidadeClientes = "A quantidade de clientes dos arquivos lidos é de: " +  verificado.getClientes().getQuantidadeClientes() + ".";
            String quantidadeVendedores = "A quantidade de vendedores dos arquivos lidos é de: " +  verificado.getVendedores().getQuantidadeVendedores() + ".";
            String piorvendedor = verificado.getVendas().getPiorVendedor() + ".";
            String maiorVenda =  "O ID da venda de maior valor é: " + verificado.getVendas().getMaiorVenda() + ".";

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

package com.analisededadosjava.analisededadosjava;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

    public void salvarIndividual(MultipartFile arquivo) {

        Path diretorioPath = Paths.get("/home/becker/data/in");
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
        try {
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

    }

}



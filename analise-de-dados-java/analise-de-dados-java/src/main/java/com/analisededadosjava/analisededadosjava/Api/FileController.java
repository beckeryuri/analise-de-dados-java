package com.analisededadosjava.analisededadosjava.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/dados")
public class FileController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private DownloadService downloadService;

    @PostMapping("/upload")
    public void uploadIndividual(@RequestParam ArrayList<MultipartFile> dados) {
        for (MultipartFile dado : dados) {
            this.uploadService.salvarIndividual(dado);
        }
    }
    @GetMapping("/download")
    public Resource downloadUltimoArquivo() throws IOException {
        File arquivo = this.downloadService.getUltimoArquivoCriado().getAbsoluteFile();
        InputStreamResource resource = new InputStreamResource( new FileInputStream(arquivo));
        return resource;
    }

}

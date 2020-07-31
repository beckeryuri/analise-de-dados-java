package com.analisededadosjava.analisededadosjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/dados")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/individual")
    public void uploadIndividual(@RequestParam ArrayList<MultipartFile> dados) {
        for (MultipartFile dado : dados) {
            this.uploadService.salvarIndividual(dado);
        }
    }


}

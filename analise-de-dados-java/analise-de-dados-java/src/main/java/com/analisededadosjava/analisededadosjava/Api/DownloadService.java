package com.analisededadosjava.analisededadosjava.Api;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DownloadService {

    public File getUltimoArquivoCriado() {
        File directory = new File("/home/becker/data/out/");
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;

        if (files != null)
        {
            for (File file : files)
            {
                if (file.lastModified() > lastModifiedTime)
                {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }

        System.out.println(chosenFile.getName());
        return chosenFile;
    }


}

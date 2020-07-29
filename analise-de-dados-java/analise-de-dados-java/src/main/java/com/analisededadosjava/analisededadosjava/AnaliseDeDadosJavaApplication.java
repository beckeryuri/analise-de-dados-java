package com.analisededadosjava.analisededadosjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.*;

@SpringBootApplication
public class AnaliseDeDadosJavaApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AnaliseDeDadosJavaApplication.class, args);

		WatchService watchService = FileSystems.getDefault().newWatchService();

		Path directory = Paths.get("/home/becker/data/in");

		WatchKey watchKey = directory.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);

		while (true) {
			for (WatchEvent<?> event : watchKey.pollEvents()) {
				ManipuladorDeArquivos manipuladorDeArquivos = new ManipuladorDeArquivos();
				manipuladorDeArquivos.deveEscreverReport(manipuladorDeArquivos);
				watchKey.pollEvents().clear();
				manipuladorDeArquivos.deveLimparPasta();
				break;
			}
		}
	}

}

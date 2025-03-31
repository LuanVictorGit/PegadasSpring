package me.pegadasspring;

import java.io.File;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;

@SpringBootApplication
@Getter
public class Core {

	@Getter private static Core instance;
	private final File folder;
	
	public Core() {
		instance = this;
		folder = new File("files");
		if (!folder.exists()) folder.mkdir();
	}
	
	public static void main(String[] args) {
		System.out.println("Inicializando o servidor...");
		SpringApplication.run(Core.class, args);
		SwingUtilities.invokeLater(()->new Core());
		System.out.println("Servidor iniciado com sucesso!");
	}
	
}

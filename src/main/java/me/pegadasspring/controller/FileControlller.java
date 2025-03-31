package me.pegadasspring.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.pegadasspring.Core;

@RestController
@RequestMapping("/api/files")
public class FileControlller {

	@GetMapping
    public List<String> listFiles() {
        File directory = Core.getInstance().getFolder();
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException("Diretório não encontrado ou inválido");
        }
        return Arrays.stream(directory.listFiles())
                .filter(File::isFile)
                .map(File::getName)
                .collect(Collectors.toList());
    }
	
}

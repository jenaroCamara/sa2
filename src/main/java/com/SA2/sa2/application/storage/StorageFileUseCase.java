package com.SA2.sa2.application.storage;

import com.SA2.sa2.application.exception.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class StorageFileUseCase implements StorageFile {
    private final StorageConfigurationProperties properties;

    @Autowired
    public StorageFileUseCase(StorageConfigurationProperties properties){
        this.properties = properties;
    }

    @Override
    public Path store(MultipartFile file) throws IOException{
        Path path = null;
        try {
            if (file.isEmpty()) {
                throw new StorageException("El archivo: " + file.getOriginalFilename() + " está vacío");
            }
            path = Path.of(properties.getPath()).resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), path);
            System.out.println(file.toString());
        } catch (RuntimeException ex) {
            throw new StorageException("Error en la subida del archivo: " + file.getOriginalFilename());
        }
        return path;
    }

    @Override
    public Resource download(Path filePath) {
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageException("No se puede leer el archivo: " + filePath);

            }
        } catch (MalformedURLException e) {
            throw new StorageException("Error en la url del archivo: " + filePath);
        }
    }
}

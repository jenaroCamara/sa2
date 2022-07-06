package com.SA2.sa2.application.register;

import com.SA2.sa2.application.fichero.domain.Fichero;
import com.SA2.sa2.application.exception.RegisterStorageException;
import com.SA2.sa2.application.fichero.infrastructure.dto.FileDTO;
import com.SA2.sa2.application.fichero.infrastructure.repository.RegisterStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class RegisterStorageUseCase implements RegisterStorage{
    @Autowired
    RegisterStorageRepository repository;

    @Override
    public Fichero registerFile(FileDTO file) {
        return repository.save(new Fichero(file));
    }

    @Override
    public Path findByName(String fileName) {
        return Path.of(repository.findByFileName(fileName).get(0).getPath());
    }

    @Override
    public Path findById(long fileId) {
        return Path.of(repository.findById(fileId).orElseThrow(() -> {
                            throw new RegisterStorageException("No se encuentra registrado ningún archivo con id " + fileId);})
                            .getPath()
        );
    }
}

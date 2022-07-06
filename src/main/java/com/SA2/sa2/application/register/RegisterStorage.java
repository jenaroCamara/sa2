package com.SA2.sa2.application.register;

import com.SA2.sa2.application.fichero.domain.Fichero;
import com.SA2.sa2.application.fichero.infrastructure.dto.FileDTO;

import java.nio.file.Path;

public interface RegisterStorage {
    Fichero registerFile(FileDTO file);
    Path findByName(String fileName);
    Path findById(long fileId);
}

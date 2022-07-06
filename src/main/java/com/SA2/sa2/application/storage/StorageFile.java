package com.SA2.sa2.application.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageFile {
    Path store(MultipartFile file)throws IOException;
    Resource download(Path fileName)throws IOException;
}

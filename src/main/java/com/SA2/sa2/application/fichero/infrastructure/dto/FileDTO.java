package com.SA2.sa2.application.fichero.infrastructure.dto;

import com.SA2.sa2.application.fichero.domain.Fichero;
import lombok.Data;
import lombok.ToString;


import java.util.Date;

@Data
@ToString
public class FileDTO {
    private long id;
    private String extension;
    private String fileName;
    private Date uploadDate;
    private String path;

    public FileDTO(Fichero file){
        setId(file.getId());
        setFileName(file.getFileName());
        setExtension(file.getExtension());
        setUploadDate(file.getUploadDate());
        setPath(file.getPath());
    }

    public FileDTO(String fileName, String extension, String path){
        setFileName(fileName);
        setExtension(extension);
        setPath(path);
    }
}

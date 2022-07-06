package com.SA2.sa2.application.fichero.domain;

import com.SA2.sa2.application.fichero.infrastructure.dto.FileDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
public class Fichero {
    @Id
    @GeneratedValue
    private long id;
    private String extension;
    private String fileName;
    private Date uploadDate;
    private String path;

    public Fichero(FileDTO file){
        setFileName(file.getFileName());
        setExtension(file.getExtension());
        setUploadDate(new Date());
        setPath(file.getPath());
    }

}

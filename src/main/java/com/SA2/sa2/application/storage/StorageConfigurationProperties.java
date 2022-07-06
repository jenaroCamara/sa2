package com.SA2.sa2.application.storage;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties("storage")
@Data
public class StorageConfigurationProperties {
    private String path;
}

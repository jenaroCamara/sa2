package com.SA2.sa2.application.fichero.infrastructure.repository;

import com.SA2.sa2.application.fichero.domain.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterStorageRepository extends JpaRepository<Fichero, Long> {
    List<Fichero> findByFileName(String fileName);
}

package br.edu.catolica.ppi.ms_merchant.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;

    @PrePersist
    public void getDateCreation() {
        dateCreation = LocalDateTime.now();
    }

    @PreUpdate
    public void getDateUpdate() {
        dateUpdate = LocalDateTime.now();
    }
}

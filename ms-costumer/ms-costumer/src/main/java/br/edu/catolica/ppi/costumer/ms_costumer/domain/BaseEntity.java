package br.edu.catolica.ppi.costumer.ms_costumer.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;

    @PrePersist
    public void prePersist(){
        dateCreation = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdate(){
        dateUpdate = LocalDateTime.now();

    }
}

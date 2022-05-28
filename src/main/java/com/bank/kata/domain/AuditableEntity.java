package com.bank.kata.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity implements Serializable{

    @CreatedDate
    @Column(name = "date_creation", columnDefinition = "TIMESTAMP WITH TIME ZONE default CURRENT_TIMESTAMP", nullable = false, updatable = false )
    private LocalDateTime dateCreation;


    @LastModifiedDate
    @Column(name = "date_modification", columnDefinition = "TIMESTAMP WITH TIME ZONE default CURRENT_TIMESTAMP")
    private LocalDateTime dateModification;

    public AuditableEntity() {
    }

    public AuditableEntity(LocalDateTime dateCreation, LocalDateTime dateModification) {
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }



    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }
}

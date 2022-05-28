package com.bank.kata.dto;



import java.time.LocalDateTime;

public class AuditableDTO {

    private LocalDateTime dateCreation;


    private LocalDateTime dateModification;

    public AuditableDTO() {
    }

    public AuditableDTO( LocalDateTime dateCreation, LocalDateTime dateModification) {
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

package com.example.stage.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "niveau")
public class Niveau implements Serializable {
    
    @Id
    private String niveau;

    // Constructeur sans argument
    public Niveau() {}

    public Niveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    } 
}


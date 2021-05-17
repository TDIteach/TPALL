package com.chakoujmed.tpall;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Condidat {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String nom;
    private  String prenom;
    private  String sexe;
    private String filiere;

    public Condidat() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Condidat(String nom, String prenom, String sexe, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.filiere = filiere;
    }
}

package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    // GETTERS

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getMatricule(){
        return matricule;
    }

    public LocalDate getDateEmbauche(){
        return dateEmbauche;
    }

    public Double getSalaire(){
        return salaire;
    }

    public final Integer getNombreAnneeAnciennete(){

        if(this.dateEmbauche != null) {
            Integer anneeEmbauche = this.dateEmbauche.getYear();
            Integer anciennete = LocalDate.now().getYear() - anneeEmbauche;
            return anciennete;
        }

        return -1;
    }

    //SETTERS

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setMatricule(String matricule){
        this.matricule = matricule;
    }

    public void setDateEmbauche(LocalDate dateEmbauche){
        this.dateEmbauche = dateEmbauche;
    }

    public void setSalaire(Double salaire){
        this.salaire = salaire;
    }

    public Employe(){
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

}

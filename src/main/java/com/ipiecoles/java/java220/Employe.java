package com.ipiecoles.java.java220;

import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe{
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

    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
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

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        LocalDate dateNow = LocalDate.now();
        if(dateEmbauche != null && dateEmbauche.isAfter(dateNow)){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        else{
            this.dateEmbauche = dateEmbauche;
        }
    }

    public void setSalaire(Double salaire){
        this.salaire = salaire;
    }

    @Override
    public String toString(){
        return "Employe{nom='"+this.nom+"', prenom='"+this.prenom+"', matricule='"+this.matricule+"', dateEmbauche="+this.dateEmbauche+", salaire="+this.salaire+"}";
    }

    @Override
    public boolean equals(Object o) {
        //Si on compare notre employé avec lui même ou une variable qui contient sa référence, on renvois true
        if (this == o) return true;
        //Si l'objet envoyé est null ou qu'on à envoyé un objet de classe différente, on renvois false
        if (o == null || getClass() != o.getClass()) return false;
        //Sinon on cast l'objet en tant qu'Employe
        Employe employe = (Employe) o;
        //On retourne en comparant chaque attributs
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    /*
    * Augmentation du salaire selon un pourcentage donné
    * Ex : salaire a 500, pourcentage à 0.5 => nouveau salaire a 750;
    *
    * @param pourcentage pourcentage est non null et strictement positif
    */
    public void augmenterSalaire(Double poucentage){
        this.salaire = this.salaire + (this.salaire * poucentage);
        //this.salaire = (this.getSalaire() +(this.salaire*pourcentage);
    }

    public abstract Double getPrimeAnnuelle();

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

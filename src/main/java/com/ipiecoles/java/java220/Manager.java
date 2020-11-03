package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Objects;

public class Manager extends Employe {

    private HashSet<Technicien> equipe = new HashSet<Technicien>();

    public Manager(){
    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public void ajoutTechnicienEquipe(Technicien technicien){
        this.equipe.add(technicien);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
    Technicien technicien = new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade);
    this.ajoutTechnicienEquipe(technicien);

    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase()+Entreprise.PRIME_MANAGER_PAR_TECHNICIEN*this.equipe.size();
    }

    public void setSalaire(Double salaire){
        Double salaireManager = salaire*Entreprise.INDICE_MANAGER+(this.equipe.size()*(salaire/10d));
        super.setSalaire(salaireManager);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(equipe, manager.equipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipe);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "equipe=" + equipe +
                '}';
    }

    private void augmenterSalaireEquipe(Double pourcentage){
        for (Technicien technicien : this.equipe){
            technicien.augmenterSalaire(pourcentage);
        }
    }

    public void augmenterSalaire(Double pourcentage){
        for (Technicien technicien : this.equipe){
            technicien.augmenterSalaire(pourcentage);
        }
        super.augmenterSalaire(pourcentage);

    }
}

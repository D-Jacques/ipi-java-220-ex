package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe{

    private Integer grade;

    public Technicien(){
        super();
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire){
       if(grade == null) {
            super.setSalaire(salaire);
       }
       super.setSalaire(salaire * (1 + grade / 10d));
    }

    @Override
    public Integer getNbConges(){
        //On va chercher le get du getter d'Employer on ajoute le nombre d'année d'ancienneté
        return super.getNbConges() + getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle(){
        //la prime annuelle de base est la prime anuelle de base que l'on multiplie par la bonification en fonction du grade
        //On ajoute la prime d'anciennetée de l'entreprise multiplié par le nombre d'année d'ancienneté du technicien
        Double primeAnnuelle = Entreprise.primeAnnuelleBase();

        return primeAnnuelle * (1+(grade/10d)) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }
}

package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe {

    private Integer performance;

    private Double caAnnuel;

    public Commercial(){
        super();
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel){
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance){
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public boolean performanceEgale(Integer perf){
        return Objects.equals(perf, this.performance);
    }

    @Override
    public Double getPrimeAnnuelle(){
        Double primeAnuelle = 500.0;
        if(this.caAnnuel != null){
            primeAnuelle = this.caAnnuel * 0.05;
            if(primeAnuelle < 500){
                primeAnuelle = 500.00;
            }
        }
        return Math.ceil(primeAnuelle);
    }

    @Override
    public boolean equals(Object o) {
        // On fait la comparaison de tout les attributs d'employés dans un premier temps en utilisant le equals de Employe
        // Commercial délègue la vérification des attributs qui viennent d'employe à employe
        // Ensuite on compare les attributs de Commercial ici caAnnuel et performance
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel) &&
                Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }


}

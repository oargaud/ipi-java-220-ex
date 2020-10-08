package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe
{
    private Integer grade;



    public Technicien()
    {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire)
    {
        super( nom, prenom, matricule, dateEmbauche, salaire);
    }


    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,Integer grade)
    {
        super( nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }


    @Override
    public void setSalaire(Double salaire)
    {
        super.setSalaire(salaire+salaire*grade/10); ;
    }

    @Override
    public Integer getNbConges()
    {
        return super.getNbConges()+getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle()
    {
        Double primeDeBase = Entreprise.primeAnnuelleBase();
        Double primeMajore = primeDeBase*(1+(grade*10d)/100);
        Double primeAnciennete = Entreprise.PRIME_ANCIENNETE*this.getNombreAnneeAnciennete();
        return primeMajore+primeAnciennete;
        // maniere plus concise et plus propre petit bug pour le moment
        //return super.getPrimeAnnuelle()*(1+(grade/10d))+Entreprise.PRIME_ANCIENNETE*this.getNombreAnneeAnciennete();
    }

    @Override
    public String toString()
    {
        return "Technicien{" +
                "grade=" + grade +
                "} " + super.toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), grade); // mieux car si Employe evolue le Hash suivra
    }

    /*
        @Override
        public int hashCode()
        {

            return Objects.hash(getNom(), getPrenom(), getMatricule(), getDateEmbauche(), getSalaire(),grade);
        }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    public Integer getGrade()
    {
        return grade;
    }

    public void setGrade(Integer grade)
    {
        this.grade = grade;
    }


}

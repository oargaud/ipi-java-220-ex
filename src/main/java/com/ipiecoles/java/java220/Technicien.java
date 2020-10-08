package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

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

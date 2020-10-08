package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;

public class Manager extends Employe
{
    private HashSet<Technicien> equipe = new HashSet<Technicien>();




    public void ajoutTechnicienEquipe(Technicien technicien)
    {
        getEquipe().add(technicien);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade)
    {
        getEquipe().add(new Technicien( nom,  prenom,  matricule,  dateEmbauche,  salaire, grade));
    }


    @Override
    public void setSalaire(Double salaire)
    {
        super.setSalaire(salaire*Entreprise.INDICE_MANAGER+salaire*0.1*equipe.size());
    }

    @Override
    public Double getPrimeAnnuelle()
    {
        Double prime = Entreprise.primeAnnuelleBase()+equipe.size()*Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;

        return prime;
    }

    private void augmenterSalaireEquipe (Double percAugmentation)
    {
        if(equipe.size()!=0)
        {
            for (Technicien t :equipe)
            {
                t.augmenterSalaire(percAugmentation);
            }
        }

    }

    @Override
    public void augmenterSalaire(Double percAugmentation)
    {
        augmenterSalaireEquipe(percAugmentation);
        super.augmenterSalaire(percAugmentation);
    }


    /*
    public HashSet equipeParGrade()
    {
        HashSet listeTrie = new HashSet();
        for (Technicien t :equipe)
        {

        }
    }
    */








    public HashSet<Technicien> getEquipe()
    {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe)
    {
        this.equipe = equipe;
    }





}

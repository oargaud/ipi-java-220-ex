package com.ipiecoles.java.java220;

import java.util.ArrayList;
import java.util.HashSet;

public class Manager extends Employe
{
    private HashSet<Technicien> equipe = new HashSet<Technicien>();




    public void ajoutTechnicienEquipe(Technicien technicien)
    {
        getEquipe().add(technicien);
    }


    @Override
    public void setSalaire(Double salaire)
    {
        super.setSalaire(salaire*Entreprise.INDICE_MANAGER+salaire*0.1*equipe.size());
    }

    @Override
    public Double getPrimeAnnuelle()
    {
        Double prime = Entreprise.primeAnnuelleBase()+Entreprise.PRIME_MANAGER_PAR_TECHNICIEN*equipe.size();

        return prime;
    }



    public HashSet<Technicien> getEquipe()
    {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe)
    {
        this.equipe = equipe;
    }
}

package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

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
        //ajoutTechnicienEquipe(new Technicien( nom,  prenom,  matricule,  dateEmbauche,  salaire, grade));
        // meilleur method car si il y a code specifique dans la fonction ajoutTechnicienEquipe de base on le recupere
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



    public ArrayList<Technicien> equipeParGrade()
    {
        ArrayList<Technicien> list = new ArrayList<Technicien>();

        for (Technicien t :equipe)
        {
            list.add(t);
        }
        list.sort(Technicien::compareTo);

        return list;
    }



//    public List<Technicien> equipeParGrade(){
//        return equipe.stream().sorted(Technicien::compareTo).collect(Collectors.toList());
//    }


    public Double salaireEquipeGrade1()
    {
        Double total = 0d;

        for (Technicien t :equipe)
        {
            if(t.getGrade()==1)
            {
                total+=t.getSalaire();
            }
        }

        return total;
    }

//    public double salaireEquipeGrade1(){
//        return equipe.stream().filter(t -> t.getGrade().equals(1)).mapToDouble(Technicien::getSalaire).sum();
//    }





    public HashSet<Technicien> getEquipe()
    {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe)
    {
        this.equipe = equipe;
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
                "} " + super.toString();
    }
}

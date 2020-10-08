package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe
{



    private String nom ;
    private String prenom ;
    private String matricule ;
    private LocalDate dateEmbauche;
    private Double salaire ;

    public Employe()
    {

    }

    public Employe(String nom,String prenom,String matricule,LocalDate dateEmbauche,Double salaire)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;

    }

    public final Integer getNombreAnneeAnciennete()
    {
        /*
        Integer anciennete;
        LocalDate dateActuelle = new LocalDate();
        Integer anneeDEmbauche = dateEmbauche.getYear();
        anciennete = dateActuelle.getYear()-anneeDEmbauche;

        return anciennete
        */
        return new LocalDate().getYear()-dateEmbauche.getYear();
    }

    public Integer getNbConges()
    {

        return Entreprise.NB_CONGES_BASE;
    }

    public String toString()
    {
        return "Employe{nom='"+this.nom+
                "', prenom='"+this.prenom+
                "', matricule='"+this.matricule+
                "', dateEmbauche="+this.dateEmbauche.toString()+
                ", salaire="+ this.salaire+"}";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

/*
    public boolean equals(Employe employe)
    {
        boolean result = false;
        if (employe!=null)
        {
            System.out.println("date employe "+employe.getDateEmbauche().toString()+" date cet employe "+this.dateEmbauche.toString());
            if(     employe.getNom().equals(this.nom)
                    && employe.getPrenom().equals(this.prenom)
                    && employe.getMatricule().equals(this.matricule)
                    && employe.getDateEmbauche().isEqual(this.dateEmbauche)
                    && employe.getSalaire().equals(this.salaire)  )
            {
                result = true;
            }
        }


        return result;
    }
*/

    /**
     * Augmente le salaire du pourcentage renseigné
     * Ex : salaire 1000 percAugmentation 0.05 -> 1050
     *
     * @param percAugmentation percAugmentation est un double non null strictement positif
     */
    public void augmenterSalaire(Double percAugmentation)
    {
        this.salaire = this.salaire*(1+percAugmentation);

    }

    public Double getPrimeAnnuelle()
    {
        return Entreprise.PRIME_ANCIENNETE;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception
    {
        if(dateEmbauche!=null && dateEmbauche.isAfter(LocalDate.now()))
        {
            throw new Exception ("La date d'embauche ne peut être postérieure à la date courante");

        }
        this.dateEmbauche = dateEmbauche;

    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }




}

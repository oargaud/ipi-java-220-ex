package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

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

    public boolean equals(Employe employe)
    {
        boolean result = false;
        if (employe.toString().equals(this.toString()))
        {
            result = true;
        }
        /*
        if(     employe.nom.equals(this.nom)
                && employe.prenom.equals(this.prenom)
                && employe.matricule.equals(this.matricule)
                && employe.dateEmbauche.toString().equals(this.dateEmbauche.toString())
                && employe.salaire.equals(this.salaire)  )
        {
            result = true;
        }
        */

        return result;
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

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
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

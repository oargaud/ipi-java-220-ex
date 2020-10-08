package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe
{

    private Double caAnnuel;
    private Integer performance;


    public Commercial()
    {

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,Double caAnnuel)
    {
        super( nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,Double caAnnuel,Integer performance)
    {
        super( nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
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
        if (!super.equals(o))
        {
            return false;
        }
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel);
    }

    @Override
    public Double getPrimeAnnuelle()
    {
        if (caAnnuel==null || caAnnuel<10000)
        {
            return 500d;
        }
        else
        {
            return Double.valueOf(Math.ceil(caAnnuel*5/100));
        }
    }

    public Boolean performanceEgale(Integer niveauPerformance)
    {
        return performance.equals(niveauPerformance);
    }



    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Double getCaAnnuel()
    {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel)
    {
        this.caAnnuel = caAnnuel;
    }


}

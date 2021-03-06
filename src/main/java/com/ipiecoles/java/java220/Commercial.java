package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe
{

    private Double caAnnuel;
    private Integer performance;
    private Note note;

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
        //super( nom, prenom, matricule, dateEmbauche, salaire);
        //this.caAnnuel = caAnnuel;
        this( nom, prenom, matricule, dateEmbauche, salaire,caAnnuel);
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
        if (!super.equals(o))   // delegue le control des champs propre a Employe au super de la classe mere
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

    public Note equivalenceNote()
    {
        switch (performance)
        {
            case 0 :
            case 50:
            {
                return Note.INSUFFISANT;
            }
            case 100:
            {
                return Note.PASSABLE;
            }
            case 150:
            {
                return Note.BIEN;
            }
            case 200:
            {
                return Note.TRES_BIEN;
            }
            default:
            {
                return null;
            }
        }
    }
    /*
    public void equivalenceNote()
    {
        switch (performance)
        {
            case 0 :
            case 50:
            {
                this.note = Note.INSUFFISANT;
                break;
            }
            case 100:
            {
                this.note = Note.PASSABLE;
                break;
            }
            case 150:
            {
                this.note = Note.BIEN;
                break;
            }
            case 200:
            {
                this.note = Note.TRES_BIEN;
                break;
            }
            default:
            {
                this.note = null;
                break;
            }
        }


    }
    */

    @Override
    public String toString()
    {
        return "Commercial{" +
                "caAnnuel=" + caAnnuel +
                ", performance=" + performance +
                ", note=" + note +
                "} " + super.toString();
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance, note);
    }
}

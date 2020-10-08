package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe
{

    private Double caAnnuel;


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

    public Double getCaAnnuel()
    {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel)
    {
        this.caAnnuel = caAnnuel;
    }


}

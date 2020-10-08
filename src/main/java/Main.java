import com.ipiecoles.java.java220.Employe;
import org.joda.time.LocalDate;

public class Main
{

    public static void main(String[] args)
    {
        String hello = "Hello world";
        System.out.println(hello);

        int nombre = 5;
        Integer nombre2 = 6;

        // nombre = null; interdit les primitif ne peuvent etre null  il vaut mieux utiliser les classes enveloppes
        nombre2 = null;
        LocalDate time =new LocalDate();
        Employe e0 = null;
        Employe e1= new Employe("TOTO","toto","12345",time,1500d);
        Employe e2= new Employe("TOTO","toto","12345",time,1500d);
        Employe e3= new Employe("TITI","toto","23456",time,1500d);
        e1.equals(e2);




        Employe employe1= new Employe("Doe","John","M12345",time,2500d);


    }

}

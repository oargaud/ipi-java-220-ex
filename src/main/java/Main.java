import com.ipiecoles.java.java220.Commercial;
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

        Commercial commercial1 = new Commercial("TOTO","toto","12345",time,1500d,50000d,0);
        Commercial commercial2 = new Commercial("TOTO","toto","12345",time,1500d,50000d,50);
        Commercial commercial3 = new Commercial("TOTO","toto","12345",time,1500d,50000d,100);
        Commercial commercial4 = new Commercial("TOTO","toto","12345",time,1500d,50000d,150);
        Commercial commercial5 = new Commercial("TOTO","toto","12345",time,1500d,50000d,200);
        Commercial commercial6 = new Commercial("TOTO","toto","12345",time,1500d,50000d,58);
        commercial1.equivalenceNote();
        commercial2.equivalenceNote();
        commercial3.equivalenceNote();
        commercial4.equivalenceNote();
        commercial5.equivalenceNote();
        commercial6.equivalenceNote();
        System.out.println("Note com1 "+commercial1.getNote());
        System.out.println("Note com2 "+commercial2.getNote());
        System.out.println("Note com3 "+commercial3.getNote());
        System.out.println("Note com4 "+commercial4.getNote());
        System.out.println("Note com5 "+commercial5.getNote());
        System.out.println("Note com6 "+commercial6.getNote());

    }

}

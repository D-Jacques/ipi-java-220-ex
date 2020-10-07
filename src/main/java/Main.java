import com.ipiecoles.java.java220.Employe;
import com.ipiecoles.java.java220.Entreprise;
import org.joda.time.LocalDate;

public class Main {

        public static void main(String[] args)
        {
            System.out.println(Entreprise.INDICE_MANAGER);

            Employe john = new Employe("Doe", "john", "DJ-inf-32", new LocalDate(2018,05,25) , 1856.02);

            System.out.println(john.getDateEmbauche());
            System.out.println(john.getNombreAnneeAnciennete());

        }
}

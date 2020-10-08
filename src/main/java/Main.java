import com.ipiecoles.java.java220.Commercial;
import com.ipiecoles.java.java220.Employe;
import com.ipiecoles.java.java220.Entreprise;
import com.ipiecoles.java.java220.Technicien;
import org.joda.time.LocalDate;

public class Main {

        public static void main(String[] args)
        {
            System.out.println(Entreprise.INDICE_MANAGER);

            Employe john = new Employe("Doe", "john", "DJ-inf-32", new LocalDate(2018,05,25) , 500.00);
            Employe jim = new Employe("Dan", "jim", "DJ-com-33", new LocalDate(2015,03,12), 1756.00);
            System.out.println(john.getDateEmbauche());

            System.out.println(john.hashCode());
            System.out.println(jim.hashCode());

            /*try {
                john.setDateEmbauche(new LocalDate(2222, 01, 01));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Veulliez saisir une autre date d'embauche ");
            }*/

            System.out.println(john.getNombreAnneeAnciennete());
            System.out.println(john.getNbConges());
            System.out.println(john.equals(jim));

            Commercial sam = new Commercial("Dell", "sam", "DS-com-34", new LocalDate(2017, 04, 15), 1953.20, 4500.10);
            System.out.println(sam.getCaAnnuel());
            System.out.println(sam.getPrimeAnnuelle());

            System.out.println(john.getPrimeAnnuelle());

            Technicien ben = new Technicien("Mann", "ben", "DS-tec-36", new LocalDate(2019, 07, 29), 1850.20, 2);
            System.out.println("ben prime anuelle "+ben.getPrimeAnnuelle());

        }
}

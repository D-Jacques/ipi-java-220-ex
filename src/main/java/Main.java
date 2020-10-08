import com.ipiecoles.java.java220.Employe;
import com.ipiecoles.java.java220.Entreprise;
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

            System.out.println(john.augmenterSalaire(0.50));
            System.out.println(jim.augmenterSalaire(0.50));

            System.out.println(john.getPrimeAnuelle());

        }
}

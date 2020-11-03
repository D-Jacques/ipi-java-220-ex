import com.ipiecoles.java.java220.*;
import org.joda.time.LocalDate;

public class Main {

        public static void main(String[] args)
        {
            System.out.println(Entreprise.INDICE_MANAGER);

            /*Employe john = new Employe("Doe", "john", "DJ-inf-32", new LocalDate(2018,05,25) , 500.00);
            Employe jim = new Employe("Dan", "jim", "DJ-com-33", new LocalDate(2015,03,12), 1756.00);
            System.out.println(john.getDateEmbauche());

            System.out.println(john.hashCode());
            System.out.println(jim.hashCode());*/

            /*try {
                john.setDateEmbauche(new LocalDate(2222, 01, 01));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Veulliez saisir une autre date d'embauche ");
            }*/

            /*System.out.println(john.getNombreAnneeAnciennete());
            System.out.println(john.getNbConges());
            System.out.println(john.equals(jim));*/

            Commercial sam = new Commercial("Dell", "sam", "DS-com-34", new LocalDate(2017, 04, 15), 1953.20, 4500.10);
            System.out.println(sam.getCaAnnuel());
            System.out.println(sam.getPrimeAnnuelle());

            //System.out.println(john.getPrimeAnnuelle());

            Technicien ben = new Technicien("Mann", "ben", "DS-tec-36", new LocalDate(2019, 07, 29), 1850.20, 2);
            Technicien patrick = new Technicien("Baum", "patrick", "DS-tec-37", new LocalDate(2015, 03, 21), 1850.20, 1);
            System.out.println("ben prime anuelle "+ben.getPrimeAnnuelle());

            Manager Ian = new Manager("Hash", "Ian", "DS-man-02", new LocalDate(2015, 02, 04), 1000.0);
            Ian.ajoutTechnicienEquipe(ben);

            System.out.println(Ian.getSalaire());
            Ian.getPrimeAnnuelle();

        }
}

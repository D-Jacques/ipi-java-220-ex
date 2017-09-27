package com.ipiecoles.java.java220;

import java.lang.reflect.InvocationTargetException;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import utils.TestUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class EmployeTest {
	
	
	class Derived extends Employe {
		//A decommenter quand le constructeur avec les 5 arguments est codé
		public Derived(String nom, String prenom, String matricule, LocalDateTime dateEmbauche, Double salaire) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
			super(nom, prenom, matricule, dateEmbauche, salaire);
		}

		public Derived() {
		}

		//A decommenter quand la méthode getPrimeAnnuelle est déclarée
		public Double getPrimeAnnuelle() {
			return 0d;
		}
	   
	}
	
	@Test
	public void exo101testClasseAbstraite() throws IllegalAccessException {
		//Rendre la classe Employe abstraite
		TestUtils.checkAbstractClass(Employe.class);
	}
	
	@Test
	public void exo102TestMethodAbstract() {
		//Déclarer dans la classe Employe une méthode abstraite getPrimeAnnuelle retournant un Double
		TestUtils.checkAbstractMethod(Employe.class, "getPrimeAnnuelle", Double.class);
	}
	
	@Test
	public void exo103TestPrivateFields() throws Exception {
		//Ajouter dans la classe Employe les champs suivants avec leurs getters/setters
		//										   Nom champ	Type
		TestUtils.checkPrivateField(Employe.class, "nom", 		String.class);
		TestUtils.checkPrivateField(Employe.class, "prenom", 	String.class);
		TestUtils.checkPrivateField(Employe.class, "matricule", String.class);
		TestUtils.checkPrivateField(Employe.class, "dateEmbauche", LocalDateTime.class);
		TestUtils.checkPrivateField(Employe.class, "salaire", 	Double.class);
		
		TestUtils.checkMethod(Employe.class, "getNom", String.class);
		TestUtils.checkMethod(Employe.class, "getPrenom", String.class);
		TestUtils.checkMethod(Employe.class, "getMatricule", String.class);
		TestUtils.checkMethod(Employe.class, "getDateEmbauche", LocalDateTime.class);
		TestUtils.checkMethod(Employe.class, "getSalaire", Double.class);
		
		TestUtils.checkMethod(Employe.class, "setNom", void.class, String.class);
		TestUtils.checkMethod(Employe.class, "setPrenom", void.class, String.class);
		TestUtils.checkMethod(Employe.class, "setMatricule", void.class, String.class);
		TestUtils.checkMethod(Employe.class, "setDateEmbauche", void.class, LocalDateTime.class);
		TestUtils.checkMethod(Employe.class, "setSalaire", void.class, Double.class);
		
		Derived d = new Derived();
		LocalDateTime dateTime = new LocalDateTime();
		TestUtils.invokeSetter(d, "nom", "nom");
		TestUtils.invokeSetter(d, "prenom", "prenom");
		TestUtils.invokeSetter(d, "matricule", "matricule");
		TestUtils.invokeSetter(d, "dateEmbauche", dateTime);
		TestUtils.invokeSetter(d, "salaire", 500.0);
		
		Assertions.assertThat(TestUtils.invokeGetter(d, "nom")).isEqualTo("nom");
		Assertions.assertThat(TestUtils.invokeGetter(d, "prenom")).isEqualTo("prenom");
		Assertions.assertThat(TestUtils.invokeGetter(d, "matricule")).isEqualTo("matricule");
		Assertions.assertThat(TestUtils.invokeGetter(d, "dateEmbauche")).isEqualTo(dateTime);
		Assertions.assertThat(TestUtils.invokeGetter(d, "salaire")).isEqualTo(500.0);
	}
	
	@Test
	public void exo104TestConstructeur() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//Définir un constructeur par défaut dans la classe Employé, puis un constructeur avec l'ensemble des arguments
		//précédemment créés, dans le même ordre
		//
		TestUtils.checkConstructor(Employe.class);
		TestUtils.checkConstructor(Employe.class, String.class, String.class, String.class, LocalDateTime.class, Double.class);
		
		LocalDateTime dateTime = new LocalDateTime();
		Derived d = null;
		d = new Derived("nom", "prenom", "matricule", dateTime, 500.0);
		Assertions.assertThat(TestUtils.invokeGetter(d, "nom")).isEqualTo("nom");
		Assertions.assertThat(TestUtils.invokeGetter(d, "prenom")).isEqualTo("prenom");
		Assertions.assertThat(TestUtils.invokeGetter(d, "matricule")).isEqualTo("matricule");
		Assertions.assertThat(TestUtils.invokeGetter(d, "dateEmbauche")).isEqualTo(dateTime);
		Assertions.assertThat(TestUtils.invokeGetter(d, "salaire")).isEqualTo(500.0);
		
	}
	
	@Test
	public void exo105TestGetNombreAnneeAnciennete() throws Exception {
		//Déclarer et développer la méthode getNombreAnneeAnciennete calculant le nombre d'année d'ancienneté d'un employé
		//Faire en sorte qu'elle ne puisse être redéfinie dans d'éventuelles sous-classes.
		//Un employé enbauché en 2017 a une ancienneté de 0
		
		TestUtils.checkFinalMethod(Employe.class, "getNombreAnneeAnciennete", Integer.class);
		
		LocalDateTime dateTime = new LocalDateTime();
		Derived d = null;
		d = new Derived();
		TestUtils.invokeSetter(d, "dateEmbauche", dateTime);
		Assertions.assertThat(TestUtils.callMethod(d, "getNombreAnneeAnciennete")).isEqualTo(0);
		
		TestUtils.invokeSetter(d, "dateEmbauche", dateTime.minusYears(5));
		Assertions.assertThat(TestUtils.callMethod(d, "getNombreAnneeAnciennete")).isEqualTo(5);
		
	}
	
	@Test
	public void exo106TestGetNombreAnneeAncienneteNegatif() throws Exception {
		//Modifier le setter de dateEmbauche pour lever une Exception avec le message "La date d'embauche ne peut être postérieure à la date courante"
		//lorsque la date d'embauche est postérieure
		//à la date courante
		
		
		LocalDateTime dateTime = new LocalDateTime();
		Derived d = new Derived();
		TestUtils.invokeSetter(d, "dateEmbauche", dateTime);
		Assertions.assertThat(TestUtils.invokeGetter(d, "dateEmbauche")).isEqualTo(dateTime);
		
		TestUtils.invokeSetter(d, "dateEmbauche", dateTime.minusDays(1));
		Assertions.assertThat(TestUtils.invokeGetter(d, "dateEmbauche")).isEqualTo(dateTime.minusDays(1));
		
		try {
			TestUtils.invokeSetter(d, "dateEmbauche", dateTime.plusDays(6));
			Assertions.fail("Aucune exception levée lorsqu'on essaye de mettre une date d'embauche postérieure à la date courante");
		} catch (Exception e) {
			Assertions.assertThat(e.getCause().getMessage()).isEqualTo("La date d'embauche ne peut être postérieure à la date courante");
		}
		
	}
	
	@Test
	public void exo107TestGetNbConges() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		//Développer une méthode getNbConges retournant la constante de classe NB_CONGES_BASE de la classe Entreprise
		
		TestUtils.checkMethod(Employe.class, "getNbConges", Integer.class);
		
		Assertions.assertThat(TestUtils.callMethod(new Derived(), "getNbConges")).isEqualTo(25);
		
	}

	@Test
	public void exo108TestToString() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//Redéfinir la méthode toString (héritée d'Object) pour afficher un employé de la manière suivante :
		//"Employe{nom='nom', prenom='prenom', matricule='12345', dateEmbauche=1970-01-01T01:00:00.000, salaire=500.0}"
		LocalDateTime dateTime = new LocalDateTime(0L);
		Derived d = new Derived("nom", "prenom", null, dateTime, 500.0);
		Assertions.assertThat(TestUtils.callMethod(d, "toString")).isEqualTo("Employe{nom='nom', prenom='prenom', matricule='null', dateEmbauche=1970-01-01T01:00:00.000, salaire=500.0}");
	}

	@Test
	public void exo109TestEquals() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//Redéfinir la méthode equals (héritée d'Object) testant l'égalité sur l'ensemble des attributs de la classe Employe
		LocalDateTime dateTime = new LocalDateTime(0L);
		Derived d = new Derived("nom", "prenom", "matricule", dateTime, 500.0);
		Derived d2 = new Derived("nom", "prenom", "matricule", dateTime, 500.0);
		Assertions.assertThat(d).isEqualTo(d2);

		d = new Derived("nom", "prenom", null, dateTime, 500.0);
		d2 = new Derived("nom", "prenom", null, dateTime, 500.0);
		Assertions.assertThat(d).isEqualTo(d2);

		d = new Derived("nom", "XXX", null, dateTime, 500.0);
		d2 = new Derived("nom", "prenom", null, dateTime, 500.0);
		Assertions.assertThat(d).isNotEqualTo(d2);
	}

	@Test
	public void exo110TestHashcode() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		//Redéfinir la méthode hashCode (héritée d'Object) en utilisant Objects.hash(...) et en respectant l'ordre
		//nom, prenom, matricule, dateEmbauche, salaire

		LocalDateTime dateTime = new LocalDateTime(0L);
		Derived d = new Derived("nom", "prenom", "matricule", dateTime, 500.0);
		Assertions.assertThat(d.hashCode()).isEqualTo(2120496656);

		d = new Derived("nom", "XXX", "matricule", dateTime, 500.0);
		Assertions.assertThat(d.hashCode()).isEqualTo(1484784545);
	}

	@Test
	public void exo111TestAugmenterSalaire() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//Coder la méthode augmenterSalaire prenant en paramètre un pourcentage d'augmentation de type Double
		//et augmentant l'attribut salaire du pourcentage passé en paramètre :
		//Ex : un salaire de 500.0, avec une augmentation de 0.50, cela donne un salaire de 750.0
		LocalDateTime dateTime = new LocalDateTime(0L);
		Derived d = new Derived("nom", "prenom", "matricule", dateTime, 500.0);
		TestUtils.callMethod(d, "augmenterSalaire", 0.50);
		Assertions.assertThat(TestUtils.invokeGetter(d, "salaire")).isEqualTo(750.0);
	}
}
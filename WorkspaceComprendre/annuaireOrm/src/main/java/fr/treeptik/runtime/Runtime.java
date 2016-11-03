package fr.treeptik.runtime;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.treeptik.pojo.Adresse;
import fr.treeptik.pojo.BoitePostale;

public class Runtime {

	public static void main(String[] args) {

		EntityManager entityManager = Persistence.createEntityManagerFactory(
				"annuaireOrm").createEntityManager();
		// Personne personne1 = new Personne(null, "Nom1", "Prenom1", new
		// Date());
		// Personne personne2 = new Personne(null, "Nom2", "Prenom2", new
		// Date());
		// Personne personne3 = new Personne(null, "Nom3", "Prenom3", new
		// Date());
		// Personne personne4 = new Personne(4, "NomMod4", "Prenom4", new
		// Date());
		// Personne personne5 = new Personne(5, "Nom6", "Prenom5", new Date());
		// Personne personne6 = new Personne(6, "Nom6", "PrenomModif6", new
		// Date());
		
		
		Adresse adresse = new Adresse(null, "Route des Milles", "Aix-en-Provence");
		BoitePostale bp = new BoitePostale(null, "13090", "CEDEX00");
		

		entityManager.getTransaction().begin();
		
		/* Persistance */
		// entityManager.persist(personne1);
		// entityManager.persist(personne2);
		// entityManager.persist(personne3);
		// System.out.println("ID: " + personne.getId());

		/* Merge */
		// entityManager.merge(personne4);
		// entityManager.merge(personne5);
		// System.out.println("ID: " + personne.getId());

		/* Remove */
		// Personne p = entityManager.find(Personne.class, 4);
		// entityManager.remove(p);
		// System.out.println(p);

		/* Find */
		// entityManager.merge(personne5);
		// Personne p = entityManager.find(Personne.class, 5);
		// System.out.println(p);

		// entityManager.merge(personne6);
		// Personne p = entityManager.find(Personne.class, personne6.getId());
		// System.out.println(p);

		
		/* Queries */
		// ici Personne est bien l'OBJET du package pojo et nom correspond bien
		// à l'attribut nom de Personne !
		// TypedQuery<Personne> query = entityManager
		// .createQuery("SELECT p FROM Personne p WHERE p.nom = :name ",
		// Personne.class);
		// query.setParameter("name", "Nom6");

		// List<Personne> lstPersonne = query.getResultList();
		
		/* Relations */
//		entityManager.persist(bp);
		adresse.setBoitePostale(bp);
//		entityManager.persist(adresse); // adresse est proprio de la relation, on doit persister bp en premier, puis adresse
		
		/* Persist en Cascade */
		entityManager.persist(adresse);

		entityManager.getTransaction().commit();

		// for (Personne personne : lstPersonne) {
		// System.out.println(personne);
		// }

		// autre écriture du foreach en JAVA8
		// lstPersonne.forEach(System.out::println);

		// encore une autre ériture
		// lstPersonne.forEach(p0 -> {
		// System.out.println(p0);
		// });

		System.out.println("FIN");
		System.exit(0);

	}

}

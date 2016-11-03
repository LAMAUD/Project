package fr.treeptik.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import fr.treeptik.model.Property;
import fr.treeptik.model.Todo;

/**
 * Voir assert-sum pour une liste des asserts principaux disponibles
 * 
 * @author marvin
 *
 */

@ContextConfiguration(locations={"classpath:test-context.xml"})
public class TodoTest {

	private Todo todo1;
	private Todo todo2;
	private Todo todo3;
	private Property property;

	// Création du contexte
	@Before
	public void setUp() {
		todo1 = new Todo();
		todo1.setTodoId("01");
		todo1.setCompleted(false);
		todo1.setDescription("Description");
		todo1.setPriority(0);

		todo2 = new Todo();
		todo2.setTodoId("02");
		todo2.setCompleted(true);
		todo2.setDescription("Description");
		todo2.setPriority(0);

		todo3 = new Todo();
		todo3.setTodoId("01");
		todo3.setCompleted(false);
		todo3.setDescription("Description");
		todo3.setPriority(0);

		property = new Property();
		property.setKey("key");
		property.setValue("value");

	}

	@After
	public void tearDown() {
		// Destruction du contexte
	}

	@Test
	public void compareTo() {
		// Vérifie la consistance avec la méthode equals
		// Cf. JavaDoc de l'API J2SE
		assertTrue(todo1.compareTo(todo3) == 0);
		// Vérifie le respect de la spec de Comparable pour null
		// Cf. JavaDoc de l’API J2SE
		try {
			todo1.compareTo(null);
			fail();
		} catch (NullPointerException e) {
			// OK
		}
		// todo1 n'est pas fermé donc < à todo2
		String message = "it's not good baby";
		assertTrue(message, todo1.compareTo(todo2) < 0);
		// Vérifie que l'inverse est vrai aussi
		assertTrue(todo2.compareTo(todo1) > 0);
	}

	@Test
	public void equals() {
		assertEquals(todo1, todo3);
		// assertSame("ce ne sont pas les mêmes objets", todo1, todo3);
		assertFalse(todo1.equals(todo2));
		assertFalse(todo1.equals(property));
		assertFalse(todo1.equals(null));

		assertEquals("ce ne sont pas du tout les mêmes ", 3.0, 2.0, 1.0);

	}

}

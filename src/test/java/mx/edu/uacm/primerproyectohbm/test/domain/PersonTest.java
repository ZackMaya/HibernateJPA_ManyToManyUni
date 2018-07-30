package mx.edu.uacm.primerproyectohbm.test.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.primerproyectohbm.HibernateJpaManyToManyUniApplication;
import mx.edu.uacm.primerproyectohbm.domain.Address;
import mx.edu.uacm.primerproyectohbm.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HibernateJpaManyToManyUniApplication.class)
public class PersonTest {

	@PersistenceContext
	protected EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(false)
	public void testGuardarPersona() {

		// Vamos a crear dos direcciones
		// Vamos a crear a dos personas
		// La persona1 tendra 2 direcciones
		// La persona2 tendra 1 direccion

		Person person1 = new Person();
		Person person2 = new Person();

		Address address1 = new Address("STL", "0800");
		Address address2 = new Address("Av. del Arbol", "0700");

		person1.getAddresses().add(address1);
		person1.getAddresses().add(address2);
		person2.getAddresses().add(address1);
		
		entityManager.persist(person1);
		entityManager.persist(person2);
		
		
		entityManager.flush();		
		
	}

}

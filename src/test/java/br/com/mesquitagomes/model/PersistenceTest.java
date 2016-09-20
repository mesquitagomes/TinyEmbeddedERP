package test.java.br.com.mesquitagomes.model;

import main.java.br.com.mesquitagomes.model.entity.Person;
import main.java.br.com.mesquitagomes.model.persistence.IPersistable;
import main.java.br.com.mesquitagomes.model.persistence.PersistenceFactory;

public class PersistenceTest {

	public static void main(String[] args) {

		Person person = new Person();
		person.setName("Marcel Mesquita Gomes");
		person.setCPF(123456789);

		IPersistable<Person> personPersistence = PersistenceFactory.getPersistence(person);

		System.out.println(person);

		personPersistence.persist(person);
	}

}

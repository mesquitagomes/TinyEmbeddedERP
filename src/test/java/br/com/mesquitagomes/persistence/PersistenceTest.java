package test.java.br.com.mesquitagomes.persistence;

import java.util.Arrays;
import java.util.List;

import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Person.PersonPropertyChangeEnum;
import main.java.br.com.mesquitagomes.model.Phone;
import main.java.br.com.mesquitagomes.persistence.AbstractPersistence;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;

public class PersistenceTest {

	private static PersistenceFactory persistenceFactory = PersistenceFactory.getInstance();

	public static void persistPerson(String name, String cpf) {

		Person person = new Person();
		person.setName(name);
		person.setCpf(cpf);

		AbstractPersistence<Person> persistence = persistenceFactory.getPersistence(Person.class);

		System.out.println(person);

		persistence.persist(person);
	}

	public static List<Person> getPersonByName(String name) {

		AbstractPersistence<Person> persistence = persistenceFactory.getPersistence(Person.class);

		String column = PersonPropertyChangeEnum.name.name();

		List<Person> person = persistence.getByColumn(column, name);

		System.out.println(Arrays.toString(person.toArray()));

		return person;
	}

	public static void persistPhone(Person person) {

		Phone phone = new Phone();
		phone.setPerson(person);
		phone.setType("Home");
		phone.setNumber("+55 11 1234-1234");

		AbstractPersistence<Phone> persistence = persistenceFactory.getPersistence(Phone.class);

		System.out.println(phone);

		persistence.persist(phone);
	}

	public static void testVarargs(String... str) {

		for (int i = 0; i < str.length; i++) {
			String s = str[i];
			System.out.println(s);
		}
	}

	public static void main(String[] args) {

		// persistPerson("Marcel", 123456789);
		List<Person> persons = getPersonByName("Marcel");
		// persistPhone(persons.get(0));
		System.out.println(Arrays.toString(persons.get(0).getPhones().toArray()));

		persistenceFactory.close();
	}

}

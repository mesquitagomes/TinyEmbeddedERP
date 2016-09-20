package main.java.br.com.mesquitagomes.model.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import main.java.br.com.mesquitagomes.model.entity.Person;

public class PersonPersistence extends AbstractPersistence implements IPersistable<Person> {

	public Person getByPK(Person person) {

		initialize();

		person = eManager.find(Person.class, person.getId());

		close();

		return person;

	}

	@SuppressWarnings("unchecked")
	public List<Person> getAll() {

		List<Person> persons = new ArrayList<Person>();

		initialize();

		Query q = eManager.createNamedQuery("GetAllPersons", Person.class);
		persons = q.getResultList();

		close();

		return persons;

	}

	@SuppressWarnings("unchecked")
	public List<Person> getByQuery(String sqlQuery, String... parameters) {

		List<Person> persons = new ArrayList<Person>();

		initialize();

		Query q = eManager.createNativeQuery(sqlQuery, "GetByQuery");

		for (int i = 1; i <= parameters.length; i++)
			q.setParameter(i, parameters[i]);

		persons = q.getResultList();

		close();

		return persons;

	}

	public void persist(Person person) {

		initialize();

		Person person2Persist = eManager.find(Person.class, person.getId());

		if (person2Persist == null) {
			eTransaction.begin();
			eManager.persist(person);
			eTransaction.commit();
		} else {
			eTransaction.begin();
			eManager.refresh(person2Persist);
			eTransaction.commit();
		}

		close();

	}

	public void delete(Person person) {

		initialize();

		Person person2Persist = eManager.find(Person.class, person.getId());

		if (person2Persist == null) person2Persist = person;

		eTransaction.begin();
		eManager.remove(person2Persist);
		eTransaction.commit();
		close();

	}

}

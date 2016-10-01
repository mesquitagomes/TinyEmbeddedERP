package main.java.br.com.mesquitagomes.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import main.java.br.com.mesquitagomes.model.Person;

public class PersonPersistence extends AbstractPersistence<Person> {

	public final String SELECT = "select * from " + Person.class.getDeclaredAnnotation(Table.class).name();

	public PersonPersistence(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Person getByPK(Person entity) {

		return entityManager.find(Person.class, entity.getId());
	}

	@Override
	public List<Person> getAll() {

		return getByQuery(getSELECT());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getByQuery(String sqlQuery, String... parameters) {

		Query q = entityManager.createNativeQuery(sqlQuery, Person.class);

		for (int i = 0; i < parameters.length; i++)
			q.setParameter(i + 1, parameters[i]);

		return q.getResultList();
	}

	@Override
	public String getSELECT() {

		return SELECT;
	}

}

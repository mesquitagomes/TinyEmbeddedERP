package main.java.br.com.mesquitagomes.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Person.PersonPropertyChangeEnum;

public class PersonPersistence extends AbstractPersistence<Person> {

	public final String SELECT = "select * from " + Person.class.getDeclaredAnnotation(Table.class).name();

	public PersonPersistence(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Person getById(Integer id) {

		return entityManager.find(Person.class, id);
	}

	@Override
	public List<Person> getAll() {

		return getByQuery(SELECT);
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

	public List<Person> getByDocsLikeOr(Integer cpf, Integer rg, Integer cnpj, Integer ie) {

		String query = SELECT + " where ";
		query += PersonPropertyChangeEnum.cpf.name() + " like ?";
		query += "or " + PersonPropertyChangeEnum.rg.name() + " like ?";
		query += "or " + PersonPropertyChangeEnum.cnpj.name() + " like ?";
		query += "or " + PersonPropertyChangeEnum.ie.name() + " like ?";

		return getByQuery(query, cpf + "%", rg + "%", cnpj + "%", ie + "%");
	}

}

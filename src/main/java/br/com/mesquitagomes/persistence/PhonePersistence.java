package main.java.br.com.mesquitagomes.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import main.java.br.com.mesquitagomes.model.Phone;

public class PhonePersistence extends AbstractPersistence<Phone> {

	public final String SELECT = "select * from " + Phone.class.getDeclaredAnnotation(Table.class).name();

	public PhonePersistence(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Phone getById(Integer id) {

		return entityManager.find(Phone.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> getAll() {

		Query q = entityManager.createNamedQuery("GetAllPhones", Phone.class);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> getByQuery(String sqlQuery, String... parameters) {

		Query q = entityManager.createNativeQuery(sqlQuery, Phone.class);

		for (int i = 0; i < parameters.length; i++)
			q.setParameter(i + 1, parameters[i]);

		return q.getResultList();
	}

	@Override
	public String getSELECT() {

		return SELECT;
	}

}

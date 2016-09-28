package main.java.br.com.mesquitagomes.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import main.java.br.com.mesquitagomes.model.Adress;

public class AdressPersistence extends AbstractPersistence<Adress> {

	public final String SELECT = "select * from " + Adress.class.getDeclaredAnnotation(Table.class).name();

	public AdressPersistence(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Adress getByPK(Adress entity) {

		return entityManager.find(Adress.class, entity.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Adress> getAll() {

		Query q = entityManager.createNamedQuery("GetAllAdress", Adress.class);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Adress> getByQuery(String sqlQuery, String... parameters) {

		Query q = entityManager.createNativeQuery(sqlQuery, Adress.class);

		for (int i = 0; i < parameters.length; i++)
			q.setParameter(i + 1, parameters[i]);

		return q.getResultList();
	}

	@Override
	public String getSELECT() {

		return SELECT;
	}

}

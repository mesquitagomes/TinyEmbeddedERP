package main.java.br.com.mesquitagomes.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * TODO make a unique and generic class for persistence.
 * 
 * @author mesquitagomes
 *
 * @param <T>
 */
public abstract class AbstractPersistence<T> {

	protected EntityManager entityManager;

	public AbstractPersistence(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	public void persist(T entity) {

		EntityTransaction transaction = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			System.err.println("Erro ao inserir o objeto: \n" + entity + ".\n" + e);
			if (transaction != null) transaction.rollback();
		}
	}

	public void merge(T entity) {

		EntityTransaction transaction = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			System.err.println("Erro ao atualizar o objeto: \n" + entity + ".\n" + e);
			if (transaction != null) transaction.rollback();
		}
	}

	public void remove(T entity) {

		EntityTransaction transaction = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(entity);
			transaction.commit();
		} catch (Exception e) {
			System.err.println("Erro ao atualizar o objeto: \n" + entity + ".\n" + e);
			if (transaction != null) transaction.rollback();
		}
	}

	abstract public T getByPK(T entity);

	abstract public List<T> getAll();

	abstract public List<T> getByQuery(String sqlQuery, String... parameters);

	/**
	 * Return the default SELECT from the T class table in question.
	 * 
	 * Example:
	 * 
	 * <pre>
	 * select * from table_name
	 * </pre>
	 * 
	 * @return
	 */
	abstract public String getSELECT();

	public List<T> getByColumn(String column, String value) {

		String sqlQuery = getSELECT() + " where " + column + " like ?";
		return getByQuery(sqlQuery, value);
	}

}

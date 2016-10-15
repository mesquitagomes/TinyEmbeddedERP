package main.java.br.com.mesquitagomes.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

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

	public void persistOrMerge(T entity) throws PersistenceException {

		// TODO verify if the column entity @Id is null to deicide what method to execute, persist or merge.
		System.out.println("The method AbstractPersistence<T>.persistMerge is not implemented yet!");
	}

	public void persist(T entity) throws PersistenceException {

		EntityTransaction transaction = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			String message = "Erro ao inserir o objeto: \n" + entity + ".\n" + e;
			System.err.println(message);
			if (transaction != null) transaction.rollback();
			throw new PersistenceException(message);
		}
	}

	public T merge(T entity) throws PersistenceException {

		EntityTransaction transaction = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			T newEntity = entityManager.merge(entity);
			transaction.commit();
			return newEntity;
		} catch (Exception e) {
			String message = "Erro ao atualizar o objeto: \n" + entity + ".\n" + e;
			System.err.println(message);
			if (transaction != null) transaction.rollback();
			throw new PersistenceException(message);
		}
	}

	public void remove(T entity) throws PersistenceException {

		EntityTransaction transaction = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(entity);
			transaction.commit();
		} catch (Exception e) {
			String message = "Erro ao atualizar o objeto: \n" + entity + ".\n" + e.getMessage() + "\n\n" + e.getStackTrace();
			System.err.println(message);
			if (transaction != null) transaction.rollback();
			throw new PersistenceException(message);
		}
	}

	abstract public T getById(Integer id);

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
		return getByQuery(sqlQuery, value + "%");
	}

}

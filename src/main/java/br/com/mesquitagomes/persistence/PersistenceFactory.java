package main.java.br.com.mesquitagomes.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.br.com.mesquitagomes.model.Adress;
import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Phone;

/**
 * Singleton persistence factory.
 * 
 * Should use the method close at the end of the program to close the <class>javax.persistence.EntityManager</class>.
 * 
 * @author mesquitagomes
 *
 */
public class PersistenceFactory {

	private static final PersistenceFactory INSTANCE = new PersistenceFactory();
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public static final String PERSISTENCE_UNIT_NAME = "tiny-embedded-erp";

	private PersistenceFactory() {

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			System.err.println("Erro ao abrir a conexão com o banco de dados.\n" + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static PersistenceFactory getInstance() {

		return INSTANCE;
	}

	public void close() {

		try {
			if (entityManager.isOpen()) entityManager.close();
			if (entityManagerFactory.isOpen()) entityManagerFactory.close();
		} catch (Exception e) {
			System.err.println("Erro ao fechar a coneção com o banco de dados.\n" + e);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> AbstractPersistence<T> getPersistence(Class<T> cls) {

		if (cls == Adress.class) return (AbstractPersistence<T>) new AdressPersistence(entityManager);
		if (cls == Person.class) return (AbstractPersistence<T>) new PersonPersistence(entityManager);
		if (cls == Phone.class) return (AbstractPersistence<T>) new PhonePersistence(entityManager);

		return null;
	}

	public PersonPersistence getPersonPersistence() {

		return (PersonPersistence) getPersistence(Person.class);
	}

}

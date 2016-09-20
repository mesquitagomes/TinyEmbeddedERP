package main.java.br.com.mesquitagomes.model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AbstractPersistence {

	protected EntityManagerFactory eManagerFactory;
	protected EntityManager eManager;
	protected EntityTransaction eTransaction;

	public void initialize() {

		try {
			eManagerFactory = Persistence.createEntityManagerFactory("tiny-embedded-erp");
			eManager = eManagerFactory.createEntityManager();
			eTransaction = eManager.getTransaction();
		} catch (Exception e) {
			System.err.println("Erro ao abrir a conexão com o banco de dados.\n" + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public void close() {

		try {
			eManager.close();
			eManagerFactory.close();
		} catch (Exception e) {
			System.err.println("Erro ao fechar a coneção com o banco de dados.\n" + e);
		}
	}

}

package main.java.br.com.mesquitagomes.model.persistence;

import main.java.br.com.mesquitagomes.model.entity.Adress;
import main.java.br.com.mesquitagomes.model.entity.Person;
import main.java.br.com.mesquitagomes.model.entity.Phone;

public class PersistenceFactory {

	@SuppressWarnings("unchecked")
	public static <T> IPersistable<T> getPersistence(T entity) {

		if (entity instanceof Person) return (IPersistable<T>) new PersonPersistence();
		if (entity instanceof Phone) return (IPersistable<T>) new PhonePersistence();
		if (entity instanceof Adress) return (IPersistable<T>) new AdressPersistence();

		return null;
	}

}

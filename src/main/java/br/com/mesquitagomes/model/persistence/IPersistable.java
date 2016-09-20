package main.java.br.com.mesquitagomes.model.persistence;

import java.util.List;

public interface IPersistable<T> {

	public T getByPK(T object);

	public List<T> getAll();

	public List<T> getByQuery(String sqlQuery, String... parameters);

	public void persist(T object);

	public void delete(T object);

}

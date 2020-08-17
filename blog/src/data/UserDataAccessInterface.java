package data;

import java.util.List;

import javax.ejb.Local;

/**
 * 
 * Interface to wrap initial DAO interface for User objects.
 *
 * @param <T> generic type for CRUD operations. 
 */
@Local
public interface UserDataAccessInterface<T> extends DataAccessInterface<T> {
	public T get(String id);
	List<T> getAll();
	void save(T t);
	void update(String id, T t);
	void delete(T t);
}

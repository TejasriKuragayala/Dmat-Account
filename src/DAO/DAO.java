package DAO;

import java.util.List;
/*
 * This is a interface for database operations.
 * Other classes can implements this interface to use its objects.
 */

public interface DAO<T>  {
	public int insert(T object);
	public int update(T object);
	public int delete(T object);
	List<T> query();
}

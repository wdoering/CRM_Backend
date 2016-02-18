package main.interfaces;
import java.util.List;



public interface CRUD<T> {
	public List<T> getList();
	public int create(T type);
	public boolean update(T type);
	public boolean delete(T type);
	
}

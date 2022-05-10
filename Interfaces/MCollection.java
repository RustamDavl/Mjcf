package MyRealization.Interfaces;

public interface MCollection<T> extends Iterable<T> {

	void insert(T element);

	int delete(T t);

	T get();

	void display();

	boolean isEmpty();
	
	int getSize();

}

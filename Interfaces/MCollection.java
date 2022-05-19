package MyRealization.Interfaces;

public interface MCollection<T> extends Iterable<T> {

	void insert(T element);
	
	void insert(int index, T element);

	int delete(T t);
	
	T deleteIndex(int index);

	T getFirst();
	
	T getLast();

	void display();

	boolean isEmpty();
	
	int getSize();
	
T get(int index);
	
	void sort();
	
	int getIndex(T element);

}

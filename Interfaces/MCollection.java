package MyRealization.Interfaces;

public interface MCollection<T> extends Iterable<T> {

	void insert(T element);

	int delete(T t);

	T getFirst();

	void display();

	boolean isEmpty();

	int getSize();

	int getIndex(T element);

}

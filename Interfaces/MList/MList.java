package MyRealization.Interfaces.MList;

import MyRealization.Interfaces.MCollection;

public interface MList<T> extends MCollection<T> {
	
	Comparable<T>[] toComparableArray();
	
	void insertLast(T value);
	
	void insert(int index, T element);
	
	T deleteIndex(int index);
	
	T deleteFirst();
	
	T deleteLast();
	
	T getLast();
	
	T get(int index);
	
	
	
	void sort();
	
	

}

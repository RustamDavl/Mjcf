package MyRealization.AbstractClasses;

import java.util.Iterator;

import javax.swing.Renderer;

import MyRealization.Interfaces.MCollection;
import MyRealization.Interfaces.MList.MList;
import MyRealization.MyCollections.MCollections;

public abstract class AbsArrayList<T extends Comparable<T>> implements MList<T> {

	protected Comparable<T>[] elements;

	private int SIZE = 10;

	private int amountOfElements;

	@SuppressWarnings("unchecked")
	protected AbsArrayList(T... el) {

		while (el.length > SIZE)
			resize();
		elements = new Comparable[SIZE];

		for (T t : el)
			elements[amountOfElements++] = t;
	}

	private void resize() {

		SIZE *= 1.5;

	}

	

	@Override
	public T get(int index) {
		return (T) elements[index];
	}

	@Override
	public void insert(T el) {
		if(isEmpty()) {
			
			
		}
		while (amountOfElements > this.SIZE)
			this.resize();

		elements[amountOfElements++] = el;
	}

	@Override
	public void display() {
		for (int i = 0; i < amountOfElements; i++) {
			System.out.print(elements[i] + " ");
		}
	}

	@Override
	public boolean isEmpty() {

		return amountOfElements == 0;
	}

	@Override
	public int delete(T t) {

		return 0;
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sort() {
		MCollections.quickSort(this);

	}

	// using it to transfer size - parameter into a method quickSort as third
	// parameter
	public int getSize() {
		return amountOfElements;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<T>[] toComparableArray() {

		return elements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.isEmpty()) {
			return "[]";
		} else {
			sb.append("[");
			for (int i = 0; i < amountOfElements; i++) {

				sb.append(elements[i]);
				if (i == amountOfElements - 1)
					break;
				sb.append(", ");
			}
			return sb.append("]").toString();
		}
	}

}

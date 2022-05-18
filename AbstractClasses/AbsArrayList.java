package MyRealization.AbstractClasses;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.Renderer;

import MyRealization.Interfaces.MCollection;
import MyRealization.Interfaces.MList.MList;
import MyRealization.MyCollections.MCollections;
import MyRealization.SearchClasses.BinarySearch;

public abstract class AbsArrayList<T extends Comparable<T>> implements MList<T> {

	protected Comparable<T>[] elements;

	private int SIZE = 15;

	private int amountOfElements;

	@SuppressWarnings("unchecked")
	protected AbsArrayList(T... el) {
		amountOfElements = el.length;

		if (el.length > SIZE)

			resize();
		elements = new Comparable[SIZE];
		int i = 0;
		for (T t : el)
			elements[i++] = t;

	}

	private void resize() {
		while (amountOfElements >= SIZE)
			SIZE *= 1.5;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index >= getSize())
			throw new IllegalArgumentException();
		return (T) elements[index];
	}

	@Override
	public void insert(T el) {

		if (getSize() >= SIZE) {

			reWriteArray();
		}

		elements[amountOfElements++] = el;
	}

	private void reWriteArray() {

		Comparable<T>[] el = new Comparable[this.getSize()];
		System.arraycopy(elements, 0, el, 0, el.length);

		resize();
		getElementsWithNewSize();
		System.arraycopy(el, 0, elements, 0, el.length);

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
	public T delete(int index) {
		return null;
	}

	@Override
	public int getIndex(T element) {
//		@SuppressWarnings("unchecked")
//		Comparable<T>[] copy = new Comparable[amountOfElements];
//		System.arraycopy(elements, 0, copy, 0, amountOfElements);
//		
//		@SuppressWarnings("unchecked")
//		Comparable<T>[] s = Arrays.stream(copy).sorted((a, b) -> a.compareTo((T)b)).toArray(Comparable[] :: new);
//		
//		return MCollections.getIndex(s, element);

		for (int i = 0; i < getSize(); i++) {
			if (elements[i].equals(element))
				return i;
		}
		return -1;

	}

	@Override
	public T get() {

		return null;
	}

	@Override
	public void sort() {
		MCollections.quickSort(this);

	}

	// using it to transfer size parameter into a method quickSort as a third
	// parameter
	public int getSize() {
		return amountOfElements;
	}

	@Override
	public Iterator<T> iterator() {

		return null;
	}

	@Override
	public Comparable<T>[] toComparableArray() {

		return elements;
	}

	@Override
	public void insert(int index, T element) {

	}

	@SuppressWarnings("unchecked")
	private void getElementsWithNewSize() {
		elements = new Comparable[SIZE];

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

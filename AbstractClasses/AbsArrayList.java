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

	private Comparable<T>[] elements;

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
			throw new IndexOutOfBoundsException("index is bigger than array's size");
		return (T) elements[index];
	}

	@Override
	public void insert(T el) {

		if (getSize() >= SIZE) {

			reWriteArray();
		}

		elements[amountOfElements++] = el;
	}
	@Override
	public void insertFirst(T value) {
		if(getSize() >= SIZE)
			reWriteArray();
		for(int i = getSize(); i > 0; i--) {
			elements[i] = elements[i - 1];
		}
		elements[0] = value;
		amountOfElements++;
	}

	protected void reWriteArray() {

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
	public int delete(T element) {
		int index = -1;
		for (int i = 0; i < getSize(); i++) {
			if (elements[i].equals(element)) {
				for (int k = i; k < getSize() - 1; k++) {
					elements[k] = elements[k + 1];

				}
				index = i;
				amountOfElements--;
				break;
			}

		}

		return index;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T deleteIndex(int index) {
		T el = (T) elements[index];
		if (index >= getSize())
			throw new IllegalArgumentException();
		for (int i = index; i < getSize() - 1; i++) {
			elements[i] = elements[i + 1];

		}
		amountOfElements--;

		return el;
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

	@SuppressWarnings("unchecked")
	@Override
	public T getFirst() {

		return (T) elements[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getLast() {
		return (T) elements[getSize() - 1];
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

		return new Iterator<T>() {
			private int i = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return i < amountOfElements;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub

				T t = (T) elements[i];
				i++;
				return t;
			}
		};
	}

	@Override
	public Comparable<T>[] toComparableArray() {

		return elements;
	}

	@Override
	public void insert(int index, T element) {

		if (index > amountOfElements) {
			if (index > SIZE) {
				reWriteArray();
			}
			elements[amountOfElements++] = element;

		} else {
			if (amountOfElements == SIZE)
				reWriteArray();
			for (int i = getSize(); i > index; i--) {
				elements[i] = elements[i - 1];
			}
			elements[index] = element;
			amountOfElements++;
		}

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

	@Override
	public T deleteFirst() {
		@SuppressWarnings("unchecked")
		T el = (T)elements[0];
		for(int i = 0; i < getSize() - 1; i++) {
			elements[i] = elements[i + 1];
		}
		amountOfElements--;
		
		return el;
	}

	@Override
	public T deleteLast() {
		@SuppressWarnings("unchecked")
		T el = (T)elements[getSize() - 1];
		amountOfElements--;
		
		return el;
	}

	

}

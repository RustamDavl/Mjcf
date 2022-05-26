package MyRealization.Classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import MyRealization.Interfaces.MList.MList;
import MyRealization.MyCollections.MCollections;

public class MLinkedList<T extends Comparable<T>> implements MList<T> {

	private Comparable<T>[] elements;

	private Node first;

	private Node last;

	private int amountOfElements;

	public MLinkedList() {
		first = null;
		last = null;
		amountOfElements = 0;

	}

	private class Node {

		private T value;
		private Node next;
		private Node previous;

		public Node(T value) {
			this.value = value;

		}

	}

	@Override
	public void insertFirst(T element) {
		Node node = new Node(element);
		if (first == null) {
			last = node;
		} else {
			first.previous = node;
		}
		node.next = first;

		first = node;

		amountOfElements++;

	}

	@Override
	public void insert(int index, T element) {
		Node node = new Node(element);

		if (index < 0) {

			first.previous = node;
			node.next = first;
			first = node;
			amountOfElements++;
			return;
		} else if (index >= amountOfElements) {
			index = amountOfElements;

			last.next = node;
			node.previous = last;
			last = node;
			amountOfElements++;
			return;
		} else {

			Node current = first;

			int i = 0;

			while (i != index) {
				current = current.next;
				i++;
			}
			current.previous.next = node;
			node.previous = current.previous;

			node.next = current;
			current.previous = node;
			amountOfElements++;
		}

	}

	@Override
	public void insert(T element) { // insert to the end

		Node node = new Node(element);

		if (last == null) {
			first = node;
		} else {
			node.previous = last;
			last.next = node;

		}

		last = node;
		amountOfElements++;

	}

	@Override
	public int delete(T t) {
		if (t == null)
			throw new NullPointerException();
		int i = 0;
		Node current = first;

		while (!current.value.equals(t)) {
			current = current.next;
			i++;
			if (current == null)
				throw new NoSuchElementException();
		}

		current.previous.next = current.next;
		current.next.previous = current.previous;
		amountOfElements--;
		return i;
	}

	@Override
	public T deleteIndex(int index) {
		if (index < 0 || index >= amountOfElements)
			throw new IndexOutOfBoundsException();
		Node current = first;
		if (index == 0) {

			first.next.previous = null;
			first = first.next;
			amountOfElements--;
			return current.value;

		}
		if (index == amountOfElements - 1) {
			T t = last.value;
			last.previous.next = null;
			last = last.previous;
			amountOfElements--;
			return t;

		}

		int i = 0;

		while (i < index) {
			i++;
			current = current.next;
		}
		current.previous.next = current.next;
		current.next.previous = current.previous;
		amountOfElements--;

		return current.value;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {

		return amountOfElements;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sort() {
		MCollections.quickSort(this);
		System.out.println(showSortedList());

	}

	private String showSortedList() {

		return Arrays.toString(elements);
	}

	@Override
	public int getIndex(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			Node current;
			{
				current = first;

			}

			@Override
			public boolean hasNext() {

				return current != null;
			}

			@Override
			public T next() {
				T el = current.value;
				current = current.next;
				return el;
			}
		};
	}

	@Override
	public Comparable<T>[] toComparableArray() {
		elements = (T[]) new Comparable[amountOfElements];
		Iterator<T> it = this.iterator();
		int i = 0;
		while (it.hasNext()) {
			elements[i++] = (T) it.next();
		}
		return elements;
	}

	@Override
	public T deleteFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T deleteLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (first == null)
			return sb.append("[]").toString();
		Iterator<T> it = this.iterator();
		sb.append("[");
		while (it.hasNext()) {
			sb.append(it.next());
			if (!it.hasNext())
				return sb.append("]").toString();
			sb.append(", ");

		}

		return "";
	}

}

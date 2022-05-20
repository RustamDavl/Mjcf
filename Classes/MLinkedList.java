package MyRealization.Classes;

import java.util.Iterator;

import MyRealization.Interfaces.MList.MList;

public class MLinkedList<T> implements MList<T> {

	private Node<T> first;

	private Node<T> last;

	private int amountOfElements;

	public MLinkedList() {
		first = null;
		last = null;
		amountOfElements = 0;

	}

	private class Node<E> {
		int index;
		E value;
		Node<E> next;
		Node<E> previous;

		public Node(E value) {
			this.value = value;

		}

	}

	@Override
	public void insert(T element) {
		Node<T> node = new Node<>(element);
		if (first == null) {
			last = node;
		} else {
			first.previous = node;
		}
		node.next = first;

		first = node;

	}

	@Override
	public void insert(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T deleteIndex(int index) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getIndex(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<T>[] toComparableArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLast(T value) {
		// TODO Auto-generated method stub

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

}

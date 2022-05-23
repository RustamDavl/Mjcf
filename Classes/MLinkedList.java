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
		static int pointer;

		E value;
		Node<E> next;
		Node<E> previous;

		public Node(E value) {
			this.value = value;

		}

	}

	@Override
	public void insertFirst(T element) {
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
	public void insert(T element) { // insert to the end
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

		return new Iterator<T>() {

			Node<T> current;
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
		// TODO Auto-generated method stub
		return null;
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

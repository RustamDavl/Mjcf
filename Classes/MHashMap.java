package MyRealization.Classes;

import java.awt.HeadlessException;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.*;

import MyRealization.MMap.MMap;

public class MHashMap<K, V> implements MMap<K, V> {

	private Node<K, V> first;

	private int amountOfElements;

	private Node<K, V>[] elements;

	private List<Integer> listOfIndexes;

	@SuppressWarnings("unchecked")
	public MHashMap() {
		elements = (Node<K, V>[]) new Node[50];
		listOfIndexes = new ArrayList<>();

	}

	private class Node<K, V> implements MMap.Entry<K, V> {

		private Node next;

		private K key;

		private V value;

		private int hash;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {

			return key;
		}

		@Override
		public V getValue() {

			return value;
		}

		@Override
		public void setValue(V value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setKey(K key) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public int hash(K key) {

		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	@Override
	public int getSize() {

		return amountOfElements;
	}

	@Override
	public boolean isEmpty() {

		return amountOfElements == 0;
	}

	@Override
	public void put(K key, V value) {
		Node<K, V> node = getInstance(key, value);

		int i = getIndex(hash(key));

		if (containsKey(key)) {

			Node<K, V> current = elements[i];
			Node<K, V> previous = current;
			while (!current.getKey().equals(key)) {
				previous = current;

				current = current.next;

			}

			if (current.getKey().equals(elements[i].getKey())) {
				
				elements[i] = node;

			} else {

				previous.next = node;
				node.next = current.next;
				current = null;

			}

		} else {

			elements[i] = node;
			amountOfElements++;
			listOfIndexes.add(i);

		}

//
//		if (elements[i] != null) {
//			
//			Node<K, V> current = elements[i];
//
//			if (current.getKey().equals(node.getKey())) {
//				elements[i] = node;
//				return;
//
//			} else {
//
//				node.next = current;
//				elements[i] = node;
//
//			}
//
//		} else {
//
//			elements[i] = getInstance(key, value);
//
//			listOfIndexes.add(i);
//
//		}
//		amountOfElements++;
	}

	private Node<K, V> getInstance(K key, V value) {
		return new Node<>(key, value);
	}

	private int getIndex(int hash) {
		return hash % elements.length;
	}

	@Override
	public boolean containsKey(K key) {

		int i = getIndex(hash(key));
		Node<K, V> current = elements[i];

		if (elements[i] != null) {

			while (current != null) {
				if (current.getKey().equals(key))
					return true;

				current = (Node<K, V>) current.next;
			}

		}

		return false;
	}

	@Override
	public V remove(K key) {
		V value;

		int i = getIndex(hash(key));

		if (elements[i] != null) {
			Node<K, V> current = elements[i];
			Node<K, V> previous = current;

			while (!current.getKey().equals(key)) {
				if (current.next == null)
					return null;

				previous = current;

				current = current.next;

			}

			if (current.getKey().equals(elements[i].getKey())) {
				value = elements[i].getValue();
				elements[i] = null;

			} else {
				value = current.getValue();
				previous.next = current.next;

			}
			
		listOfIndexes.remove((Integer)i);

			amountOfElements--;
			return value;
		}

		return null;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		if (amountOfElements == 0)
			return sb.append("{}").toString();

		sb.append("{");
		for (int i = 0; i < listOfIndexes.size(); i++) {
			Node<K, V> current = elements[listOfIndexes.get(i)];
			if (listOfIndexes.size() - i == 1) {
				while (current != null) {
					sb.append(current.getKey());
					sb.append(" = ");
					sb.append(current.getValue());
					current = current.next;

				}
				return sb.append("}").toString();
			}

			while (current != null) {
				sb.append(current.getKey());
				sb.append(" = ");
				sb.append(current.getValue());
				sb.append(", ");
				current = current.next;

			}

		}
		return "";

	}

}

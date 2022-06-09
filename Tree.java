package Lafore.MyRealisation.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<Key extends Comparable<Key>> {

	private Node root;
	private List<Key> list;
	private int size;

	public Tree() {

		list = new ArrayList<>();
	}

	private class Node {
		Key key;
		Node right;
		Node left;

		public Node(Key key) {
			this.key = key;
		}

	}

	public void put(Key key) {

		this.root = put(root, key);
	}

	private Node put(Node n, Key key) {

		if (n == null) {
			size++;
			return new Node(key);

		}

		int i = n.key.compareTo(key);
		if (i > 0)
			n.left = put(n.left, key);
		else if (i < 0) {
			n.right = put(n.right, key);

		}

		return n;

	}

	private void display(Node node) {

		if (node == null) {

			return;
		}

		display(node.left);

		list.add(node.key);

		display(node.right);

	}

	public int getSize() {
		return size;
	}

	public boolean contains(Key key) {

		if (root == null)
			return false;
		int index = contains(root, key);

		return index == 0;

	}

	private int contains(Node node, Key key) {
		if (node == null)
			return -1;

		int index = node.key.compareTo(key);

		if (index < 0)
			index = contains(node.right, key);
		else if (index > 0)
			index = contains(node.left, key);

		return index;

	}

	private void clearList() {
		list.clear();
	}

	public Key max() {
		if (root == null)
			return null;

		return max(root).key;

	}

	private Node max(Node node) {
		if (node.right == null)
			return node;

		return max(node.right);

	}

	public Key min() {
		if (root == null)
			return null;

		return min(root).key;

	}

	private Node min(Node node) {

		if (node.left == null)
			return node;

		return min(node.left);

	}

	public void deleteMin() {

		if (root == null)
			return;

		deleteMin(root);
		size--;

	}

	private Node deleteMin(Node node) {

		if (node.left == null) {
			if (node == root) {
				root = node.right;
				return root;
			}
			return node.right;
		}

		node.left = deleteMin(node.left);

		return node;

	}

	public void deleteMax() {

		deleteMax(root);
		size--;
	}

	private Node deleteMax(Node node) {

		if (node.right == null) {
			if (node == root) {
				root = node.left;
				return root;
			}
			return node.left;

		}
		node.right = deleteMax(node.right);

		return node;
	}

	public void deleteKey(Key key) {

		if (!contains(key))
			return ;

		root = deleteKey(root, key);
		size--;

	}

	private Node deleteKey(Node node, Key key) {

		if (node.key.compareTo(key) == 0) {

			if (node.left != null && node.right != null) {
				
				Node t = node;

				t = min(node.right);
				t.right = deleteMin(node.right);
				t.left = node.left;

					
				return t;
			}

			if (node.left != null) {
				return node.left;
			}
			if (node.right != null)
				return node.right;

			return null;

		}

		int index = node.key.compareTo(key);

		if (index < 0)
			node.right = deleteKey(node.right, key);
		else if (index > 0)
			node.left = deleteKey(node.left, key);

		return node;

	}

	@Override
	public String toString() {
		if (root == null)
			return "[]";

		clearList();
		display(root);

		return Arrays.toString(list.toArray());

	}

}

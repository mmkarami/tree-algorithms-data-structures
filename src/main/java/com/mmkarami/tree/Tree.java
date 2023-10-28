package com.mmkarami.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<E> {

	private Node<E> root;

	private int size;

	public Tree(Node<E> root) {
		this.root = root;
		this.size = numDescendantsPreOrder(root);
	}

	public Node<E> root() {
		return root;
	}

	public int size() {
		return size;
	}

	public int numDescendantsPreOrder(Node<E> node) {
		if (node == null)
			return 0;
		int sum = 1; // node is touched
		if (node.getChildren() != null)
			for (Node<E> child : node.getChildren())
				sum += numDescendantsPreOrder(child);
		return sum;
	}

	public int numDescendantsPostOrder(Node<E> node) {
		if (node == null)
			return 0;
		int sum = 0;
		if (node.getChildren() != null)
			for (Node<E> child : node.getChildren())
				sum += numDescendantsPostOrder(child);
		sum++; // node is touched
		return sum;
	}

	public int numDescendantsLevelOrder(Node<E> node) {
		int sum = 0;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node<E> current = queue.remove();
			sum++;
			if (current.getChildren() != null)
				for (Node<E> child : current.getChildren())
					queue.add(child);
		}
		return sum;
	}
	
	public Queue<Node<E>> traversePreOrder(Node<E> node) {
		if (node == null)
			return null;
		Queue<Node<E>> traversedNodes = new LinkedList<>();
		traversedNodes.add(node); // node is touched
		if (node.getChildren() != null)
			for (Node<E> child : node.getChildren())
				traversedNodes.addAll(traversePreOrder(child));
		return traversedNodes;
	}

	public Queue<Node<E>> traversePostOrder(Node<E> node) {
		if (node == null)
			return null;
		Queue<Node<E>> traversedNodes = new LinkedList<>();
		if (node.getChildren() != null)
			for (Node<E> child : node.getChildren())
				traversedNodes.addAll(traversePostOrder(child));
		traversedNodes.add(node); // node is touched
		return traversedNodes;
	}

	public Queue<Node<E>> traverseLevelOrder(Node<E> node) {
		Queue<Node<E>> traversedNodes = new LinkedList<>();
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node<E> current = queue.remove();
			traversedNodes.add(current); // node is touched
			if (current.getChildren() != null)
				for (Node<E> child : current.getChildren())
					queue.add(child);
		}
		return traversedNodes;
	}
}
package com.mmkarami.tree;

import java.util.List;

public class Node<E> {

	private E value;

	private List<Node<E>> children;

	public Node(E value, List<Node<E>> children) {
		this.value = value;
		this.children = children;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public List<Node<E>> getChildren() {
		return children;
	}

	public void setChildren(List<Node<E>> children) {
		this.children = children;
	}
}
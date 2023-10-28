package com.mmkarami.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTest {

	private Tree<String> tree;

	@BeforeEach
	public void initBinaryTree() {
		Node<String> tajrishNode = new Node<String>("Tajrish", null);
		Node<String> vanakNode = new Node<String>("Vanak", null);

		Node<String> tehranNode = new Node<String>("Tehran", new ArrayList<>());
		Node<String> tabrizNode = new Node<String>("Tabriz", null);
		Node<String> shirazNode = new Node<String>("Shiraz", null);
		tehranNode.getChildren().add(tajrishNode);
		tehranNode.getChildren().add(vanakNode);

		Node<String> iranNode = new Node<String>("Iran", new ArrayList<>());
		iranNode.getChildren().add(tehranNode);
		iranNode.getChildren().add(tabrizNode);
		iranNode.getChildren().add(shirazNode);


		tree = new Tree<>(iranNode);
	}
	
	public Tree<String> getTree() {
		return tree;
	}
	
	@Test
	public void testNumDescendantsPreOrderByNullNode_whenCallByNullValue_thenItMustReturnZero() {

		// Arrange
		

		// Act
		var nodeCount = this.getTree().numDescendantsPreOrder(null);

		// Assert
		assertEquals(0, nodeCount);
	}
	
	@Test
	public void testNumDescendantsPreOrderByOneNode_whenCallByOneValue_thenItMustReturnOne() {

		// Arrange
		Node<String> iranNode = new Node<String>("Iran", null);

		// Act
		var nodeCount = this.getTree().numDescendantsPreOrder(iranNode);

		// Assert
		assertEquals(1, nodeCount);
	}

	@Test
	public void testNumDescendantsPreOrder_whenCreateTree_thenItMustReturnCorrectNumber() {

		// Arrange

		// Act
		var nodeCount = this.getTree().numDescendantsPreOrder(this.getTree().root());

		// Assert
		assertEquals(6, nodeCount);
	}
	
	@Test
	public void testNumDescendantsInOrder_whenCreateTree_thenItMustReturnCorrectNumber() {

		// Arrange

		// Act
		var nodeCount = this.getTree().numDescendantsPostOrder(this.getTree().root());

		// Assert
		assertEquals(6, nodeCount);
	}
	
	@Test
	public void testNumDescendantsLevelOrder_whenCreateTree_thenItMustReturnCorrectNumber() {

		// Arrange
		
		// Act
		var nodeCount = this.getTree().numDescendantsLevelOrder(this.getTree().root());

		// Assert
		assertEquals(6, nodeCount);
	}
	
	@Test
	public void testTraversePreOrder_whenCreateTree_thenItMustReturnCorrectQueueOfNodes() {

		// Arrange
		
		// Act
		var queue = this.getTree().traversePreOrder(this.getTree().root());

		// Assert
		assertEquals("Iran", queue.remove().getValue());
		assertEquals("Tehran", queue.remove().getValue());
		assertEquals("Tajrish", queue.remove().getValue());
		assertEquals("Vanak", queue.remove().getValue());
		assertEquals("Tabriz", queue.remove().getValue());
		assertEquals("Shiraz", queue.remove().getValue());
		
	}
	
	@Test
	public void testTraversePostOrder_whenCreateTree_thenItMustReturnCorrectQueueOfNodes() {

		// Arrange
		
		// Act
		var queue = this.getTree().traversePostOrder(this.getTree().root());

		// Assert
		assertEquals("Tajrish", queue.remove().getValue());
		assertEquals("Vanak", queue.remove().getValue());
		assertEquals("Tehran", queue.remove().getValue());
		assertEquals("Tabriz", queue.remove().getValue());
		assertEquals("Shiraz", queue.remove().getValue());
		assertEquals("Iran", queue.remove().getValue());
		
	}
	
	@Test
	public void testTraverseLevelOrder_whenCreateTree_thenItMustReturnCorrectQueueOfNodes() {

		// Arrange
		
		// Act
		var queue = this.getTree().traverseLevelOrder(this.getTree().root());

		// Assert
		assertEquals("Iran", queue.remove().getValue());
		assertEquals("Tehran", queue.remove().getValue());
		assertEquals("Tabriz", queue.remove().getValue());
		assertEquals("Shiraz", queue.remove().getValue());
		assertEquals("Tajrish", queue.remove().getValue());
		assertEquals("Vanak", queue.remove().getValue());
		
	}
}
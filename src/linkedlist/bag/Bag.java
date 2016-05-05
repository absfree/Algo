package linkedlist.bag;

import java.util.Iterator;
import com.zlp.std.StdIn;
import com.zlp.std.StdOut;

public class Bag<Item> implements Iterable<Item> {
	private int itemCount;
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public int size() {
		return itemCount;
	}

	public boolean isEmpty() {
		return itemCount == 0;
	}

	public void add(Item item) {
		if (itemCount == 0) {
			first = new Node();
		}
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = first.next;
		first = newNode;
		itemCount++;
	}


	public Iterator<Item> iterator() {
		return new BagIterator();
	}

	private class BagIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public Item next() {
			Item result = current.item;
			current = current.next;
			return result;
		}
		public void remove() {}
	}

	
}
package linkedlist.queue;

import java.util.Iterator;



public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int itemCount;

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

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		itemCount++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (--itemCount == 0) {
			last = null;
		}
		return item;
	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
		private Node current;
		public boolean hasNext() {
			return current != null;
		}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
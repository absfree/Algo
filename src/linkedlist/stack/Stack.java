package linkedlist.stack;

import com.zlp.std.StdIn;
import com.zlp.std.StdOut;

import java.util.Iterator;

/**
 * Created by Administrator on 2016/5/5.
 */
public class Stack<Item> implements Iterable<Item> {
    private int itemCount = 0;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        itemCount++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        itemCount--;
        return item;
    }

    public int size() {
        return itemCount;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (StdIn.hasNextLine()) {
            String item = StdIn.readLine();
            if (!item.equals("-")) {
                stack.push(item);
                for (String s : stack) {
                    StdOut.println(s);
                }
            } else {
                stack.pop();
                for (String s : stack) {
                    StdOut.println(s);
                }
            }

        }
    }
}

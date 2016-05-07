package linkedlist;



import util.StdIn;
import util.StdOut;

import java.util.Iterator;

public class DoubleLinkedList<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int itemCount;

    private class Node {
        Node prev;
        Node next;
        Item item;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.prev = first;
        }
        if (itemCount == 0) {
            last = first;
        }
        itemCount++;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (itemCount == 0) {
            first = last;
        }
        itemCount++;
    }

    public Item delFirst() {
        if (first == null) {
            throw new NullPointerException("No node in linked list.");
        }
        Item result = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        if (itemCount == 1) {
            last = null;
        }
        itemCount--;
        return result;
    }

    public Item delLast() {
        if (last == null) {
            throw new NullPointerException("No node in linked list.");
        }
        Item result = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        if (itemCount == 1) {
            first = null;
        }
        itemCount--;
        return result;
    }

    public void addBefore(Item targetItem, Item item) {
        //从头开始遍历寻找目标节点
        Node target = first;
        if (target == null) {
            throw new NullPointerException("No node in linked list");
        }
        while (target != null && target.item != targetItem) {
            //继续向后寻找目标节点
            target = target.next;
        }
        if (target == null) {
            throw new NullPointerException("Can't find target node.");
        }
        //现在target为指向目标结点的引用
        if (target.prev == null) {
            //此时相当于在表头插入结点
            addFirst(item);
        } else {
            Node oldPrev = target.prev;
            Node newNode = new Node();
            newNode.item = item;
            target.prev = newNode;
            newNode.next = target;
            newNode.prev = oldPrev;
            oldPrev.next = newNode;
            itemCount++;
        }
    }

    public void addAfter(Item targetItem, Item item) {
        Node target = first;
        if (target == null) {
            throw new NullPointerException("No node in linked list.");
        }
        while (target != null && target.item != targetItem) {
            target = target.next;
        }
        if (target == null) {
            throw new NullPointerException("Can't find target node.");
        }
        if (target.next == null) {
            addLast(item);
        } else {
            Node oldNext = target.next;
            Node newNode = new Node();
            newNode.item = item;
            target.next = newNode;
            newNode.prev = target;
            newNode.next= oldNext;
            oldNext.prev = newNode;
            itemCount++;
        }

    }



    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {}
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> l = new DoubleLinkedList<>();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        l.addLast(a);
        l.addLast(b);
        l.addLast(c);
        l.addLast(d);
        l.addBefore("c", "e");
        l.addAfter("b", "ddd");
        for (String s : l) {
            System.out.println(s);
        }
        while (StdIn.hasNextLine()) {
            String item = StdIn.readLine();
            if (!item.equals("-")) {
                l.addLast(item);
                for (String s : l) {
                    StdOut.println(s);
                }
            } else {
                l.delLast();
                for (String s : l) {
                    StdOut.println(s);
                }
            }
        }

    }

}
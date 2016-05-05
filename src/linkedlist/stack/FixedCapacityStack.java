package linkedlist.stack;

import com.zlp.std.StdIn;
import com.zlp.std.StdOut;

/**
 * Created by Administrator on 2016/5/5.
 */
public class FixedCapacityStack<Item> {
    private Item[] items;
    private int itemCount = 0;

    public FixedCapacityStack(int size) {
        items = (Item[]) new Object[size];
    }

    public int size() {
        return itemCount;
    }

    public void push(Item item) {
        items[itemCount++] = item;
    }

    public Item pop() {
        Item result = items[--itemCount];
        items[itemCount] = null;
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemCount; i++) {
            sb.append(items[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);
        while (StdIn.hasNextLine()) {
            String item = StdIn.readLine();
            if (!item.equals("-")) {
                stack.push(item);
                StdOut.println(stack);
            } else {
                stack.pop();
                StdOut.println(stack);
            }
        }
    }
}

package linkedlist.stack;

import com.zlp.std.StdIn;
import com.zlp.std.StdOut;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ResizingArrayStack<Item> {
    private Item[] items;
    private int itemCount = 0;

    public ResizingArrayStack(int size) {
        items = (Item[]) new Object[size];
    }

    public void push(Item item) {
        items[itemCount++] = item;
        if (itemCount == items.length) {
            Item[] newItems = (Item[]) new Object[itemCount * 2];
            System.arraycopy(items, 0, newItems, 0, itemCount);
            items = newItems;
        }
    }

    public Item pop() {
        Item result = items[--itemCount];
        items[itemCount] = null;
        if (itemCount == items.length / 4) {
            Item[] newItems = (Item[]) new Object[itemCount * 2];
            System.arraycopy(items, 0, newItems, 0, itemCount);
            items = newItems;
        }
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
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(5);
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

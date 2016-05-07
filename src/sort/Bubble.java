package sort;

import util.StdOut;
import util.StdRandom;

/**
 * Created by Administrator on 2016/5/7.
 */
public class Bubble {
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)  {
            for (int j = 0; j < N - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    exchange(a, j, j+1);
                }
            }
        }
    }

    public static void exchange(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int N = 20;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0, 1000);
        }
        sort(a);
        for (Integer i : a) {
            StdOut.print(i + " ");
        }
    }
}

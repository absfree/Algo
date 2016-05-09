package sort;

import util.StdOut;
import util.StdRandom;

/**
 * Created by Administrator on 2016/5/8.
 */
public class SortCompare {
    public static double time(String alg, int[] a) {
        long startTime = System.currentTimeMillis();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        } else if (alg.equals("Selection")) {
            Selection.sort(a);
        } else if (alg.equals("Bubble")) {
            Bubble.sort(a);
        } else if (alg.equals("Shell")) {
            Shell.sort(a);
        } else if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime) / 1000.0;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        //使用alg指定的排序算法将长度为N的数组排序，共排序T次，并计算总时间
        double total = 0.0;
        int[] a = new int[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform(10000 * N);
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random ints\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s", t2/t1, alg2);
    }
}

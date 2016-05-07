package analysis;


import util.In;
import util.StdOut;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts("E:\\jvm\\test\\4Kints.txt");
        long startTime = System.currentTimeMillis();
        int count = count(a);
        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime) / 1000.0;
        StdOut.println("The result is: " + count + ", and takes " + time + " seconds.");
    }
}

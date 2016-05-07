package analysis;

import sun.management.snmp.jvmmib.EnumJvmMemPoolCollectThreshdSupport;
import util.StdOut;
import util.StdRandom;

/**
 * Created by Administrator on 2016/5/6.
 */
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        long startTime = System.currentTimeMillis();
        int count = ThreeSum.count(a);
        long endTime = System.currentTimeMillis();
        double time =  (endTime - startTime) / 1000.0;
        return time;
    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}

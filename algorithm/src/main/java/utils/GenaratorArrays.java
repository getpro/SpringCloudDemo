package utils;

import java.util.Random;

/**
 * Created by irskj on 2019/1/21.
 */
public class GenaratorArrays {

    public static int[] gen(int max) {
        int arr[] = new int[max];

        for (int i = 0; i < max; i++) {
            arr[i] = new Random().nextInt(max);
        }
        return arr;
    }
}

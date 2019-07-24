package sort;


import utils.GenaratorArrays;

import java.util.Arrays;

/**
 * Created by irskj on 2019/1/21.
 */
public abstract class BaseSort implements Sort {

    protected static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Class<? extends Sort> cls) {
        int[] arr = GenaratorArrays.gen(10);

        Sort sort = SortFactory.create(cls);
        if (sort != null) {
            System.out.println("排序算法：" + sort.sortName());
            printArr(arr);
            sort.sort(arr);
            printArr(arr);
        } else {
            System.out.println("算法不存在");
        }

    }

    /**
     * 交换数据
     *
     * @param arr
     * @param fromIndex
     * @param toIndex
     */
    protected static void swap(int[] arr, int fromIndex, int toIndex) {
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = temp;
    }

}

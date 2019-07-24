package sort;

/**
 * 归并排序
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * <p>
 * 时间复杂度：O(n log n）
 * Created by irskj on 2019/1/21.
 */
public class MergeSort extends BaseSort {

    public static void main(String[] args) {
        sort(MergeSort.class);
    }

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     *
     * @param arr 待排序数组
     * @return 输出有序数组
     */
    public static void sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(arr, low, mid);
            // 右边
            sort(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }
    }

    /**
     * 将数组中low到high位置的数进行排序
     *
     * @param arr  待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // 把新数组中的数覆盖arr数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
    }

    @Override
    public String sortName() {
        return "归并排序";
    }
}

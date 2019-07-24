package sort;


/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序。
 * <p>
 * 时间复杂度：
 * Created by irskj on 2019/1/19.
 */
public class FastSort extends BaseSort {
    public static void main(String[] args) {
        sort(FastSort.class);
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param arr   带查找数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 中轴所在位置
     */
    public static int dividerAndChange(int[] arr, int start, int end) {
        int pivot = arr[start];

        while (start < end) {
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            if (start < end) {
                swap(arr, start, end);
                start++;
            }

            while (start < end && arr[start] < pivot) {
                start++;
            }

            if (start < end) {
                swap(arr, start, end);
                end--;
            }
        }
        arr[start] = pivot;
        return start;
    }

    /**
     * @param arr   带排序数组
     * @param start 开始位置
     * @param end   结束位置
     */
    public static void sort(int[] arr, int start, int end) {
        if (end - start > 1) {
            int mid = 0;
            mid = dividerAndChange(arr, start, end); //将arr数组进行一分为二
            sort(arr, start, mid); //对低字段表进行递归排序
            sort(arr, mid + 1, end); //对高字段表进行递归排序
        }
    }

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    @Override
    public String sortName() {
        return "快速排序";
    }
}

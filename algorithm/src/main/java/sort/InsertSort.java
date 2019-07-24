package sort;


/**
 * 插入排序
 * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
 * <p>
 * 时间复杂度：O（n^2）
 * Created by irskj on 2019/1/21.
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args) {
        sort(InsertSort.class);
    }

    @Override
    public void sort(int[] arr) {
        insertSort(arr);
    }

    @Override
    public String sortName() {
        return "插入排序";
    }

    /**
     * 插入排序
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        int size = arr.length;
        int temp = 0;
        int n = 0;

        for (int i = 0; i < size; i++) {
            temp = arr[i];

            for (n = i; n > 0 && temp < arr[n - 1]; n--) {
                arr[n] = arr[n - 1];
            }
            arr[n] = temp;
        }
    }
}

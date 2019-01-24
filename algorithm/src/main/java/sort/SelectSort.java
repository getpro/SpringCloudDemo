package sort;

/**
 * 选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 *
 * 时间复杂度：
 * Created by irskj on 2019/1/21.
 */
public class SelectSort extends BaseSort{

    public static void main(String[] args) {
        sort(SelectSort.class);
    }

    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     * @param arr
     */
    public static void selectSort(int[] arr){
        int size = arr.length;
        int temp = 0;

        for (int i=0;i<size-1;i++){
            int k = i; //待确定的位置
            for (int n=size-1;n>i;n--){

                if(arr[k]>arr[n]){ //选择出应该在第i个位置的数
                    k=n;
                }
            }
            swap(arr,i,k);
        }
    }

    @Override
    public void sort(int[] arr) {
        selectSort(arr);
    }

    @Override
    public String sortName() {
        return "选择排序";
    }
}

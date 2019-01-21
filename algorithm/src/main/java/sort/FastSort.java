package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * Created by irskj on 2019/1/19.
 */
public class FastSort {
    public static void main(String[] args) {
        int max = 100;
        int arr[] = new int[max];

        for(int i=0;i<max;i++){
            arr[i]=new Random().nextInt(max);
        }

        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
        System.out.println("单线程排序时间："+(System.currentTimeMillis()-start)+" ms");
        System.out.println(Arrays.toString(arr));

    }

    public static int dividerAndChange(int[] arr,int start,int end){
        int pivot = arr[start];

        while (start<end){
            while (start<end && arr[end]>=pivot){
                end--;
            }
            if(start<end){
                swap(arr,start,end);
                start++;
            }

            while (start<end && arr[start] < pivot){
                start++;
            }

            if(start<end){
                swap(arr,start,end);
                end--;
            }
        }
        arr[start]=pivot;
        return start;
    }

    public static void sort(int[] arr,int start,int end){
        if(end - start>1){
            int mid = 0;
            mid = dividerAndChange(arr,start,end);
            sort(arr,start,mid);
            sort(arr,mid+1,end);
        }
    }

    public static void swap(int[] arr,int fromIndex,int toIndex){
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex]=temp;
    }

}
